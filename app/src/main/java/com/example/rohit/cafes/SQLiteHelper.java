package com.example.rohit.cafes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class SQLiteHelper extends SQLiteOpenHelper {
 private static final int DATABASE_VERSION = 1;
 private static final String DATABASE_NAME = "cafes.db";
 private static final String TABLE_NAME = "user";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_Email ="email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_USERNAME = "username";

    SQLiteDatabase db;

    private static final String TABLE_CREATE = "Create table user (name text not null, email text primary key not null , password text not null, username text not null)";

    public SQLiteHelper (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;

    }

    public boolean insert(String email,String password, String name, String username){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_Email, email);
        values.put(COLUMN_PASSWORD,password);
        values.put(COLUMN_USERNAME,username);

        long ins = db.insert(TABLE_NAME , null,values);
        if (ins ==-1) return false;
        else return true;
    }


    public boolean checkusername(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where username =?", new String[]{username});
        if (cursor.getCount()>0) return false;
        else return true;}

        public Boolean checkuserPass(String username,String password){
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("Select * from user where username =? and password=?", new String[]{username,password});
            if (cursor.getCount()>0) return true;
            else return false;
        }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS user";
        db.execSQL(query);
    }
 }
