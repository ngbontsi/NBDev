package development.ngbontsi.com.adapter;

import java.util.List;


import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import development.ngbontsi.com.interfaces.UserListener;
import development.ngbontsi.com.R;
import development.ngbontsi.com.login.UsersListActivity;
import development.ngbontsi.com.module.EventModule;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder>   {



	/**
	 * ViewHolder class
	 */
	public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		public AppCompatTextView textViewEeventName;
		public AppCompatTextView textViewEventType;
		public AppCompatTextView textViewEventCommercial;
		public AppCompatTextView textViewEventOrganizer;


		public UserViewHolder(View view) {
			super(view);
			textViewEeventName = (AppCompatTextView) view.findViewById(R.id.textViewEventName);
			textViewEventType = (AppCompatTextView) view.findViewById(R.id.textViewEventType);
			textViewEventCommercial = (AppCompatTextView) view.findViewById(R.id.textViewEventCommercial);
			textViewEventOrganizer = (AppCompatTextView) view.findViewById(R.id.textViewEventOrganiser);
			view.setOnClickListener(this);

		}

		@Override
		public void onClick(View v) {
			EventModule eventModule = eventModules.get(getAdapterPosition());
			userListener.onItemClick(eventModule);

		}

	}

	private final List<EventModule> eventModules;
	private static UserListener userListener;
	private Context context;
	public UsersRecyclerAdapter(Context context, List<EventModule> eventModules)
	{
		this.eventModules = eventModules;
		this.context= context;
		userListener = new UsersListActivity();
	}

	@Override
	public int getItemCount() {
		Log.v(UsersRecyclerAdapter.class.getSimpleName(),""+ eventModules.size());

		return eventModules.size();
	}

	@Override
	public void onBindViewHolder(UserViewHolder holder, int position) {
		holder.textViewEeventName.setText(eventModules.get(position).getEvent_description());
		holder.textViewEventType.setText(eventModules.get(position).getEvent_type_description());
		holder.textViewEventOrganizer.setText(eventModules.get(position).getOrganizer_name());
		holder.textViewEventCommercial.setText(eventModules.get(position).getEvent_commercial_description());
	}


	@Override
	public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// inflating recycler item view
		View itemView = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item_user_recycler, parent, false);

		return new UserViewHolder(itemView);
	}

}
