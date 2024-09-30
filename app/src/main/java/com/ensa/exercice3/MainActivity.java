package com.ensa.exercice3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {
    private Button Suivant, Quitter;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    private RadioGroup radioGroup;
    private RadioButton radioButtonOui, radioButtonNon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Suivant = findViewById(R.id.suivant);
        Quitter = findViewById(R.id.quiter);

        checkBox1 = findViewById(R.id.un);
        checkBox2 = findViewById(R.id.deux);
        checkBox3 = findViewById(R.id.trois);
        checkBox4 = findViewById(R.id.quatre);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonOui = findViewById(R.id.oui);
        radioButtonNon = findViewById(R.id.nom);

        Quitter.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Quitter.class);
            startActivity(intent);
            MainActivity.this.finish();
        });

        Suivant.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, Suivant.class);


            StringBuilder responses = new StringBuilder("Réponses: \n");
            if (checkBox1.isChecked()) responses.append("- ").append(checkBox1.getText().toString()).append("\n");
            if (checkBox2.isChecked()) responses.append("- ").append(checkBox2.getText().toString()).append("\n");
            if (checkBox3.isChecked()) responses.append("- ").append(checkBox3.getText().toString()).append("\n");
            if (checkBox4.isChecked()) responses.append("- ").append(checkBox4.getText().toString()).append("\n");


            int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
            if (selectedRadioButtonId == radioButtonOui.getId()) {
                responses.append("\nQuestion 2: ").append(radioButtonOui.getText().toString());
            } else if (selectedRadioButtonId == radioButtonNon.getId()) {
                responses.append("\nQuestion 2: ").append(radioButtonNon.getText().toString());
            }

            
            intent.putExtra("responses", responses.toString());
            startActivity(intent);
            MainActivity.this.finish();
        });
    }
}