package xiao.testscheme;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    public static final String ONCLICK = "com.app.onclick";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_act);

        findViewById(R.id.btn_to_other).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to other activity
                openOtherApp();
                //show notification
                showNotification();


            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    private void showNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder notifyBuilder = new Notification.Builder(this);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.test_notification_layout);
        notifyBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notifyBuilder.setContent(remoteViews);
        Notification notification = notifyBuilder.build();
        Intent intent = new Intent("com.app.onclick");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        notification.contentView.setOnClickPendingIntent(R.id.tv_back, pendingIntent);
        //发送通知请求
        notificationManager.notify(10, notification);
    }

    /**
     *
     */
    private void openOtherApp() {
        TextView tvValue = findViewById(R.id.tv_value);
        tvValue.setText(String.valueOf(1));

        ComponentName apk2Component1 = new ComponentName("xiao.usedtotestscheme", "xiao.usedtotestscheme.MainActivity");
        Intent mIntent = new Intent();
        mIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        mIntent.setComponent(apk2Component1);
        startActivity(mIntent);


    }


}
