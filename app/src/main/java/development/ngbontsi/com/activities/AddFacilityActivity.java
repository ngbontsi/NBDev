package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAddFacilityBinding;
import development.ngbontsi.com.util.InputValidation;

public class AddFacilityActivity extends AppCompatActivity implements View.OnClickListener{

    private AppCompatActivity activity = AddFacilityActivity.this;
    private ActivityAddFacilityBinding addFacilityBinding;
    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFacilityBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_facility);
        addFacilityBinding.appCompatButtonAddFacility.setOnClickListener(this);
        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.appCompatButtonAddFacility:
                if (!inputValidation.isInputEditTextFilled(addFacilityBinding.textInputEditTextDescription, addFacilityBinding.textInputLayoutDescription, getString(R.string.error_message_mandotary)))
                    return;
                Snackbar.make(addFacilityBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();
        }

    }
}
