package cyb.toucheventlesson;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import cyb.toucheventlesson.touch.BaseActivity;
import cyb.toucheventlesson.touch.EMLayoutBinder;

@EMLayoutBinder(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    public static final int RECORD_AUDIO = 0x00154;
    private String TAG ="MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
        startActivityForResult(intent, RECORD_AUDIO);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RECORD_AUDIO:
                try {
                    Uri uri = data.getData();
                    String filePath = getAudioFilePathFromUri(uri);
                    Log.d(TAG, filePath);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private String getAudioFilePathFromUri(Uri uri) {
        Cursor cursor = getContentResolver()
                .query(uri, null, null, null, null);
        cursor.moveToFirst();
        int index = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA);
        return cursor.getString(index);
    }


// ...


}
