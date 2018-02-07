package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAddVenueBinding;

public class AddVenueActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = AddVenueActivity.this;
    private ActivityAddVenueBinding addVenueBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addVenueBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_venue);
        addVenueBinding.appCompatButtonAddVenue.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.appCompatButtonAddVenue:
                Snackbar.make(addVenueBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();
        }

    }
}
