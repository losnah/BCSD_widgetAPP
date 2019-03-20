package com.gkskfhdlstmapk.hanpinetree.bcsd_android;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.RandomAccess;

public class random extends Fragment {
    TextView tv_random_count;
    Button buttonFinish;

    String TAG = Random.class.getName(); //이런식으로 TAG값을 얻어낼 수도 있다.
    //
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.activity_random, container,false);

       tv_random_count = (TextView)rootView.findViewById(R.id.tv_random_count);
       Random random = new Random();
       int count = 16;
       buttonFinish = (Button)rootView.findViewById(R.id.buttonFinish);
       buttonFinish.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //Intent intent = new Intent(getContext(), MyService.class);
               //getContext().stopService(intent);
               getActivity().finish();
           }
       });
      /*Bundle 및 argument
      try {
          // Intent intent = Intent.getIntentOld("com.gkskfhdlstmapk.hanpinetree.bcsd_android");//이쪽!
          // count = intent.getExtras().getInt("Count");
           //getArgument -> main에서는 bundle로 값을 putInt로 보냄. fragment.setArguments!!로 함!
       }catch (URISyntaxException e){
       }
       */
       tv_random_count.setText(String.valueOf(random.nextInt(count)));

        return rootView;
}
}
