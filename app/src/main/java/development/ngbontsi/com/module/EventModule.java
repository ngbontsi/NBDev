package development.ngbontsi.com.module;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.database.ApplicationDatabase;
import development.ngbontsi.com.database.CommercialDatabase;
import development.ngbontsi.com.database.EventDatabase;
import development.ngbontsi.com.database.EventStatusDatabase;
import development.ngbontsi.com.database.EventTypeDatabase;
import development.ngbontsi.com.database.OrganizerDatabase;
import development.ngbontsi.com.database.VenueDatabase;
import development.ngbontsi.com.model.Event;

/**
 * Created by ndimphiwe.bontsi on 2018/02/01.
 */

public class EventModule {
    private Context context;

    private ApplicationDatabase database;
    private EventDatabase eventDatabase;
    private EventStatusDatabase eventStatusDatabase;
    private EventTypeDatabase eventTypeDatabase;
    private OrganizerDatabase organizerDatabase;
    private VenueDatabase venueDatabase;
    private CommercialDatabase commercialDatabase;

    public EventModule(Context context){
        this.context = context;
        eventDatabase = new EventDatabase(context);
        eventStatusDatabase = new EventStatusDatabase(context);
        eventTypeDatabase = new EventTypeDatabase(context);
        organizerDatabase = new OrganizerDatabase(context);
        venueDatabase = new VenueDatabase(context);
        commercialDatabase = new CommercialDatabase(context);
    }

    public List<EventLayout> getAll() {

        List<Event> events = eventDatabase.getEvents();
        List<EventLayout> outputData = new ArrayList<>();
        for (Event event:events) {
            int eventId =event.getEvent_id();
            EventLayout eventLayout = new EventLayout();
            eventLayout.setCommercial(commercialDatabase.getById(event.getEvent_commercial_id()).getEvent_commercial_description());
            eventLayout.setVenue(venueDatabase.getById(event.getVenue_id()).getVenue_name());
            eventLayout.setStatus(eventStatusDatabase.getById(event.getEvent_status_id()).getEvent_description());
            eventLayout.setOrganizer(organizerDatabase.getByEventId(event.getOrganizer_id()).getOrganizer_name());
            eventLayout.setName(event.getName());
            eventLayout.setType(eventTypeDatabase.getById(event.getEvent_type_id()).getEvent_type_description());
            eventLayout.setId(eventId);
            outputData.add(eventLayout);


        }
        return  outputData;
    }

}
