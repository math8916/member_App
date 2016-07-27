package com.abc.app.memberapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2017 on 2016-07-27.
 */
public class MemberDAO extends SQLiteOpenHelper {

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public MemberDAO(Context context){
        super(context, "", null, 1);
    }





    public int insert(MemberBean mem) {
        int result = 0;
        String sql = "insert into member(id,pw,name,reg,ssn,email,profile_img, phone) "
                + "values(?,?,?,?,?,?,?,?)";

        return result;
    }

    public void update(MemberBean mem) {
        String sql = "update member set pw = ?, email = ? where id = ?";

    }

    public void delete(MemberBean mem) {
        String sql = "delete from member where id = ? and pw = ?";


    }


    public List<?> list() {
        String sql = "select * from member";
        List<MemberBean> list = new ArrayList<MemberBean>();

        return list;
    }

    public MemberBean findById(String pk) {
        String sql = "select * from member where id = ?";
        MemberBean temp = null;

        return temp;
    }


    public List<?> findByName(String name) {
        String sql = "select * from member where name = ?";
        List<MemberBean> list2 = new ArrayList<MemberBean>();

        return list2;
    }

    public int count() {
        int count = 0;
        String sql = "select count(*) as count from member";

        return count;
    }

    public boolean login(MemberBean param) {
        boolean loginOk= false;
        if(param.getId()!=null
                && param.getPw()!=null
                && this.existId(param.getId())){
            MemberBean member = this.findById(param.getId());
            if(member.getPw().equals(param.getPw())){
                loginOk = true;
            }
        }
        System.out.println("LOGIN_OK ?"+loginOk);
        return loginOk;
    }
    public boolean existId(String id){
        boolean existOK = false;
        String sql = "select count(*) as count from member where id = ?";
        int result = 0;

        if(result == 1){
            existOK = true;
        }
        return existOK;
    }


}