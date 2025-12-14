package com.priyanshu.listexamples;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Spinner spinner;
AutoCompleteTextView autoView;
Button button;
//int[] arrNo = new int[]{1,2,3,4,5};
ArrayList<String> arrIds = new ArrayList<>();
ArrayList<String> arrLang = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner = findViewById(R.id.spinner);
        arrIds.add("Aadhaar Card");
        arrIds.add("PAN Card");
        arrIds.add("Driving License");
        arrIds.add("Birth Certificate");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,arrIds);
        spinner.setAdapter(spinnerAdapter);

        autoView = findViewById(R.id.autoView);
        arrLang.add("C");
        arrLang.add("C++");
        arrLang.add("PHP");
        arrLang.add("MySQL");
        arrLang.add("Oracle SQL");
        arrLang.add("Python");
        arrLang.add("Java");
        arrLang.add("HTML");
        arrLang.add("JavaScript");

        ArrayAdapter<String> autoAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,arrLang);
        autoView.setAdapter(autoAdapter);
        autoView.setThreshold(2);

        Intent iNext = new Intent(getApplicationContext(), MainActivity2.class);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iNext);
            }
        });

    }
}