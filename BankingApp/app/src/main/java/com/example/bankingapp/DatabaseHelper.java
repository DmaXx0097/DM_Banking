package com.example.bankingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private String TABLE_NAME = "customer_table";
    private String TABLE_NAME1 = "transaction_table";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into customer_table values(6548795213,'Sheety',6572.00,'sheety.07@gmail.com','XXXXXXXXXXXX5534','MMS96586742')");
        db.execSQL("insert into customer_table values(8796542135,'Anurag',8822.67,'anu08mr@gmail.com','XXXXXXXXXXXX1124','CBI87541269')");
        db.execSQL("insert into customer_table values(9865487852,'Binod',5640,'bin0d@gmail.com','XXXXXXXXXXXX2546','HDF63963548')");
        db.execSQL("insert into customer_table values(6254879653,'Kamal',8801,'k99mal@gmail.com','XXXXXXXXXXXX3565','BOA21154236')");
        db.execSQL("insert into customer_table values(5487216598,'Lui',7541.25,'luisdes@gmail.com','XXXXXXXXXXXX4875','PUI96587412')");
        db.execSQL("insert into customer_table values(8889785462,'Sanjana',973.95,'angelsan.03@gmail.com','XXXXXXXXXXXX9641','HDF54712658')");
        db.execSQL("insert into customer_table values(7548965987,'Dheeraj',8456,'dhirj44@gmail.com','XXXXXXXXXXXX4587','SBT96587452')");
        db.execSQL("insert into customer_table values(9985478213,'Jacob',8546.2,'cobJ.25@gmail.com','XXXXXXXXXXXX1679','PUI65342987')");
        db.execSQL("insert into customer_table values(8564525836,'Luis',2000,'luis03.03@gmail.com','XXXXXXXXXXXX7725','BOA76500791')");
        db.execSQL("insert into customer_table values(2015487865,'Tanaka',624.2,'tanaka@gmail.com','XXXXXXXXXXXX4579','SBT67980092')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from customer_table", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from customer_table where phonenumber = " + phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from customer_table except select * from customer_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update customer_table set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readtransferdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from transaction_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}
