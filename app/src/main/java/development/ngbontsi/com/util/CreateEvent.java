package development.ngbontsi.com.util;

import android.content.Context;

import java.util.List;

import development.ngbontsi.com.database.CommercialDAO;
import development.ngbontsi.com.database.EventDAO;
import development.ngbontsi.com.database.EventStatusDAO;
import development.ngbontsi.com.database.EventTypeDAO;
import development.ngbontsi.com.database.OrganizerDAO;
import development.ngbontsi.com.database.VenueDAO;
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
    private EventDAO eventDAO;
    private EventStatusDAO eventStatusDAO;
    private EventTypeDAO eventTypeDAO;
    private CommercialDAO commercialDAO;
    private OrganizerDAO organizerDAO;
    private VenueDAO venueDAO;
      public CreateEvent(Context context){
        this.context = context;
        eventDAO = new EventDAO(context);
        eventStatusDAO = new EventStatusDAO(context);
        eventTypeDAO = new EventTypeDAO(context);
        commercialDAO = new CommercialDAO(context);
        organizerDAO=new OrganizerDAO(context);
        venueDAO = new VenueDAO(context);
    }
    public void create()throws Exception{

        List<Organizer> organizers = organizerDAO.getAllOrganizers();
        List<EventStatus> statuses= eventStatusDAO.getAllEventStatus();
        List<EventType> eventTypes = eventTypeDAO.getAllEventTypes();
        List<Commercial> commercials= commercialDAO.getAllCommercials();
        List<Venue> venues = venueDAO.getAllVenues();
        for (Organizer organizer:organizers)
        {
            Event event = new Event();
            event.setEvent_status_id(statuses.get(0).getEvent_status_id());
            event.setEvent_type_id(eventTypes.get(0).getEvent_type_id());
            event.setEvent_commercial_id(commercials.get(0).getEvent_commercial_id());
            event.setOrganizer_id(organizer.getOrganizer_id());
            event.setVenue_id(venues.get(0).getVenue_id());
            event.setName(organizer.getOrganizer_name());
            event.setStartDate(DateUtills.today());
            event.setEndDate(DateUtills.datePlus(31));
            eventDAO.addEvent(event);
        }

    }
}
