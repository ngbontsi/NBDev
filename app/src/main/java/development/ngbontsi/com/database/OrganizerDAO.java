package development.ngbontsi.com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.model.Organizer;

import static development.ngbontsi.com.database.DatabaseHelper.TABLE_ORGANIZER;
import static development.ngbontsi.com.database.DatabaseHelper.ORGANIZER_ID;
import static development.ngbontsi.com.database.DatabaseHelper.ORGANIZER_EMAIL;
import static development.ngbontsi.com.database.DatabaseHelper.ORGANIZER_NAME;



/**
 * Created by nbontsi on 2017/06/08.
 */

public class OrganizerDAO {

    private DatabaseHelper databaseHelper;

    public OrganizerDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(Organizer user) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ORGANIZER_NAME, user.getOrganizer_name());
        values.put(ORGANIZER_EMAIL, user.getOrganizer_email());


        // Inserting Row
        db.insert(TABLE_ORGANIZER, null, values);
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                ORGANIZER_ID
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // selection criteria
        String selection = ORGANIZER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_ORGANIZER, //Table to query
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
     * @param orgId
     * @return true/false
     */
    public Organizer getOrganizer(int orgId) throws Exception{

        // array of columns to fetch
        String[] columns = {
                ORGANIZER_ID,
                ORGANIZER_NAME,
                ORGANIZER_EMAIL
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // selection criteria
        String selection = ORGANIZER_ID + " = ?";

        // selection argument
        String[] selectionArgs = {String.valueOf(orgId)};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_ORGANIZER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        Organizer organizer = getOrganizer(cursor);
        cursor.close();
        db.close();

        return organizer;
    }

    public String getName(int orgId)throws Exception{
        return getOrganizer(orgId).getOrganizer_name();
    }

    /**
     * This method to check user exist or not
     *
     * @param name
     * @param email
     * @return true/false
     */
    public boolean checkUser(String name, String email) {

        // array of columns to fetch
        String[] columns = {
                ORGANIZER_ID
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        // selection criteria
        String selection = ORGANIZER_NAME + " = ?" + " AND " + ORGANIZER_EMAIL+ " = ?";

        // selection arguments
        String[] selectionArgs = {name, email};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_ORGANIZER, //Table to query
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
     * @param user
     */
    public void deleteUser(Organizer user) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_ORGANIZER, ORGANIZER_ID + " = ?",
                new String[]{String.valueOf(user.getOrganizer_id())});
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<Organizer> getAllOrganizers()throws Exception {
        // array of columns to fetch
        String[] columns = {
                ORGANIZER_ID,
                ORGANIZER_NAME,
                ORGANIZER_EMAIL
        };
        // sorting orders
        String sortOrder =
                ORGANIZER_NAME + " ASC";
        List<Organizer> userList = new ArrayList<Organizer>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_ORGANIZER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst())
            do {
                Organizer user = getOrganizer(cursor);

                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    @NonNull
    private Organizer getOrganizer(Cursor cursor)throws Exception {
        Organizer user = new Organizer();

            user.setOrganizer_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ORGANIZER_ID))));
            user.setOrganizer_name(cursor.getString(cursor.getColumnIndex(ORGANIZER_NAME)));
            user.setOrganizer_email(cursor.getString(cursor.getColumnIndex(ORGANIZER_EMAIL)));

        return user;
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateOrganizer(Organizer user) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ORGANIZER_NAME, user.getOrganizer_name());
        values.put(ORGANIZER_EMAIL, user.getOrganizer_email());


        // updating row
        db.update(TABLE_ORGANIZER, values, ORGANIZER_ID + " = ?",
                new String[]{String.valueOf(user.getOrganizer_id())});
        db.close();
    }
}
