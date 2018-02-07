package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAddEventStatusBinding;

public class AddEventStatusActivity extends AppCompatActivity implements View.OnClickListener{

    private AppCompatActivity activity = AddEventStatusActivity.this;
    private ActivityAddEventStatusBinding addEventStatusBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addEventStatusBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_event_status);
        addEventStatusBinding.appCompatButtonAddEventStatus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.appCompatButtonAddEventStatus:
                Snackbar.make(addEventStatusBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();
        }

    }
}
