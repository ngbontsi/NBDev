package development.ngbontsi.com.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import development.ngbontsi.com.model.EventStatus;
import development.ngbontsi.com.model.EventType;

/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */
@Dao
public interface EventTypeDAO {
    @Query(" select * from event_type")
    List<EventType> getEventStatuses();
    @Query("SELECT * FROM event_type where description LIKE  :description")
    EventType findByDescription(String description);

    @Query("SELECT COUNT(*) from event_type")
    int countEventStatuses();

    @Insert
    void insertAll(EventType... eventTypes);

    @Delete
    void delete(EventType eventType);
}
