package development.ngbontsi.com.database;


import android.content.Context;

import java.util.List;

import development.ngbontsi.com.model.Address;
import development.ngbontsi.com.model.Commercial;

/**
 * Created by nbontsi on 2017/06/08.
 */

public class AddressDatabase {


    private ApplicationDatabase database;
    public AddressDatabase(Context context){
        database = ApplicationDatabase.getAppDatabase(context);
    }

    public Address addAddress(Address address){
        database.addressDAO().insertAll(address);
        return address;
    }


    public Address getCommercial( String street){
        return database.addressDAO().findByStreet(street);
    }

    public List<Address> getAddresses(){
        return database.addressDAO().getAddresses();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }


}
