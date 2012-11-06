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
    int _houseid;
    String _housename;
    int _service;
 
    // Empty constructor
    public House(){
 
    }
    // constructor
    public House(int id, String name, int _service){
        this._houseid = id;
        this._housename = name;
        this._service = _service;
    }
 
    // constructor
    public House(String name, int _service){
        this._housename = name;
        this._service = _service;
    }
    // getting ID
    public int getID(){
        return this._houseid;
    }
 
    // setting id
    public void setID(int id){
        this._houseid = id;
    }
 
    // getting name
    public String getName(){
        return this._housename;
    }
 
    // setting name
    public void setName(String name){
        this._housename = name;
    }
 
    // getting phone number
    public int getService(){
        return this._service;
    }
 
    // setting phone number
    public void setService(int service){
        this._service = service;
    }
}