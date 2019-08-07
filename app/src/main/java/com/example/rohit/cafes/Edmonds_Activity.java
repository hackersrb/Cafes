package com.example.rohit.cafes;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class Edmonds_Activity extends AppCompatActivity {
    ImageView b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edmonds);
    }

    public void directionEdmonds(View view) {
        Intent intent=null, chooser=null;
        if(view.getId()==R.id.buttonedmonds){

            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:-33.979680,151.074439?z=10&q=edmonds and greer"));
            Intent.createChooser(intent,"Edmonds and Greer");
            startActivity(intent);
        }
    }
    private boolean favourite = true;
    public void buttonPressed(View view) {
            ImageView button = (ImageView) view;
            int icon;

            if (favourite) {
                favourite = false;
                icon = R.drawable.ic_favorite_black_24dp;
                Toast.makeText(getApplicationContext(), "Edmonds and Greer has been added to your Favourite list", Toast.LENGTH_SHORT).show();

            } else {

                favourite = true;
                icon = R.drawable.ic_favorite_border_black_24dp;
                Toast.makeText(getApplicationContext(), "Edmonds and Greer has been removed your Favourite list", Toast.LENGTH_SHORT).show();
                    }
            button.setImageDrawable(
                    ContextCompat.getDrawable(getApplicationContext(), icon));


        }
}
