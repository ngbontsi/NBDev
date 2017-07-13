package development.ngbontsi.com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.model.Address;
import development.ngbontsi.com.model.Commercial;

import static development.ngbontsi.com.database.DatabaseHelper.ADDRESS_ID;
import static development.ngbontsi.com.database.DatabaseHelper.CITY;
import static development.ngbontsi.com.database.DatabaseHelper.STREET;
import static development.ngbontsi.com.database.DatabaseHelper.LINE_1;
import static development.ngbontsi.com.database.DatabaseHelper.LINE_2;
import static development.ngbontsi.com.database.DatabaseHelper.LINE_3;
import static development.ngbontsi.com.database.DatabaseHelper.LINE_4;
import static development.ngbontsi.com.database.DatabaseHelper.POSTAL_CODE;
import static development.ngbontsi.com.database.DatabaseHelper.TABLE_ADDRESS;
import static development.ngbontsi.com.database.DatabaseHelper.USER_PASSWORD;


/**
 * Created by nbontsi on 2017/06/08.
 */

public class AddressDAO {

    private DatabaseHelper databaseHelper;

    public AddressDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    /**
     * This method is to create user record
     *
     * @param address
     */
    public void addAddress(Address address) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CITY, address.getCity());
        values.put(STREET, address.getStreet());
        values.put(LINE_1, address.getLine_1());
        values.put(LINE_2, address.getLine_2());
        values.put(LINE_3, address.getLine_3());
        values.put(LINE_4, address.getLine_4());
        values.put(POSTAL_CODE, address.getPostal_code());



        // Inserting Row
        db.insert(TABLE_ADDRESS, null, values);
        db.close();
    }




    /**
     * This method to check user exist or not
     *
     * @param city
     * @param street
     * @return true/false
     */
    public boolean checkAddress(String city,String street) {

        // array of columns to fetch
        String[] columns = {
                ADDRESS_ID
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        // selection criteria
        String selection =CITY + " = ?"+ " AND " + STREET + " = ?" ;

        // selection arguments
        String[] selectionArgs = {city,street};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_ADDRESS, //Table to query
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
     * @param address
     */
    public void deleteAddress(Address address) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_ADDRESS, ADDRESS_ID+ " = ?",
                new String[]{String.valueOf(address.getAddress_id())});
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<Address> getAllAddresses()throws Exception {
        // array of columns to fetch
        String[] columns = {
                ADDRESS_ID,
                CITY,
                STREET,
                LINE_1,
                LINE_2,
                LINE_3,
                LINE_4,
                POSTAL_CODE

        };
        // sorting orders
        String sortOrder =
                STREET + " ASC";
        List<Address> userList = new ArrayList<Address>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_ADDRESS, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst())
            do {
                Address address = getAddress(cursor);


                // Adding user record to list
                userList.add(address);
            } while (cursor.moveToNext());
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    @NonNull
    private Address getAddress(Cursor cursor)throws Exception {
        Address address = new Address();
        address.setAddress_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ADDRESS_ID))));
        address.setCity(cursor.getString(cursor.getColumnIndex(CITY)));
        address.setStreet(cursor.getString(cursor.getColumnIndex(STREET)));
        address.setLine_1(cursor.getString(cursor.getColumnIndex(LINE_1)));
        address.setLine_2(cursor.getString(cursor.getColumnIndex(LINE_2)));
        address.setLine_3(cursor.getString(cursor.getColumnIndex(LINE_3)));
        address.setLine_4(cursor.getString(cursor.getColumnIndex(LINE_4)));
        address.setPostal_code(Integer.parseInt(cursor.getString(cursor.getColumnIndex(POSTAL_CODE))));
        return address;
    }

    /**
     * This method to update user record
     *
     * @param address
     */
    public void updateAddress(Address address) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CITY, address.getCity());
        values.put(STREET, address.getStreet());
        values.put(LINE_1, address.getLine_1());
        values.put(LINE_2, address.getLine_2());
        values.put(LINE_3, address.getLine_3());
        values.put(LINE_4, address.getLine_4());
        values.put(POSTAL_CODE, address.getPostal_code());

        // updating row
        db.update(TABLE_ADDRESS, values, ADDRESS_ID+ " = ?",
                new String[]{String.valueOf(address.getAddress_id())});
        db.close();
    }
}
