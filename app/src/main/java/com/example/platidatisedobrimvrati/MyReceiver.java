package com.example.platidatisedobrimvrati;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.room.Room;

import com.example.platidatisedobrimvrati.model.GlobalnePromenljive;
import com.example.platidatisedobrimvrati.model.OrganizacijaDao;
import com.example.platidatisedobrimvrati.model.OrganizacijaRoomDatabase;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //System.out.println(6);

        Intent intentStampa = new Intent("com.payten.ecr.action");
        intentStampa.setPackage("com.payten.paytenapos");
        String stringStampa = "{\n" +
                "\t\"header\":{\n" +
                "\t\t\"length\":64983,\n" +
                "\t\t\"hash\":\"9397e30d8f92da29d9c1016a3e0eab55c7874f5b1cc67e400ecfac233f82889234f41328b2df08066b3e692dcb6f028d56b0fd009fca18fdac9b5669f6775e71\",\n" +
                "\t\t\"version\":\"1\"\n" +
                "\t},\n" +
                "\t\n" +
                "\t\"request\":{\t\t\n" +
                "\t\t\"command\":{\n" +
                "\t\t\t\"printer\":{\n" +
                "\t\t\t\t\"type\":\"JSON\",\n" +
                "\t\t\t\t\"printLines\":\n" +
                "\t\t\t\t[\n" +
                "\t\t\t\t\t{\t\"type\":\"text\",\n" +
                "\t\t\t\t\t\t\"style\":\"CONDENSED\",\n" +
                "\t\t\t\t\t\t\"content\":\"" + GlobalnePromenljive.tekstRacun + "\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t{\t\"type\":\"QR\",\n" +
                "\t\t\t\t\t\t\"content\":\"" + GlobalnePromenljive.tekstQr + "\"\n" +
                "\t\t\t\t\t}" +
                "\t\t\t\t]\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        intentStampa.putExtra("ecrJson", stringStampa);
        intentStampa.putExtra("senderIntentFilter", "com.example.platidatisedobrimvratifilter2"); // nikako filter, bice rekurzivno
        intentStampa.putExtra("senderPackage", "com.example.platidatisedobrimvrati");
        //intent.putExtra("senderClass", "MainActivity");
        intentStampa.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);

        context.sendBroadcast(intentStampa);


        String response = intent.getStringExtra("ResponseResult");
        Intent i = new Intent(context, MainActivity.class);
        i.putExtra("ResponseResult",response);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(i);
        //System.out.println(response);
    }
}