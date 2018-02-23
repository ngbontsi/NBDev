package development.ngbontsi.com.util;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.model.EventStatus;

/**
 * Created by ndimphiwe.bontsi on 2018/02/09.
 */

public class EventStatusUtil {


    public static List<String> getStatusDescription(List<EventStatus> eventStatusList) {
        List<String> output = new ArrayList<String>();
        for (EventStatus eventType: eventStatusList) {
            output.add(eventType.getEvent_description());
        }

        return output;
    }

}
