package com.abc.app.memberapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2017 on 2016-07-27.
 */
public class MemberDAO extends SQLiteOpenHelper {
    public static final String TABLE_NAME ="member";
    public static final String ID ="id";
    public static final String PW ="pw";
    public static final String NAME ="name";
    public static final String SSN ="ssn";
    public static final String EMAIL ="email";
    public static final String PHONE ="phone";
    public static final String PROFILE ="profile";

    public MemberDAO(Context context){

        super(context, "hanbitdb", null, 1);
        Log.d("DB 생성 체크","======================여기가지 집입");
        this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
       String sql= "create table if not exists "
               +TABLE_NAME
               +" ("
               +ID+" text primary key,"
               +PW+" text,"
               +NAME+" text,"
               +SSN+" text,"
               +PROFILE+" text,"
               +EMAIL+" text,"
               +PHONE+" text);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql ="drop table if exist"+TABLE_NAME;
        db.execSQL(sql);
    }






    public int insert(MemberBean mem) {
        int result = 0;
        String sql = "insert into "+TABLE_NAME
                +String.format("(%s,%s,%s,%s,%s,%s,%s) ",ID,PW,NAME,SSN,EMAIL,PROFILE,PHONE)
                +String.format(" values('%s','%s','%s','%s','%s','%s','%s');"
                ,mem.getId()
                ,mem.getPw()
                ,mem.getName()
                ,mem.getSsn()
                ,mem.getEmail()
                ,mem.getProfile()
                ,mem.getPhone()
        );
    SQLiteDatabase db =this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }

    public int update(MemberBean mem) {
        int result =0;
        String sql = "update member set pw = ?, email = ? where id = ?;";
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL(sql);
return result;
    }

    public void delete(MemberBean mem) {
        String sql = "delete from member where id = ? and pw = ?;";


    }


    public List<?> list() {
        String sql = "select * from member;";
        List<MemberBean> list = new ArrayList<MemberBean>();
    SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        return list;
    }

    public MemberBean findById(String pk) {
        String sql = "select * from member where id = ?;";
        MemberBean temp = null;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        return temp;
    }


    public List<?> findByName(String name) {
        String sql = "select * from member where name = ?;";
        List<MemberBean> list2 = new ArrayList<MemberBean>();
SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        return list2;
    }

    public int count() {
        int count = 0;
        String sql = "select count(*) as count from member;";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);

        return count;
    }

    public boolean login(MemberBean param) {
        boolean loginOk= false;
        String sql="select pw from member where id ='hong';";
        if(param.getId()!=null
                && param.getPw()!=null
                && this.existId(param.getId())){
            MemberBean member = this.findById(param.getId());
            if(member.getPw().equals(param.getPw())){
                loginOk = true;
            }
        }
        SQLiteDatabase db=this.getReadableDatabase();

        System.out.println("LOGIN_OK ?"+loginOk);
        return loginOk;
    }
    public boolean existId(String id){
        boolean existOK = false;
        String sql = "select count(*) as count from member where id = ?;";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        int result = 0;

        if(result == 1){
            existOK = true;
        }
        return existOK;
    }



}