package development.ngbontsi.com.util;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.model.Commercial;

/**
 * Created by ndimphiwe.bontsi on 2018/02/09.
 */

public class CommercialUtil {
    public static List<String> getStringValues(List<Commercial> commercials) {
        List<String> output = new ArrayList<String>();

        for (Commercial commercial:commercials) {
            output.add(commercial.getEvent_commercial_description());

        }
        return output;
    }
}
