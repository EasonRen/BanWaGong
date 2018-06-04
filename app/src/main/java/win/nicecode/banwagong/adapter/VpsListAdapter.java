package win.nicecode.banwagong.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import win.nicecode.banwagong.R;
import win.nicecode.banwagong.bean.VpsInfoData;
import win.nicecode.banwagong.ui.VpsDetailActivity;

/**
 * Created by Eason.Ren on 5/8/2018 15:15
 * Email: eason.ren@outlook.com
 */
public class VpsListAdapter extends RecyclerView.Adapter<VpsListAdapter.ViewHolder> {
    private static final String TAG = "VpsListAdapter";
    private List<VpsInfoData> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private Context mcontext;

        @BindView(R.id.osImg)
        public ImageView osImg;
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
            //view.setOnClickListener(this);
        }

        @OnClick()
        public void onClick(View v) {
            Log.i(TAG, "Element " + getAdapterPosition() + " clicked.");
            Log.i(TAG, "Element " + v.getTag());

            Intent intent = new Intent(mcontext, VpsDetailActivity.class);
            intent.putExtra("ip", v.getTag().toString());
            mcontext.startActivity(intent);
        }

        @OnLongClick()
        public boolean onLongClick(View v) {
            Toast.makeText(mcontext, "OnLongClick", Toast.LENGTH_SHORT).show();
            return true;
        }

//        @Override
//        public void onClick(View v) {
//            Log.i(TAG, "Element " + getAdapterPosition() + " clicked.");
//            Log.i(TAG, "Element " + v.getTag());
//
//            Intent intent = new Intent(mcontext, VpsDetailActivity.class);
//            intent.putExtra("ip", v.getTag().toString());
//            mcontext.startActivity(intent);
//        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public VpsListAdapter(List<VpsInfoData> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public VpsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vps_view, parent, false);

        ViewHolder vh = new ViewHolder(view, parent.getContext());
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        VpsInfoData vpsInfoData = mDataset.get(position);
        holder.mLocation.setText(vpsInfoData.getNode_location());
        holder.mIpAdress.setText(vpsInfoData.getIp_address());
        holder.mOs.setText(vpsInfoData.getOs());
        holder.mOsStatus.setText(vpsInfoData.getStatus());
        holder.mOsBandwidth.setText(String.valueOf(vpsInfoData.getData_counter()));
        holder.osImg.setImageResource(getOsTag(vpsInfoData.getOs()));
        holder.itemView.setTag(vpsInfoData.getId() + "");
    }

    private int getOsTag(final String osName) {
        if (osName == null || osName.isEmpty())
            return R.mipmap.icon_linux;

        if (osName.contains("ubuntu"))
            return R.mipmap.icon_ubuntu;
        else if (osName.contains("centos"))
            return R.mipmap.icon_centos;
        else if (osName.contains("debian"))
            return R.mipmap.icon_debian;
        else if (osName.contains("fedora"))
            return R.mipmap.icon_fedora;
        else if (osName.contains("suse"))
            return R.mipmap.icon_suse;
        else
            return R.mipmap.icon_linux;
    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position, List playloads) {
//        // - get element from your dataset at this position
//        // - replace the contents of the view with that element
//        if (playloads.isEmpty()){
//            onBindViewHolder(holder,position);
//        }else{
//
//        }
//    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }

    public void refreshData(List<VpsInfoData> data) {
        mDataset = data;
        notifyDataSetChanged();
    }
}
