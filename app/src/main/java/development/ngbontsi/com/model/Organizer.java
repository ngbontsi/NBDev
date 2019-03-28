package development.ngbontsi.com.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by nbontsi on 2017/06/07.
 */

public class Organizer {
    @SerializedName("organizer_id")
    private int organizer_id;
    @SerializedName("organizer_name")
    private String organizer_name;
    @SerializedName("organizer_email")
    private String organizer_email;
    @SerializedName("user_id")
    private int user_id;

    public int getOrganizer_id() {
        return organizer_id;
    }

    public void setOrganizer_id(int organizer_id) {
        this.organizer_id = organizer_id;
    }

    public String getOrganizer_name() {
        return organizer_name;
    }

    public void setOrganizer_name(String organizer_name) {
        this.organizer_name = organizer_name;
    }

    public String getOrganizer_email() {
        return organizer_email;
    }

    public void setOrganizer_email(String organizer_email) {
        this.organizer_email = organizer_email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
