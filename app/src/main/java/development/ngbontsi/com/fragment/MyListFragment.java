package development.ngbontsi.com.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import development.ngbontsi.com.R;

/**
 * Created by nbontsi on 2017/07/24.
 */

public class MyListFragment extends Fragment {

    private OnItemSelectedListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rsslist_overview,
                container, false);
        Button button = (Button) view.findViewById(R.id.updateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("fake");
            }
        });

        return view;
    }
    public interface OnItemSelectedListener{
        public void onRssItemSelected(String link);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnItemSelectedListener){
            listener = (OnItemSelectedListener)context;
        }else {
            throw new ClassCastException((context.toString()+"must implement MyListFragment.OnItemSelectedListener"));
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    // may also be triggered from the Activity
    public void updateDetail(String uri) {
        // create a string just for testing
        String newTime = String.valueOf(System.currentTimeMillis());

        // inform the Activity about the change based
        // interface defintion
        listener.onRssItemSelected(newTime);
    }
}
