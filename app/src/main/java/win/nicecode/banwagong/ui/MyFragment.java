package win.nicecode.banwagong.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import win.nicecode.banwagong.R;

public class MyFragment extends Fragment {

    @BindView(R.id.btn_one)
    Button btn_one;
    @BindView(R.id.btn_two)
    Button btn_two;
    @BindView(R.id.btn_three)
    Button btn_three;
    @BindView(R.id.btn_four)
    Button btn_four;
    @BindView(R.id.btn_jump)
    Button btn_jump;

    public MyFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.btn_one, R.id.btn_two, R.id.btn_three, R.id.btn_four, R.id.btn_jump})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                TextView tab_menu_channel_num = getActivity().findViewById(R.id.tab_menu_home_num);
                tab_menu_channel_num.setText("11");
                tab_menu_channel_num.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_two:
                TextView tab_menu_message_num =getActivity().findViewById(R.id.tab_menu_like_num);
                tab_menu_message_num.setText("20");
                tab_menu_message_num.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_three:
                TextView tab_menu_better_num = getActivity().findViewById(R.id.tab_menu_message_num);
                tab_menu_better_num.setText("99+");
                tab_menu_better_num.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_four:
                ImageView tab_menu_setting_partner =  getActivity().findViewById(R.id.tab_menu_setting_partner);
                tab_menu_setting_partner.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_jump:
                startActivity(new Intent(getActivity(), TestActivity.class));
                break;
        }
    }
}
