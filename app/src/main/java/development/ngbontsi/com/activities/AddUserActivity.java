package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.List;

import development.ngbontsi.com.R;
import development.ngbontsi.com.constants.ApplicationConstants;
import development.ngbontsi.com.databinding.ActivityAddUserBinding;
import development.ngbontsi.com.model.Address;
import development.ngbontsi.com.model.Organizer;
import development.ngbontsi.com.model.User;
import development.ngbontsi.com.util.AddressUtil;
import development.ngbontsi.com.util.InputValidation;

public class AddUserActivity extends AppCompatActivity implements View.OnClickListener{

    private AppCompatActivity activity = AddUserActivity.this;
    private ActivityAddUserBinding addUserBinding;
    private InputValidation inputValidation;
    private int addressId;
    private List<Address> addresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addUserBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_user);
        addUserBinding.appCompatButtonAddUser.setOnClickListener(this);
        inputValidation = new InputValidation(activity);
        addresses = ApplicationDatabase.getAppDatabase(activity).addressDAO().getAddresses();
        ArrayAdapter addressAdapter = new ArrayAdapter(activity,android.R.layout.simple_spinner_item, AddressUtil.getStingValues(addresses));
        addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addUserBinding.addressList.setAdapter(addressAdapter);
        addUserBinding.addressList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter roleAdapter = new ArrayAdapter(activity,android.R.layout.simple_spinner_item, ApplicationConstants.values());
        roleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addUserBinding.userRoleList.setAdapter(roleAdapter);
        addUserBinding.userRoleList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
            case R.id.appCompatButtonAddUser:
                if (!inputValidation.isInputEditTextFilled(addUserBinding.textInputEditTextFirstName, addUserBinding.textInputLayoutFirstName, getString(R.string.error_message_mandotary)))
                    return;
                if (!inputValidation.isInputEditTextFilled(addUserBinding.textInputEditTextLastName, addUserBinding.textInputLayoutLastName, getString(R.string.error_message_mandotary)))
                    return;

                if (!inputValidation.isInputEditTextFilled(addUserBinding.textInputEditTextEmail, addUserBinding.textInputLayoutEmail, getString(R.string.error_message_mandotary)))
                    return;
                User user = new User();
                user.setAddressid(addressId);
                user.setPassword("");
                user.setEmail(addUserBinding.textInputEditTextEmail.getText().toString().trim());
                user.setLastName(addUserBinding.textInputEditTextLastName.getText().toString().trim());
                user.setName(addUserBinding.textInputEditTextFirstName.getText().toString().trim());
                ApplicationDatabase.getAppDatabase(activity).userDAO().insertAll(user);
                if(addUserBinding.userRoleList.getSelectedItem().toString().equalsIgnoreCase(ApplicationConstants.Organizer_role.toString())){
                    User user1=ApplicationDatabase.getAppDatabase(activity).userDAO().findByName(addUserBinding.textInputEditTextFirstName.getText().toString().trim(),addUserBinding.textInputEditTextLastName.getText().toString().trim());
                    Organizer organizer = new Organizer();
                    organizer.setOrganizer_email(user1.getEmail());
                    organizer.setOrganizer_name(user1.getName());
                    organizer.setUser_id(user1.getId());
                    ApplicationDatabase.getAppDatabase(activity).organizerDAO().insertAll(organizer);
                }


                Snackbar.make(addUserBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();
        }

    }
}
