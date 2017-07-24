package development.ngbontsi.com.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.login.R;

public class MainActivity extends AppCompatActivity implements MyListFragment.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getResources().getBoolean(R.bool.twoPanelMode)){
            return;
        }
        if(savedInstanceState!=null){
            getFragmentManager().executePendingTransactions();
            Fragment fragmentById = getFragmentManager().findFragmentById()
        }
    }

    @Override
    public void onRssItemSelected(String link) {
        DetailFragment fragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragment);
        fragment.setText(link);
    }
}
