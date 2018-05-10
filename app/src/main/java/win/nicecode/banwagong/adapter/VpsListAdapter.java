package win.nicecode.banwagong.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import win.nicecode.banwagong.R;
import win.nicecode.banwagong.bean.LiveServiceInfo;
import win.nicecode.banwagong.ui.VpsDetailActivity;

/**
 * Created by Eason.Ren on 5/8/2018 15:15
 * Email: eason.ren@outlook.com
 */
public class VpsListAdapter extends RecyclerView.Adapter<VpsListAdapter.ViewHolder> {
    private static final String TAG = "VpsListAdapter";
    private List<LiveServiceInfo> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        private Context mcontext;

        @BindView(R.id.tv_location)
        public TextView mLocation;
        @BindView(R.id.tv_ip_address)
        public TextView mIpAdress;
        @BindView(R.id.tv_os)
        public TextView mOs;
        @BindView(R.id.tv_os_status)
        public TextView mOsStatus;
        @BindView(R.id.tv_os_bandwidth)
        public TextView mOsBandwidth;

        public ViewHolder(View view, final Context context) {
            super(view);
            mcontext = context;
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.i(TAG, "Element " + getAdapterPosition() + " clicked.");
            Log.i(TAG, "Element " + v.getTag());

            Intent intent = new Intent(mcontext, VpsDetailActivity.class);
            intent.putExtra("ip", v.getTag().toString());
            mcontext.startActivity(intent);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public VpsListAdapter(List<LiveServiceInfo> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public VpsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vps_view, parent, false);

        ViewHolder vh = new ViewHolder(v, parent.getContext());
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mLocation.setText(mDataset.get(position).getNode_location());
        holder.mIpAdress.setText(mDataset.get(position).getIp_addresses().get(0));
        holder.mOs.setText(mDataset.get(position).getOs());
        holder.mOsStatus.setText(mDataset.get(position).getVz_status().getStatus());
        holder.mOsBandwidth.setText(String.valueOf(mDataset.get(position).getData_counter()));
        holder.itemView.setTag(mDataset.get(position).getIp_addresses().get(0));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }
}
