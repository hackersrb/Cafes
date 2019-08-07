package com.example.rohit.cafes;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class CommonGround_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_ground);
    }

    public void directionCommon(View view) {
        Intent intent=null, chooser=null;
        if(view.getId()==R.id.buttonCommon){
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:-33.966191,151.103741?z=10&q=Common cafe and kitchen hurstville"));
            Intent.createChooser(intent,"Common Ground cafe and Kitchen");
            startActivity(intent);
        }
    }
    private boolean favourite = true;
    public void commonfav(View view) {
        ImageView button = (ImageView) view;
        int icon;

        if (favourite) {
            favourite = false;
            icon = R.drawable.ic_favorite_black_24dp;
            Toast.makeText(getApplicationContext(), "Common Ground cafe and Kitchen has been added to your Favourite list", Toast.LENGTH_SHORT).show();

        } else {

            favourite = true;
            icon = R.drawable.ic_favorite_border_black_24dp;
            Toast.makeText(getApplicationContext(), "Common Ground cafe and Kitchen has been removed from your Favourite list", Toast.LENGTH_SHORT).show();
        }
        button.setImageDrawable(
                ContextCompat.getDrawable(getApplicationContext(), icon));


    }}

