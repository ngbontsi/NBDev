package development.ngbontsi.com.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import development.ngbontsi.com.database.UserDao;
import development.ngbontsi.com.R;
import com.facebook.FacebookSdk;



import development.ngbontsi.com.database.DatabaseHelper;
import development.ngbontsi.com.databinding.ActivityLogInBinding;
import development.ngbontsi.com.util.InputValidation;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = LogInActivity.this;



    private InputValidation inputValidation;
    private UserDao userDao;
   private ActivityLogInBinding logInBinding;

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
        logInBinding.textInputEditTextEmail.setText(null);
        logInBinding.textInputEditTextPassword.setText(null);

    }



    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        userDao = new UserDao(activity);
        inputValidation = new InputValidation(activity);

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
                // Navigate to RegisterActivity
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;
        }
    }



    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */
    private void verifyFromSQLite() {

        if (!inputValidation.isInputEditTextFilled(logInBinding.textInputEditTextEmail, logInBinding.textInputLayoutEmail, getString(R.string.error_message_email)))
            return;
        if (!inputValidation.isInputEditTextEmail(logInBinding.textInputEditTextEmail, logInBinding.textInputLayoutEmail, getString(R.string.error_message_email)))
            return;
        if (!inputValidation.isInputEditTextFilled(logInBinding.textInputEditTextPassword, logInBinding.textInputLayoutPassword, getString(R.string.error_message_password)))
            return;


        if (userDao.checkUser(logInBinding.textInputEditTextEmail.getText().toString().trim(), logInBinding.textInputEditTextPassword.getText().toString().trim())) {


            Intent accountsIntent = new Intent(activity, UsersListActivity.class);
            accountsIntent.putExtra("EMAIL", logInBinding.textInputEditTextEmail.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountsIntent);


        } else
            // Snack Bar to show success message that record is wrong
            Snackbar.make(logInBinding.nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
    }
}
