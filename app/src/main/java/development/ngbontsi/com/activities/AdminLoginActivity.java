package development.ngbontsi.com.activities;


import static  development.ngbontsi.com.constants.ApplicationConstants.Administration_role;
import static  development.ngbontsi.com.constants.ApplicationConstants.Administration_user;
import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.database.LoginData;
import development.ngbontsi.com.databinding.ActivityAdminLoginBinding;
import development.ngbontsi.com.util.InputValidation;

public class AdminLoginActivity extends AppCompatActivity implements View.OnClickListener{


private ActivityAdminLoginBinding adminLoginBinding;
private AppCompatActivity  activity = AdminLoginActivity.this;
    private LoginData userDatabases;
    private InputValidation inputValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     adminLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_admin_login);
        getSupportActionBar().hide();
        initListeners();
        initObjects();
    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        adminLoginBinding.appCompatButtonAdminLogin.setOnClickListener(this);

    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        adminLoginBinding.textInputEditTextAdminUser.setText(null);
        adminLoginBinding.textInputEditTextAdminPassword.setText(null);

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
            case R.id.appCompatButtonAdminLogin:
verifyAdminRights();
                break;

        }
    }

    private void verifyAdminRights() {

        if (!inputValidation.isInputEditTextFilled(adminLoginBinding.textInputEditTextAdminUser, adminLoginBinding.textInputLayoutAdminUser, getString(R.string.error_message_mandotary)))
            return;
        if (!inputValidation.isInputEditTextFilled(adminLoginBinding.textInputEditTextAdminPassword, adminLoginBinding.textInputLayoutAdminPassword, getString(R.string.error_message_mandotary)))
            return;

        String username =adminLoginBinding.textInputEditTextAdminUser.getText().toString().trim();
        String password =adminLoginBinding.textInputEditTextAdminPassword.getText().toString().trim();

        if(username.equalsIgnoreCase(Administration_user.getValue())||password.equalsIgnoreCase(Administration_role.getValue()))
            Snackbar.make(adminLoginBinding.nestedScrollView, getString(R.string.not_admin_message), Snackbar.LENGTH_LONG).show();
        else{
//            TODO  call admin screen
        }
    }
}
