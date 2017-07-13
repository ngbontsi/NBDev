package development.ngbontsi.com.interfaces;

import android.content.Context;
import android.view.View;

import development.ngbontsi.com.model.User;
import development.ngbontsi.com.module.EventModule;

/**
 * Created by nbontsi on 2017/06/07.
 */

public interface UserListener {
    public void onItemClick(EventModule selected);
}
