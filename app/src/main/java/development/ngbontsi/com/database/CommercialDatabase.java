package development.ngbontsi.com.database;


import android.content.Context;

import java.util.List;

import development.ngbontsi.com.model.Commercial;


/**
 * Created by nbontsi on 2017/06/08.
 */

public class CommercialDatabase {

    private ApplicationDatabase database;
    public CommercialDatabase(Context context){
        database = ApplicationDatabase.getAppDatabase(context);
    }

    public Commercial addCommercial(Commercial commercial){
        database.commercialDAO().insertAll(commercial);
        return commercial;
    }


    public Commercial getCommercial( String description){
        return database.commercialDAO().findByDescription(description);
    }

    public List<Commercial> getCommercials(){
        return database.commercialDAO().getCommercials();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }


}
