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
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PowerAppActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
//	public static int house_count = 0;
//	public static House houses[] = new House[10];  // Max 10 houses during first iteration of the program

	
	Button B1=null;
	Button B3=null;
	Button ServiceEnter=null;
	Button Main=null;
	Button buttonMain=null;
	Button buttonAmp=null;
	Button buttonApp=null;
	Button reset=null;
	Context aContext = getBaseContext();

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
        B1=(Button)findViewById(R.id.button1);
        B3=(Button)findViewById(R.id.button3);
    //    B1.setOnClickListener(this);
        B1.setPressed(false);
 //       B3.setOnClickListener(this);
        B3.setPressed(false);
        reset=(Button)findViewById(R.id.Reset);
        reset.setPressed(false);
        
        
        

        
        B1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
           //     Intent myintent2 = new Intent(PowerAppActivity.this,PowerAppActivity.class);
            //    startActivity(myintent2);
            	
            	setContentView(R.layout.button1);
            	
            	ServiceEnter=(Button)findViewById(R.id.ServiceEnter);
                ServiceEnter.setOnClickListener(enterHandler);
                ServiceEnter.setPressed(false);
                
            }
        });
        
        B3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
           //     Intent myintent2 = new Intent(PowerAppActivity.this,PowerAppActivity.class);
            //    startActivity(myintent2);
            	setContentView(R.layout.ampdisplay);
            	
            	buttonMain=(Button)findViewById(R.id.buttonMain);
            	buttonMain.setOnClickListener(exitOneHandler);
            	buttonMain.setPressed(false);

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
    
