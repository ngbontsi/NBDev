package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import development.ngbontsi.com.R;

import development.ngbontsi.com.databinding.ActivityRegisterBinding;
import development.ngbontsi.com.model.User;
import development.ngbontsi.com.util.DatabaseCreation;
import development.ngbontsi.com.util.InputValidation;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private final AppCompatActivity activity = RegisterActivity.this;

    private InputValidation inputValidation;

    private User user;
    private ActivityRegisterBinding registerBinding;
    private DatabaseCreation databaseCreation;
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

        databaseCreation = new DatabaseCreation(activity);
        user = new User();

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
                createDummyDataToSQLite();
                break;

            case R.id.appCompatTextViewLoginLink:
                finish();
                break;
        }
    }

    private void createDummyDataToSQLite() {
        try {
            databaseCreation.createDataBase();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(registerBinding.textInputEditTextName, registerBinding.textInputLayoutName, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(registerBinding.textInputEditTextEmail, registerBinding.textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(registerBinding.textInputEditTextEmail, registerBinding.textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(registerBinding.textInputEditTextPassword, registerBinding.textInputLayoutPassword, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(registerBinding.textInputEditTextConfirmPassword,
                registerBinding.textInputLayoutConfirmPassword, getString(R.string.error_password_match))) {
            return;
        }

//        if (!userDao.checkUser(registerBinding.textInputEditTextEmail.getText().toString().trim())) {
//
//            User nUser = new User();
//            nUser.setEmail(registerBinding.textInputEditTextEmail.getText().toString().trim());
//            nUser.setName(registerBinding.textInputEditTextName.getText().toString().trim());
//            nUser.setPassword(registerBinding.textInputEditTextPassword.getText().toString().trim());
//            userDao.addUser(nUser);
//
//            // Snack Bar to show success message that record saved successfully
//            Snackbar.make(registerBinding.nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
//            emptyInputEditText();
//
//
//        } else {
//            // Snack Bar to show error message that record already exists
//            Snackbar.make(registerBinding.nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
//        }


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

}
