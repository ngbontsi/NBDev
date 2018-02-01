package development.ngbontsi.com.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import development.ngbontsi.com.model.Address;
import development.ngbontsi.com.model.User;

/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */
@Dao
public interface AddressDAO {
    @Query(" select * from address")
    List<Address> getAddresses();
    @Query("SELECT * FROM address where street LIKE  :street")
    Address findByStreet(String street);

    @Query("select * from address where address_id like :address_id")
    Address findById(int address_id);

    @Query("SELECT COUNT(*) from address")
    int countAddresses();

    @Insert
    void insertAll(Address... addresses);

    @Delete
    void delete(Address address);
}
