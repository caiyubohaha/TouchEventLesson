package cyb.toucheventlesson;

import android.app.Activity;
import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by user on 2017/2/28.
 */

public class MyApplication extends Application {
    public static MyApplication myApplication;
    //public RefWatcher refWatcher;
    public Activity activity;
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
         LeakCanary.install(this);
    }

    public  static  MyApplication getInstance() {
        return myApplication;
    }


    public void setActivity(Activity activity){
        this.activity = activity;
    }
}
