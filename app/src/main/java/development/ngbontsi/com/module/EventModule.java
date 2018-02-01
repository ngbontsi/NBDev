package development.ngbontsi.com.module;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.database.CommercialDatabase;
import development.ngbontsi.com.database.ApplicationDatabase;
import development.ngbontsi.com.database.EventDatabase;
import development.ngbontsi.com.database.EventStatusDatabase;
import development.ngbontsi.com.database.EventTypeDatabase;
import development.ngbontsi.com.database.OrganizerDatabase;
import development.ngbontsi.com.database.VenueDatabase;
import development.ngbontsi.com.model.Event;



/**
 * Created by nbontsi on 2017/06/13.
 */

public class EventModule implements Serializable{

    private int event_id;
    private String name;
    private String event_description;
    private String event_type_description;
    private String event_commercial_description;
    private String organizer_name;
    private String venue_name;
    private ApplicationDatabase database;
    private EventDatabase eventDAO;
    private EventStatusDatabase eventStatusDAO;
    private EventTypeDatabase eventTypeDAO;
    private OrganizerDatabase organizerDAO;
    private VenueDatabase venueDAO;
    private CommercialDatabase commercialDAO;
    private Context context;
    public EventModule(){

    }
//    public List<EventModule>getAll()throws Exception{
//       eventDAO = new EventDatabase(context);
//        eventStatusDAO = new EventStatusDatabase(context);
//        eventTypeDAO = new EventTypeDatabase(context);
//        organizerDAO = new OrganizerDatabase(context);
//        venueDAO = new VenueDatabase(context);
//        commercialDAO = new CommercialDatabase(context);
//        List<Event> list = eventDAO.getAllEvents();
//        List<EventModule> eventModules = new ArrayList<EventModule>();
//        for(Event event: list){
//            EventModule eventModule = new EventModule();
//            eventModule.setEvent_id(event.getEvent_id());
//            eventModule.setName(event.getName());
//            eventModule.setVenue_name(venueDAO.getDescription(event.getVenue_id()));
//            eventModule.setEvent_type_description(eventTypeDAO.getDescription(event.getEvent_type_id()));
//            eventModule.setEvent_description(eventStatusDAO.getDescription(event.getEvent_status_id()));
//            eventModule.setEvent_commercial_description(commercialDAO.getDescription(event.getEvent_commercial_id()));
//            eventModule.setOrganizer_name(organizerDAO.getName(event.getOrganizer_id()));
//        eventModules.add(eventModule);
//    }
//        return eventModules;
//    }
    public EventModule(Context context){
        this.context = context;
//        database = new ApplicationDatabase(context);
    }
    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public String getEvent_type_description() {
        return event_type_description;
    }

    public void setEvent_type_description(String event_type_description) {
        this.event_type_description = event_type_description;
    }

    public String getEvent_commercial_description() {
        return event_commercial_description;
    }

    public void setEvent_commercial_description(String event_commercial_description) {
        this.event_commercial_description = event_commercial_description;
    }

    public String getOrganizer_name() {
        return organizer_name;
    }

    public void setOrganizer_name(String organizer_name) {
        this.organizer_name = organizer_name;
    }

    public String getVenue_name() {
        return venue_name;
    }

    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }



//    public List<EventModule> getEventModule(int event_id){
//        if(event_id!=0||event_id<0){
//            return eventModule(event_id);
//        }
//        return new ArrayList<EventModule>();
//    }
//    public List<EventModule> getAllEventModule(){
//       return eventModule(0);
//    }

//    private List<EventModule> eventModule(int event_id){
//        List<EventModule> events = new ArrayList<EventModule>();
//
//        String selectQuery = getSQLStatement(event_id);
//        SQLiteDatabase db = database.getReadableDatabase();
//        Cursor c = db.rawQuery(selectQuery, null);
//
//        if (c.moveToFirst())
//            do {
//                EventModule event = new EventModule();
//                event.setEvent_id(Integer.parseInt(c.getString(c.getColumnIndex(EVENT_ID))));
//                event.setEvent_commercial_description(c.getString(c.getColumnIndex(EVENT_COMMERCIAL_DESCRIPTION)));
//                event.setOrganizer_name(c.getString(c.getColumnIndex(ORGANIZER_NAME)));
//                event.setEvent_description(c.getString(c.getColumnIndex(EVENT_DESCRIPTION)));
//                event.setEvent_type_description(c.getString(c.getColumnIndex(EVENT_TYPE_DESCRIPTION)));
//                event.setVenue_name(c.getString(c.getColumnIndex(VENUE_NAME)));
//                // Adding user record to list
//                events.add(event);
//            } while (c.moveToNext());
//        c.close();
//        db.close();
//
//
//
//        return events;
//    }

    @NonNull
//    private String getSQLStatement(int event_id) {
//        String sql= "SELECT eve."
//                    +EVENT_ID+",evt."+EVENT_TYPE_DESCRIPTION+",evs."+EVENT_DESCRIPTION
//                    +",com."+EVENT_COMMERCIAL_DESCRIPTION+",org."+ORGANIZER_NAME+",ven."+ VENUE_NAME
//                    +" FROM " + TABLE_EVENT + " eve, "
//                    + TABLE_EVENT_STATUS + " evs, " + TABLE_EVENT_TYPE + " evt,"+TABLE_COMMERCIAL+" com,"
//                    +TABLE_ORGANIZER+" org,"+TABLE_VENUE+" ven"
//                    +" WHERE evs."+EVENT_STATUS_ID+" = eve."+E_EVENT_STATUS_ID
//                    + " and evt."+E_EVENT_TYPE_ID+" = eve."+E_EVENT_TYPE_ID
//                    +" and com."+EVENT_COMMERCIAL_ID+"= eve."+COM_EVENT_COMMERCIAL_ID
//                    +" and org."+ORGANIZER_ID+"= eve."+E_ORGANIZER_ID
//                    +" and ven."+ VENUE_ID +"= eve."+E_VANUE_ID;
//                if(event_id>0){
//                    sql+=" And eve."+EVENT_ID+" = "+event_id;
//                }
//        return sql;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
