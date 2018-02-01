package development.ngbontsi.com.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import development.ngbontsi.com.model.Address;
import development.ngbontsi.com.model.Contact;

/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */
@Dao
public interface ContactDAO {
    @Query(" select * from contact")
    List<Contact> getContacts();
    @Query("SELECT * FROM contact where organizer_id LIKE  :organizer_id")
    Contact findByUserId(int organizer_id);

    @Query("SELECT COUNT(*) from contact")
    int countContacts();

    @Insert
    void insertAll(Contact... addresses);

    @Delete
    void delete(Contact address);
}
