package development.ngbontsi.com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.model.EventStatus;
import development.ngbontsi.com.model.EventType;

import static development.ngbontsi.com.database.DatabaseHelper.EVENT_TYPE_DESCRIPTION;
import static development.ngbontsi.com.database.DatabaseHelper.EVENT_TYPE_ID;
import static development.ngbontsi.com.database.DatabaseHelper.TABLE_EVENT_TYPE;



/**
 * Created by nbontsi on 2017/06/08.
 */

public class EventTypeDAO {

    private DatabaseHelper databaseHelper;

    public EventTypeDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    /**
     * This method is to create user record
     *
     * @param eventType
     */
    public void addEventType(EventType eventType) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EVENT_TYPE_DESCRIPTION, eventType.getEvent_type_description());



        // Inserting Row
        db.insert(TABLE_EVENT_TYPE, null, values);
        db.close();
    }




    /**
     * This method to check user exist or not
     *
     * @param description
     * @return true/false
     */
    public boolean checkEventType(String description) {

        // array of columns to fetch
        String[] columns = {
                EVENT_TYPE_ID
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        // selection criteria
        String selection = EVENT_TYPE_DESCRIPTION+ " = ?" ;

        // selection arguments
        String[] selectionArgs = {description};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_EVENT_TYPE, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0)
            return true;

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param eventTypeId
     * @return EventType
     */
    public EventType getEventType(int eventTypeId)throws Exception {

        // array of columns to fetch
        String[] columns = {
                EVENT_TYPE_ID,
                EVENT_TYPE_DESCRIPTION
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        // selection criteria
        String selection = EVENT_TYPE_ID+ " = ?" ;

        // selection arguments
        String[] selectionArgs = {String.valueOf(eventTypeId)};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_EVENT_TYPE, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();
EventType eventType = getEventType(cursor);
        cursor.close();
        db.close();


        return eventType;
    }

    public String getDescription(int eventTypeId)throws Exception{
        return getEventType(eventTypeId).getEvent_type_description();
    }
    /**
     * This method is to delete user record
     *
     * @param eventType
     */
    public void deleteEvenetType(EventType eventType) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_EVENT_TYPE, EVENT_TYPE_ID+ " = ?",
                new String[]{String.valueOf(eventType.getEvent_type_id())});
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<EventType> getAllEventTypes() throws Exception{
        // array of columns to fetch
        String[] columns = {
                EVENT_TYPE_ID,
                EVENT_TYPE_DESCRIPTION

        };
        // sorting orders
        String sortOrder =
                EVENT_TYPE_DESCRIPTION + " ASC";
        List<EventType> eventTypes = new ArrayList<EventType>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_EVENT_TYPE, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst())
            do {
                EventType eventType = getEventType(cursor);
                // Adding user record to list
                eventTypes.add(eventType);
            } while (cursor.moveToNext());
        cursor.close();
        db.close();

        // return user list
        return eventTypes;
    }

    @NonNull
    private EventType getEventType(Cursor cursor)throws Exception {
        EventType eventType = new EventType();

            eventType.setEvent_type_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(EVENT_TYPE_ID))));
            eventType.setEvent_type_description(cursor.getString(cursor.getColumnIndex(EVENT_TYPE_DESCRIPTION)));

        return eventType;
    }

    /**
     * This method to update user record
     *
     * @param eventType
     */
    public void updateEventType(EventType eventType) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EVENT_TYPE_DESCRIPTION, eventType.getEvent_type_description());



        // updating row
        db.update(TABLE_EVENT_TYPE, values, EVENT_TYPE_ID + " = ?",
                new String[]{String.valueOf(eventType.getEvent_type_id())});
        db.close();
    }
}
