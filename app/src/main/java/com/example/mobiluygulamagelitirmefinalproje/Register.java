package com.example.mobiluygulamagelitirmefinalproje;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Button button,button2;
    TextView textView;
    EditText editTextText,editTextText2,editTextText3;
    Benibendenalırsansenisanabırakmam data_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button=(Button) findViewById(R.id.button);
        editTextText=(EditText) findViewById(R.id.editTextText);
        editTextText2=(EditText) findViewById(R.id.editTextText2);
        editTextText3=(EditText) findViewById(R.id.editTextText3);
        textView=(TextView) findViewById(R.id.textView);
        button2=(Button) findViewById(R.id.button2);
        data_base = new Benibendenalırsansenisanabırakmam(this);
        final getttar waxman=(getttar) getApplicationContext();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation buttonClick = new AlphaAnimation(0.4F, 0.2F);
                v.startAnimation(buttonClick);
                String wiredname = editTextText3.getText().toString();
                String wiredpass = editTextText2.getText().toString();
                String wiredpass2 = editTextText.getText().toString();

                if (wiredname.equals("")||wiredpass.equals("")||wiredpass2.equals(""))
                    Toast.makeText(Register.this, "Veriables cant be empty", Toast.LENGTH_LONG).show();
                else{
                    if(wiredpass.equals(wiredpass2)){
                        Boolean checkuser=data_base.chechusername(wiredname);
                        if(checkuser==false){
                            Boolean insert = data_base.insertdata(wiredname,wiredpass,0);
                            if(insert==true){
                                waxman.SetUserName(wiredname);
                                Intent intent = new Intent(getApplicationContext(), Anasayfa.class);
                                startActivity(intent);
                            }
                        }
                        else{
                            Toast.makeText(Register.this,"Name already exist", Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Toast.makeText(Register.this, "Şifreler uyuşmuyor*", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {//go to login
            @Override
            public void onClick(View v) {
                AlphaAnimation buttonClick = new AlphaAnimation(0.4F, 0.2F);
                v.startAnimation(buttonClick);
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}