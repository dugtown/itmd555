package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    String id = null; // class var for id
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView iv = findViewById(R.id.imageView);
        TextView tv = findViewById(R.id.textView);
        // grab or "receive" intent from MainActivity
        Intent i = getIntent();
        id = i.getStringExtra("carValue");
        if(id.equals("1")) {
            // names the drop down based on ID selected
            iv.setImageResource(R.drawable.dodgeviper);
            id = "Dodge Viper\n";
            id += "150 HP\n";
            tv.setText(id);
        }
        if(id.equals("2")) {
            // names the drop down based on ID selected
            iv.setImageResource(R.drawable.volkswagonvan);
            id = "60's Volkswagon Van\n";
            id += "250 HP\n";
            tv.setText(id);
        }
        if(id.equals("3")) {
            iv.setImageResource(R.drawable.mysterymachine);
            id = "Mystery Machine\n";
            id += "350 HP\n";
            tv.setText(id);
        }
        if(id.equals("4")) {
            // names the drop down based on ID selected
            iv.setImageResource(R.drawable.gwag);
            id = "Mercedes G Wagon 550\n";
            id += "450 HP\n";
            tv.setText(id);
        }
        if(id.equals("5")) {
            iv.setImageResource(R.drawable.phantom);
            id = "Rolls Royce Phantom\n";
            id += "550 HP\n";
            tv.setText(id);
        }



            // make toast show which is selected in spinner
/*            Toast.makeText(getApplicationContext(),
                            id,
                            Toast.LENGTH_LONG)
                    .show();*/

    }
}