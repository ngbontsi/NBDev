package development.ngbontsi.com.util;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.model.Organizer;

/**
 * Created by ndimphiwe.bontsi on 2018/02/09.
 */

public class OrganiserUtil {


    public static List<String> getOrganisors(List<Organizer> organizers) {
        List<String> output = new ArrayList<String>();
        for (Organizer organizer: organizers) {
            output.add(organizer.getOrganizer_name());
        }

        return output;
    }

}
