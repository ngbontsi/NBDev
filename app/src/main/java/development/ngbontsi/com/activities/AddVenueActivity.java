package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAddVenueBinding;
import development.ngbontsi.com.model.Venue;
import development.ngbontsi.com.util.InputValidation;

public class AddVenueActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = AddVenueActivity.this;
    private ActivityAddVenueBinding addVenueBinding;
    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addVenueBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_venue);
        addVenueBinding.appCompatButtonAddVenue.setOnClickListener(this);
        inputValidation = new InputValidation(activity);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.appCompatButtonAddVenue:
                if (!inputValidation.isInputEditTextFilled(addVenueBinding.textInputEditTextDescription, addVenueBinding.textInputLayoutDescription, getString(R.string.error_message_mandotary)))
                    return;
                Venue venue = new Venue();
                venue.setVenue_name(addVenueBinding.textInputEditTextDescription.getText().toString().trim());
                ApplicationDatabase.getAppDatabase(activity).venueDAO().insertAll(venue);
                Snackbar.make(addVenueBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();
        }

    }
}
