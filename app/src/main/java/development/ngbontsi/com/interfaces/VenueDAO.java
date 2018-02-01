package development.ngbontsi.com.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import development.ngbontsi.com.model.Commercial;
import development.ngbontsi.com.model.Venue;

/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */
@Dao
public interface VenueDAO {
    @Query(" select * from venue")
    List<Venue> getVenues();
    @Query("SELECT * FROM venue where description LIKE  :description")
    Venue findByDescription(String description);

    @Query("SELECT COUNT(*) from venue")
    int countVenues();

    @Insert
    void insertAll(Venue... venues);

    @Delete
    void delete(Venue venue);
}
