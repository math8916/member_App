package com.abc.app.memberapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends  Activity implements View.OnClickListener {
    EditText et_id,et_password;
    Button bt_login,bt_regist;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = new MemberServiceImpl(this.getApplicationContext());

        et_id = (EditText) findViewById(R.id.et_id);

        et_password= (EditText) findViewById(R.id.et_password);
        bt_login= (Button) findViewById(R.id.bt_login);
        bt_regist= (Button) findViewById(R.id.bt_regist);
        bt_login.setOnClickListener(this);
        bt_regist.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.bt_regist:
            startActivity(new Intent(this,Main2Activity.class ));


            break;
        case R.id.bt_login:
            Toast.makeText(MainActivity.this,"ID:"+et_id.getText().toString()
                    +"PW:"+et_password.getText().toString()
                    ,Toast.LENGTH_LONG).show();
            MemberBean member = new MemberBean();
            member.setId(et_id.getText().toString());
            member.setPw(et_password.getText().toString());
            if (service.login(member)) {
                startActivity(new Intent(this, HomeActivity.class));
            }else {
                startActivity(new Intent(this, MainActivity.class));
            }
                break;
    }
    }
}
