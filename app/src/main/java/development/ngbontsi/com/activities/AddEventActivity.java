package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAddEventBinding;
import development.ngbontsi.com.util.InputValidation;

public class AddEventActivity extends AppCompatActivity implements View.OnClickListener{

    private  AppCompatActivity activity = AddEventActivity.this;
    private ActivityAddEventBinding addEventBinding;
    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addEventBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_event);
        addEventBinding.appCompatButtonAddEvent.setOnClickListener(this);
        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.appCompatButtonAddEvent:
                if (!inputValidation.isInputEditTextFilled(addEventBinding.textInputEditTextEventName, addEventBinding.textInputLayoutEventName, getString(R.string.error_message_mandotary)))
                    return;

                Snackbar.make(addEventBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();

        }

    }
}
