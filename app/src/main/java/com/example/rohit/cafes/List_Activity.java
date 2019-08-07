package com.example.rohit.cafes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class List_Activity extends Activity {
    TextView b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String username = getIntent().getStringExtra("USERNAME");

        b2=(TextView) findViewById(R.id.LogOut);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(List_Activity.this,login_activity.class);
                Toast passw = Toast.makeText(getApplicationContext()," LogOut Successful  - Thank you ",Toast.LENGTH_SHORT);
                passw.show();
                startActivity(intent);
            }
        });

        final TextView textViewToChange = (TextView) findViewById(R.id.username);
        textViewToChange.setText(username);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> listview, View V, int position, long id) {
                if (position==0){
                    Intent intent = new Intent(List_Activity.this,Edmonds_Activity.class);
                    startActivity(intent);
                }
                else if (position==1){
                    Intent intent = new Intent(List_Activity.this,Charlie_Activity.class);
                    startActivity(intent);
                }
                else if (position==2){
                    Intent intent = new Intent(List_Activity.this,CommonGround_activity.class);
                    startActivity(intent);
                }
                else if (position==3){
                    Intent intent = new Intent(List_Activity.this,Gram_Activity.class);
                    startActivity(intent);
                }
                else if (position==4){
                    Intent intent = new Intent(List_Activity.this,ShedCafe_Activity.class);
                    startActivity(intent);
                }
                else if (position==5){
                    Intent intent = new Intent(List_Activity.this,EatzBridge_Activity.class);
                    startActivity(intent);
                }
                }
            };
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);

    }
}

