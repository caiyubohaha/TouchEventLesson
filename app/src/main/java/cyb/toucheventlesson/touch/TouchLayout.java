package cyb.toucheventlesson.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by user on 2017/2/20.
 */

public class TouchLayout extends RelativeLayout{
    public TouchLayout(Context context) {
        super(context);
    }

    public TouchLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("8888","容器AonTouchEvent--"+event.getAction());
        boolean b =  super.onTouchEvent(event);
        Log.i("8888",b+"");
        return b;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("8888","容器AdispatchTouchEvent--"+ev.getAction());
        boolean b =super.dispatchTouchEvent(ev);
        Log.i("8888",b+"---------------------------dispatchTouchEvent");
        return b;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("8888","容器AonInterceptTouchEvent--"+ev.getAction());
        boolean b =super.onInterceptTouchEvent(ev);
        Log.i("8888",b+"-------------------------onInterceptTouchEvent");
        return b;
    }
}
