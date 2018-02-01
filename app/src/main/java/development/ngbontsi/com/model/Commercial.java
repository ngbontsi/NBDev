package development.ngbontsi.com.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nbontsi on 2017/06/07.
 */

@Entity(tableName = "commercial")
public class Commercial {
    @PrimaryKey(autoGenerate = true)
    private int event_commercial_id;
    @ColumnInfo(name = "description")
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
