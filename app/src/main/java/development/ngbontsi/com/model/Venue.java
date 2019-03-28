package development.ngbontsi.com.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by nbontsi on 2017/06/07.
 */

public class Venue {
    @SerializedName("venue_id")
    private int venue_id;
    @SerializedName("description")
    private String venue_name;

    public int getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(int venue_id) {
        this.venue_id = venue_id;
    }

    public String getVenue_name() {
        return venue_name;
    }

    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }

}
