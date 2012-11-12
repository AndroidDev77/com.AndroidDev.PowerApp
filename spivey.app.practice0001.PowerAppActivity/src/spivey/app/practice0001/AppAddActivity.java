package spivey.app.practice0001;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class AppAddActivity extends Activity {
	
	
	
	Button appliance_Button=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance_add);
   //     getActionBar().setDisplayHomeAsUpEnabled(true);
        
        appliance_Button=(Button)findViewById(R.id.ApplianceAdd);
        appliance_Button.setPressed(false);
        
        
        appliance_Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
              Intent myintent2 = new Intent(AppAddActivity.this,PowerAppActivity.class);
               startActivity(myintent2);
            	//setContentView(R.layout.ampdisplay);
            	
      

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_app_display, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     /*   switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this); 
                return true;
        } */
        return super.onOptionsItemSelected(item);
    }

}
