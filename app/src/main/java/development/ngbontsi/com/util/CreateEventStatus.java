package development.ngbontsi.com.util;

import android.content.Context;

import development.ngbontsi.com.database.EventStatusDatabase;
import development.ngbontsi.com.model.EventStatus;

/**
 * Created by nbontsi on 2017/06/09.
 */

public class CreateEventStatus {

    private Context context;
    private EventStatusDatabase eventStatusDAO;
    private String[] names = new String[]{"New","Pasted","Cancelled","Still to come"};
    public CreateEventStatus(Context context){
        this.context = context;
        eventStatusDAO = new EventStatusDatabase(context);
    }
    public void create(){
        int size = names.length;
        for (int i=0; i<size-1;i++)
        {
            EventStatus organizer = new EventStatus();
            organizer.setEvent_description(names[i]);
            eventStatusDAO.addEventStatus(organizer);
        }

    }
}
