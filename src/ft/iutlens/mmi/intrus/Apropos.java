package ft.iutlens.mmi.intrus;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
	
public class Apropos extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apropos);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.apropos, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    
	        case R.menu.configuration:
	        	Intent configuration = new Intent(this, ConfigurationActivity.class);
	        	startActivity(configuration);
	            return true;
	            
	        case R.menu.menu:
	        	Intent menu = new Intent(this, MenuActivity.class);
	        	startActivity(menu);
	            return true;
	            
	        case R.menu.main:
	        	Intent jouer = new Intent(this, MainActivity.class);
	        	startActivity(jouer);
	            return true;
	             
	        	
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	

	
}
