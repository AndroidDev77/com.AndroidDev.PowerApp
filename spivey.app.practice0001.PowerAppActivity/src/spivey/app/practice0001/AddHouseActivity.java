package spivey.app.practice0001;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class AddHouseActivity extends Activity {

	EditText housenameEdit;
	EditText serviceamountEdit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_house);
       // getActionBar().setDisplayHomeAsUpEnabled(true);

    	housenameEdit =(EditText)findViewById(R.id.HouseName_text);
        serviceamountEdit = (EditText)findViewById(R.id.ServiceAmount);
        Button ServiceEnter=(Button)findViewById(R.id.ServiceEnter);
        ServiceEnter.setOnClickListener(enterHandler);
        ServiceEnter.setPressed(false);
    }
    private OnClickListener enterHandler = new OnClickListener() {
    	public void onClick(View v){
    		DatabaseHandler db = new DatabaseHandler(getBaseContext());
            Log.v("Insert: ", "Inserting ..");
            db.addHouse(new House(1, housenameEdit.getText().toString(),Integer.parseInt(serviceamountEdit.getText().toString())));
            //db.addHouse(new House(2,"House2", 2200));
            //db.addHouse(new House(3,"House3", 3000));
            //db.addHouse(new House(4,"House4", 1500));
     
            // Reading all contacts
            Log.d("Reading: ", "Reading all contacts..");
            List<House> contacts = db.getAllHouses();       
     
            for (House cn : contacts) {
                String log = "HouseId: "+cn.getID()+" ,Name: " + cn.getName() + " ,Service Amps: " + cn.getService();
                    // Writing Contacts to log
            Log.v("Name: ", log);
            }
            
            Intent myintent2 = new Intent(AddHouseActivity.this,HouseConfigActivity.class);
            startActivity(myintent2);
    	}
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_house, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           /* case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;*/
        }
        return super.onOptionsItemSelected(item);
    }

}
