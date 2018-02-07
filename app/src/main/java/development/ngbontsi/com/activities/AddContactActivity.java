package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAddContactBinding;
import development.ngbontsi.com.util.InputValidation;

public class AddContactActivity extends AppCompatActivity implements View.OnClickListener{

    private  AppCompatActivity activity = AddContactActivity.this;
    private ActivityAddContactBinding addContactBinding;
    private InputValidation inputValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addContactBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_contact);
        addContactBinding.appCompatButtonAddContact.setOnClickListener(this);
        inputValidation = new InputValidation(activity);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.appCompatButtonAdContact:
                if (!inputValidation.isInputEditTextFilled(addContactBinding.textInputEditTextContactNumber, addContactBinding.textInputLayoutContactNumber, getString(R.string.error_message_mandotary)))
                    return;
                Snackbar.make(addContactBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();

        }

    }
}
