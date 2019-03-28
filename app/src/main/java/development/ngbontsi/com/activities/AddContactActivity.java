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
import development.ngbontsi.com.databinding.ActivityAddContactBinding;
import development.ngbontsi.com.model.Address;
import development.ngbontsi.com.model.Contact;
import development.ngbontsi.com.model.Organizer;
import development.ngbontsi.com.util.AddressUtil;
import development.ngbontsi.com.util.InputValidation;
import development.ngbontsi.com.util.OrganiserUtil;

public class AddContactActivity extends AppCompatActivity implements View.OnClickListener{

    private  AppCompatActivity activity = AddContactActivity.this;
    private ActivityAddContactBinding addContactBinding;
    private InputValidation inputValidation;
    private List<Address> addresses;
    private  List<Organizer> organizers;
    private int addressId;
    private  int contactId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addContactBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_contact);
        addContactBinding.appCompatButtonAddContact.setOnClickListener(this);
        inputValidation = new InputValidation(activity);

        addresses = ApplicationDatabase.getAppDatabase(activity).addressDAO().getAddresses();
        organizers = ApplicationDatabase.getAppDatabase(activity).organizerDAO().getOrganizers();

        ArrayAdapter addressAdapter = new ArrayAdapter(activity,android.R.layout.simple_spinner_item, AddressUtil.getStingValues(addresses));
        addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addContactBinding.addressList.setAdapter(addressAdapter);
        addContactBinding.addressList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addressId = addresses.get(position).getAddress_id();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter contactAdapter = new ArrayAdapter(activity,android.R.layout.simple_spinner_item, OrganiserUtil.getOrganisors(organizers));
        contactAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addContactBinding.organiserList.setAdapter(contactAdapter);
        addContactBinding.organiserList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                contactId = organizers.get(position).getOrganizer_id();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }





    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.appCompatButtonAdContact:
                if (!inputValidation.isInputEditTextFilled(addContactBinding.textInputEditTextContactNumber, addContactBinding.textInputLayoutContactNumber, getString(R.string.error_message_mandotary)))
                    return;
                Contact contact = new Contact();
                contact.setAddress_id(addressId);
                contact.setContact_number(addContactBinding.textInputEditTextContactNumber.getText().toString().trim());
                contact.setOrganizer_id(contactId);
                contact.setOther_details("");
                contact.setWeb_site_address("");
                ApplicationDatabase.getAppDatabase(activity).contactDAO().insertAll(contact);

                Snackbar.make(addContactBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();

        }

    }
}
