package ft.iutlens.mmi.intrus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;


public class ConfigurationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configuration);

		
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	TextSwitcher text = (TextSwitcher)findViewById(R.id.textSwitcher1);		//ajouter 
				text.showNext();
		    }
		});
	}


	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.configuration, menu);
		return true;
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    
	        case R.menu.main:
	        	Intent jouer = new Intent(this, MainActivity.class);
	        	startActivity(jouer);
	            return true;
	            
	        case R.menu.apropos:
	        	Intent apropos = new Intent(this, Apropos.class);
	        	startActivity(apropos);
	            return true;
	            
	        case R.menu.menu:
	        	Intent menu = new Intent(this, MenuActivity.class);
	        	startActivity(menu);
	            return true;
	             
	        	
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	   
	
	
}	
}


