package win.nicecode.banwagong.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import win.nicecode.banwagong.R;
import win.nicecode.banwagong.adapter.VpsListAdapter;
import win.nicecode.banwagong.api.DataManager;
import win.nicecode.banwagong.bean.LiveServiceInfo;
import win.nicecode.banwagong.bean.VpsInfoData;
import win.nicecode.banwagong.db.VpsInfoDb;

public class VpsListFragment extends Fragment {
    private Context mContext;
    private View rootView;
    private VpsInfoDb vpsInfoDb;
    private String veid = "379833";
    private String api_key = "private_NUvbYdSRZ35vaQhhSaU3ux63";
    private List<VpsInfoData> list;
    private VpsListAdapter adapter;

    @BindView(R.id.vps_list)
    RecyclerView vpsListRecyclerView;

    public VpsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        //bindData();
        Log.i("VpsListFragment", "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_vps_list, container, false);
            ButterKnife.bind(this, rootView);
            vpsInfoDb = new VpsInfoDb(getActivity());

            list = vpsInfoDb.query("");

            if (adapter == null) {
                adapter = new VpsListAdapter(list);
            }

            vpsListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            vpsListRecyclerView.setAdapter(adapter);
        }

        Log.i("VpsListFragment", "onCreateView");
        updateList();
        return rootView;
    }

    public void updateList() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < list.size(); i++) {
                    bindData(i, list.get(i).getVeid(), list.get(i).getApi_key());
                }
            }
        });
    }

    public void addVps() {
        VpsInfoData vpsInfoData = new VpsInfoData();
        vpsInfoData.setVeid(veid);
        vpsInfoData.setApi_key(api_key);
        vpsInfoDb.insert(vpsInfoData);
        list.add(vpsInfoData);
        adapter.notifyDataSetChanged();
    }

    private void bindData(final int positionId, final String veid, final String api_key) {
        DataManager.getInstance()
                .getLiveServiceInfo(veid, api_key)
                .enqueue(new Callback<LiveServiceInfo>() {
                    @Override
                    public void onResponse(Call<LiveServiceInfo> c, Response<LiveServiceInfo> response) {
                        LiveServiceInfo result = response.body();
                        //VpsInfoDb vpsInfoDb = new VpsInfoDb(getActivity());
                        //list.getClass()
                        VpsInfoData vpsInfoData = list.get(positionId);
                        vpsInfoData.setNode_location(result.getNode_location());
                        vpsInfoData.setIp_address(result.getIp_addresses().get(0));
                        vpsInfoData.setOs(result.getOs());
                        vpsInfoData.setStatus(result.getVz_status().getStatus());
                        vpsInfoData.setData_counter(result.getData_counter() + "");
                        //adapter.notifyItemChanged(positionId);
                        adapter.notifyDataSetChanged();
                        vpsInfoDb.update(vpsInfoData);
                        //adapter.notifyItemChanged(positionId);

                        Log.i("VpsListFragment", result.getData_counter() + "");
                    }

                    @Override
                    public void onFailure(Call<LiveServiceInfo> c, Throwable t) {
                        Toast.makeText(mContext, "request error", Toast.LENGTH_SHORT).show();
                        //Log.i("VpsListFragment", "Bad request");
                    }
                });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        vpsInfoDb.destroy();
    }
}