/*    public void onClick(View v){
    	
    	
    	switch (v.getId()) {
        case R.id.button1: 
            ServiceEnter=(Button)findViewById(R.id.ServiceEnter);
            ServiceEnter.setOnClickListener(enterHandler);
            ServiceEnter.setPressed(false);
       	try {
			houses[house_count] = new_house();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         break;
        case R.id.button3:
        	setContentView(R.layout.ampdisplay);
        	
        	buttonMain=(Button)findViewById(R.id.buttonMain);
        	buttonMain.setOnClickListener(exitOneHandler);
        	buttonMain.setPressed(false);
         break;
     }

    } */

    
    private OnClickListener enterHandler = new OnClickListener() {
    	public void onClick(View v){
    		if(ServiceEnter.isPressed()){
            	//save text entry to serAmp in new house function
            	setContentView(R.layout.houseconfig);
            	
            	buttonMain=(Button)findViewById(R.id.buttonMain);
      //      	buttonMain.setOnClickListener(exitOneHandler);
            	buttonMain.setPressed(false);
            	
            	buttonApp=(Button)findViewById(R.id.buttonApp);
      //      	buttonMain.setOnClickListener(exitOneHandler);
            	buttonApp.setPressed(false);
            	
            	buttonAmp=(Button)findViewById(R.id.buttonAmp);
      //      	buttonMain.setOnClickListener(exitOneHandler);
            	buttonAmp.setPressed(false);
            	
            	//Database
            	//TODO
            	/*
            	private DatabaseHandler exitOneHandler = new OnClickListener() {
                	public void onClick(View v){
            	DatabaseHandler db = new DatabaseHandler(this);
            	 */
                /**
                 * CRUD Operations
                 * */
                // Inserting Contacts
            	
            	DatabaseHandler db = new DatabaseHandler(aContext);
                Log.d("Insert: ", "Inserting ..");
                db.addHouse(new House("Ravi", "9100000000"));
                db.addHouse(new House("Srinivas", "9199999999"));
                db.addHouse(new House("Tommy", "9522222222"));
                db.addHouse(new House("Karthik", "9533333333"));
         
                // Reading all contacts
                Log.d("Reading: ", "Reading all contacts..");
                List<House> contacts = db.getAllHouses();       
         
                for (House cn : contacts) {
                    String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                        // Writing Contacts to log
                Log.d("Name: ", log);
            }
            	
                
                buttonAmp.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                   //     Intent myintent2 = new Intent(PowerAppActivity.this,PowerAppActivity.class);
                    //    startActivity(myintent2);
                    	setContentView(R.layout.ampdisplay);
                    	
                    	buttonMain=(Button)findViewById(R.id.buttonMain);
                    	buttonMain.setOnClickListener(exitOneHandler);
                    	buttonMain.setPressed(false);
                    }
                });
                
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
                    	
                        B1=(Button)findViewById(R.id.button1);
                        B3=(Button)findViewById(R.id.button3);
                    //    B1.setOnClickListener(this);
                        B1.setPressed(false);
                 //       B3.setOnClickListener(this);
                        B3.setPressed(false);
                        reset=(Button)findViewById(R.id.Reset);
                        reset.setPressed(false);
                        
                        
                        B1.setOnClickListener(new View.OnClickListener() {

                            public void onClick(View v) {
                           //     Intent myintent2 = new Intent(PowerAppActivity.this,PowerAppActivity.class);
                            //    startActivity(myintent2);
                            	setContentView(R.layout.button1);
                            	
                            	ServiceEnter=(Button)findViewById(R.id.ServiceEnter);
                                ServiceEnter.setOnClickListener(enterHandler);
                                ServiceEnter.setPressed(false);

                            }
                        });
                        
                        B3.setOnClickListener(new View.OnClickListener() {

                            public void onClick(View v) {
                           //     Intent myintent2 = new Intent(PowerAppActivity.this,PowerAppActivity.class);
                            //    startActivity(myintent2);
                            	setContentView(R.layout.ampdisplay);
                            	
                            	buttonMain=(Button)findViewById(R.id.buttonMain);
                            	buttonMain.setOnClickListener(exitOneHandler);
                            	buttonMain.setPressed(false);

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
                B1=(Button)findViewById(R.id.button1);
                B3=(Button)findViewById(R.id.button3);
                B1.setPressed(false);
                B3.setPressed(false);
            	
                reset=(Button)findViewById(R.id.Reset);
                reset.setPressed(false);
                
                B1.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                   //     Intent myintent2 = new Intent(PowerAppActivity.this,PowerAppActivity.class);
                    //    startActivity(myintent2);
                    	setContentView(R.layout.button1);
                    	
                    	ServiceEnter=(Button)findViewById(R.id.ServiceEnter);
                        ServiceEnter.setOnClickListener(enterHandler);
                        ServiceEnter.setPressed(false);

                    }
                });
                
                B3.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                   //     Intent myintent2 = new Intent(PowerAppActivity.this,PowerAppActivity.class);
                    //    startActivity(myintent2);
                    	setContentView(R.layout.ampdisplay);
                    	
                    	buttonMain=(Button)findViewById(R.id.buttonMain);
                    	buttonMain.setOnClickListener(exitOneHandler);
                    	buttonMain.setPressed(false);

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
                
                
                
                
            }
    	}
    };
    
    
    
    private OnClickListener myClickHandler = new OnClickListener() {
    	public void onClick(View v){
    		if(B1.isPressed()){
            	setContentView(R.layout.button1);
                ServiceEnter=(Button)findViewById(R.id.ServiceEnter);
                ServiceEnter.setOnClickListener(enterHandler);
                ServiceEnter.setPressed(false);
            }
    	}
    };
    
    private OnClickListener ampDisHandler = new OnClickListener() {
    	public void onClick(View v){
    		if(B3.isPressed()){
            	setContentView(R.layout.ampdisplay);
            	
            	buttonMain=(Button)findViewById(R.id.buttonMain);
            	buttonMain.setOnClickListener(exitOneHandler);
            	buttonMain.setPressed(false);
            	/*
                ServiceEnter=(Button)findViewById(R.id.ServiceEnter);
                ServiceEnter.setOnClickListener(enterHandler);
                ServiceEnter.setPressed(false); */
            }
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