package com.gkskfhdlstmapk.hanpinetree.bcsd_android;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //접근 지정자 꼭 써줄 것!!
    private TextView tv_count;
    private Button btn_toast ;
    private Button btn_count ;
    private Button btn_random;
    private int count = 0;

   //NotificationManager notificationManager;
    //PendingIntent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_count = (TextView)findViewById(R.id.tv_count);
        btn_toast = (Button)findViewById(R.id.btn_toast);

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"number is "+tv_count.getText().toString(),Toast.LENGTH_SHORT).show();
                show();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onButtonClicked(View view){
        btn_count = (Button)findViewById(R.id.btn_count);
        btn_random = (Button)findViewById(R.id.btn_random);

        switch (view.getId()){
            case R.id.btn_count:
                tv_count.setText(String.valueOf(++count));
                break;
            case R.id.btn_random:
               /* intent = PendingIntent.getActivity(this, 0, new Intent(getApplicationContext(), MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
                Notification.Builder builder = new Notification.Builder(this)
                         .setSmallIcon(R.drawable.ic_launcher_background) // 아이콘 설정하지 않으면 오류남
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setContentTitle("알림 제목") // 제목 설정
                        .setContentText("알림 내용") // 내용 설정
                        .setTicker("한줄 출력") // 상태바에 표시될 한줄 출력
                        .setAutoCancel(true)
                        .setContentIntent(intent);

                notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0, builder.build());
*/
                Intent intent = new Intent(this, MyService.class);
                intent.putExtra("Count",count);
                startService(intent);

                break;
        }

    }
    // IMPLEMENT 상속 받아서 사용하는 방법
    //위에서 btn_count.setOnClickListener(this)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_count:
                break;
            default:
        }
    }
    void show()
    {
        //여기서는 리스트 자료구조를 사용할 예정임
        //이건 데이터셋에 불과함.
        final List<String> ListItems = new ArrayList<>();
        //리스트라이템은 다음과 같음
        ListItems.add("positive");
        ListItems.add("neutral");
        ListItems.add("negative ");
        final CharSequence[] items =  ListItems.toArray(new String[ ListItems.size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("AlertDialog");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int pos) {
                String selectedText = items[pos].toString();
                if(selectedText == "positive"){
                    count = 0;
                    tv_count.setText(count+"");
                }else if(selectedText == "neutral"){
                    Toast.makeText(getApplicationContext(),"토스트메세지~",Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.show();
    }

}
//getApplicationContext보다는,
//Context mContext = this;이런식으로 사용했네, init()내부로 해서!! -> 유지보수가 쉽게!
