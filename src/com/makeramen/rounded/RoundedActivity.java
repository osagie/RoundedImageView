package com.makeramen.rounded;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class RoundedActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_rounded);

		StreamAdapter adapter = new StreamAdapter(this);
		((ListView) findViewById(R.id.main_list)).setAdapter(adapter);

		adapter.add(new StreamItem(this, R.drawable.photo1, "Tufa at night", "Mono Lake, CA"));
		adapter.add(new StreamItem(this, R.drawable.photo2, "Starry night", "Lake Powell, AZ"));
		adapter.add(new StreamItem(this, R.drawable.photo3, "Racetrack playa", "Death Valley, CA"));
		adapter.add(new StreamItem(this, R.drawable.photo4, "Napali coast", "Kauai, HI"));
		adapter.add(new StreamItem(this, R.drawable.photo5, "Delicate Arch", "Arches, UT"));
		adapter.add(new StreamItem(this, R.drawable.photo6, "Sierra sunset", "Lone Pine, CA"));
		adapter.add(new StreamItem(this, R.drawable.photo7, "Majestic", "Grand Teton, WY"));
	}

	class StreamItem {
		final Bitmap mBitmap;
		final String mLine1;
		final String mLine2;

		StreamItem(Context c, int resid, String line1, String line2) {
			mBitmap = BitmapFactory.decodeResource(c.getResources(), resid);
			mLine1 = line1;
			mLine2 = line2;
		}
	}

	class StreamAdapter extends ArrayAdapter<StreamItem> {
		private final LayoutInflater mInflater;

		public StreamAdapter(Context context) {
			super(context, 0);
			mInflater = LayoutInflater.from(getContext());
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewGroup view = null;
			
			if (convertView == null) {
				view = (ViewGroup) mInflater.inflate(R.layout.rounded_item, parent, false);
			} else {
				view = (ViewGroup) convertView;
			}

			StreamItem item = getItem(position);

			((RoundedImageView) view.findViewById(R.id.imageView1)).setImageBitmap(item.mBitmap);
			((TextView) view.findViewById(R.id.textView1)).setText(item.mLine1);
			((TextView) view.findViewById(R.id.textView2)).setText(item.mLine2);
			return view;
		}
	}
}
