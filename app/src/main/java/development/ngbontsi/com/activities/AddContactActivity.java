package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAddContactBinding;

public class AddContactActivity extends AppCompatActivity implements View.OnClickListener{

    private  AppCompatActivity activity = AddContactActivity.this;
    private ActivityAddContactBinding addContactBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addContactBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_contact);

        addContactBinding.appCompatButtonAddContact.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.appCompatButtonAdContact:
                Snackbar.make(addContactBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();

        }

    }
}
