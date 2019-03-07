package xiao.testscheme;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import static android.content.Context.NOTIFICATION_SERVICE;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MyBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("MyBroadCastReceiver", "onReceive");
        String action = intent.getAction();
        Uri uri = intent.getData();
        if ("com.app.onclick".equals(action)) {
            Intent newIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("schemetest://xiao.testscheme:8080/test"));
            newIntent.addFlags(FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(newIntent);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            notificationManager.cancelAll();
        }
    }
}