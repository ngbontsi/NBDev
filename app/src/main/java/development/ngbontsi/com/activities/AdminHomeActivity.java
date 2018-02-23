package development.ngbontsi.com.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAdminHomeBinding;
import development.ngbontsi.com.model.Commercial;
import development.ngbontsi.com.model.Event;
import development.ngbontsi.com.model.EventStatus;
import development.ngbontsi.com.model.EventType;
import development.ngbontsi.com.model.Organizer;
import development.ngbontsi.com.model.VenueFacility;

public class AdminHomeActivity extends AppCompatActivity implements View.OnClickListener{

    private AppCompatActivity activity = AdminHomeActivity.this;
    private  ActivityAdminHomeBinding adminHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adminHomeBinding = DataBindingUtil.setContentView( activity,R.layout.activity_admin_home);
        getSupportActionBar().hide();
        initListeners();
        
    
    }

    private void initListeners() {

        adminHomeBinding.appCompatButtonAddCommercial.setOnClickListener(this);
        adminHomeBinding.appCompatButtonAdContact.setOnClickListener(this);
        adminHomeBinding.appCompatButtonAddEvent.setOnClickListener(this);
        adminHomeBinding.appCompatButtonAddOrganizer.setOnClickListener(this);
        adminHomeBinding.appCompatButtonAddFacility.setOnClickListener(this);
        adminHomeBinding.appCompatButtonAddStatus.setOnClickListener(this);
        adminHomeBinding.appCompatButtonAddType.setOnClickListener(this);
        adminHomeBinding.appCompatButtonAddUser.setOnClickListener(this);
        adminHomeBinding.appCompatButtonAddVenue.setOnClickListener(this);
        adminHomeBinding.appCompatButtonAddAddress.setOnClickListener(this);
    }


    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonAddCommercial:
                    callScreen(AddCommercialActivity.class);
                break;
            case R.id.appCompatButtonAddEvent:
callScreen(AddEventActivity.class);
                break;
            case R.id.appCompatButtonAddFacility:
            callScreen(AddFacilityActivity.class);
                break;
            case R.id.appCompatButtonAddOrganizer:
                callScreen(AddUserActivity.class);
                break;
            case R.id.appCompatButtonAddStatus:
                callScreen(AddEventStatusActivity.class);
                break;
            case R.id.appCompatButtonAddType:
                    callScreen(AddEventTypeActivity.class);
                break;
            case R.id.appCompatButtonAddUser:
                callScreen(AddUserActivity.class);
                break;
            case R.id.appCompatButtonAddVenue:
                callScreen(AddVenueActivity.class);
                break;
            case R.id.appCompatButtonAddAddress:
                callScreen(AddAddressActivity.class);
                break;

            case R.id.appCompatButtonAdContact:
                callScreen(AddContactActivity.class);
                break;


        }
    }

    private void callScreen(Class<?> clazz) {

        Intent screenCall = new Intent(activity,clazz);
        startActivity(screenCall);

    }

}
