package com.krish.horizontalscrollview;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class HorizontalScrollViewActivity extends Activity {
	CenterLockHorizontalScrollview centerLockHorizontalScrollview;
	CustomListAdapter customListAdapter;
	Button btnPrev, btnNext;
	int currIndex = 0;
	private TextView text;
	ArrayList<String> list = new ArrayList<String>() {

		{
			add("Manchester city");
			add("Manchester United");
			add("Chelsea");
			add("Liverpool");
			add("TottenHam");
			add("Everton");
			add("WestHam");
			add("Arsenal");
			add("West Broom");
			add("New Castle");
			add("Norich City");
			add("Swansea city");
			add("stroke city");

		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_horizontal_scroll_view);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnPrev = (Button) findViewById(R.id.btnPrev);
		text=(TextView)findViewById(R.id.text);
		centerLockHorizontalScrollview = (CenterLockHorizontalScrollview) findViewById(R.id.scrollView);
		customListAdapter = new CustomListAdapter(this,
				R.layout.news_list_item, list);
		centerLockHorizontalScrollview.setAdapter(this, customListAdapter);
		btnNext.setOnClickListener(onClickListener);
		btnPrev.setOnClickListener(onClickListener);

	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v.getId() == R.id.btnPrev) {
				if (currIndex != 0) {
					currIndex--;
					centerLockHorizontalScrollview.setCenter(currIndex);
					text.setText(list.get(currIndex==0?0:currIndex-1));
				}
			} else if (v.getId() == R.id.btnNext) {

				if (currIndex < list.size()) {
					centerLockHorizontalScrollview.setCenter(currIndex);
					currIndex++;
					text.setText(list.get(currIndex-1));
				}
			}

		}
	};

}
