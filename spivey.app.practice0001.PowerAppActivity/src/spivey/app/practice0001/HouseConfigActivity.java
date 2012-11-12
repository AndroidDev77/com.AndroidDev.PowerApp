package spivey.app.practice0001;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class HouseConfigActivity extends Activity {

	
	Button buttonMain=null;
	Button buttonAmp=null;
	Button buttonApp=null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_config);
    	buttonMain=(Button)findViewById(R.id.buttonMain);
    	buttonMain.setPressed(false);
    	
    	buttonApp=(Button)findViewById(R.id.buttonApp);
    	buttonApp.setPressed(false);
    	
    	buttonAmp=(Button)findViewById(R.id.buttonAmp);
    	buttonAmp.setPressed(false);
    	
        //getActionBar().setDisplayHomeAsUpEnabled(true);
    	
        buttonMain.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
              Intent myintent2 = new Intent(HouseConfigActivity.this,PowerAppActivity.class);
               startActivity(myintent2);
            	//setContentView(R.layout.ampdisplay);
            	
      

            }
        });
        
        buttonAmp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
              Intent myintent2 = new Intent(HouseConfigActivity.this,AmpDisplayActivity.class);
               startActivity(myintent2);
            	//setContentView(R.layout.ampdisplay);
            	
      

            }
        });
        
        buttonApp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
              Intent myintent2 = new Intent(HouseConfigActivity.this,AppDisplayActivity.class);
               startActivity(myintent2);
            	//setContentView(R.layout.ampdisplay);
            	
      

            }
        });
    }


    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_house_config, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       /* switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }*/
        return super.onOptionsItemSelected(item);
    }

}
