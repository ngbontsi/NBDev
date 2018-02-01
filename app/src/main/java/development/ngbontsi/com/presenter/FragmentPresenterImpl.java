package development.ngbontsi.com.presenter;

import android.content.Context;

import development.ngbontsi.com.interfaces.FragmentView;
import development.ngbontsi.com.module.EventModule;

/**
 * Created by nbontsi on 2017/07/26.
 */

public class FragmentPresenterImpl implements FragmentPresenter {


    private FragmentView fragmentView;
    private EventModule eventModule;
            public FragmentPresenterImpl(FragmentView fragmentView){
                this.fragmentView= fragmentView;
                eventModule = new EventModule(fragmentView.getActivity());
            }

    @Override
    public void loadData(String screen) {
        try {
//           fragmentView.onLoadData(eventModule.getAll());
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void ItemClicked(EventModule itemId) {
        fragmentView.onClickItem(itemId);
    }
}
