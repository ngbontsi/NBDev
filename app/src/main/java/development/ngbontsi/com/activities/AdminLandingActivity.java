package development.ngbontsi.com.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import development.ngbontsi.com.R;

public class AdminLandingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_landing);
        GridView gridView = (GridView)findViewById(R.id.grid_view);
    }
}
