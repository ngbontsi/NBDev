package development.ngbontsi.com.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;


import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import development.ngbontsi.com.R;


import development.ngbontsi.com.database.LoginData;
import development.ngbontsi.com.database.UserData;
import development.ngbontsi.com.databinding.ActivityLogInBinding;
import development.ngbontsi.com.util.InputValidation;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = LogInActivity.this;





   private ActivityLogInBinding logInBinding;
   private LoginData userDatabases;
    private InputValidation inputValidation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logInBinding = DataBindingUtil.setContentView(this,R.layout.activity_log_in);
        getSupportActionBar().hide();
        initListeners();
        initObjects();
    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        logInBinding.appCompatButtonLogin.setOnClickListener(this);
        logInBinding.textViewLinkRegister.setOnClickListener(this);
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        logInBinding.textInputEditTextUserName.setText(null);
        logInBinding.textInputEditTextPassword.setText(null);

    }



    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {

        inputValidation = new InputValidation(activity);
        userDatabases = new LoginData(activity);

    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonLogin:
                verifyFromSQLite();
                break;
            case R.id.textViewLinkRegister:

                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;
            case R.id.appCompatButtonAdminLogin:
                callAdminLogin();
        }
    }

    private void callAdminLogin() {
        Intent adminActivity = new Intent(activity,AdminLoginActivity.class);
        startActivity(adminActivity);
    }


    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */
    private void verifyFromSQLite() {

        if (!inputValidation.isInputEditTextFilled(logInBinding.textInputEditTextUserName, logInBinding.textInputLayoutUserName, getString(R.string.error_message_mandotary)))
            return;
        if (!inputValidation.isInputEditTextFilled(logInBinding.textInputEditTextPassword, logInBinding.textInputLayoutPassword, getString(R.string.error_message_mandotary)))
            return;


String username =logInBinding.textInputEditTextUserName.getText().toString().trim();
        String password =logInBinding.textInputEditTextPassword.getText().toString().trim();
        if (userDatabases.userExist(username) ) {

            if(userDatabases.userPassword(username).equals(password)){
                Intent accountsIntent = new Intent(activity, UsersListActivity.class);
                accountsIntent.putExtra("USERNAME", logInBinding.textInputEditTextUserName.getText().toString().trim());
                emptyInputEditText();
                startActivity(accountsIntent);
            }else
                inputValidation.displayError(logInBinding.textInputEditTextPassword,logInBinding.textInputLayoutPassword,getString(R.string.error_valid_email_password));




        } else
            inputValidation.displayError(logInBinding.textInputEditTextUserName, logInBinding.textInputLayoutUserName, getString(R.string.error_user_does_not_exist));


    }
}
