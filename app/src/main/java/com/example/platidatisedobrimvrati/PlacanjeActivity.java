package com.example.platidatisedobrimvrati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.platidatisedobrimvrati.R;
import com.example.platidatisedobrimvrati.model.GlobalnePromenljive;
import com.example.platidatisedobrimvrati.model.Organizacija;
import com.example.platidatisedobrimvrati.model.OrganizacijaDao;
import com.example.platidatisedobrimvrati.model.OrganizacijaRoomDatabase;

import java.io.File;

public class PlacanjeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placanje);

        String imeOrganizacije = new String("a");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            imeOrganizacije = extras.getString("key");
            //The key argument here must match that used in the other activity
        }
        Button dugmePlati = (Button)findViewById(R.id.dugmePlatiSvotu);
        Button dugmeSvota1 = (Button)findViewById(R.id.dugmeSvota1);
        Button dugmeSvota2 = (Button)findViewById(R.id.dugmeSvota2);
        Button dugmeSvota3 = (Button)findViewById(R.id.dugmeSvota3);
        EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        TextView tvZahvalnica = (TextView)findViewById(R.id.tvZahvalnica);
        int c = R.drawable.budihuman;

        OrganizacijaRoomDatabase db = Room.databaseBuilder(getApplicationContext(), OrganizacijaRoomDatabase.class, "organizacija_database").allowMainThreadQueries().build();
        OrganizacijaDao dao = db.organizacijaDao();
        Organizacija org = dao.getOrganizacijaPoImenu(imeOrganizacije);
        int linkDoSlike = org.getLinkDoSlike();

        ImageView ivSlika=(ImageView)findViewById(R.id.imageView);
        ivSlika.setImageResource(linkDoSlike);

        String textZahvalnice = "Donirajte za organizaciju:\n\"" + imeOrganizacije+"\"";
        tvZahvalnica.setText(textZahvalnice);
        //tvZahvalnica.setTextAlignment();
        dugmePlati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int iznos =Integer.parseInt(editTextNumber.getText().toString());
                org.dodajDonaciju(iznos);
                dao.update(org);

                GlobalnePromenljive.tekstRacun = org.getPoruka();
                //String tekstRacun = org.getPoruka();
                Boolean jeNajveca = org.daLiJeNajvecaDonacija(iznos);
                if(jeNajveca){
                    //tekstRacun += "\n Hvala na najvecoj donaciji danas!";
                    GlobalnePromenljive.tekstRacun += "\"\n" +
                            "\t\t\t\t\t},\n" +
                            "\t\t\t\t\t{\t\"type\":\"text\",\n" +
                            "\t\t\t\t\t\t\"style\":\"CONDENSED\",\n" +
                            "\t\t\t\t\t\t\"content\":\"Hvala na najvecoj donaciji danas!";
                }
                //tekstRacun += "\n Ako zelite da pratite donacije za ovu organizaciju,\n skenirajte naredni QR kod:";
                GlobalnePromenljive.tekstRacun += "\"\n" +
                        "\t\t\t\t\t},\n" +
                        "\t\t\t\t\t{\t\"type\":\"text\",\n" +
                        "\t\t\t\t\t\t\"style\":\"CONDENSED\",\n" +
                        "\t\t\t\t\t\t\"content\":\"Ako zelite da pratite donacije za ovu\"\n" +
                        "\t\t\t\t\t},\n" +
                        "\t\t\t\t\t{\t\"type\":\"text\",\n" +
                        "\t\t\t\t\t\t\"style\":\"CONDENSED\",\n" +
                        "\t\t\t\t\t\t\"content\":\"organizaciju, skenirajte naredni QR kod:";
                GlobalnePromenljive.tekstQr = org.getQrCode();
                //String tekstQr = org.getQrCode();

                //System.out.println(org.getUkupnaDonacija());

                Intent intentNaplati = new Intent("com.payten.ecr.action");
                intentNaplati.setPackage("com.payten.paytenapos");
                String stringNaplati = "{\n" +
                        "\t\"header\":{\n" +
                        "\t\t\"length\":\"282\",\n" +
                        "\t\t\"hash\":\"XXX\",\n" +
                        "\t\t\"version\":\"01\"\n" +
                        "\t},\n" +
                        "\t\n" +
                        "\t\"request\":{\t\t\t\n" +
                        "\t\t\"financial\":{\t\t\t\n" +
                        "\t\t\t\"transaction\":\"sale\",\n" +
                        "\t\t\t\n" +
                        "\t\t\t\"id\": {\n" +
                        "\t\t\t\t\"ecr\": \"000001\"\n" +
                        "\t\t\t},\n" +
                        "\t\t\t\n" +
                        "\t\t\t\"amounts\": {\n" +
                        "\t\t\t\t\"base\": \"" + iznos + "\",\n" +
                        "\t\t\t\t\"currencyCode\": \"RSD\"\n" +
                        "\t\t\t},\n" +
                        "\n" +
                        "\t\t\t\"options\":{\n" +
                        "\t\t\t\t\"language\": \"sr\",\n" +
                        "\t\t\t\t\"print\": \"true\"\n" +
                        "\t\t\t}\n" +
                        "\t\t}\n" +
                        "\t}\n" +
                        "}";
                intentNaplati.putExtra("ecrJson", stringNaplati);
                intentNaplati.putExtra("senderIntentFilter", "com.example.platidatisedobrimvratifilter");
                intentNaplati.putExtra("senderPackage", "com.example.platidatisedobrimvrati");
                //intent.putExtra("senderClass", "MainActivity");
                intentNaplati.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intentNaplati);
            }
        });

        dugmeSvota1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = (String)dugmeSvota1.getText();
                String []arrOfStr = text1.split(" ",2);
                editTextNumber.setText(arrOfStr[0]);

            }
        });
        dugmeSvota2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text2 = (String)dugmeSvota2.getText();
                String []arrOfStr = text2.split(" ",2);
                editTextNumber.setText(arrOfStr[0]);
            }
        });

        dugmeSvota3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text3 = (String)dugmeSvota3.getText();
                String []arrOfStr = text3.split(" ",2);
                editTextNumber.setText(arrOfStr[0]);
            }
        });

    }


}