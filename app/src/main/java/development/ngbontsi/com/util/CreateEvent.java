package development.ngbontsi.com.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import development.ngbontsi.com.database.CommercialDatabase;
import development.ngbontsi.com.database.EventDatabase;
import development.ngbontsi.com.database.EventStatusDatabase;
import development.ngbontsi.com.database.EventTypeDatabase;
import development.ngbontsi.com.database.OrganizerDatabase;
import development.ngbontsi.com.database.VenueDatabase;
import development.ngbontsi.com.model.Commercial;
import development.ngbontsi.com.model.Event;
import development.ngbontsi.com.model.EventStatus;
import development.ngbontsi.com.model.EventType;
import development.ngbontsi.com.model.Organizer;
import development.ngbontsi.com.model.Venue;

/**
 * Created by nbontsi on 2017/06/09.
 */

public class CreateEvent {

    private Context context;
    private EventDatabase eventDAO;
    private EventStatusDatabase eventStatusDAO;
    private EventTypeDatabase eventTypeDAO;
    private CommercialDatabase commercialDAO;
    private OrganizerDatabase organizerDAO;
    private VenueDatabase venueDAO;
      public CreateEvent(Context context){
        this.context = context;
        eventDAO = new EventDatabase(context);
        eventStatusDAO = new EventStatusDatabase(context);
        eventTypeDAO = new EventTypeDatabase(context);
        commercialDAO = new CommercialDatabase(context);
        organizerDAO=new OrganizerDatabase(context);
        venueDAO = new VenueDatabase(context);
    }
    public void create()throws Exception{

        List<Organizer> organizers = new ArrayList<>();
        List<EventStatus> statuses= new ArrayList<>();
        List<EventType> eventTypes = new ArrayList<>();
        List<Commercial> commercials= new ArrayList<>();
        List<Venue> venues = new ArrayList<>();
        for (Organizer organizer:organizers)
        {
            Event event = new Event();
            event.setEvent_status_id(statuses.get(0).getEvent_status_id());
            event.setEvent_type_id(eventTypes.get(0).getEvent_type_id());
            event.setEvent_commercial_id(commercials.get(0).getEvent_commercial_id());
            event.setOrganizer_id(organizer.getOrganizer_id());
            event.setVenue_id(venues.get(0).getVenue_id());
            event.setName(organizer.getOrganizer_name());
//            event.setStartDate("");
//            event.setEndDate("");
//            eventDAO.addEvent(event);
        }

    }
}
