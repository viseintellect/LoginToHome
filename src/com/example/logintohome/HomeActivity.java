package com.example.logintohome;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends ActionBarActivity {
	private TextView helloUser;
	private ImageView iv;
	private Bitmap bitmap;
	public static final String IMAGE_URL = "http://www.wkrb13.com/logos/visa-logo_jq4o.jpg";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		helloUser = (TextView) findViewById(R.id.textView1);
		String userName = getIntent().getExtras().getString("userName");
		helloUser.append(userName);
		
		iv = (ImageView) findViewById(R.id.imageView1);
		bitmap = getBitmapFromURL(IMAGE_URL);
		iv.setImageBitmap(bitmap);
	}

	public Bitmap getBitmapFromURL(String src){
		try{
			URL url = new URL(src);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.connect();
			
			InputStream input = connection.getInputStream();
			Bitmap myBitmap = BitmapFactory.decodeStream(input);
			return myBitmap;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
