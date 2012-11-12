package spivey.app.practice0001;

import java.util.ArrayList;
import java.util.List;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ApplianceDataHandler extends SQLiteOpenHelper {
	
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "housesManager";
 
    // Houses table name
    private static final String TABLE_APPLIANCES = "appliance";
 
    // Houses Table Columns naming
    private static final String KEY_ID = "id";
    private static final String KEY_HOUSE_ID = "house_id";
    private static final String KEY_APP_NAME = "appliance_name";
    private static final String KEY_APP_COUNT = "appliance_count";
    private static final String KEY_APP_MODEL = "appliance_model";
    private static final String KEY_USE_RATING = "use_rating"; 
    
    public ApplianceDataHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_APP_TABLE = "CREATE TABLE " + TABLE_APPLIANCES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_APP_NAME + " TEXT,"
                + KEY_APP_COUNT + " TEXT" + KEY_HOUSE_ID + " TEXT" 
                + KEY_APP_MODEL + " TEXT" + KEY_USE_RATING + "TEXT" + ")";
        db.execSQL(CREATE_APP_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_APPLIANCES);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    // Adding new house
    void addAppliance(Appliance appliance) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_APP_NAME, appliance.getName()); // Appliance Name
        values.put(KEY_APP_COUNT, appliance.getCount()); // Appliance Count
        values.put(KEY_HOUSE_ID, appliance.getHID()); // Appliance House ID
        values.put(KEY_APP_MODEL, appliance.getModel()); // Appliance Model
        values.put(KEY_USE_RATING, appliance.getRating()); // Appliance Use Rating
 
        // Inserting Row
        db.insert(TABLE_APPLIANCES, null, values);
        db.close(); // Closing database connection
    }
 
    // Getting single house
    Appliance getHouse(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        
 //TODO not updated for new fields
        Cursor cursor = db.query(TABLE_APPLIANCES, new String[] { KEY_ID,
        		KEY_APP_NAME, KEY_APP_COUNT }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        
        
        //TODO check if updates were done correctly
        Appliance appliance = new Appliance(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)), id, null, id);

        return appliance;
    }
 
    // Getting All House
    public List<Appliance> getAllHouses() {
        List<Appliance> applianceList = new ArrayList<Appliance>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_APPLIANCES;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Appliance appliance = new Appliance();
                // TODO UPDATE
                appliance.setID(Integer.parseInt(cursor.getString(0)));
                appliance.setName(cursor.getString(1));
                appliance.setCount(Integer.parseInt(cursor.getString(2)));
                // Adding house to list
                applianceList.add(appliance);
            } while (cursor.moveToNext());
        }
 
        // return house list
        return applianceList;
    }
 
    // Updating single house
    public int updateAppliance(Appliance appliance) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();

        values.put(KEY_APP_NAME, appliance.getName());
        values.put(KEY_APP_COUNT, appliance.getCount());       
        values.put(KEY_HOUSE_ID, appliance.getHID()); // Appliance House ID
        values.put(KEY_APP_MODEL, appliance.getModel()); // Appliance Model
        values.put(KEY_USE_RATING, appliance.getRating()); // Appliance Use Rating

 
        // updating row
        return db.update(TABLE_APPLIANCES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(appliance.getID()) });
    }
 
    // Deleting single house
    public void deleteHouse(House house) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_APPLIANCES, KEY_ID + " = ?",
                new String[] { String.valueOf(house.getID()) });
        db.close();
    }
 
    // Getting houses Count
    public int getHousesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_APPLIANCES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }

}
