package development.ngbontsi.com.database;
import static development.ngbontsi.com.database.DatabaseHelper.USER_ID;
import static development.ngbontsi.com.database.DatabaseHelper.USER_NAME;
import static development.ngbontsi.com.database.DatabaseHelper.USER_EMAIL;
import static development.ngbontsi.com.database.DatabaseHelper.USER_PASSWORD;
import static development.ngbontsi.com.database.DatabaseHelper.TABLE_USER;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.model.User;

/**
 * Created by nbontsi on 2017/06/08.
 */

public class UserDao {

    private DatabaseHelper databaseHelper;

    public UserDao(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_NAME, user.getName());
        values.put(USER_EMAIL, user.getEmail());
        values.put(USER_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
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
                USER_ID
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // selection criteria
        String selection = USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
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
     * @param email
     * @param password
     * @return true/false
     */
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                USER_ID
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        // selection criteria
        String selection = USER_EMAIL + " = ?" + " AND " + USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
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
    public void deleteUser(User user) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() throws Exception{
        // array of columns to fetch
        String[] columns = {
                USER_ID,
                USER_EMAIL,
                USER_NAME,
                USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst())
            do {
                User user = getUser(cursor);
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    @NonNull
    private User getUser(Cursor cursor) throws Exception{
        User user = new User();
        user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(USER_ID))));
        user.setName(cursor.getString(cursor.getColumnIndex(USER_NAME)));
        user.setEmail(cursor.getString(cursor.getColumnIndex(USER_EMAIL)));
        user.setPassword(cursor.getString(cursor.getColumnIndex(USER_PASSWORD)));
        return user;
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_NAME, user.getName());
        values.put(USER_EMAIL, user.getEmail());
        values.put(USER_PASSWORD, user.getPassword());

        // updating row
        db.update(TABLE_USER, values, USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }
}
