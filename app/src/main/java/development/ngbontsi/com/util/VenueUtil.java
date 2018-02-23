package development.ngbontsi.com.util;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.model.Venue;

/**
 * Created by ndimphiwe.bontsi on 2018/02/09.
 */

public class VenueUtil {

    public static List<String> getVenues(List<Venue> venues) {
        List<String> output = new ArrayList<>();
        for (Venue venue:venues) {
            output.add(venue.getVenue_name());
        }

        return output;
    }
}
