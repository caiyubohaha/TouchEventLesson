package cyb.toucheventlesson.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by user on 2017/2/20.
 */

public class TouchView extends View {
    public TouchView(Context context) {
        super(context);
    }

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("8888","子控件onTouchEvent--"+event.getAction());
        boolean b= super.onTouchEvent(event);
        Log.i("8888",b+"");
        return b;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("8888","子控件dispatchTouchEvent--"+ev.getAction());
//        boolean b =  super.dispatchTouchEvent(ev);
//        Log.i("8888",b+"");
        return true;
    }

}
