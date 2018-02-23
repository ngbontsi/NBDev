package development.ngbontsi.com.activities;
import  static development.ngbontsi.com.constants.ApplicationConstants.Organizer_role;
import  static development.ngbontsi.com.constants.ApplicationConstants.User_role;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import development.ngbontsi.com.R;

import development.ngbontsi.com.api.ApplicationAPI;
import development.ngbontsi.com.database.AddressData;
import development.ngbontsi.com.database.LoginData;
import development.ngbontsi.com.database.UserData;
import development.ngbontsi.com.databinding.ActivityRegisterBinding;
import development.ngbontsi.com.model.Address;
import development.ngbontsi.com.model.Login;
import development.ngbontsi.com.model.User;
import development.ngbontsi.com.util.InputValidation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private final AppCompatActivity activity = RegisterActivity.this;

    private InputValidation inputValidation;


    private ActivityRegisterBinding registerBinding;
    private LoginData loginData;
    private UserData userData;
    private AddressData addressData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerBinding = DataBindingUtil.setContentView(this,R.layout.activity_register);
        getSupportActionBar().hide();


        initListeners();
        initObjects();
    }



    /**
     * This method is to initialize listeners
     */
    private void initListeners() {

        registerBinding.appCompatButtonRegister.setOnClickListener(this);
        registerBinding.appCompatTextViewLoginLink.setOnClickListener(this);

    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        inputValidation = new InputValidation(activity);
        loginData = new LoginData(activity);
        userData = new UserData(activity);
        addressData = new AddressData(activity);

    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case  R.id.appCompatButtonRegister:
                postDataToSQLite();

                break;

            case R.id.appCompatTextViewLoginLink:
                finish();
                break;
        }
    }



    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(registerBinding.textInputEditTextName, registerBinding.textInputLayoutName, getString(R.string.error_message_mandotary))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(registerBinding.textInputEditTextUserName, registerBinding.textInputLayoutUserName, getString(R.string.error_message_mandotary))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(registerBinding.textInputEditTextEmail, registerBinding.textInputLayoutEmail, getString(R.string.error_message_mandotary))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(registerBinding.textInputEditTextEmail, registerBinding.textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(registerBinding.textInputEditTextPassword, registerBinding.textInputLayoutPassword, getString(R.string.error_message_mandotary))) {
            return;
        }


        if (!inputValidation.isInputEditTextFilled(registerBinding.textInputEditTextCity, registerBinding.textInputLayoutCity, getString(R.string.error_message_mandotary))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(registerBinding.textInputEditTextLine1, registerBinding.textInputLayoutLine1, getString(R.string.error_message_mandotary))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(registerBinding.textInputEditTextLine2, registerBinding.textInputLayoutLine2, getString(R.string.error_message_mandotary))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(registerBinding.textInputEditTextLine3, registerBinding.textInputLayoutLine3, getString(R.string.error_message_mandotary))) {
            return;
        }

        if (!inputValidation.isInputEditTextFilled(registerBinding.textInputEditTextProvince, registerBinding.textInputLayoutProvince, getString(R.string.error_message_mandotary))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(registerBinding.textInputEditTextStreet, registerBinding.textInputLayoutStreet, getString(R.string.error_message_mandotary))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(registerBinding.textInputEditTextPostalCode, registerBinding.textInputLayoutPostalCode, getString(R.string.error_message_mandotary))) {
            return;
        }




        if (!inputValidation.isInputEditTextMatches(registerBinding.textInputEditTextConfirmPassword,registerBinding.textInputEditTextPassword,
                registerBinding.textInputLayoutConfirmPassword, getString(R.string.error_password_match))) {
            return;
        }
//String username = registerBinding.textInputEditTextUserName.getText().toString().trim();
//        if (!loginData.userExist(username)) {
//String email =registerBinding.textInputEditTextEmail.getText().toString().trim();
//            String firstName =registerBinding.textInputEditTextName.getText().toString().trim();
//            String password = registerBinding.textInputEditTextPassword.getText().toString().trim();
//            String city =registerBinding.textInputEditTextCity.getText().toString().trim();
//            String line1 = registerBinding.textInputEditTextLine1.getText().toString().trim();
//            String line2 = registerBinding.textInputEditTextLine2.getText().toString().trim();
//            String line3 = registerBinding.textInputEditTextLine3.getText().toString().trim();
//            String province = registerBinding.textInputEditTextProvince.getText().toString().trim();
//            String street = registerBinding.textInputEditTextStreet.getText().toString().trim();
//            String postalCode = registerBinding.textInputEditTextPostalCode.getText().toString().trim();
//
//            Address existingAddress = addressData.getCommercial(street);
//            User user = new User();
//            Login login = new Login();
//            if(existingAddress== null) {
//                Address address = new Address();
//                address.setCity(city);
//                address.setLine_1(line1);
//                address.setLine_2(line2);
//                address.setLine_3(line3);
//                address.setLine_4(province);
//                address.setStreet(street);
//                address.setPostal_code(Integer.parseInt(postalCode));
//                address=addressData.addAddress(address);
//                user.setAddressid(address.getAddress_id());
//            }else
//                user.setAddressid(existingAddress.getAddress_id());
//            user.setEmail(email);
//            login.setUsername(username);
//            user.setName(firstName);
//            login.setPassword(password);
//            if(registerBinding.chkOrganiser.isChecked())
//            login.setUserrole(Organizer_role.getValue());
//            else
//                login.setUserrole(User_role.getValue());
//            user.setPassword(password);
//            userData.addUser(user);
//            loginData.addLogin(login);
//
//
//            // Snack Bar to show success message that record saved successfully
//            Snackbar.make(registerBinding.nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
//            emptyInputEditText();
//
//            Intent accountsIntent = new Intent(activity, LogInActivity.class);
//            startActivity(accountsIntent);
//
//
//        } else {
//            // Snack Bar to show error message that record already exists
//            Snackbar.make(registerBinding.nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
//        }

insertUser();
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        registerBinding.textInputEditTextName.setText(null);
        registerBinding.textInputEditTextEmail.setText(null);
        registerBinding.textInputEditTextPassword.setText(null);
        registerBinding.textInputEditTextConfirmPassword.setText(null);

        registerBinding.textInputEditTextCity.setText(null);
        registerBinding.textInputEditTextLine1.setText(null);
        registerBinding.textInputEditTextLine2.setText(null);
        registerBinding.textInputEditTextLine3.setText(null);
        registerBinding.textInputEditTextProvince.setText(null);
        registerBinding.textInputEditTextStreet.setText(null);
        registerBinding.textInputEditTextPostalCode.setText(null);
        registerBinding.chkOrganiser.setChecked(false);
        registerBinding.chkUser.setChecked(true);

    }

    private void insertUser(){

        Retrofit retrofit= new Retrofit.Builder().baseUrl("http://localhost/").build();

        ApplicationAPI api = retrofit.create(ApplicationAPI.class);

        api.insertUser(registerBinding.textInputEditTextName.getText().toString().trim(), registerBinding.textInputEditTextName.getText().toString().trim(), registerBinding.textInputEditTextPassword.getText().toString().trim(),
                new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, Response<Response> response) {

                        Snackbar.make(registerBinding.nestedScrollView, response.body().toString(), Snackbar.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Snackbar.make(registerBinding.nestedScrollView, t.getMessage().toString(), Snackbar.LENGTH_LONG).show();
                    }
                });


    }

}
