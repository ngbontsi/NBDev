package development.ngbontsi.com.util;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.model.Address;

/**
 * Created by ndimphiwe.bontsi on 2018/02/09.
 */

public class AddressUtil {


    public static List<String> getStingValues(List<Address> addresses) {
        List<String> output = new ArrayList<String>();
        for (Address address:addresses) {
            output.add(address.getStreet());

        }

        return output;
    }
}
