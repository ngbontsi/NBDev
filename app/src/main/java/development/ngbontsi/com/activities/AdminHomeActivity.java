package development.ngbontsi.com.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import development.ngbontsi.com.R;

public class AdminHomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonAddCommercial:
//                TODO
                break;
            case R.id.appCompatButtonAddEvent:
//                TODO
                break;
            case R.id.appCompatButtonAddFacility:
//                TODO
                break;
            case R.id.appCompatButtonAddOrganizer:
//                TODO
                break;
            case R.id.appCompatButtonAddStatus:
//                TODO
                break;
            case R.id.appCompatButtonAddType:
//                TODO
                break;
            case R.id.appCompatButtonAddUser:
//                TODO
                break;
            case R.id.appCompatButtonAddVenue:
//                TODO
                break;


        }
    }

}
