package development.ngbontsi.com.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import development.ngbontsi.com.model.Contact;
import development.ngbontsi.com.model.Event;

/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */
@Dao
public interface EventDAO {
    @Query(" select * from event")
    List<Event> getEvents();
    @Query("SELECT * FROM event where organizer_id LIKE  :organizer_id")
    Event findByUserId(int organizer_id);

    @Query("select * from event where event_id like :event_id")
    Event findById(int event_id);

    @Query("SELECT COUNT(*) from event")
    int countEvents();

    @Insert
    void insertAll(Event... addresses);

    @Delete
    void delete(Event address);
}
