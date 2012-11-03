package spivey.app.practice0001;

//public class House {
//	public int Service = 0; // Amperage supplied to the home
////	public Appliance app; // House member of type appliance
//	public  Appliance appliances[] = new Appliance[10]; // Each house can have 10 appliances 
//	
//
//}

public class House {
	 
    //private variables
    int _id;
    String _name;
    String _phone_number;
 
    // Empty constructor
    public House(){
 
    }
    // constructor
    public House(int id, String name, String _phone_number){
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
    }
 
    // constructor
    public House(String name, String _phone_number){
        this._name = name;
        this._phone_number = _phone_number;
    }
    // getting ID
    public int getID(){
        return this._id;
    }
 
    // setting id
    public void setID(int id){
        this._id = id;
    }
 
    // getting name
    public String getName(){
        return this._name;
    }
 
    // setting name
    public void setName(String name){
        this._name = name;
    }
 
    // getting phone number
    public String getPhoneNumber(){
        return this._phone_number;
    }
 
    // setting phone number
    public void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }
}