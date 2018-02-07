package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAddUserBinding;

public class AddUserActivity extends AppCompatActivity implements View.OnClickListener{

    private AppCompatActivity activity = AddUserActivity.this;
    private ActivityAddUserBinding addUserBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addUserBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_user);
        addUserBinding.appCompatButtonAddUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.appCompatButtonAddUser:
                Snackbar.make(addUserBinding.nestedScrollView,getString(R.string.text_record_added),Snackbar.LENGTH_LONG).show();
        }

    }
}
