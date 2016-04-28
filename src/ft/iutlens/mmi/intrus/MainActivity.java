package ft.iutlens.mmi.intrus;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Data data;
	private Question question;

	private boolean running;
	public long timeLeft;

	private int[] imageId = {
			R.id.imageButton1,
			R.id.imageButton2,
			R.id.imageButton3,
			R.id.imageButton4};
	private int score;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		try { // chargement des données (recup erreur dans un appli qui pourrai se lancer tt de meme = protection
			data = new Data(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

		setContentView(R.layout.activity_main);

		start();		//
	}

	private void setQuestion(Question question) {		//configure les champ et/donc boucle sur les images (boutons)
		this.question = question;						// (memorise la question pour savoir si on a bien repondu)

		for(int i=0; i < 4; ++i){ //affiche les images
			((ImageButton) findViewById(imageId[i])).setImageResource(question.id[i]);
		}
	}

	
	void setScore(int score){							//rafraichi les score
		this.score = score;
		((TextView) findViewById(R.id.score)).setText("Score : "+score);
	}

	private void start(){				// demarage score a  0
		setScore(0);
		setQuestion(data.getNextQuestion());
		new CountDownTimer(30000, 100) {			//code du timer (temps em ms, temps entre deux "tic")
	
			

			public void onTick(long millisUntilFinished) {
				timeLeft = millisUntilFinished;
				((TextView) findViewById(R.id.countdown)).setText("Time : " + ((int)Math.round(millisUntilFinished / 100.0)/10.0));
			}

			public void onFinish() 	{
				//pop-up
				((TextView) findViewById(R.id.countdown)).setText("Terminé !");
				new AlertDialog.Builder(MainActivity.this) 
			    .setTitle("Partie Terminé !")
			    .setMessage("votre score est de: "+score) //affichage du score
			 
			    
			    .setPositiveButton("menu", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int which) { 
			            // continue with delete ----> menu
			        	Intent intent = new Intent(MainActivity.this, ft.iutlens.mmi.intrus.MenuActivity.class);
						startActivity(intent);
			        }
			     })
			     
			    .setNegativeButton("rejouer", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int which) { 
			            // do nothing ----> rejouer
			        	setScore(0);
			        	start();
			        	running = true;
		
			        }
			     })
			    .setIcon(android.R.drawable.ic_dialog_alert)
			     .show();		//faudra afficher un message pour indiquer la fin
				running = false;
			}

		}.start();
		running = true;		
	}

	
	
	public void onClick(View view){			// arrivé des 4 bouton
		if (!running){
			start();				//regarde si on tourne sinon on demarre (voir poour ajouter un bouton demarrer)
		} else {
			int answer=0;
			while (answer<4 && view.getId() != imageId[answer]) ++answer; //cherche l'indice du bouton

			if (question.isCorrect(answer)){ //bonne réponse
				setScore(score+1);
				setQuestion(data.getNextQuestion()); //question suivante (score augmente)à			
			} else { //mauvaise réponse (szcore diminue)
				setScore(score-1);
			}			
		}
	}
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	    public void imageClick(View view) { //creée l'annimation sur l'image
	    	
	    	ImageView image = (ImageView) findViewById (R.id.imageView1);
			Animation animation = AnimationUtils.loadAnimation (this, android.R.anim.fade_out);
			image.startAnimation(animation);
			
			
		}
	    
	    public void onSaveINstanceState (Bundle outState){
	    	super.onSaveInstanceState(outState);
	    	outState.putInt("duree",  (int) timeLeft / 1000);	
	    }
	    
	    //faire un bouton stop
	    // saveIntanceState.getInt("score"), pour recupere le score -> sauvagarder le score.+ voir pour les modes paysages !!
	    //saveIntanceState.getInt("duree"), pour recupere la duree -> pause + voir commencer changer timming + voir pour les modes paysage !! 
	    
	    

	    
	    
	    
	 
}

