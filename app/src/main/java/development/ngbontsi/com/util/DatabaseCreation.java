package development.ngbontsi.com.util;

import android.content.Context;

/**
 * Created by nbontsi on 2017/06/23.
 */

public class DatabaseCreation {
    private Context context;
    //Create Event Status
   private CreateEventStatus createEventStatus;
   private CreateEventType createEventType ;
   private CreateEventCommercial createEventCommercial ;
   private CreateAddress createAddress ;
   private CreateOgrganizer createOgrganizer ;
   private CreateContact createContact ;
   private CreateVanue createVanue ;
    private CreateEvent createEvent;


    public DatabaseCreation(Context context){
        this.context = context;
    }
    public void createDataBase()throws Exception{
    //Create Event Status
        createEventStatus = new CreateEventStatus(context);
        createEventStatus.create();
        //Create Event Types
        createEventType = new CreateEventType(context);
        createEventType.create();
        //Create Event Commercials
        createEventCommercial = new CreateEventCommercial(context);
        createEventCommercial.create();
        // Create Addresses
        createAddress = new CreateAddress(context);
        createAddress.create();
        //    Create Organizers
        createOgrganizer = new CreateOgrganizer(context);
        createOgrganizer.create();
        //    Create Contact
        createContact = new CreateContact(context);
        createContact.create();
        //Create Vanue
        createVanue = new CreateVanue(context);
        createVanue.create();

        createEvent = new CreateEvent(context);
        createEvent.create();
    }

}
