package development.ngbontsi.com.database;


import android.content.Context;

import java.util.List;

import development.ngbontsi.com.interfaces.CommercialDAO;
import development.ngbontsi.com.model.Commercial;


/**
 * Created by nbontsi on 2017/06/08.
 */

public class CommercialDatabase {

    private CommercialDAO database;
    public CommercialDatabase(Context context){
        database = ApplicationDatabase.getAppDatabase(context).commercialDAO();
    }

    public Commercial addCommercial(Commercial commercial){
        database.insertAll(commercial);
        return commercial;
    }


    public Commercial getCommercial( String description){
        return database.findByDescription(description);
    }

    public List<Commercial> getCommercials(){
        return database.getCommercials();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }


    public Commercial getById(int event_commercial_id) {
        return database.findById(event_commercial_id);
    }
}
