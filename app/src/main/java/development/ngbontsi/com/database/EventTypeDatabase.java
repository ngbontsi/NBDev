package development.ngbontsi.com.database;


import android.content.Context;

import java.util.List;

import development.ngbontsi.com.interfaces.EventTypeDAO;
import development.ngbontsi.com.model.EventType;
import development.ngbontsi.com.model.Organizer;

/**
 * Created by nbontsi on 2017/06/08.
 */

public class EventTypeDatabase {

    private EventTypeDAO database;
    public EventTypeDatabase(Context context){
        database = ApplicationDatabase.getAppDatabase(context).eventTypeDAO();
    }

    public EventType addEventType(EventType eventType){
        database.insertAll(eventType);
        return eventType;
    }


    public EventType getEventType( String description){
        return database.findByDescription(description);
    }

    public List<EventType> getOrganizers(){
        return database.getEventStatuses();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }


    public EventType getById(int event_type_id) {
        return database.findById(event_type_id);
    }
}
