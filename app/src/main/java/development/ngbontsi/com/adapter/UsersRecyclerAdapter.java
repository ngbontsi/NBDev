package development.ngbontsi.com.adapter;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import development.ngbontsi.com.R;
import development.ngbontsi.com.module.EventModule;
import development.ngbontsi.com.presenter.FragmentPresenter;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder>   {

	private List<EventModule> eventModules= new ArrayList<EventModule>();
	private FragmentPresenter fragmentPresenter;
	private Context context;
	public UsersRecyclerAdapter(FragmentPresenter fragmentPresenter,Context context)
	{
		this.context= context;
		this.fragmentPresenter = fragmentPresenter;

	}

	@Override
	public int getItemCount() {
		Log.v(UsersRecyclerAdapter.class.getSimpleName(),""+ eventModules.size());

		return eventModules.size();
	}

	@Override
	public void onBindViewHolder(UserViewHolder holder, final int position) {
		holder.textViewEeventName.setText(eventModules.get(position).getName());
		holder.textViewEeventStatus.setText(eventModules.get(position).getEvent_description());
		holder.textViewEventType.setText(eventModules.get(position).getEvent_type_description());
		holder.textViewEventOrganizer.setText(eventModules.get(position).getOrganizer_name());
		holder.textViewEventCommercial.setText(eventModules.get(position).getEvent_commercial_description());
		holder.itemView.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				fragmentPresenter.ItemClicked(eventModules.get(position));
			}
		});
	}


	@Override
	public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// inflating recycler item view
		View itemView = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item_user_recycler, parent, false);

		return new UserViewHolder(itemView);
	}

	public void setDataList(List<EventModule> dataList) {
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
