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
import development.ngbontsi.com.databinding.ActivityAddEventBinding;
import development.ngbontsi.com.interfaces.EventStatusDAO;
import development.ngbontsi.com.interfaces.EventTypeDAO;
import development.ngbontsi.com.model.Commercial;
import development.ngbontsi.com.model.EventStatus;
import development.ngbontsi.com.model.EventType;
import development.ngbontsi.com.model.Organizer;
import development.ngbontsi.com.model.Venue;
import development.ngbontsi.com.util.CommercialUtil;
import development.ngbontsi.com.util.EventStatusUtil;
import development.ngbontsi.com.util.EventTypeUtil;
import development.ngbontsi.com.util.InputValidation;
import development.ngbontsi.com.util.OrganiserUtil;
import development.ngbontsi.com.util.VenueUtil;

public class AddEventActivity extends AppCompatActivity implements View.OnClickListener{

    private  AppCompatActivity activity = AddEventActivity.this;
    private ActivityAddEventBinding addEventBinding;
    private InputValidation inputValidation;
private List<EventStatus> eventStatusList;
private List<EventType> eventTypeList;
    private List<Commercial> commercials;
    private List<Organizer> organizers;
    private List<Venue> venues;
private String startDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addEventBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_event);
        addEventBinding.appCompatButtonAddEvent.setOnClickListener(this);
        inputValidation = new InputValidation(activity);
        eventStatusList = ApplicationDatabase.getAppDatabase(activity).eventStatusDAO().getEventStatuses();
        eventTypeList = ApplicationDatabase.getAppDatabase(activity).eventTypeDAO().getEventStatuses();
        commercials = ApplicationDatabase.getAppDatabase(activity).commercialDAO().getCommercials();
        organizers = ApplicationDatabase.getAppDatabase(activity).organizerDAO().getOrganizers();
        venues = ApplicationDatabase.getAppDatabase(activity).venueDAO().getVenues();
        ArrayAdapter eventTypeAdapter = new ArrayAdapter(activity,android.R.layout.simple_spinner_item, EventTypeUtil.getTypeDescription(eventTypeList));
        eventTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addEventBinding.typeList.setAdapter(eventTypeAdapter);
        addEventBinding.typeList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int companyId = eventTypeList.get(position).getEvent_type_id();
                String companyName = eventTypeList.get(position).getEvent_type_description();
                Snackbar.make(addEventBinding.nestedScrollView, "Company Name: " + companyName, Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter eventStatusAdapter = new ArrayAdapter(activity,android.R.layout.simple_spinner_item, EventStatusUtil.getStatusDescription(eventStatusList));
        eventStatusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addEventBinding.statusList.setAdapter(eventStatusAdapter);
        addEventBinding.statusList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter commercialAdapter = new ArrayAdapter(activity,android.R.layout.simple_spinner_item, CommercialUtil.getStringValues(commercials));
        commercialAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addEventBinding.commerialList.setAdapter(commercialAdapter);
        addEventBinding.commerialList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter orgerniserAdapter = new ArrayAdapter(activity,android.R.layout.simple_spinner_item, OrganiserUtil.getOrganisors(organizers));
        orgerniserAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addEventBinding.commerialList.setAdapter(orgerniserAdapter);
        addEventBinding.commerialList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter venueAdapter = new ArrayAdapter(activity,android.R.layout.simple_spinner_item, VenueUtil.getVenues(venues));
        venueAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addEventBinding.venueList.setAdapter(venueAdapter);
        addEventBinding.venueList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }






    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.appCompatButtonAddEvent:
                if (!inputValidation.isInputEditTextFilled(addEventBinding.textInputEditTextEventName, addEventBinding.textInputLayoutEventName, getString(R.string.error_message_mandotary)))
                    return;
startDate =addEventBinding.dpResult.getDayOfMonth()+"/"+addEventBinding.dpResult.getMonth()+"/"+addEventBinding.dpResult.getYear();
                Snackbar.make(addEventBinding.nestedScrollView,getString(R.string.text_record_added) +startDate,Snackbar.LENGTH_LONG).show();

        }

    }


}
