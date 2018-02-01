package development.ngbontsi.com.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nbontsi on 2017/06/07.
 */
@Entity(tableName = "venue_facility")
public class VenueFacility {
    @PrimaryKey(autoGenerate = true)
    private int facility_code;
    @ColumnInfo(name = "venue_id")
    private int venue_id;
    @ColumnInfo(name = "description")
    private String facility_description;

    public int getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(int venue_id) {
        this.venue_id = venue_id;
    }

    public int getFacility_code() {
        return facility_code;
    }

    public void setFacility_code(int facility_code) {
        this.facility_code = facility_code;
    }

    public String getFacility_description() {
        return facility_description;
    }

    public void setFacility_description(String facility_description) {
        this.facility_description = facility_description;
    }
}
