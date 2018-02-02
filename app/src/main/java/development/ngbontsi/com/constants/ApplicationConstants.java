package development.ngbontsi.com.constants;

import android.util.SparseArray;

import development.ngbontsi.com.fregment.NavigationDrawer;

/**
 * Created by nbontsi on 2017/06/29.
 */

public enum ApplicationConstants {
    Screen("SCREEN_NAME"),
    All_Events("All Evenets"),
    Search_Event("Search Evenets"),
    Notifications("Notification"),
    Organizer_role("ORG"),
    User_role("USER"),
    Administration_role("ADMIN"),
    Administration_user("ngbontsi"),
    Mails("Mails");

    private String model;

    private ApplicationConstants(String model){
        this.model = model;
    }

    public String getValue() {
        return model;
    }
}

