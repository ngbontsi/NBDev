package development.ngbontsi.com.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import development.ngbontsi.com.model.Commercial;
import development.ngbontsi.com.model.Organizer;

/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */
@Dao
public interface OrganizerDAO {
    @Query(" select * from organizer")
    List<Organizer> getOrganizers();
    @Query("SELECT * FROM organizer where organizer_name LIKE  :organizer_name")
    Organizer findByDescription(String organizer_name);

    @Query("select * from organizer where organizer_id like :organizer_id")
    Organizer findById(int organizer_id);

    @Query("SELECT COUNT(*) from organizer")
    int countOrganizers();

    @Insert
    void insertAll(Organizer... commercials);

    @Delete
    void delete(Organizer commercial);
}
