package cyb.toucheventlesson.touch;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by user on 2017/3/3.
 */

public class EMAnnotationParser {
    public static void injectActivity(Activity activity){
        if (null==activity){
            return ;
        }
        Class<Activity> activityClass = (Class<Activity>) activity.getClass();
        if (isEMLayoutBinder(activityClass)){
            EMLayoutBinder layout = activityClass.getAnnotation(EMLayoutBinder.class);
            activity.setContentView(layout.value());
        }
        View decorView = activity.getWindow().getDecorView();
        initviews(activityClass.getDeclaredFields(),decorView,activity);
        initeven(activityClass.getDeclaredMethods(),decorView,activity);
    }

    private static void initeven(Method[] declaredMethods, View decorView, final Activity activity) {
        for (final Method method:  declaredMethods){
            if (isEMEventBinder(method)){
                EMOnclickBinder onlick = method.getAnnotation(EMOnclickBinder.class);
                MyOnclickListener listener = new MyOnclickListener(method,activity);
                int[] ids = onlick.value();
                for (int id:ids) {
                    //decorView.findViewById(id).setOnClickListener(listener);
                    decorView.findViewById(id).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            method.setAccessible(true);
                            try {
                                method.invoke(activity,v,v);

                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }catch (IllegalArgumentException e){
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }

        }
    }


    private static boolean isEMLayoutBinder(Class<?> c){
        return c.isAnnotationPresent(EMLayoutBinder.class);
    }
    private static void initviews(Field[] declaredFields, View decorView, Object object) {
        View view1;
        for (Field field: declaredFields) {
            if (isEMViewBinder(field)){
                EMViewBinder emview = field.getAnnotation(EMViewBinder.class);
                view1 = decorView.findViewById(emview.value());
                if (null!=view1){
                    try {
                        field.setAccessible(true);
                        field.set(object,view1);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }catch (IllegalArgumentException e){
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    private static boolean isEMViewBinder(Field field){
        return field.isAnnotationPresent(EMViewBinder.class);
    }
    private static boolean isEMEventBinder(Method method){
        return method.isAnnotationPresent(EMOnclickBinder.class);
    }
    static class MyOnclickListener implements View.OnClickListener{
        private Method method;
        private Object object;
        public MyOnclickListener (Method method,Object object){
            this.method = method;
            this.object = object;
        }
        @Override
        public void onClick(View v) {
            method.setAccessible(true);
            try {
                method.invoke(object,v);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
