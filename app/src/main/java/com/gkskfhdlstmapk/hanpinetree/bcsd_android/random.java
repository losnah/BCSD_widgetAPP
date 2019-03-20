package com.gkskfhdlstmapk.hanpinetree.bcsd_android;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class random extends Fragment {
    private TextView mRandomCountTextview;
    private Button mFinishButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.activity_random, container,false);

        mRandomCountTextview = (TextView)rootView.findViewById(R.id.activity_random_textview_random_count);
       Random random = new Random();
       int count = 16;
        mFinishButton = (Button)rootView.findViewById(R.id.activity_random_finish_button);
        mFinishButton.setOnClickListener(new View.OnClickListener() {
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
        mRandomCountTextview.setText(String.valueOf(random.nextInt(count)));

        return rootView;
}
}
