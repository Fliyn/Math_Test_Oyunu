package com.example.mobiluygulamagelitirmefinalproje;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //private DatabaseReference mdatabase;
    android.widget.Button button6, Button5;
    CheckBox checkBox3;
    TextView textView5;
    EditText editTextText6, editTextText5;
    Benibendenalırsansenisanabırakmam data_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button6 = (Button) findViewById(R.id.button6);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        Button5 = (Button) findViewById(R.id.button5);
        textView5 = (TextView) findViewById(R.id.textView5);
        editTextText5 = (EditText) findViewById(R.id.editTextText5);
        editTextText6 = (EditText) findViewById(R.id.editTextText6);
        data_base = new Benibendenalırsansenisanabırakmam(this);
        final getttar waxman=(getttar) getApplicationContext();

        Cursor opennesssss = data_base.opennesss();
        if(opennesssss.moveToFirst()){
            waxman.SetUserName(opennesssss.getString(0));
            String adım= opennesssss.getString(0);
            Toast.makeText(MainActivity.this, "Welcome Back "+ adım, Toast.LENGTH_LONG).show();
            Intent intent =new Intent(getApplicationContext(),Anasayfa.class);
            startActivity(intent);
        }


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//login
                AlphaAnimation buttonClick = new AlphaAnimation(0.4F, 0.2F);
                v.startAnimation(buttonClick);

                String wiredname = editTextText5.getText().toString();
                String wiredpass = editTextText6.getText().toString();
                if (wiredname.equals("")||wiredpass.equals(""))
                    Toast.makeText(MainActivity.this, "Veriables cant be empty", Toast.LENGTH_LONG).show();
                else{
                    Boolean namecheck = data_base.chechusernameandpassword(wiredname,wiredpass);
                    if(namecheck==true){
                        waxman.SetUserName(wiredname);
                        if(checkBox3.isChecked()){
                            Boolean yapıştır = data_base.hazx(wiredname,1);
                            if(yapıştır){

                            }
                        }
                        Toast.makeText(MainActivity.this,"Giriş Başarılı",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(getApplicationContext(),Anasayfa.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Uyumsuz giriş",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button5.setOnClickListener(new View.OnClickListener() {//go to register
            @Override
            public void onClick(View v) {
                AlphaAnimation buttonClick = new AlphaAnimation(0.4F, 0.2F);
                v.startAnimation(buttonClick);
                Intent intent =new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });


        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    SharedPreferences preferences =getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("checkBox","true");
                    editor.apply();
                    Toast toast = Toast.makeText(MainActivity.this, "çk", LENGTH_SHORT);
                    toast.show();
                } else if(!buttonView.isChecked()){
                    SharedPreferences preferences =getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("checkBox","false");
                    editor.apply();
                    Toast toast = Toast.makeText(MainActivity.this, "nçk", LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }


}