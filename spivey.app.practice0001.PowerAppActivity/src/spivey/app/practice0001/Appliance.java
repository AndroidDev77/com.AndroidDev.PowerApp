package spivey.app.practice0001;

/*public class Appliance {
	public int amount = 0; // number of this type of appliance owned
	public int amps = 0;   // current draw of the appliance
	public int usage = 1;  // how much appliance is used rate 1,2 or 3
	public String name = "test"; // name of the appliance

}*/

public class Appliance {
	 
    //private variables
    int _houseid;
    String _housename;
    int _service;
 
    // Empty constructor
    public Appliance(){
 
    }
    // constructor
    public Appliance(int id, String name, int _service){
        this._houseid = id;
        this._housename = name;
        this._service = _service;
    }
 
    // constructor
    public Appliance(String name, int _service){
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