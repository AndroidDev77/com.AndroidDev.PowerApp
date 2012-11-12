package spivey.app.practice0001;

/*public class Appliance {
	public int amount = 0; // number of this type of appliance owned
	public int amps = 0;   // current draw of the appliance
	public int usage = 1;  // how much appliance is used rate 1,2 or 3
	public String name = "test"; // name of the appliance

}*/

public class Appliance {
	 
    //private variables
    int _applianceid;
    String _appliancename;
    int _count;
    int _houseid;
    String _model;
    int _rating;
    // Empty constructor
    public Appliance(){
 
    }
    // constructor
    public Appliance(int id, String name, int _count,int hid, String model, int _rating){
        this._applianceid = id;
        this._appliancename = name;
        this._count = _count;
        this._houseid = hid;
        this._model = model;
        this._rating = _rating;
    }
 

    // constructor
    // TODO are more secondary constructors needed ?
    public Appliance(String name, int _count){
        this._appliancename = name;
        this._count = _count;
    }
    // getting ID
    public int getID(){
        return this._applianceid;
    }
 
    // setting id
    public void setID(int id){
        this._applianceid = id;
    }
 
    // getting name
    public String getName(){
        return this._appliancename;
    }
 
    // setting name
    public void setName(String name){
        this._appliancename = name;
    }
 
    // getting appliance count
    public int getCount(){
        return this._count;
    }
 
    // setting appliance count
    public void setCount(int count){
        this._count = count;
    }
    
    // getting appliance count
    public int getHID(){
        return this._houseid;
    }
 
    // setting appliance count
    public void setHID(int hid){
        this._houseid = hid;
    }
    
    // getting appliance model
    public String getModel(){
        return this._model;
    }
 
    // setting appliance model
    public void setModel(String model){
        this._model = model;
    }
    
    // getting appliance rating
    public int getRating(){
        return this._rating;
    }
 
    // setting appliance rating
    public void setRating(int rating){
        this._rating = rating;
    }
}