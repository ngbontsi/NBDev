package development.ngbontsi.com.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by nbontsi on 2017/06/07.
 */

public class EventType {
    @SerializedName("type_id")
    private int event_type_id;
    @SerializedName("description")
    private String event_type_description;

    public int getEvent_type_id() {
        return event_type_id;
    }

    public void setEvent_type_id(int event_type_id) {
        this.event_type_id = event_type_id;
    }

    public String getEvent_type_description() {
        return event_type_description;
    }

    public void setEvent_type_description(String event_type_description) {
        this.event_type_description = event_type_description;
    }
}
