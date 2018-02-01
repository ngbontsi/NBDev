package development.ngbontsi.com.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import development.ngbontsi.com.model.User;

/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */
@Dao
public interface UserDAO {
    @Query(" select * from users")
    List<User> getUsers();
    @Query("SELECT * FROM users where first_name LIKE  :firstName AND last_name LIKE :lastName")
    User findByName(String firstName, String lastName);

    @Query("select * from users where id like :id")
    User findById(int id);

    @Query("SELECT COUNT(*) from users")
    int countUsers();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
