package win.nicecode.banwagong.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
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

public class VpsListFragment extends Fragment {
    private String veid = "379833";
    private String api_key = "private_NUvbYdSRZ35vaQhhSaU3ux63";
    private List<LiveServiceInfo> list;
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
        bindData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vps_list, container, false);
        ButterKnife.bind(this, view);
        if (list == null) {
            list = new ArrayList<>();
        }

        if (adapter == null) {
            adapter = new VpsListAdapter(list);
        }

        vpsListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        vpsListRecyclerView.setAdapter(adapter);

        Log.i("dasdsa", "sadasdasdsa");
        return view;
    }

    private void bindData() {
        DataManager.getInstance()
                .getLiveServiceInfo(veid, api_key)
                .enqueue(new Callback<LiveServiceInfo>() {
                    @Override
                    public void onResponse(Call<LiveServiceInfo> c, Response<LiveServiceInfo> response) {
                        LiveServiceInfo result = response.body();
                        if (list.size() > 0) {
                            list.get(0).setData_counter(517474);
                        } else {
                            list.add(result);
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<LiveServiceInfo> c, Throwable t) {
                        Toast toast = Toast.makeText(getActivity(), "Bad request", 2 * 1000);
                        toast.show();
                    }
                });
    }
}
