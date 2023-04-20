package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    // create array of Strings and store name of cars
    String[] cars = { "Dodge Viper", "Fancy Volkswagon Van",
            "Ma Mystery Machine", "Mercedes G Wagon 550",
            "Rolls Royce Phantom" };
    List<String> carList = new ArrayList<>(Arrays.asList(cars));
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Take the instance of Spinner and
        // apply OnItemSelectedListener on it which
        // tells which item of spinner is clicked
        Spinner spinr = findViewById(R.id.carspinner);
        spinr.setOnItemSelectedListener(this);

        Collections.sort(carList);
        carList.add(0, "Car City!");
        // Initializing ArrayAdapter as anonymous class
        ArrayAdapter<String> spinnerAd = new ArrayAdapter<String>(
                this, R.layout.spinner_item, carList) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView,
                        parent);
                TextView tv = (TextView) view;
                if (position % 2 == 1) {
                    // Set the item background color
                    tv.setBackgroundColor(Color.parseColor("#FFC9A3FF"));
                } else {
                    // Set the alternate item background color
                    tv.setBackgroundColor(Color.parseColor("#FFAF89E5"));
                }
                return view;
            }
        };

        // set simple layout resource file for each spinner item
        spinnerAd.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data to bind data to Spinner 
        spinr.setAdapter(spinnerAd);
    }

    // Performing action when ItemSelected from spinner, Overriding onItemSelected method

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int
            position, long id) {


        if(position != 0) {
        /*    // make toast show which is selected in spinner
            Toast.makeText(getApplicationContext(),
                            carList.get(position),
                            Toast.LENGTH_LONG)
                    .show();*/

            // Starts Intent for DetailsActivity
            Intent i = new Intent(this, DetailsActivity.class);
            String keyIdentifier = String.valueOf(position);
            i.putExtra("carValue", keyIdentifier);
            startActivity(i);
            System.out.println("TEST");
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {  }
}
