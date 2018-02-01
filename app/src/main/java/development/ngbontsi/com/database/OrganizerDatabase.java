package development.ngbontsi.com.database;


import android.content.Context;

import java.util.List;

import development.ngbontsi.com.model.Organizer;
import development.ngbontsi.com.model.User;

/**
 * Created by nbontsi on 2017/06/08.
 */

public class OrganizerDatabase {

    private ApplicationDatabase database;
    public OrganizerDatabase(Context context){
        database = ApplicationDatabase.getAppDatabase(context);
    }

    public Organizer addOrganizer(Organizer organizer){
        database.organizerDAO().insertAll(organizer);
        return organizer;
    }


    public Organizer getOrganizer( String description){
        return database.organizerDAO().findByDescription(description);
    }

    public List<Organizer> getOrganizers(){
        return database.organizerDAO().getOrganizers();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }


}
