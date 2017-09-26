package development.ngbontsi.com.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import development.ngbontsi.com.database.DatabaseHelper;
import development.ngbontsi.com.model.Address;

/**
 * Created by nbontsi on 2017/08/21.
 */
@Dao
public interface AddressDataControler {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAddress(Address address);
    @Query("Select * form "+ DatabaseHelper.TABLE_ADDRESS)
    public List<Address> getAllAddresses();
    @Query("select * from "+DatabaseHelper.TABLE_ADDRESS+" where "+DatabaseHelper.ADDRESS_ID+" =:"+DatabaseHelper.ADDRESS_ID)
    public List<Address> getAddress(long id);
}
