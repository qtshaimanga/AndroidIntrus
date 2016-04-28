package ft.iutlens.mmi.intrus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		final Button playButton = (Button) findViewById(R.id.button1);
		playButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuActivity.this, MainActivity.class);
				startActivity(intent);
			}});
		
	
		
		final Button playButton3 = (Button) findViewById(R.id.button3);
		playButton3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuActivity.this, Apropos.class);
				startActivity(intent);
			}});
		
		final Button playButton4 = (Button) findViewById(R.id.button4);
		playButton4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuActivity.this, ConfigurationActivity.class);
				startActivity(intent);
			}});
	}





	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

}
