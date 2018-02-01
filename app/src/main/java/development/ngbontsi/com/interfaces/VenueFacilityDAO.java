package development.ngbontsi.com.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import development.ngbontsi.com.model.Venue;
import development.ngbontsi.com.model.VenueFacility;

/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */
@Dao
public interface VenueFacilityDAO {
    @Query(" select * from venue_facility")
    List<VenueFacility> getVenueFacilities();
    @Query("SELECT * FROM venue_facility where description LIKE  :description")
    VenueFacility findByDescription(String description);

    @Query("SELECT COUNT(*) from venue_facility")
    int countVenueFacilities();

    @Insert
    void insertAll(VenueFacility... venueFacilities);

    @Delete
    void delete(VenueFacility venueFacility);
}
