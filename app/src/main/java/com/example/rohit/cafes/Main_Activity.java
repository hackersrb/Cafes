package com.example.rohit.cafes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Main_Activity extends AppCompatActivity {
    SQLiteHelper db = new SQLiteHelper(this);
    Button b1,b2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText name = (EditText)findViewById(R.id.SName);
        final EditText username = (EditText)findViewById(R.id.Suname);
        final EditText age = (EditText)findViewById(R.id.SAge);
        final EditText gender = (EditText)findViewById(R.id.SGender);
        final EditText email = (EditText)findViewById(R.id.SEmail);
        final EditText password = (EditText)findViewById(R.id.SPassword);
        b1=(Button)findViewById(R.id.buttonsignup);
        b2=(Button)findViewById(R.id.Sloginbutton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main_Activity.this,login_activity.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namestring = name.getText().toString();
                String usernamestring = username.getText().toString();
                String agestring = age.getText().toString();
                String genderstring = gender.getText().toString();
                String emailstring = email.getText().toString();
                String passwordstring =password.getText().toString();

                if (namestring.equals("")||agestring.equals("")||genderstring.equals("")||emailstring.equals("")||passwordstring.equals("")){
                    Toast pass = Toast.makeText(getApplicationContext()," Fields are empty - please fill all the fields ",Toast.LENGTH_SHORT);
                    pass.show();
                }else {
                    Boolean checkemail = db.checkusername(usernamestring);
                    if (checkemail==true){
                        Boolean insert= db.insert(emailstring,passwordstring,namestring,usernamestring);
                        if (insert==true){
                            Toast pass = Toast.makeText(getApplicationContext()," Registered Successfully - thank you ",Toast.LENGTH_SHORT);
                            pass.show();
                        }
                    }else {
                        Toast pass = Toast.makeText(getApplicationContext()," Username Already Exists ",Toast.LENGTH_SHORT);
                        pass.show();
                    }
                }
            }
        });

    }
    }

