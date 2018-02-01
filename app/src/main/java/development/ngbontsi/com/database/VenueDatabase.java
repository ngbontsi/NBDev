package development.ngbontsi.com.database;


import android.content.Context;

import java.util.List;

import development.ngbontsi.com.model.User;
import development.ngbontsi.com.model.Venue;

/**
 * Created by nbontsi on 2017/06/08.
 */

public class VenueDatabase {

    private ApplicationDatabase database;

    public VenueDatabase(Context context){
        database = ApplicationDatabase.getAppDatabase(context);
    }

    public Venue addVenue(Venue venue){
        database.venueDAO().insertAll(venue);
        return venue;
    }


    public Venue getVenue( String description){
        return database.venueDAO().findByDescription(description);
    }

    public List<Venue> getVenues(){
        return database.venueDAO().getVenues();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }
}