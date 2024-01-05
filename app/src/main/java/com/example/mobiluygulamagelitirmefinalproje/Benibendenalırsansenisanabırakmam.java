package com.example.mobiluygulamagelitirmefinalproje;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Benibendenalırsansenisanabırakmam extends SQLiteOpenHelper {
    public static final String DBNAME ="Lsogin.db";
    public static final String TABLE_NAME = "users";
    public Benibendenalırsansenisanabırakmam(Context context) {
        super(context, "Lsogin.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("Create Table users(username TEXT,password TEXT,open int)");
    }



    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
    }


    public Boolean insertdata(String username,String password,int open){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("open",open);

        long result=MyDB.insert("users",null,contentValues);
        if (result==-1) return false;
        else return true;
    }

    public boolean chechusername(String username){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("select * From users Where username=?",new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor opennesss(){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("select username From users Where open=1",new String[]{});
            return cursor;

    }
    public boolean chechusernameandpassword(String username,String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("select * From users Where username=? And password=?",new String[]{username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public boolean hazx(String username,int open){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("open",open);
        long result =db.update("users", cv,"username=?",new String[]{username});
        if (result==-1) return false;
        else return true;
    }




    }