package com.example.mobiluygulamagelitirmefinalproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Anasayfa extends AppCompatActivity {

    TextView textView3;
    Button button7;
    Button button4;
    CheckBox checkBox,checkBox2,checkBox4;
    Benibendenalırsansenisanabırakmam data_base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);
        data_base = new Benibendenalırsansenisanabırakmam(this);
        final getttar waxman=(getttar) getApplicationContext();
        textView3= (TextView) findViewById(R.id.textView3);
        button7=(Button) findViewById(R.id.button7);
        button4=(Button) findViewById(R.id.button4);
        textView3.setText(waxman.GetUsername());
        checkBox2=(CheckBox) findViewById(R.id.checkBox2);
        checkBox=(CheckBox) findViewById(R.id.checkBox);
        checkBox4=(CheckBox) findViewById(R.id.checkBox4);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checkBox.setChecked(true);
                checkBox2.setChecked(false);
                checkBox4.setChecked(false);
                waxman.settime(40000);
                waxman.setartıpuan(5);
                waxman.setpuaneksi(-1);
                //0-50
                waxman.setrandom(0);
                waxman.setrandomax(50);
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox.setChecked(false);
                //checkBox2.setChecked(true);
                checkBox4.setChecked(false);
                waxman.settime(25000);
                waxman.setartıpuan(10);
                waxman.setpuaneksi(-3);
                //50-75
                waxman.setrandom(50);
                waxman.setrandomax(25);
            }
        });
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox.setChecked(false);
                checkBox2.setChecked(false);
                //checkBox4.setChecked(true);
                waxman.settime(15000);
                waxman.setartıpuan(12);
                waxman.setpuaneksi(-8);
                //25-100
                waxman.setrandom(25);
                waxman.setrandomax(75);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked() || checkBox2.isChecked() || checkBox4.isChecked()){
                    waxman.sethak(3);
                    waxman.setpuan(0);
                    waxman.setdoğrusorusays(0);
                    Intent intent =new Intent(getApplicationContext(),HESAP_sayfasI.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Anasayfa.this, "Zorluk seçiniz", Toast.LENGTH_LONG).show();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean axamar = data_base.hazx(waxman.GetUsername(),5);
                if(axamar){
                    Toast.makeText(Anasayfa.this, "Hesaptan çıkıldı", Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }
}