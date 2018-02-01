package development.ngbontsi.com.presenter;

import development.ngbontsi.com.interfaces.FragmentView;
import development.ngbontsi.com.module.EventLayout;

/**
 * Created by nbontsi on 2017/07/26.
 */

public class FragmentPresenterImpl implements FragmentPresenter {


    private FragmentView fragmentView;
    private EventLayout eventModule;
            public FragmentPresenterImpl(FragmentView fragmentView){
                this.fragmentView= fragmentView;
                eventModule = new EventLayout();
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
    public void ItemClicked(EventLayout itemId) {
        fragmentView.onClickItem(itemId);
    }
}
