package cyb.toucheventlesson.touch;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cyb.toucheventlesson.R;

@EMLayoutBinder(R.layout.activity_annotation_lesson)
public class AnnotationLesson extends BaseActivity {
    @EMViewBinder(R.id.tv)
    TextView tv;
    @EMViewBinder(R.id.tv2)
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_annotation_lesson);
        //EMAnnotationParser.injectActivity(this);
        tv.setText("傻逼把你");
        tv2.setText("傻");
    }

    @EMOnclickBinder({R.id.btn,R.id.btn2})
    public void onclick(View v,View e){
        switch(v.getId()){
            case R.id.btn:
                Toast.makeText(this, "傻逼1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                Toast.makeText(this, "傻逼2", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
