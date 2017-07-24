package development.ngbontsi.com.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import development.ngbontsi.com.R;

/**
 * Created by nbontsi on 2017/07/24.
 */

public class DetailFragment extends Fragment {

    public static final String EXTRA_URL="url";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rssitem_detail,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle!= null){
            String link = bundle.getString("url");
                    setText(link);
        }
    }
    public void setText(String url){
        TextView view = (TextView)getView().findViewById(R.id.detailsText);
        view.setText(url);

    }
}
