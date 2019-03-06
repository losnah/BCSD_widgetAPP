package com.gkskfhdlstmapk.hanpinetree.bcsd_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv_count;
    Button btn_toast ;
    Button btn_count ;
    Button btn_random;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_count = (TextView)findViewById(R.id.tv_count);
        btn_toast = (Button)findViewById(R.id.btn_toast);

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"number is "+tv_count.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onButtonClicked(View view){
        btn_count = (Button)findViewById(R.id.btn_count);
        btn_random = (Button)findViewById(R.id.btn_random);

        switch (view.getId()){
            case R.id.btn_count:
                tv_count.setText(String.valueOf(++count));
                break;
            case R.id.btn_random:
                Intent intent = new Intent(this, random.class);
                startActivity(intent);
                break;
        }

    }
}
