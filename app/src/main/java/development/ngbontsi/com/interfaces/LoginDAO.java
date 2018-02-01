package development.ngbontsi.com.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import development.ngbontsi.com.model.Login;
import development.ngbontsi.com.model.User;

/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */
@Dao
public interface LoginDAO {
    @Query(" select * from login")
    List<Login> getLogins();
    @Query("SELECT * FROM login where username LIKE  :username")
    Login findByUserName(String username);
    @Query("select * from login where id like :id")
    Login findById(int id);

    @Query("SELECT COUNT(*) from login")
    int countLogins();

    @Insert
    void insertAll(Login... logins);

    @Delete
    void delete(Login login);
}
