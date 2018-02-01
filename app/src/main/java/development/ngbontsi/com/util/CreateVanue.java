package development.ngbontsi.com.util;

import android.content.Context;

import development.ngbontsi.com.database.VenueDatabase;
import development.ngbontsi.com.model.Venue;

/**
 * Created by nbontsi on 2017/06/09.
 */

public class CreateVanue {

    private Context context;
    private VenueDatabase venueDAO;
    private String[] names = new String[]{"Music","Wedding","Perfomance","soccer","rugby"};
    public CreateVanue(Context context){
        this.context = context;
        venueDAO = new VenueDatabase(context);

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
