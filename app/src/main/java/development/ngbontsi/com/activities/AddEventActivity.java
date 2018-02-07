package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAddEventBinding;

public class AddEventActivity extends AppCompatActivity implements View.OnClickListener{

    private  AppCompatActivity activity = AddEventActivity.this;
    private ActivityAddEventBinding addEventBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addEventBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_event);
        addEventBinding.appCompatButtonAddEvent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.appCompatButtonAddEvent:
                Snackbar.make(addEventBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();

        }

    }
}
