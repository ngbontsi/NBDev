package development.ngbontsi.com.fregment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import development.ngbontsi.com.R;
import development.ngbontsi.com.adapter.SearchAdapter;
import development.ngbontsi.com.adapter.UsersRecyclerAdapter;
import development.ngbontsi.com.constants.ApplicationConstants;
import development.ngbontsi.com.event.EventActivity;
import development.ngbontsi.com.interfaces.FragmentView;
import development.ngbontsi.com.model.Event;
import development.ngbontsi.com.module.EventModule;
import development.ngbontsi.com.presenter.FragmentPresenter;
import development.ngbontsi.com.presenter.FragmentPresenterImpl;

/**
 * Created by nbontsi on 2017/07/25.
 */

public class NavigationDrawer extends Fragment implements FragmentView {

    private String name;
    private UsersRecyclerAdapter usersRecyclerAdapter;
    private SearchAdapter searchAdapter;
    private RecyclerView recyclerView;
    private EventModule eventModule;
    private FragmentPresenter fragmentPresenter;


    public static NavigationDrawer newInstance(String name){
        NavigationDrawer navigationDrawer = new NavigationDrawer();
        Bundle bundle = new Bundle();
        bundle.putString(ApplicationConstants.Screen.toString(),name);
        navigationDrawer.setArguments(bundle);
        return navigationDrawer;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            this.name = getArguments().getString(ApplicationConstants.Screen.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.list_home);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentPresenter = new FragmentPresenterImpl(this);
        createAview();
        return view;
    }

    private void  createAview(){
eventModule = new EventModule(getActivity());
        if(this.name.equals(ApplicationConstants.All_Events.getValue())){
            usersRecyclerAdapter = new UsersRecyclerAdapter(fragmentPresenter,getActivity());
            recyclerView.setAdapter(usersRecyclerAdapter);
            fragmentPresenter.loadData(this.name);
        }else if(this.name.equals(ApplicationConstants.Search_Event.getValue())){
            try{
//                searchAdapter = new SearchAdapter(fragmentPresenter,eventModule.getAll());
                recyclerView.setAdapter(searchAdapter);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onLoadData(List<EventModule> dataList) {
        usersRecyclerAdapter.setDataList(dataList);

    }

    @Override
    public void onClickItem(EventModule data) {
        Intent intent = new Intent(getActivity(),EventActivity.class);
        getActivity().startActivity(intent);

    }
}
