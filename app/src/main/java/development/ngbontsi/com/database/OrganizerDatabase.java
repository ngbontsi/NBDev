package development.ngbontsi.com.database;


import android.content.Context;

import java.util.List;

import development.ngbontsi.com.interfaces.OrganizerDAO;
import development.ngbontsi.com.model.Organizer;


/**
 * Created by nbontsi on 2017/06/08.
 */

public class OrganizerDatabase {

    private OrganizerDAO database;
    public OrganizerDatabase(Context context){
        database = ApplicationDatabase.getAppDatabase(context).organizerDAO();
    }

    public Organizer addOrganizer(Organizer organizer){
        database.insertAll(organizer);
        return organizer;
    }


    public Organizer getOrganizer( String description){
        return database.findByDescription(description);
    }

    public List<Organizer> getOrganizers(){
        return database.getOrganizers();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }


    public Organizer getByEventId(int organizer_id) {
        return  database.findById(organizer_id);
    }
}
