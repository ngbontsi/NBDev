package development.ngbontsi.com.util;

import android.content.Context;

import development.ngbontsi.com.database.CommercialDAO;
import development.ngbontsi.com.database.EventTypeDAO;
import development.ngbontsi.com.model.Commercial;
import development.ngbontsi.com.model.EventType;

/**
 * Created by nbontsi on 2017/06/09.
 */

public class CreateEventType {

    private Context context;
    private EventTypeDAO eventTypeDAO;
    private String[] names = new String[]{"Music","Wedding","Perfomance","soccer","rugby"};
    public CreateEventType(Context context){
        this.context = context;
        eventTypeDAO = new EventTypeDAO(context);
    }
    public void create(){
        int size = names.length;
        for (int i=0; i<size-1;i++)
        {
            EventType eventType = new EventType();
            eventType.setEvent_type_description(names[i]);
            eventTypeDAO.addEventType(eventType);
        }

    }
}
