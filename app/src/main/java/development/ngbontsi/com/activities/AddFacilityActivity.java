package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.R;
import development.ngbontsi.com.database.ApplicationDatabase;
import development.ngbontsi.com.databinding.ActivityAddFacilityBinding;
import development.ngbontsi.com.model.Venue;
import development.ngbontsi.com.model.VenueFacility;
import development.ngbontsi.com.util.InputValidation;
import development.ngbontsi.com.util.VenueUtil;

public class AddFacilityActivity extends AppCompatActivity implements View.OnClickListener{

    private AppCompatActivity activity = AddFacilityActivity.this;
    private ActivityAddFacilityBinding addFacilityBinding;
    private InputValidation inputValidation;
    private List<Venue> venues;
    private int vanueId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFacilityBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_facility);
        addFacilityBinding.appCompatButtonAddFacility.setOnClickListener(this);
        inputValidation = new InputValidation(activity);
        venues = ApplicationDatabase.getAppDatabase(activity).venueDAO().getVenues();

        ArrayAdapter venueAdapter = new ArrayAdapter(activity,android.R.layout.simple_spinner_item, VenueUtil.getVenues(venues));
        venueAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addFacilityBinding.venueList.setAdapter(venueAdapter);
        addFacilityBinding.venueList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vanueId = venues.get(position).getVenue_id();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.appCompatButtonAddFacility:
                if (!inputValidation.isInputEditTextFilled(addFacilityBinding.textInputEditTextDescription, addFacilityBinding.textInputLayoutDescription, getString(R.string.error_message_mandotary)))
                    return;

                VenueFacility venueFacility = new VenueFacility();
                venueFacility.setVenue_id(vanueId);
                venueFacility.setFacility_description(addFacilityBinding.textInputEditTextDescription.getText().toString().trim());
                ApplicationDatabase.getAppDatabase(activity).venueFacilityDAO().insertAll(venueFacility);
                Snackbar.make(addFacilityBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();
        }

    }
}
