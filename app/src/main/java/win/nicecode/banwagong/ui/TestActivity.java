package win.nicecode.banwagong.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import win.nicecode.banwagong.R;

public class TestActivity extends AppCompatActivity {
    @BindView(R.id.button2)
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button2)
    public void jumpActivity(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
