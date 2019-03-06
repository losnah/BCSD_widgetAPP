package com.gkskfhdlstmapk.hanpinetree.bcsd_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class random extends AppCompatActivity {
    TextView tv_random_count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        tv_random_count = (TextView)findViewById(R.id.tv_random_count);
        Random random = new Random();
        tv_random_count.setText(String.valueOf(random.nextInt(16)));

    }
}
