package development.ngbontsi.com.database;


import android.content.Context;

import java.util.List;

import development.ngbontsi.com.model.Contact;
import development.ngbontsi.com.model.Event;

/**
 * Created by nbontsi on 2017/06/08.
 */

public class ContactDatabase {

    private ApplicationDatabase database;
    public ContactDatabase(Context context){
        database = ApplicationDatabase.getAppDatabase(context);
    }

    public Contact addContact(Contact contact){
        database.contactDAO().insertAll(contact);
        return contact;
    }


    public Contact getContact( int id){
        return database.contactDAO().findByUserId(id);
    }

    public List<Contact> getContacts(){
        return database.contactDAO().getContacts();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }



}
