package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.api.ApplicationAPI;
import development.ngbontsi.com.databinding.ActivityAddAddressBinding;

import development.ngbontsi.com.interfaces.AddressDAO;
import development.ngbontsi.com.model.Address;
import development.ngbontsi.com.util.InputValidation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAddressActivity extends AppCompatActivity implements View.OnClickListener{

    private AppCompatActivity activity= AddAddressActivity.this;
    private ActivityAddAddressBinding addAddressBinding;
    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addAddressBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_address);
        inputValidation = new InputValidation(activity);
        addAddressBinding.appCompatButtonAddAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.appCompatButtonAddAddress:

                if (!inputValidation.isInputEditTextFilled(addAddressBinding.textInputEditTextStreet, addAddressBinding.textInputLayoutStreet, getString(R.string.error_message_mandotary)))
                    return;
                if (!inputValidation.isInputEditTextFilled(addAddressBinding.textInputEditTextProvince, addAddressBinding.textInputLayoutProvince, getString(R.string.error_message_mandotary)))
                    return;
                if (!inputValidation.isInputEditTextFilled(addAddressBinding.textInputEditTextPostalCode, addAddressBinding.textInputLayoutPostalCode, getString(R.string.error_message_mandotary)))
                    return;
                if (!inputValidation.isInputEditTextFilled(addAddressBinding.textInputEditTextLine1, addAddressBinding.textInputLayoutLine1, getString(R.string.error_message_mandotary)))
                    return;
                if (!inputValidation.isInputEditTextFilled(addAddressBinding.textInputEditTextLine2, addAddressBinding.textInputLayoutLine2, getString(R.string.error_message_mandotary)))
                    return;
                if (!inputValidation.isInputEditTextFilled(addAddressBinding.textInputEditTextLine3, addAddressBinding.textInputLayoutLine3, getString(R.string.error_message_mandotary)))
                    return;

                Address address = new Address();
                address.setStreet(addAddressBinding.textInputEditTextStreet.getText().toString().trim());
                address.setLine_1(addAddressBinding.textInputEditTextLine1.getText().toString().trim());
                address.setLine_2(addAddressBinding.textInputEditTextLine2.getText().toString().trim());
                address.setLine_3(addAddressBinding.textInputEditTextLine3.getText().toString().trim());
                address.setLine_1(addAddressBinding.textInputEditTextLine1.getText().toString().trim());

insertData(address);
                Snackbar.make(addAddressBinding.nestedScrollView, getString(R.string.text_record_added), Snackbar.LENGTH_LONG).show();
        }

    }

    private void insertData(Address address) {
        AddressDAO addressDAO = ApplicationAPI.getRETROFIT().create(AddressDAO.class);
        Call<Address> call = addressDAO.insertAll(address);

        call.enqueue(new Callback<Address>() {
            @Override
            public void onResponse(Call<Address> call, Response<Address> response) {

                Address address1 = response.body();



            }

            @Override
            public void onFailure(Call<Address> call, Throwable t) {
Snackbar.make(addAddressBinding.nestedScrollView,t.getMessage(),Snackbar.LENGTH_LONG).show();
            }
        });


    }
}
