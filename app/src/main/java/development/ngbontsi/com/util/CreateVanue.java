package development.ngbontsi.com.util;

import android.content.Context;

import development.ngbontsi.com.database.EventTypeDAO;
import development.ngbontsi.com.database.VenueDAO;
import development.ngbontsi.com.model.Address;
import development.ngbontsi.com.model.EventType;
import development.ngbontsi.com.model.Venue;

/**
 * Created by nbontsi on 2017/06/09.
 */

public class CreateVanue {

    private Context context;
    private VenueDAO venueDAO;
    private String[] names = new String[]{"Music","Wedding","Perfomance","soccer","rugby"};
    public CreateVanue(Context context){
        this.context = context;
        venueDAO = new VenueDAO(context);

    }
    public void create(){
        int size = names.length;
        for (int i=0; i<size-1;i++)
        {
            Venue venue = new Venue();
            venue.setVenue_name(names[i]);
            venueDAO.addVenue(venue);
        }

    }
}
