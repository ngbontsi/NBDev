package development.ngbontsi.com.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by nbontsi on 2017/06/07.
 */


public class Commercial {
    @SerializedName("commercial_id")
    private int event_commercial_id;
    @SerializedName( "description")
    private String event_commercial_description;

    public int getEvent_commercial_id() {
        return event_commercial_id;
    }

    public void setEvent_commercial_id(int event_commercial_id) {
        this.event_commercial_id = event_commercial_id;
    }

    public String getEvent_commercial_description() {
        return event_commercial_description;
    }

    public void setEvent_commercial_description(String event_commercial_description) {
        this.event_commercial_description = event_commercial_description;
    }
}
