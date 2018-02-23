package development.ngbontsi.com.util;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.model.EventType;

/**
 * Created by ndimphiwe.bontsi on 2018/02/09.
 */

public class EventTypeUtil {

    public static List<String> getTypeDescription(List<EventType> eventTypeList) {
        List<String> output = new ArrayList<String>();
        for (EventType eventType: eventTypeList) {
            output.add(eventType.getEvent_type_description());
        }

        return output;
    }
}
