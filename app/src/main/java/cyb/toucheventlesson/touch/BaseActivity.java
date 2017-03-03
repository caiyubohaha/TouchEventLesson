package cyb.toucheventlesson.touch;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_base);
        EMAnnotationParser.injectActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // MyApplication.getInstance().refWatcher.watch(this);
    }
}
