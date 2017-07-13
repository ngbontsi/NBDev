package development.ngbontsi.com.util;

import android.content.Context;

import development.ngbontsi.com.database.AddressDAO;
import development.ngbontsi.com.database.CommercialDAO;
import development.ngbontsi.com.model.Address;

/**
 * Created by nbontsi on 2017/06/09.
 */

public class CreateAddress {

    private Context context;
    private AddressDAO addressDAO;
    private final String line_1="line_1";
    private final String line_2="line_2";
    private final String line_3="line_3";
    private final String line_4="line_4";
    private String[] city = new String[]{"Cape town","Gautang","Port Elizabeth","Mpumalanga","Cradock","Umtata"};
    private String[] street = new String[]{"Mxenge","Goven Mbeki","Kwa Zakhele","Tsumep","Lingelihle","Maliboo"};
    private int[] postalCode = new int[]{1020,5864,7525,5881,5008,6004};
    public CreateAddress(Context context){
        this.context = context;
        addressDAO = new AddressDAO(context);

    }
    public void create(){
        int size = city.length;
        for (int i=0; i<size-1;i++)
        {
            Address address = new Address();
            address.setCity(city[i]);
            address.setStreet(street[i]);
            address.setLine_1(line_1);
            address.setLine_2(line_2);
            address.setLine_3(line_3);
            address.setLine_4(line_4);
            address.setPostal_code(postalCode[i]);
            addressDAO.addAddress(address);
        }

    }
}
