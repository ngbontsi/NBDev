package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAddFacilityBinding;

public class AddFacilityActivity extends AppCompatActivity implements View.OnClickListener{

    private AppCompatActivity activity = AddFacilityActivity.this;
    private ActivityAddFacilityBinding addFacilityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFacilityBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_facility);
        addFacilityBinding.appCompatButtonAddFacility.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.appCompatButtonAddFacility:
                Snackbar.make(addFacilityBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();
        }

    }
}
