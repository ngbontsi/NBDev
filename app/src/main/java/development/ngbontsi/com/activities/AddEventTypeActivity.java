package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAddEventTypeBinding;

public class AddEventTypeActivity extends AppCompatActivity implements View.OnClickListener{

    private AppCompatActivity activity = AddEventTypeActivity.this;
    private ActivityAddEventTypeBinding addEventTypeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addEventTypeBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_event_type);
        addEventTypeBinding.appCompatButtonAddEventType.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.appCompatButtonAddEventType:
                Snackbar.make(addEventTypeBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();
        }

    }
}
