package com.example.rohit.cafes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login_activity extends AppCompatActivity {
   Button b1;
   SQLiteHelper db = new SQLiteHelper(this);
   EditText Luser,Lpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_login);
       Luser = (EditText) findViewById(R.id.LUname);
       Lpassword = (EditText) findViewById(R.id.LPass);
        b1=(Button)findViewById(R.id.buttonLogin);
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String username = Luser.getText().toString();
               String password = Lpassword.getText().toString();
                Boolean check =db.checkuserPass(username,password);
               if (check==true){
                       Toast passw = Toast.makeText(getApplicationContext()," Welcome - Successful login ",Toast.LENGTH_SHORT);
                       passw.show();
                   Intent intent=new Intent(login_activity.this,List_Activity.class);
                   intent.putExtra("USERNAME","Hi, "+ username);
                   startActivity(intent);
               }else {
                   Toast passs = Toast.makeText(getApplicationContext()," Wrong Email or password ",Toast.LENGTH_SHORT);
                   passs.show();
           }
       }});}}

