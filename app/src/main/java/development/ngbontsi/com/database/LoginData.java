package development.ngbontsi.com.database;

import android.content.Context;

import java.util.List;

import development.ngbontsi.com.model.Login;
import development.ngbontsi.com.model.User;

/**
 * Created by nbontsi on 2017/06/08.
 */
public class LoginData {
private ApplicationDatabase database;
    public LoginData(Context context){
        database = ApplicationDatabase.getAppDatabase(context);
    }

    public Login addLogin(Login login){
        database.loginDAO().insertAll(login);
        return login;
    }


    public Login getLogin( String userName){
        return database.loginDAO().findByUserName(userName);
    }

    public List<Login> getLogins(){
        return database.loginDAO().getLogins();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }

    public boolean userExist(String username) {
        return  getLogin(username) != null;
    }

    public String userPassword(String username) {
        if(userExist(username))
        return  getLogin(username).getPassword();
    return null;
    }
}
