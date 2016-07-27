package com.abc.app.memberapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends Activity implements View.OnClickListener {
    EditText bt_id,bt_pw,bt_name,bt_ssn,bt_phone,bt_email;
    Button bt_regist,bt_reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    bt_id= (EditText) findViewById(R.id.bt_id);
    bt_pw= (EditText) findViewById(R.id.bt_pw);
        bt_name= (EditText) findViewById(R.id.bt_name);
        bt_ssn= (EditText) findViewById(R.id.bt_ssn);
        bt_phone= (EditText) findViewById(R.id.bt_phone);
        bt_email= (EditText) findViewById(R.id.bt_email);
        bt_regist= (Button) findViewById(R.id.bt_regist);
        bt_reset= (Button) findViewById(R.id.bt_reset);
        bt_regist.setOnClickListener(this);
        bt_regist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.bt_regist:
            Toast.makeText(Main2Activity.this,"id:"+bt_id.getText().toString()
            +"pw:"+bt_pw.getText().toString()
            +"name"+bt_name.getText().toString()
            +"ssn:"+bt_ssn.getText().toString()
            +"phone:"+bt_phone.getText().toString()
            +"email:"+bt_email.getText().toString(),Toast.LENGTH_LONG).show();
            break;
        case R.id.bt_reset:
            startActivity(new Intent(this,MainActivity.class));
            break;
    }
    }
}
