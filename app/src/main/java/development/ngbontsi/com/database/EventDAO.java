package development.ngbontsi.com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.model.Address;
import development.ngbontsi.com.model.Event;

import static development.ngbontsi.com.database.DatabaseHelper.E_VANUE_ID;
import static development.ngbontsi.com.database.DatabaseHelper.E_ORGANIZER_ID;
import static development.ngbontsi.com.database.DatabaseHelper.EVENT_COMMERCIAL_ID;
import static development.ngbontsi.com.database.DatabaseHelper.E_EVENT_TYPE_ID;
import static development.ngbontsi.com.database.DatabaseHelper.E_EVENT_STATUS_ID;
import static development.ngbontsi.com.database.DatabaseHelper.EVENT_ID;
import static development.ngbontsi.com.database.DatabaseHelper.EVENT_NAME;
import static development.ngbontsi.com.database.DatabaseHelper.EVENT_STARTDATE;
import static development.ngbontsi.com.database.DatabaseHelper.EVENT_ENDDATE;
import static development.ngbontsi.com.database.DatabaseHelper.TABLE_EVENT;


/**
 * Created by nbontsi on 2017/06/08.
 */

public class EventDAO {

    private DatabaseHelper databaseHelper;

    public EventDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    /**
     * This method is to create user record
     *
     * @param event
     */
    public void addEvent(Event event) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = getContentValues(event);
        // Inserting Row
        db.insert(TABLE_EVENT, null, values);
        db.close();
    }




    /**
     * This method to check user exist or not
     *
     * @param status
     * @return true/false
     */
    public boolean checkEventByStatus(int status) {

        // array of columns to fetch
        String[] columns = {
                EVENT_ID
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        // selection criteria
        String selection =E_EVENT_STATUS_ID + " = ?";

        // selection arguments
        String[] selectionArgs = {String.valueOf(status)};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_EVENT, //Table to query
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
     * This method is to delete user record
     *
     * @param event
     */
    public void deleteEvent(Event event) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_EVENT, EVENT_ID+ " = ?",
                new String[]{String.valueOf(event.getEvent_id())});
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<Event> getAllEvents() throws Exception{
        // array of columns to fetch
        String[] columns = {
                EVENT_ID,
                E_EVENT_STATUS_ID,
                E_EVENT_TYPE_ID,
                EVENT_COMMERCIAL_ID,
                E_ORGANIZER_ID,
                E_VANUE_ID,
                EVENT_NAME,
                EVENT_STARTDATE,
                EVENT_ENDDATE

        };
        // sorting orders
        String sortOrder =
                EVENT_ID + " ASC";
        List<Event> events = new ArrayList<Event>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_EVENT, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst())
            do {
                Event event = getEvent(cursor);
                // Adding user record to list
                events.add(event);
            } while (cursor.moveToNext());
        cursor.close();
        db.close();

        // return user list
        return events;
    }

    @NonNull
    private Event getEvent(Cursor cursor)throws Exception {
        Event event = new Event();

            event.setEvent_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(EVENT_ID))));
            event.setEvent_status_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(E_EVENT_STATUS_ID))));
            event.setEvent_type_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(E_EVENT_TYPE_ID))));
            event.setOrganizer_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(E_ORGANIZER_ID))));
            event.setEvent_commercial_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(EVENT_COMMERCIAL_ID))));
            event.setVenue_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(E_VANUE_ID))));
            event.setName(cursor.getString(cursor.getColumnIndex(EVENT_NAME)));
            event.setStartDate(cursor.getString(cursor.getColumnIndex(EVENT_STARTDATE)));
            event.setEndDate(cursor.getString(cursor.getColumnIndex(EVENT_ENDDATE)));


        return event;
    }

    /**
     * This method to update user record
     *
     * @param event
     */
    public void updateEvent(Event event) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = getContentValues(event);

        // updating row
        db.update(TABLE_EVENT, values, EVENT_ID+ " = ?",
                new String[]{String.valueOf(event.getEvent_id())});
        db.close();
    }

    @NonNull
    private ContentValues getContentValues(Event event) {
        ContentValues values = new ContentValues();
        values.put(E_EVENT_STATUS_ID, event.getEvent_status_id());
        values.put(E_EVENT_TYPE_ID, event.getEvent_type_id());
        values.put(E_ORGANIZER_ID, event.getOrganizer_id());
        values.put(EVENT_COMMERCIAL_ID,event.getEvent_commercial_id());
        values.put(E_VANUE_ID, event.getVenue_id());
        values.put(EVENT_NAME, event.getName());
        values.put(EVENT_STARTDATE, event.getStartDate());
        values.put(EVENT_ENDDATE, event.getEndDate());
        return values;
    }
}
