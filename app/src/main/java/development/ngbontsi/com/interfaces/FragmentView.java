package development.ngbontsi.com.interfaces;

import android.content.Context;

import java.util.List;

import development.ngbontsi.com.module.EventLayout;

/**
 * Created by nbontsi on 2017/08/08.
 */

public interface FragmentView {
    Context getActivity();
    public void onLoadData(List<EventLayout> dataList);
    public void onClickItem(EventLayout data);

}

