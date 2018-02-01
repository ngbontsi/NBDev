package development.ngbontsi.com.database;


import android.content.Context;

import java.util.List;

import development.ngbontsi.com.model.EventType;
import development.ngbontsi.com.model.Organizer;

/**
 * Created by nbontsi on 2017/06/08.
 */

public class EventTypeDatabase {

    private ApplicationDatabase database;
    public EventTypeDatabase(Context context){
        database = ApplicationDatabase.getAppDatabase(context);
    }

    public EventType addEventType(EventType eventType){
        database.eventTypeDAO().insertAll(eventType);
        return eventType;
    }


    public EventType getEventType( String description){
        return database.eventTypeDAO().findByDescription(description);
    }

    public List<EventType> getOrganizers(){
        return database.eventTypeDAO().getEventStatuses();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }



}
