package development.ngbontsi.com.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import development.ngbontsi.com.model.Address;
import development.ngbontsi.com.model.Commercial;

/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */
@Dao
public interface CommercialDAO {
    @Query(" select * from commercial")
    List<Commercial> getCommercials();
    @Query("SELECT * FROM commercial where description LIKE  :description")
    Commercial findByDescription(String description);

    @Query("SELECT COUNT(*) from commercial")
    int countCommercials();

    @Insert
    void insertAll(Commercial... commercials);

    @Delete
    void delete(Commercial commercial);
}
