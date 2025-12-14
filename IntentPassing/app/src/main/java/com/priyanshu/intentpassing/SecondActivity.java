package com.priyanshu.intentpassing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnNext;
        btnNext = findViewById(R.id.btnNext);
        Intent iBack;
        iBack = new Intent(getApplicationContext(), MainActivity.class);

        Intent fromAct = getIntent();
        String name = fromAct.getStringExtra("Name");
        int num = fromAct.getIntExtra("Rollno",2611);
        String title = fromAct.getStringExtra("Title");

        getSupportActionBar().setTitle(title);

        TextView txtStudentName;
        txtStudentName = findViewById(R.id.txtStudentName);
        txtStudentName.setText("Roll no: "+num+"\nName:"+name);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iBack);
            }
        });
    }
}