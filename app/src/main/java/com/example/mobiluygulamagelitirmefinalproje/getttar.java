package com.example.mobiluygulamagelitirmefinalproje;

import android.app.Application;

public class getttar extends Application {
    public String UserName;
    public int time;

    public int puanartı;
    public int puaneksi;
    public int hak;
    public int rand;
    public int randmax;
    public int puan;
    public int doğrusorusays;


    public String GetUsername() {
        return UserName;
    }
    public void SetUserName(String _susername){
        UserName=_susername;
    }

    public int gettime() {
        return time;
    }
    public void settime(int timeees){
        time=timeees;
    }

    public int getartıpuan() {
        return puanartı;
    }
    public void setartıpuan(int garave){
        puanartı=garave;
    }

    public int getpuaneksi() {
        return puaneksi;
    }
    public void setpuaneksi(int yooook){
        puaneksi=yooook;
    }

    public int gethak() {
        return hak;
    }
    public void sethak(int waxrac){
        hak=waxrac;
    }

    public int getrandom() {
        return rand;
    }
    public void setrandom(int raxtac){
        rand=raxtac;
    }

    public int getrandomax() {
        return randmax;
    }
    public void setrandomax(int xxxxxx){
        randmax=xxxxxx;
    }

    public int getpuan(){
        return puan;
    }
    public void setpuan(int xaxaxax){
        puan=xaxaxax;
    }

    public int getdoğrusorusays(){
        return doğrusorusays;
    }
    public void setdoğrusorusays(int fnl){
        doğrusorusays=fnl;
    }
}
