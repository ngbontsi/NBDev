package development.ngbontsi.com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.model.Organizer;
import development.ngbontsi.com.model.Venue;

import static development.ngbontsi.com.database.DatabaseHelper.VENUE_ID;
import static development.ngbontsi.com.database.DatabaseHelper.VENUE_NAME;
import static development.ngbontsi.com.database.DatabaseHelper.V_ADDRESS_ID;
import static development.ngbontsi.com.database.DatabaseHelper.TABLE_VENUE;


/**
 * Created by nbontsi on 2017/06/08.
 */

public class VenueDAO {

    private DatabaseHelper databaseHelper;

    public VenueDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    /**
     * This method is to create user record
     *
     * @param venue
     */
    public void addVenue(Venue venue) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(VENUE_NAME, venue.getVenue_name());



        // Inserting Row
        db.insert(TABLE_VENUE, null, values);
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param venue
     * @return true/false
     */
    public boolean checkVenue(String venue) {

        // array of columns to fetch
        String[] columns = {
                VENUE_ID
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // selection criteria
        String selection = VENUE_NAME + " = ?";

        // selection argument
        String[] selectionArgs = {venue};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_VENUE, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
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
     * @param venueId
     * @return Venue
     */
    public Venue getVenue(int venueId) throws Exception{

        // array of columns to fetch
        String[] columns = {
                VENUE_ID,
                VENUE_NAME
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // selection criteria
        String selection = VENUE_ID + " = ?";

        // selection argument
        String[] selectionArgs = {String.valueOf(venueId)};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_VENUE, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        Venue venue = getVenue(cursor);
        cursor.close();
        db.close();

        return venue;
    }

    public String getDescription(int venueId)throws Exception{
        return  getVenue(venueId).getVenue_name();
    }


    /**
     * This method to check user exist or not
     *
     * @param addressId
     * @return true/false
     */
    public boolean checkVenue(int addressId) {

        // array of columns to fetch
        String[] columns = {
            VENUE_ID        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        // selection criteria
        String selection = V_ADDRESS_ID + " = ?";

        // selection arguments
        String[] selectionArgs = {Integer.toString(addressId)};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_VENUE, //Table to query
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
     * @param venue
     */
    public void deleteVenue(Venue venue) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_VENUE, VENUE_ID + " = ?",
                new String[]{String.valueOf(venue.getVenue_id())});
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<Venue> getAllVenues() throws Exception{
        // array of columns to fetch
        String[] columns = {
                VENUE_ID,
                VENUE_NAME,
                V_ADDRESS_ID
        };
        // sorting orders
        String sortOrder =
                VENUE_NAME + " ASC";
        List<Venue> userList = new ArrayList<Venue>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_VENUE, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst())
            do {
                Venue user = getVenue(cursor);

                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    @NonNull
    private Venue getVenue(Cursor cursor)throws Exception {
        Venue user = new Venue();
        user.setVenue_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(VENUE_ID))));
        user.setVenue_name(cursor.getString(cursor.getColumnIndex(VENUE_NAME)));
       return user;
    }

    /**
     * This method to update user record
     *
     * @param venue
     */
    public void updateVenue(Venue venue) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(VENUE_NAME, venue.getVenue_name());

        // updating row
        db.update(TABLE_VENUE, values, VENUE_ID + " = ?",
                new String[]{String.valueOf(venue.getVenue_id())});
        db.close();
    }
}
