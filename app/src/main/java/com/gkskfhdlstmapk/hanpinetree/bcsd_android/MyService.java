package com.gkskfhdlstmapk.hanpinetree.bcsd_android;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public NotificationManager notifyManager;
    public NotificationCompat.Builder mBuilder;
    public String CHANNEL_ID = "channel";
    public String CHANNEL_NAME = "ㅠㅠ";
    public int notificationId = 1;
    NotificationManagerCompat notificationManager;
    NotificationCompat.Builder builder;
    Intent notificationIntent;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent !=null){
            processCommand(intent);
        }

        /*
        notificationManager = NotificationManagerCompat.from(this);
        builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("Picture Download")
                .setContentText("Download in progress")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(NotificationCompat.PRIORITY_LOW);

        int PROGRESS_MAX = 100;
        int PROGRESS_CURRENT = 0;
        builder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false);
        notificationManager.notify(notificationId, builder.build());
*/

        notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            int importance = NotificationManager.IMPORTANCE_UNSPECIFIED;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,importance);
            notifyManager.createNotificationChannel(mChannel);
        }
        mBuilder =
                new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
        notificationIntent = new Intent(getApplicationContext(),random.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        mBuilder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("프로그래스")
                .setContentText("실행중입니다")
                .setDefaults(Notification.DEFAULT_ALL);
        mBuilder.setProgress(0,100,true);
        notifyManager.notify(0,mBuilder.build());

        return Service.START_NOT_STICKY;
    }

    private void processCommand(Intent intent){
        int count = intent.getIntExtra("Count",0);
        Toast.makeText(getApplicationContext(),"서비스실행됨~"+count,Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        builder.setContentText("끝났습니다.")
                .setProgress(100,100,false);
        notificationManager.notify(notificationId, builder.build());

        /*
        mBuilder.setProgress(0,0,false);
        notifyManager.notify(0,mBuilder.build());
        */
        //stopService(notificationIntent);
        Toast.makeText(getApplicationContext(),"서비스 종료됨~",Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
