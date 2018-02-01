package development.ngbontsi.com.database;

import android.content.Context;

import java.util.List;

import development.ngbontsi.com.model.User;

/**
 * Created by nbontsi on 2017/06/08.
 */
public class UserData {
private ApplicationDatabase database;
    public UserData(Context context){
        database = ApplicationDatabase.getAppDatabase(context);
    }

    public User addUser(User user){
        database.userDAO().insertAll(user);
        return user;
    }


    public User getUser( String firstName,String lastName){
        return database.userDAO().findByName(firstName,lastName);
    }

    public List<User> getUsers(){
        return database.userDAO().getUsers();
    }

    protected void finalize(){
        ApplicationDatabase.destroyInstance();
    }

    public boolean userExist(String firstname, String lastname) {
        return  getUser(firstname,lastname) != null;
    }
}
