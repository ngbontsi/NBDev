package development.ngbontsi.com.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.math.BigDecimal;

/**
 * Created by nbontsi on 2017/06/07.
 */
@Entity(tableName = "contact")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    private int contact_id;
    @ColumnInfo(name = "organizer_id")
    private int organizer_id;
    @ColumnInfo(name = "address_id")
    private int address_id;
    @ColumnInfo(name = "contact_number")
    private String contact_number;
    @ColumnInfo(name = "web_site_address")
    private String web_site_address;
    @ColumnInfo(name = "other_details")
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
