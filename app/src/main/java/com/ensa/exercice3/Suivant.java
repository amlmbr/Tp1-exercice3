package com.ensa.exercice3;

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



public class Suivant extends AppCompatActivity {
    private Button back;
    private TextView responsesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_suivant);

        back = findViewById(R.id.back);
        responsesTextView = findViewById(R.id.responses);



        String responses = getIntent().getStringExtra("responses");
        responsesTextView.setText(responses);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(Suivant.this, MainActivity.class);
            startActivity(intent);
            Suivant.this.finish();
        });
    }
}