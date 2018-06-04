package win.nicecode.banwagong.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import win.nicecode.banwagong.R;

public class CreateActivity extends AppCompatActivity {
    @BindView(R.id.etVeid)
    EditText etVeid;
    @BindView(R.id.etApiKey)
    EditText etApiKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        ButterKnife.bind(this);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        //mActionBar.setTitle("修改菜品分类");
    }

    @OnClick({R.id.btnAdd, R.id.btnCancel})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                Log.d("edit",etVeid.getText().toString());
                Log.d("edit",etApiKey.getText().toString());
                break;
            case R.id.btnCancel:
                startActivity(new Intent(CreateActivity.this, MainActivity.class));
                finish();
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
