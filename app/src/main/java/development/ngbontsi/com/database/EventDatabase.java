package development.ngbontsi.com.database;


import android.content.Context;

import java.util.List;

import development.ngbontsi.com.model.Event;
import development.ngbontsi.com.model.EventStatus;

/**
 * Created by nbontsi on 2017/06/08.
 */

public class EventDatabase {

    private ApplicationDatabase database;
    public EventDatabase(Context context){
        database = ApplicationDatabase.getAppDatabase(context);
    }

    public Event addEventStatus(Event event){
        database.eventDAO().insertAll(event);
        return event;
    }


    public Event getEvent( int id){
        return database.eventDAO().findByUserId(id);
    }

    public List<Event> getEvents(){
        return database.eventDAO().getEvents();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }

}
