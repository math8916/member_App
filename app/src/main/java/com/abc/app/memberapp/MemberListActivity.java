package com.abc.app.memberapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MemberListActivity extends Activity {
    ListView lv_member_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        ArrayList<MemberBean> list = this.getList();
        lv_member_list = (ListView) findViewById(R.id.lv_member_list);
        lv_member_list.setAdapter(new MemberAdapter(this, list));
        lv_member_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Object o = lv_member_list.getItemAtPosition(i);
                MemberBean mem = (MemberBean) o;
           //     Toast.makeText(MemberListActivity.this, "선택한 이름 ====" + o.toString(), Toast.LENGTH_LONG);
                Log.d("테스트",mem.getPhone());
           //     MemberBean member = (MemberBean) o;

            }
        });
    }

    public ArrayList<MemberBean> getList() {
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();

        String[] names = {
                "donut",
                "blur",
                "bright",
                "cupcake",
                "chrysanthemum",
                "eclair",
                "froyo",
                "gingerbread",
                "honeycomb"
        };
        int i = 0;
        while (i < names.length) {
            MemberBean member = new MemberBean();
            member.setName(names[i]);
            member.setPhone("010-5477-6715");
            list.add(member);
            i++;
        }
        return list;
    }
}

