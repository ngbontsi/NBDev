package development.ngbontsi.com.util;

import android.content.Context;

import development.ngbontsi.com.database.CommercialDAO;
import development.ngbontsi.com.model.Commercial;

/**
 * Created by nbontsi on 2017/06/09.
 */

public class CreateEventCommercial {

    private Context context;
    private CommercialDAO commercialDAO;
    private String[] names = new String[]{"Free ","Payable","Commercial"};
    public CreateEventCommercial(Context context){
        this.context = context;
        commercialDAO = new CommercialDAO(context);
    }
    public void create(){
        int size = names.length;
        for (int i=0; i<size-1;i++)
        {
            Commercial organizer = new Commercial();
            organizer.setEvent_commercial_description(names[i]);
            commercialDAO.addUser(organizer);
        }

    }
}
