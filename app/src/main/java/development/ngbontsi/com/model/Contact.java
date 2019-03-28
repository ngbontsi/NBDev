package development.ngbontsi.com.model;



import com.google.gson.annotations.SerializedName;



/**
 * Created by nbontsi on 2017/06/07.
 */

public class Contact {
    @SerializedName("contact_id")
    private int contact_id;
    @SerializedName("organizer_id")
    private int organizer_id;
    @SerializedName( "address_id")
    private int address_id;
    @SerializedName( "contact_number")
    private String contact_number;
    @SerializedName("web_site_address")
    private String web_site_address;
    @SerializedName("other_details")
    private String other_details;

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public int getOrganizer_id() {
        return organizer_id;
    }

    public void setOrganizer_id(int organizer_id) {
        this.organizer_id = organizer_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getWeb_site_address() {
        return web_site_address;
    }

    public void setWeb_site_address(String web_site_address) {
        this.web_site_address = web_site_address;
    }

    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }
}
