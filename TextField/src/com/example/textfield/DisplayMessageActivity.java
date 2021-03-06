package com.example.textfield;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {
	
	@SuppressLint("NewApi")

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
		{
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		String otherMessage;
		otherMessage = message+"\n";
		for(int k = 0; k < 3; k++)
		{
			otherMessage = otherMessage+otherMessage;
		}
		textView.setText(otherMessage);
		
		setContentView(textView);
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		
		}
		return super.onOptionsItemSelected(item);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

}
