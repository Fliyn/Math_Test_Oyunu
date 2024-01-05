package com.example.mobiluygulamagelitirmefinalproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class HESAP_sayfasI extends AppCompatActivity {


    private CountDownTimer countDownTimer;
    private long lefttime =10000;
    TextView textView2;
    TextView textView7,textView8,textView9,textView11,textView10;
    Button button3;
    Button button8;
    EditText editTextNumberPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final getttar waxman=(getttar) getApplicationContext();
        setContentView(R.layout.activity_hesap_sayfas_i);

        Random rand = new Random();
        TextView textView2= (TextView)  findViewById(R.id.textView2);
        TextView textView7= (TextView)  findViewById(R.id.textView7);
        TextView textView8= (TextView)  findViewById(R.id.textView8);
        TextView textView9= (TextView)  findViewById(R.id.textView9);
        TextView textView11= (TextView)  findViewById(R.id.textView11);
        TextView textView10= (TextView)  findViewById(R.id.textView10);
        Button button3= (Button)  findViewById(R.id.button3);
        Button button8= (Button)  findViewById(R.id.button8);
        EditText editTextNumberPassword= (EditText)  findViewById(R.id.editTextNumberPassword);


        String x= String.valueOf(waxman.getrandom()+(rand.nextInt(waxman.getrandomax())));
        String y= String.valueOf(waxman.getrandom()+(rand.nextInt(waxman.getrandomax())));

        textView7.setText(x);
        textView8.setText(y);
        textView9.setText(waxman.GetUsername());
        lefttime=waxman.gettime();
        String hakk = String.valueOf(waxman.gethak());
        textView11.setText(hakk);
        textView10.setText(String.valueOf(waxman.getpuan()));
        //lefttime=12000;
        countDownTimer= new CountDownTimer(lefttime,1000){
            @Override
            public void onTick(long l){
                lefttime=l;

                int seconds= (int) (lefttime %60000 / 1000);

                String timerlefttxt="";
                if (seconds<10) timerlefttxt+="0";
                timerlefttxt+=seconds;
                textView2.setText(timerlefttxt);


            }
            @Override
            public void onFinish(){
                Intent intent = new Intent(getApplicationContext(), Ahmadmuhsin.class);
                startActivity(intent);
            }
        }.start();


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                Intent intent =new Intent(getApplicationContext(),Anasayfa.class);
                startActivity(intent);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Integer.valueOf(String.valueOf(textView11.getText())))<2){
                    countDownTimer.cancel();
                    Intent intent = new Intent(getApplicationContext(), Ahmadmuhsin.class);
                    startActivity(intent);
                }
                if(editTextNumberPassword.length()<1) {
                    Toast.makeText(HESAP_sayfasI.this, "Boş Geçmayınnnn", Toast.LENGTH_SHORT).show();
                    int hakeksilen =waxman.gethak();
                    hakeksilen=hakeksilen-1;
                    waxman.sethak(hakeksilen);
                    String x= String.valueOf(waxman.getrandom()+(rand.nextInt(waxman.getrandomax())));
                    String y= String.valueOf(waxman.getrandom()+(rand.nextInt(waxman.getrandomax())));
                    int puanson= (Integer.valueOf(String.valueOf(textView10.getText())))+waxman.getpuaneksi();
                    textView10.setText(String.valueOf(puanson));
                    waxman.setpuan(puanson);
                    String haktext= String.valueOf(hakeksilen);
                    textView11.setText(haktext);
                    textView7.setText(x);
                    textView8.setText(y);
                }
                else{
                int eşit=Integer.valueOf(String.valueOf(editTextNumberPassword.getText()));
                if(eşit == (Integer.parseInt(String.valueOf(textView7.getText())))+(Integer.parseInt(String.valueOf(textView8.getText())))){
                //++puan
                    int doğrusays=waxman.getdoğrusorusays();
                    doğrusays=doğrusays+1;
                    waxman.setdoğrusorusays(doğrusays);
                    String x= String.valueOf(waxman.getrandom()+(rand.nextInt(waxman.getrandomax())));
                    String y= String.valueOf(waxman.getrandom()+(rand.nextInt(waxman.getrandomax())));
                    int puanson= (Integer.valueOf(String.valueOf(textView10.getText())))+waxman.getartıpuan();
                    textView10.setText(String.valueOf(puanson));
                    waxman.setpuan(puanson);
                textView7.setText(x);
                textView8.setText(y);
                }
                else{
                    int hakeksilen =waxman.gethak();
                    hakeksilen=hakeksilen-1;
                    waxman.sethak(hakeksilen);
                    String x= String.valueOf(waxman.getrandom()+(rand.nextInt(waxman.getrandomax())));
                    String y= String.valueOf(waxman.getrandom()+(rand.nextInt(waxman.getrandomax())));
                    int puanson= (Integer.valueOf(String.valueOf(textView10.getText())))+waxman.getpuaneksi();
                    textView10.setText(String.valueOf(puanson));
                    waxman.setpuan(puanson);
                    String haktext= String.valueOf(hakeksilen);
                    textView11.setText(haktext);
                    textView7.setText(x);
                    textView8.setText(y);
                }
                }
            }
        });
    }
}