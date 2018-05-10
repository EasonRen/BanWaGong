package win.nicecode.banwagong.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import win.nicecode.banwagong.R;
import win.nicecode.banwagong.api.DataManager;
import win.nicecode.banwagong.bean.LiveServiceInfo;
import win.nicecode.banwagong.bean.VpsInfoData;
import win.nicecode.banwagong.db.VpsInfoDb;

public class MainActivity extends AppCompatActivity {
    private String veid = "379833";
    private String api_key = "private_NUvbYdSRZ35vaQhhSaU3ux63";

    @BindView(R.id.ly_tab_menu_home)
    LinearLayout ly_tab_menu_home;
    @BindView(R.id.tab_menu_home)
    TextView tab_menu_home;
    @BindView(R.id.tab_menu_home_num)
    TextView tab_menu_home_num;

    @BindView(R.id.ly_tab_menu_like)
    LinearLayout ly_tab_menu_like;
    @BindView(R.id.tab_menu_like)
    TextView tab_menu_like;
    @BindView(R.id.tab_menu_like_num)
    TextView tab_menu_like_num;

    @BindView(R.id.ly_tab_menu_message)
    LinearLayout ly_tab_menu_message;
    @BindView(R.id.tab_menu_message)
    TextView tab_menu_message;
    @BindView(R.id.tab_menu_message_num)
    TextView tab_menu_message_num;

    @BindView(R.id.ly_tab_menu_person)
    LinearLayout ly_tab_menu_person;
    @BindView(R.id.tab_menu_person)
    TextView tab_menu_person;
    @BindView(R.id.tab_menu_setting_partner)
    ImageView tab_menu_setting_partner;

    FragmentManager fManager;
    FragmentTransaction fTransaction;
    MyFragment fg1;
    VpsListFragment vpsListFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ly_tab_menu_home.performClick();
        fg1 = new MyFragment();
        fManager = getFragmentManager();
        fTransaction = fManager.beginTransaction();
        fTransaction.add(R.id.ly_frame, fg1).commit();
        //bindData();

        VpsInfoDb vpsInfoDb = new VpsInfoDb(this);

        List<VpsInfoData> ls=vpsInfoDb.query("");
    }

    @OnClick({R.id.ly_tab_menu_home, R.id.ly_tab_menu_like, R.id.ly_tab_menu_message, R.id.ly_tab_menu_person})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ly_tab_menu_home:
                setSelected();
                tab_menu_home.setSelected(true);
                tab_menu_home_num.setVisibility(View.INVISIBLE);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.ly_frame, new MyFragment())
                        .commit();
                break;
            case R.id.ly_tab_menu_like:
                setSelected();
                tab_menu_like.setSelected(true);
                tab_menu_like_num.setVisibility(View.INVISIBLE);
                if (vpsListFragment == null)
                    vpsListFragment = new VpsListFragment();

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.ly_frame, vpsListFragment)
                        .commit();
                break;
            case R.id.ly_tab_menu_message:
                setSelected();
                tab_menu_message.setSelected(true);
                tab_menu_message_num.setVisibility(View.INVISIBLE);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.ly_frame, new MyFragment())
                        .commit();
                break;
            case R.id.ly_tab_menu_person:
                setSelected();
                tab_menu_person.setSelected(true);
                tab_menu_setting_partner.setVisibility(View.INVISIBLE);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.ly_frame, new MyFragment())
                        .commit();
                break;
        }
    }

    private void setSelected() {
        tab_menu_home.setSelected(false);
        tab_menu_like.setSelected(false);
        tab_menu_message.setSelected(false);
        tab_menu_person.setSelected(false);
    }

    private void bindData() {
        DataManager.getInstance()
                .getLiveServiceInfo(veid, api_key)
                .enqueue(new Callback<LiveServiceInfo>() {
                    @Override
                    public void onResponse(Call<LiveServiceInfo> c, Response<LiveServiceInfo> response) {
                        LiveServiceInfo result = response.body();

                    }

                    @Override
                    public void onFailure(Call<LiveServiceInfo> c, Throwable t) {
                        Toast toast = Toast.makeText(MainActivity.this, "Bad request", 2 * 1000);
                        toast.show();
                    }
                });
    }
}
