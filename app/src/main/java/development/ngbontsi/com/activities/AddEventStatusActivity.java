package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAddEventStatusBinding;
import development.ngbontsi.com.model.EventStatus;
import development.ngbontsi.com.util.InputValidation;

public class AddEventStatusActivity extends AppCompatActivity implements View.OnClickListener{

    private AppCompatActivity activity = AddEventStatusActivity.this;
    private ActivityAddEventStatusBinding addEventStatusBinding;
    private InputValidation inputValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addEventStatusBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_event_status);
        addEventStatusBinding.appCompatButtonAddEventStatus.setOnClickListener(this);
        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.appCompatButtonAddEventStatus:

                if (!inputValidation.isInputEditTextFilled(addEventStatusBinding.textInputEditTextDescription, addEventStatusBinding.textInputLayoutDescription, getString(R.string.error_message_mandotary)))
                    return;
                EventStatus eventStatus = new EventStatus();
                eventStatus.setEvent_description(addEventStatusBinding.textInputEditTextDescription.getText().toString().trim());
                ApplicationDatabase.getAppDatabase(activity).eventStatusDAO().insertAll(eventStatus);
                Snackbar.make(addEventStatusBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();
        }

    }
}
