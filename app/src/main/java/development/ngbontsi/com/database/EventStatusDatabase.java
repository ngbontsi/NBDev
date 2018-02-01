package development.ngbontsi.com.database;


import android.content.Context;

import java.util.List;

import development.ngbontsi.com.model.EventStatus;
import development.ngbontsi.com.model.EventType;

/**
 * Created by nbontsi on 2017/06/08.
 */

public class EventStatusDatabase {


    private ApplicationDatabase database;
    public EventStatusDatabase(Context context){
        database = ApplicationDatabase.getAppDatabase(context);
    }

    public EventStatus addEventStatus(EventStatus eventStatus){
        database.eventStatusDAO().insertAll(eventStatus);
        return eventStatus;
    }


    public EventStatus getEventStatus( String description){
        return database.eventStatusDAO().findByDescription(description);
    }

    public List<EventStatus> getEventStatuses(){
        return database.eventStatusDAO().getEventStatuses();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }



}
