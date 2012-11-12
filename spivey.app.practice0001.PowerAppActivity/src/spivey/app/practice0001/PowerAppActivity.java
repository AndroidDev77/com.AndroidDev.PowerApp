package spivey.app.practice0001;

import java.io.IOException;
import java.util.List;

import spivey.app.practice0001.*;
//import spivey.app.practice0001.R;
//import spivey.app.practice0001.House;
import android.util.Log;
//import spivey.app.practice0001.DatabaseHandler;
//import spivey.app.practice0001.Appliance;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PowerAppActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
//	public static int house_count = 0;
//	public static House houses[] = new House[10];  // Max 10 houses during first iteration of the program

	
	Button addHouse_Button=null;
	Button amp_Button=null;
	Button ServiceEnter=null;
	Button Main=null;
	Button buttonMain=null;
	Button buttonAmp=null;
	Button buttonApp=null;
	Button reset=null;
	EditText housenameEdit;
	EditText serviceamountEdit;
	
 /*   
	public static House new_house() throws IOException {
//		read_input new_input = new read_input();
		int serAMP = 0;

//		serAMP = new_input.read_input_int();
		House H = new House();
		H.Service = serAMP;
		house_count++;
		for (int i = 0; i < 10; i++)
		{
			H.appliances[i] = new Appliance();
		}
		
		return H;
    }   */
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        addHouse_Button=(Button)findViewById(R.id.addHouse_Button_id);
        amp_Button=(Button)findViewById(R.id.amp_button_id);
        amp_Button.setPressed(false);
    //    B1.setOnClickListener(this);
        addHouse_Button.setPressed(false);
 //       B3.setOnClickListener(this);
        
        reset=(Button)findViewById(R.id.Reset);
        reset.setPressed(false);
                //Spinner for House Selection
        Spinner house_spin = (Spinner) this.findViewById(R.id.house_spin_id);
        DatabaseHandler db = new DatabaseHandler(getBaseContext());
        List<House> housenames = db.getAllHouses(); 
        String[] housenames_array = new String[housenames.size()] ;
       
        for(int i = 0; i < housenames.size() ;i++)
        {
        	housenames_array[i] = housenames.get(i).getName();
        }
        
        ArrayAdapter<String> house_name_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, housenames_array);
        house_name_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        house_spin.setAdapter(house_name_adapter);


        
        
        Context aContext = getBaseContext();


        
        addHouse_Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent myintent2 = new Intent(PowerAppActivity.this,AddHouseActivity.class);
                startActivity(myintent2);
            	
            /*	setContentView(R.layout.button1);
                housenameEdit =(EditText)findViewById(R.id.HouseName_text);
                serviceamountEdit = (EditText)findViewById(R.id.ServiceAmount);
            	ServiceEnter=(Button)findViewById(R.id.ServiceEnter);
                ServiceEnter.setOnClickListener(enterHandler);
                ServiceEnter.setPressed(false);*/
                
            }
        });
        
        amp_Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
              Intent myintent2 = new Intent(PowerAppActivity.this,AmpDisplayActivity.class);
               startActivity(myintent2);
            	//setContentView(R.layout.ampdisplay);
            	
      

            }
        });
        
        reset.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
           //     Intent myintent2 = new Intent(PowerAppActivity.this,PowerAppActivity.class);
            //    startActivity(myintent2);
            	setContentView(R.layout.resetdisplay);
            	
            	buttonMain=(Button)findViewById(R.id.buttonMain);
            	buttonMain.setOnClickListener(exitOneHandler);
            	buttonMain.setPressed(false);

            }
        });
/*     
        Main=(Button)findViewById(R.id.buttonMain);
        Main.setOnClickListener(this);
        Main.setPressed(false);        */
    }
    


    
    private OnClickListener enterHandler = new OnClickListener() {
    	public void onClick(View v){
    		if(ServiceEnter.isPressed()){
 
            	
            	
 
            	

            	
                
             
                
                buttonApp.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                   //     Intent myintent2 = new Intent(PowerAppActivity.this,PowerAppActivity.class);
                    //    startActivity(myintent2);
                    	setContentView(R.layout.appdisplay);
                    	
                    	buttonMain=(Button)findViewById(R.id.buttonMain);
                    	buttonMain.setOnClickListener(exitOneHandler);
                    	buttonMain.setPressed(false);

                    }
                });
                
                buttonMain.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                   //     Intent myintent2 = new Intent(PowerAppActivity.this,PowerAppActivity.class);
                    //    startActivity(myintent2);
                    	setContentView(R.layout.main);
                    	
                      //  addHouse_Button=(Button)findViewById(R.id.button1);
                      //  B3=(Button)findViewById(R.id.button3);
                    //    B1.setOnClickListener(this);
                        addHouse_Button.setPressed(false);
                 //       B3.setOnClickListener(this);
                     //   B3.setPressed(false);
                        reset=(Button)findViewById(R.id.Reset);
                        reset.setPressed(false);
                        

                        
         
                        reset.setOnClickListener(new View.OnClickListener() {

                            public void onClick(View v) {
                           //     Intent myintent2 = new Intent(PowerAppActivity.this,PowerAppActivity.class);
                            //    startActivity(myintent2);
                            	setContentView(R.layout.resetdisplay);
                            	
                            	buttonMain=(Button)findViewById(R.id.buttonMain);
                            	buttonMain.setOnClickListener(exitOneHandler);
                            	buttonMain.setPressed(false);

                            }
                        });
                    }
                });


            }
    	}
    };
    
    
    
    private OnClickListener exitOneHandler = new OnClickListener() {
    	public void onClick(View v){
    		if(buttonMain.isPressed()){
            	//save text entry to serAmp in new house function
            	setContentView(R.layout.main);
                //addHouse_Button=(Button)findViewById(R.id.button1);
                //B3=(Button)findViewById(R.id.button3);
                addHouse_Button.setPressed(false);
               // B3.setPressed(false);
            	
                reset=(Button)findViewById(R.id.Reset);
                reset.setPressed(false);
                
/*                addHouse_Button.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                   //     Intent myintent2 = new Intent(PowerAppActivity.this,PowerAppActivity.class);
                    //    startActivity(myintent2);
                    	setContentView(R.layout.button1);
                        housenameEdit =(EditText)findViewById(R.id.HouseName_text);
                        serviceamountEdit = (EditText)findViewById(R.id.ServiceAmount);
                    	ServiceEnter=(Button)findViewById(R.id.ServiceEnter);
                        ServiceEnter.setOnClickListener(enterHandler);
                        ServiceEnter.setPressed(false);

                    }
                });*/
                
   
                reset.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                   //     Intent myintent2 = new Intent(PowerAppActivity.this,PowerAppActivity.class);
                    //    startActivity(myintent2);
                    	setContentView(R.layout.resetdisplay);
                    	
                    	buttonMain=(Button)findViewById(R.id.buttonMain);
                    	buttonMain.setOnClickListener(exitOneHandler);
                    	buttonMain.setPressed(false);

                    }
                });
                
                
                
                
            }
    	}
    };
    
    
    

    
    private OnClickListener ampDisHandler = new OnClickListener() {
    	public void onClick(View v){
    
    	}
    };


	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

    
/*    
    public void onStart(){
    	
    }
    
    public void onResume() {
    	
    }
    
    public void onPause() {
    	
    }
    
    public void onStop() {
    	
    }
    
    public void onDestroy() {
    	
    }
    
    public void onRestart() {
    	
    }
*/
}