package development.ngbontsi.com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;


import development.ngbontsi.com.model.Commercial;

import static development.ngbontsi.com.database.DatabaseHelper.COM_EVENT_COMMERCIAL_ID;
import static development.ngbontsi.com.database.DatabaseHelper.EVENT_COMMERCIAL_ID;
import static development.ngbontsi.com.database.DatabaseHelper.EVENT_TYPE_DESCRIPTION;
import static development.ngbontsi.com.database.DatabaseHelper.TABLE_COMMERCIAL;
import static development.ngbontsi.com.database.DatabaseHelper.EVENT_COMMERCIAL_DESCRIPTION;




/**
 * Created by nbontsi on 2017/06/08.
 */

public class CommercialDAO {

    private DatabaseHelper databaseHelper;

    public CommercialDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(Commercial user) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = getContentValues(user);



        // Inserting Row
        db.insert(TABLE_COMMERCIAL, null, values);
        db.close();
    }




    /**
     * This method to check user exist or not
     *
     * @param name
     * @return true/false
     */
    public boolean checkCommercial(String name) {

        // array of columns to fetch
        String[] columns = {
                EVENT_COMMERCIAL_ID
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        // selection criteria
        String selection = EVENT_COMMERCIAL_DESCRIPTION + " = ?" ;

        // selection arguments
        String[] selectionArgs = {name};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_COMMERCIAL, //Table to query
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
     * @param commercialId
     * @return Commercial
     */
    public Commercial getCommercial(int commercialId)throws Exception {

        // array of columns to fetch
        String[] columns = {
                EVENT_COMMERCIAL_ID,
                EVENT_COMMERCIAL_DESCRIPTION
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        // selection criteria
        String selection = EVENT_COMMERCIAL_ID + " = ?" ;

        // selection arguments
        String[] selectionArgs = {String.valueOf(commercialId)};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_COMMERCIAL, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();
        Commercial commercial = getCommercial(cursor);
        cursor.close();
        db.close();


        return commercial;
    }

    public String getDescription(int commercialId)throws Exception{
        for(Commercial commercial:getAllCommercials()){
            if(commercial.getEvent_commercial_id()==commercialId)
                return commercial.getEvent_commercial_description();
        }
        return "Unknown";
    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(Commercial user) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_COMMERCIAL, EVENT_COMMERCIAL_ID+ " = ?",
                new String[]{String.valueOf(user.getEvent_commercial_id())});
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<Commercial> getAllCommercials() throws Exception{
        // array of columns to fetch
        String[] columns = {
                EVENT_COMMERCIAL_ID,
                EVENT_COMMERCIAL_DESCRIPTION

        };
        // sorting orders
        String sortOrder =
                EVENT_COMMERCIAL_DESCRIPTION + " ASC";
        List<Commercial> userList = new ArrayList<Commercial>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_COMMERCIAL, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst())
            do {
                Commercial user = getCommercial(cursor);


                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    @NonNull
    private Commercial getCommercial(Cursor cursor) throws Exception{
        Commercial commercial = new Commercial();

            commercial.setEvent_commercial_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(EVENT_COMMERCIAL_ID))));
            commercial.setEvent_commercial_description(cursor.getString(cursor.getColumnIndex(EVENT_COMMERCIAL_DESCRIPTION)));

        return commercial;
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateOrganizer(Commercial user) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = getContentValues(user);



        // updating row
        db.update(TABLE_COMMERCIAL, values, EVENT_COMMERCIAL_ID + " = ?",
                new String[]{String.valueOf(user.getEvent_commercial_id())});
        db.close();
    }

    @NonNull
    private ContentValues getContentValues(Commercial user) {
        ContentValues values = new ContentValues();
        values.put(EVENT_COMMERCIAL_DESCRIPTION, user.getEvent_commercial_description());
        return values;
    }
}
