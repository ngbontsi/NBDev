package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAddCommercialBinding;
import development.ngbontsi.com.util.InputValidation;

public class AddCommercialActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = AddCommercialActivity.this;
    private ActivityAddCommercialBinding addCommercialBinding;
    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addCommercialBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_commercial);
        addCommercialBinding.appCompatButtonAddCommercial.setOnClickListener(this);
        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.appCompatButtonAddCommercial:
//                TODO
                if (!inputValidation.isInputEditTextFilled(addCommercialBinding.textInputEditTextDescription, addCommercialBinding.textInputLayoutDescription, getString(R.string.error_message_mandotary)))
                    return;
                Snackbar.make(addCommercialBinding.nestedScrollView, getString(R.string.text_record_added), Snackbar.LENGTH_LONG).show();
        }

    }
}
