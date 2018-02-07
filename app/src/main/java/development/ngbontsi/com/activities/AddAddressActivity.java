package development.ngbontsi.com.activities;

import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.databinding.ActivityAddAddressBinding;

public class AddAddressActivity extends AppCompatActivity implements View.OnClickListener{

    private AppCompatActivity activity= AddAddressActivity.this;
    private ActivityAddAddressBinding addAddressBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addAddressBinding = DataBindingUtil.setContentView(activity,R.layout.activity_add_address);

        addAddressBinding.appCompatButtonAddAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.appCompatButtonAddAddress:
//                TODO
                Snackbar.make(addAddressBinding.nestedScrollView, getString(R.string.text_record_added), Snackbar.LENGTH_LONG).show();
        }

    }
}
