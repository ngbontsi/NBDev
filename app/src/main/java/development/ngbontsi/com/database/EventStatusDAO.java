package development.ngbontsi.com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.model.Commercial;
import development.ngbontsi.com.model.Event;
import development.ngbontsi.com.model.EventStatus;

import static development.ngbontsi.com.database.DatabaseHelper.EVENT_STATUS_ID;
import static development.ngbontsi.com.database.DatabaseHelper.EVENT_DESCRIPTION;
import static development.ngbontsi.com.database.DatabaseHelper.TABLE_EVENT_STATUS;



/**
 * Created by nbontsi on 2017/06/08.
 */

public class EventStatusDAO {

    private DatabaseHelper databaseHelper;

    public EventStatusDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    /**
     * This method is to create user record
     *
     * @param eventStatus
     */
    public void addEventStatus(EventStatus eventStatus) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EVENT_DESCRIPTION, eventStatus.getEvent_description());



        // Inserting Row
        db.insert(TABLE_EVENT_STATUS, null, values);
        db.close();
    }




    /**
     * This method to check user exist or not
     *
     * @param description
     * @return true/false
     */
    public boolean checkEventStatus(String description) {

        // array of columns to fetch
        String[] columns = {
                EVENT_STATUS_ID
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        // selection criteria
        String selection = EVENT_DESCRIPTION+ " = ?" ;

        // selection arguments
        String[] selectionArgs = {description};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_EVENT_STATUS, //Table to query
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
     * @param eventStatusId
     * @return true/false
     */
    public EventStatus getEventStatus(int eventStatusId) throws Exception{

        // array of columns to fetch
        String[] columns = {
                EVENT_STATUS_ID,
                EVENT_DESCRIPTION
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        // selection criteria
        String selection = EVENT_STATUS_ID+ " = ?" ;

        // selection arguments
        String[] selectionArgs = {String.valueOf(eventStatusId)};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_EVENT_STATUS, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();
        EventStatus eventStatus = getEventStatus(cursor);
        cursor.close();
        db.close();
        return eventStatus;
    }
    public String getDescription(int eventStatusId)throws Exception{
        return getEventStatus(eventStatusId).getEvent_description();
    }
    
    /**
     * This method is to delete user record
     *
     * @param eventStatus
     */
    public void deleteUser(EventStatus eventStatus) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_EVENT_STATUS, EVENT_STATUS_ID+ " = ?",
                new String[]{String.valueOf(eventStatus.getEvent_status_id())});
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<EventStatus> getAllEventStatus()throws Exception {
        // array of columns to fetch
        String[] columns = {
                EVENT_STATUS_ID,
                EVENT_DESCRIPTION

        };
        // sorting orders
        String sortOrder =
                EVENT_DESCRIPTION + " ASC";
        List<EventStatus> eventStatuses = new ArrayList<EventStatus>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_EVENT_STATUS, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst())
            do {
                EventStatus eventStatus = getEventStatus(cursor);


                // Adding user record to list
                eventStatuses.add(eventStatus);
            } while (cursor.moveToNext());
        cursor.close();
        db.close();

        // return user list
        return eventStatuses;
    }

    @NonNull
    private EventStatus getEventStatus(Cursor cursor)throws Exception {
        EventStatus eventStatus = new EventStatus();

            eventStatus.setEvent_status_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(EVENT_STATUS_ID))));
            eventStatus.setEvent_description(cursor.getString(cursor.getColumnIndex(EVENT_DESCRIPTION)));
       return eventStatus;
    }

    /**
     * This method to update user record
     *
     * @param eventStatus
     */
    public void updateEventStatus(EventStatus eventStatus) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EVENT_DESCRIPTION, eventStatus.getEvent_description());



        // updating row
        db.update(TABLE_EVENT_STATUS, values, EVENT_STATUS_ID + " = ?",
                new String[]{String.valueOf(eventStatus.getEvent_status_id())});
        db.close();
    }
}
