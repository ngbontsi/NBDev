package development.ngbontsi.com.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.database.OrganizerDAO;
import development.ngbontsi.com.model.Organizer;

/**
 * Created by nbontsi on 2017/06/09.
 */

public class CreateOgrganizer {

    private Context context;
    private OrganizerDAO organizerDAO;
    private String[] names = new String[]{"Mbacu ","Mzoli","Ndira","Khalima","Sox","Lira"};
    private String[] emails = new String[]{"Mbacu@gmail.com","Mzoli@gmail.com","Ndira@gmail.com","Khalima@gmail.com","Sox@gmail.com","Lira@gmail.com"};
   public CreateOgrganizer(Context context){
       this.context = context;
       organizerDAO = new OrganizerDAO(context);
   }
public void create(){
    int size = names.length;
    for (int i=0; i<size-1;i++)
    {
     Organizer organizer = new Organizer();
      organizer.setOrganizer_name(names[i]);
      organizer.setOrganizer_email(emails[i]);
     organizerDAO.addUser(organizer);
    }

}

}
