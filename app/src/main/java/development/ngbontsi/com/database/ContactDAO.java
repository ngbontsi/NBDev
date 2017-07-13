package development.ngbontsi.com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.model.Commercial;
import development.ngbontsi.com.model.Contact;

import static development.ngbontsi.com.database.DatabaseHelper.CONTACT_ID;
import static development.ngbontsi.com.database.DatabaseHelper.CONTACT_NUMBER;
import static development.ngbontsi.com.database.DatabaseHelper.C_ORGANIZER_ID;
import static development.ngbontsi.com.database.DatabaseHelper.C_ADDRESS_ID;
import static development.ngbontsi.com.database.DatabaseHelper.WEB_SITE_ADDRESS;
import static development.ngbontsi.com.database.DatabaseHelper.OTHER_DETAILS;
import static development.ngbontsi.com.database.DatabaseHelper.TABLE_CONTACT;


/**
 * Created by nbontsi on 2017/06/08.
 */

public class ContactDAO {

    private DatabaseHelper databaseHelper;

    public ContactDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    /**
     * This method is to create user record
     *
     * @param contact
     */
    public void addContact(Contact contact) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = getContentValues(contact, C_ORGANIZER_ID, contact.getOrganizer_id(), C_ADDRESS_ID, contact.getAddress_id());


        // Inserting Row
        db.insert(TABLE_CONTACT, null, values);
        db.close();
    }

    @NonNull
    private ContentValues getContentValues(Contact contact, String cOrganizerId, int organizer_id, String cAddressId, int address_id) {
        ContentValues values = new ContentValues();
        values.put(CONTACT_NUMBER, contact.getContact_number());
        values.put(cOrganizerId, organizer_id);
        values.put(cAddressId, address_id);
        values.put(WEB_SITE_ADDRESS, contact.getWeb_site_address());
        values.put(OTHER_DETAILS, contact.getOther_details());
        return values;
    }


    /**
     * This method to check user exist or not
     *
     * @param number
     * @return true/false
     */
    public boolean checkContact(String number) {

        // array of columns to fetch
        String[] columns = {
                CONTACT_ID
        };
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        // selection criteria
        String selection = CONTACT_NUMBER + " = ?" ;

        // selection arguments
        String[] selectionArgs = {number};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_CONTACT, //Table to query
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
     * @param contact
     */
    public void deleteUser(Contact contact) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_CONTACT, CONTACT_ID+ " = ?",
                new String[]{String.valueOf(contact.getContact_id())});
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<Contact> getAllContacts() throws Exception {
        // array of columns to fetch
        String[] columns = {
                CONTACT_ID,
                CONTACT_NUMBER,
                C_ADDRESS_ID,
                C_ORGANIZER_ID,
                WEB_SITE_ADDRESS,
                OTHER_DETAILS
                };
        // sorting orders
        String sortOrder =
                CONTACT_NUMBER + " ASC";
        List<Contact> contacts = new ArrayList<Contact>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_CONTACT, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst())
            do {
                Contact contact = getContact(cursor);
                // Adding user record to list
                contacts.add(contact);
            } while (cursor.moveToNext());
        cursor.close();
        db.close();

        // return user list
        return contacts;
    }

    @NonNull
    private Contact getContact(Cursor cursor) throws Exception{
        Contact contact = new Contact();
        contact.setContact_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(CONTACT_ID))));
        contact.setContact_number(cursor.getString(cursor.getColumnIndex(CONTACT_NUMBER)));
        contact.setAddress_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(C_ADDRESS_ID))));
        contact.setOrganizer_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(C_ORGANIZER_ID))));
        contact.setWeb_site_address(cursor.getString(cursor.getColumnIndex(WEB_SITE_ADDRESS)));
        contact.setOther_details(cursor.getString(cursor.getColumnIndex(OTHER_DETAILS)));
        return contact;
    }

    /**
     * This method to update user record
     *
     * @param contact
     */
    public void updateContac(Contact contact) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = getContentValues(contact, C_ADDRESS_ID, contact.getAddress_id(), C_ORGANIZER_ID, contact.getOrganizer_id());
        // updating row
        db.update(TABLE_CONTACT, values, CONTACT_ID+ " = ?",
                new String[]{String.valueOf(contact.getContact_id())});
        db.close();
    }
}
