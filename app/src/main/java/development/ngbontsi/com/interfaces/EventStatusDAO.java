package development.ngbontsi.com.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import development.ngbontsi.com.model.Commercial;
import development.ngbontsi.com.model.EventStatus;

/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */
@Dao
public interface EventStatusDAO {
    @Query(" select * from event_status")
    List<EventStatus> getEventStatuses();
    @Query("SELECT * FROM event_status where description LIKE  :description")
    EventStatus findByDescription(String description);

    @Query("SELECT COUNT(*) from event_status")
    int countEventStatuses();

    @Insert
    void insertAll(EventStatus... eventStatuses);

    @Delete
    void delete(EventStatus eventStatus);
}
