package development.ngbontsi.com.presenter;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by nbontsi on 2017/08/08.
 */

public class ActivityPresenterImpl implements ActivityPresenter {


    @Override
    public void loadData() {

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                final  FragmentGetDatasEvent fragmentGetDatasEvent = new FragmentGetDatasEvent();
            }
        },1000);

    }
}
