package development.ngbontsi.com.event;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import development.ngbontsi.com.R;
import development.ngbontsi.com.constants.ModelConstants;
import development.ngbontsi.com.database.EventDAO;
import development.ngbontsi.com.model.Event;
import development.ngbontsi.com.module.EventModule;

public class EventActivity extends AppCompatActivity {

    private EventDAO eventDAO;
    private Event event;
    private EventModule eventModule;
    private final AppCompatActivity activity = EventActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        getSupportActionBar().setTitle("Event details");


        initViews();
        initObjects();
       }

    private void initViews() {
    }
    private void initObjects() {
        eventDAO = new EventDAO(activity);
        Intent startIntent = getIntent();
        eventModule = (EventModule) startIntent.getSerializableExtra(ModelConstants.User.toString());
    }



}
