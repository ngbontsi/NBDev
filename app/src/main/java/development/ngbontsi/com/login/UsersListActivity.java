package development.ngbontsi.com.login;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.R;
import development.ngbontsi.com.adapter.UsersRecyclerAdapter;
import development.ngbontsi.com.constants.ModelConstants;
import development.ngbontsi.com.event.EventActivity;
import development.ngbontsi.com.interfaces.UserListener;
import development.ngbontsi.com.module.EventModule;
import development.ngbontsi.com.util.DatabaseCreation;

public class UsersListActivity extends AppCompatActivity implements UserListener{
    private final AppCompatActivity activity = UsersListActivity.this;
    private AppCompatTextView textViewEventName,textViewEventType,textViewEventCommercial,textViewEventOrganiser;
    private RecyclerView recyclerViewUsers;
    private List<EventModule> eventModules;
    private UsersRecyclerAdapter usersRecyclerAdapter;
    private EventModule eventModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        getSupportActionBar().setTitle("");
        initViews();
        initObjects();
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {

        textViewEventName = (AppCompatTextView) findViewById(R.id.textViewEventName);
        textViewEventType = (AppCompatTextView) findViewById(R.id.textViewEventType);
        textViewEventCommercial = (AppCompatTextView) findViewById(R.id.textViewEventCommercial);
        textViewEventOrganiser = (AppCompatTextView) findViewById(R.id.textViewEventOrganiser);
        recyclerViewUsers = (RecyclerView) findViewById(R.id.recyclerViewUsers);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {

        eventModules = new ArrayList<EventModule>();
        usersRecyclerAdapter = new UsersRecyclerAdapter(activity, eventModules);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewUsers.setLayoutManager(mLayoutManager);
        recyclerViewUsers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUsers.setHasFixedSize(true);
        recyclerViewUsers.setAdapter(usersRecyclerAdapter);
        eventModule = new EventModule(activity);

        String emailFromIntent = getIntent().getStringExtra("EMAIL");
       // textViewEventName.setText(emailFromIntent);

        getDataFromSQLite();
    }

    /**
     * This method is to fetch all user records from SQLite
     */
    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                eventModules.clear();
                try {
                    List<EventModule> lis= eventModule.getAll();
                    for (EventModule eventModule:lis){
                        eventModules.add(eventModule);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }


               return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                usersRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }


    @Override
    public void onItemClick(EventModule selected) {
        showActivity(selected ,EventActivity.class);
    }
    private void showActivity(EventModule selected,Class clazz){
        Intent eventActivity = new Intent(activity, EventActivity.class);
        eventActivity.putExtra(ModelConstants.User.toString(),selected);
        startActivity(eventActivity);

    }
}
