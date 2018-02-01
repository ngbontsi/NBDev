package development.ngbontsi.com.database;


import android.content.Context;

import java.util.List;

import development.ngbontsi.com.interfaces.EventStatusDAO;
import development.ngbontsi.com.model.EventStatus;
import development.ngbontsi.com.model.EventType;

/**
 * Created by nbontsi on 2017/06/08.
 */

public class EventStatusDatabase {


    private EventStatusDAO database;
    public EventStatusDatabase(Context context){
        database = ApplicationDatabase.getAppDatabase(context).eventStatusDAO();
    }

    public EventStatus addEventStatus(EventStatus eventStatus){
        database.insertAll(eventStatus);
        return eventStatus;
    }


    public EventStatus getEventStatus( String description){
        return database.findByDescription(description);
    }

    public List<EventStatus> getEventStatuses(){
        return database.getEventStatuses();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }


    public EventStatus getById(int event_status_id) {
        return database.findById(event_status_id);
    }
}
