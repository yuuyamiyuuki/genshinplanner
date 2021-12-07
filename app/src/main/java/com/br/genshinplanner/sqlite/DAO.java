package com.br.genshinplanner.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.br.genshinplanner.EventEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DAO extends SQLiteOpenHelper {

    public DAO(@Nullable Context context) {
        super(context, "apkDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE EVENT (ID INTEGER PRIMARY KEY AUTOINCREMENT, date DATE, time DATE, resinSpent INTEGER, domain TEXT)");
        db.execSQL("CREATE TABLE USER (ID INTEGER PRIMARY KEY AUTOINCREMENT, firstTime INTEGER)");
        ContentValues cv = new ContentValues();
        cv.put("firstTime", 1);
        db.insert("USER", null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldV, int newV) {

    }

    public void updateUser(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("firstTime", 0);
        db.update("USER", cv, "ID = ?", new String[]{"1"});
    }

    public boolean getUserFirstTime(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] params = new String[]{"1"};
        Cursor cursor = db.rawQuery( "SELECT * FROM USER WHERE ID = ?",params);
        if (cursor.moveToFirst()) {
            return Integer.parseInt(cursor.getString(1)) == 1;
        }
        else{
            return false;
        }
    }

    public EventEntity addOne(EventEntity model){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        if(Objects.nonNull(model.getDate())) {
            cv.put("date", model.getDate().toString());
        }
        if(Objects.nonNull(model.getTime())) {
            cv.put("time", model.getTime().toString());
        }
        cv.put("resinSpent", model.getResinSpent());
        cv.put("domain", model.getDomain());
        Long id = db.insert("EVENT", null, cv);
        return this.getOne(id.intValue());
    }

    public List<EventEntity> getAllByDate(LocalDate date){
        List<EventEntity> entries = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] params = new String[]{ date.toString() };
        Cursor cursor = db.rawQuery( "SELECT * FROM EVENT WHERE date = ?",params);
        if (cursor.moveToFirst()) {
            do {
                EventEntity entry = new EventEntity();
                entry.setId(cursor.getInt(0));
                if(Objects.nonNull(cursor.getString(1))) {
                    entry.setDate(LocalDate.parse(cursor.getString(1)));
                }
                if(Objects.nonNull(cursor.getString(2))) {
                    entry.setTime(LocalTime.parse(cursor.getString(2)));
                }
                entry.setResinSpent(cursor.getInt(3));
                entry.setDomain(cursor.getString(4));
                entries.add(entry);

            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return entries;
    }

    public void deleteOne(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("EVENT", "ID=?", new String[] { String.valueOf(id) });
    }

    public EventEntity getOne(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] params = new String[]{ id.toString() };
        Cursor cursor = db.rawQuery( "SELECT * FROM EVENT WHERE ID = ?",params);
        EventEntity entry = new EventEntity();
        try {
            if (cursor.moveToFirst()) {
                entry.setId(cursor.getInt(0));
                if(Objects.nonNull(cursor.getString(1))) {
                    entry.setDate(LocalDate.parse(cursor.getString(1)));
                }
                if(Objects.nonNull(cursor.getString(2))) {
                    entry.setTime(LocalTime.parse(cursor.getString(2)));
                }
                entry.setResinSpent(cursor.getInt(3));
                entry.setDomain(cursor.getString(4));
            }
        } finally {
            cursor.close();
        }
        return entry;
    }
}
