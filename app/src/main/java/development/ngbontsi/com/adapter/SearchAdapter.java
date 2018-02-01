package development.ngbontsi.com.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.R;
import development.ngbontsi.com.module.EventLayout;
import development.ngbontsi.com.presenter.FragmentPresenter;

/**
 * Created by nbontsi on 2017/08/11.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.UserViewHolder> implements Filterable {

    private List<EventLayout> eventModules= new ArrayList<EventLayout>();
    private FragmentPresenter fragmentPresenter;
    private Context context;
    private List<EventLayout> filteredList = new ArrayList<EventLayout>();

    public SearchAdapter(FragmentPresenter fragmentPresenter, List<EventLayout> eventModules){
        this.context= context;
        this.eventModules = eventModules;
        this.filteredList = eventModules;
        this.fragmentPresenter = fragmentPresenter;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_recycler, parent, false);

        return new SearchAdapter.UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        holder.textViewEeventName.setText(eventModules.get(position).getName());
        holder.textViewEeventStatus.setText(eventModules.get(position).getStatus());
        holder.textViewEventType.setText(eventModules.get(position).getType());
        holder.textViewEventOrganizer.setText(eventModules.get(position).getOrganizer());
        holder.textViewEventCommercial.setText(eventModules.get(position).getCommercial());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fragmentPresenter.ItemClicked(eventModules.get(position));
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return eventModules.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();

                if(charString.isEmpty()){
filteredList = eventModules;
                }else {
                    List<EventLayout> filterList = new ArrayList<EventLayout>();
                    for (EventLayout eventModule:eventModules) {
                        if(eventModule.getName().toLowerCase().contains(charString)){
                            filterList.add(eventModule);
                        }
                    }
                    filteredList = filterList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                filteredList =(ArrayList<EventLayout>)results.values;
                notifyDataSetChanged();

            }
        };
    }

    public void setDataList(List<EventLayout> dataList) {
        if(dataList != null && dataList.size()>0){
            this.eventModules.clear();
            this.eventModules.addAll(dataList);
            notifyDataSetChanged();
        }
    }

    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewEeventName;
        public AppCompatTextView textViewEeventStatus;
        public AppCompatTextView textViewEventType;
        public AppCompatTextView textViewEventCommercial;
        public AppCompatTextView textViewEventOrganizer;


        public UserViewHolder(View view) {
            super(view);
            textViewEeventName = (AppCompatTextView) view.findViewById(R.id.textViewEventName);
            textViewEeventStatus = (AppCompatTextView) view.findViewById(R.id.textViewEventStatus);
            textViewEventType = (AppCompatTextView) view.findViewById(R.id.textViewEventType);
            textViewEventCommercial = (AppCompatTextView) view.findViewById(R.id.textViewEventCommercial);
            textViewEventOrganizer = (AppCompatTextView) view.findViewById(R.id.textViewEventOrganiser);

        }

    }
}
