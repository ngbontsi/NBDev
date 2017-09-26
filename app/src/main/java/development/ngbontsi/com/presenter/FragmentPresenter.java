package development.ngbontsi.com.presenter;

import development.ngbontsi.com.module.EventModule;

/**
 * Created by nbontsi on 2017/08/08.
 */

public interface FragmentPresenter {

    public void loadData(String screen);
    public void ItemClicked(EventModule itemId);
}
