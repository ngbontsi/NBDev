package development.ngbontsi.com.fregment;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import development.ngbontsi.com.R;
import development.ngbontsi.com.module.EventLayout;

/**
 * Created by nbontsi on 2017/07/25.
 */

public class FragmentAdapter extends RecyclerView.Adapter<FragmentAdapter.ViewHolder> {
    private Context context;
    private List<EventLayout> data = new ArrayList<EventLayout>();
    FragmentAdapter(Context context){
        this.context = context;
    }

    public void  setData(List<EventLayout> data){
        if(data !=null){
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    public String getItem(int position){
        return data.get(position).getName();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.fragment_drawer, parent, false);
        final ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            holder.textViewEventName.setText(data.get(position).getName());
            holder.textViewEventType.setText(data.get(position).getType());
            holder.textViewEventCommercial.setText(data.get(position).getCommercial());
            holder.textViewEventOrganiser.setText(data.get(position).getOrganizer());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        } catch (final Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private AppCompatTextView textViewEventName,textViewEventType,textViewEventCommercial,textViewEventOrganiser;
        public ViewHolder(View view){
            super(view);
            textViewEventName = (AppCompatTextView) itemView.findViewById(R.id.textViewEventName);
            textViewEventType = (AppCompatTextView) itemView.findViewById(R.id.textViewEventType);
            textViewEventCommercial = (AppCompatTextView) itemView.findViewById(R.id.textViewEventCommercial);
            textViewEventOrganiser = (AppCompatTextView) itemView.findViewById(R.id.textViewEventOrganiser);


        }
    }

}
