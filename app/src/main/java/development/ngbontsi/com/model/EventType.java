package development.ngbontsi.com.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nbontsi on 2017/06/07.
 */
@Entity(tableName = "event_type")
public class EventType {
    @PrimaryKey(autoGenerate = true)
    private int event_type_id;
    @ColumnInfo(name="description")
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
