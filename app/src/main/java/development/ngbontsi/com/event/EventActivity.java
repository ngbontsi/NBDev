package development.ngbontsi.com.event;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import development.ngbontsi.com.R;
import development.ngbontsi.com.constants.ModelConstants;
import development.ngbontsi.com.database.EventDatabase;
import development.ngbontsi.com.model.Event;
import development.ngbontsi.com.module.EventLayout;

public class EventActivity extends AppCompatActivity {

    private EventDatabase eventDAO;
    private Event event;
    private EventLayout eventModule;
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
        eventDAO = new EventDatabase(activity);
        Intent startIntent = getIntent();
        eventModule = (EventLayout) startIntent.getSerializableExtra(ModelConstants.User.toString());
    }



}
