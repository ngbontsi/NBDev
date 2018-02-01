package development.ngbontsi.com.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.database.AddressData;
import development.ngbontsi.com.database.ContactDatabase;
import development.ngbontsi.com.database.OrganizerDatabase;
import development.ngbontsi.com.model.Address;
import development.ngbontsi.com.model.Contact;
import development.ngbontsi.com.model.Organizer;

/**
 * Created by nbontsi on 2017/06/09.
 */

public class CreateContact {

    private Context context;
    private ContactDatabase contactDAO;
    private OrganizerDatabase organizerDAO;
    private AddressData addressDAO;
    private String[] contact_number = new String[]{"021 321 0254","021 465 2453","021 098 4350","072 321 1254","078 321 0253","076 321 0252"};
    public CreateContact(Context context){
        this.context = context;
        contactDAO = new ContactDatabase(context);
        organizerDAO = new OrganizerDatabase(context);
        addressDAO = new AddressData(context);
    }
    public void create()throws Exception{
        List<Organizer> organizers = new ArrayList<>();
        List<Address> addresses = new ArrayList<>();
        int size = addresses.size();
        for (int i=0; i<size-1;i++)
        {
            Contact contact = new Contact();
            Organizer organizer = organizers.get(i);
            Address address = addresses.get(i);

            contact.setOrganizer_id(organizer.getOrganizer_id());
            contact.setAddress_id(address.getAddress_id());
            contact.setContact_number(contact_number[i]);
            contact.setWeb_site_address("Ndirax.co.za");
            contact.setOther_details("Other Details");
            contactDAO.addContact(contact);
        }

    }
}
