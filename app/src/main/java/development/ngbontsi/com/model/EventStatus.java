package development.ngbontsi.com.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nbontsi on 2017/06/07.
 */
@Entity(tableName = "event_status")
public class EventStatus {
    @PrimaryKey(autoGenerate = true)
    private int event_status_id;
    @ColumnInfo(name = "description")
    private String event_description;

    public int getEvent_status_id() {
        return event_status_id;
    }

    public void setEvent_status_id(int event_status_id) {
        this.event_status_id = event_status_id;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }
}
