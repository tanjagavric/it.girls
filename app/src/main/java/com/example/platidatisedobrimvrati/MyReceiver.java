package com.example.platidatisedobrimvrati;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println(6);
        String response = intent.getStringExtra("ResponseResult");
        Intent i = new Intent(context, MainActivity.class);
        i.putExtra("ResponseResult",response);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(i);
    }
}