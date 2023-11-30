package com.example.platidatisedobrimvrati;

        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;

        import androidx.room.Room;

        import com.example.platidatisedobrimvrati.model.GlobalnePromenljive;
        import com.example.platidatisedobrimvrati.model.OrganizacijaDao;
        import com.example.platidatisedobrimvrati.model.OrganizacijaRoomDatabase;

public class MyReceiverEnd extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //System.out.println(6);

        Intent i = new Intent(context, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags (Intent.FLAG_ACTIVITY_SINGLE_TOP);
        i.putExtra("close_activity",true);
        context.startActivity(i);
    }
}