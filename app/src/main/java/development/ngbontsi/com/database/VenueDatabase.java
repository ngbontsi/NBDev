package development.ngbontsi.com.database;


import android.content.Context;

import java.util.List;

import development.ngbontsi.com.interfaces.VenueDAO;
import development.ngbontsi.com.model.User;
import development.ngbontsi.com.model.Venue;

/**
 * Created by nbontsi on 2017/06/08.
 */

public class VenueDatabase {

    private VenueDAO database;

    public VenueDatabase(Context context){
        database = ApplicationDatabase.getAppDatabase(context).venueDAO();
    }

    public Venue addVenue(Venue venue){
        database.insertAll(venue);
        return venue;
    }


    public Venue getVenue( String description){
        return database.findByDescription(description);
    }

    public List<Venue> getVenues(){
        return database.getVenues();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }

    public Venue getById(int venue_id) {
        return database.findById(venue_id);
    }
}
