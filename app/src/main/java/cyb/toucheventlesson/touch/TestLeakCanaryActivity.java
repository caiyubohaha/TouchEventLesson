package cyb.toucheventlesson.touch;

import android.app.Application;
import android.os.Bundle;

import cyb.toucheventlesson.MyApplication;
import cyb.toucheventlesson.R;

public class TestLeakCanaryActivity extends BaseActivity {
    Application application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyApplication.getInstance().setActivity(TestLeakCanaryActivity.this);
        finish();
    }
}
