package com.priyanshu.animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        TextView txtAnim = (TextView) findViewById(R.id.txtAnim);
        Animation move = AnimationUtils.loadAnimation(this, R.anim.move);
        Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);

        Button btnTranslate = (Button) findViewById(R.id.btnTranslate);
        Button btnRotate = (Button) findViewById(R.id.btnRotate);
        Button btnAlpha = (Button) findViewById(R.id.btnAlpha);
        Button btnScale = (Button) findViewById(R.id.btnScale);

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAnim.startAnimation(move);
            }
        });
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAnim.startAnimation(rotate);
            }
        });
        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAnim.startAnimation(alpha);
            }
        });
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAnim.startAnimation(scale);
            }
        });


    }
}