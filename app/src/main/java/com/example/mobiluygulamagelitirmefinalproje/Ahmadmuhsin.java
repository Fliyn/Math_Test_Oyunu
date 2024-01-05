package com.example.mobiluygulamagelitirmefinalproje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ahmadmuhsin extends AppCompatActivity {


    TextView textView13;
    TextView textView14;
    TextView textView15;
    Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahmadmuhsin);
        final getttar waxman=(getttar) getApplicationContext();
        textView13 = (TextView) findViewById(R.id.textView13);
        textView14 = (TextView) findViewById(R.id.textView14);
        textView15 = (TextView) findViewById(R.id.textView15);
        button9= (Button) findViewById(R.id.button9);

        textView14.setText(String.valueOf(waxman.GetUsername()));
        textView15.setText(String.valueOf(waxman.getdoğrusorusays()));
        textView13.setText("Puan:"+(String.valueOf(waxman.getpuan())));



        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel= new NotificationChannel("w","w", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(Ahmadmuhsin.this, "w");
        builder.setContentTitle("Sonuçlar");
        builder.setContentText("Cevaplanan Doğru soru sayısı: "+(String.valueOf(waxman.getdoğrusorusays()))+" Toplam Puan: "+(String.valueOf(waxman.getpuan())));
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setAutoCancel(true);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Ahmadmuhsin.this);
        managerCompat.notify(17, builder.build());


        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Anasayfa.class);
                startActivity(intent);
            }
        });
    }
}