package win.nicecode.banwagong.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import win.nicecode.banwagong.R;

public class VpsDetailActivity extends AppCompatActivity {

    @BindView(R.id.tv_detail_ip)
    TextView ipTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vps_detail);
        ButterKnife.bind(this);
        ipTextView.setText(getIntent().getStringExtra("ip"));
    }
}
