package com.iset.compteurfruits;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton rbPomme, rbPoire;
    TextView tvPomme, tvPoire;
    Button boutonCompter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbPomme = findViewById(R.id.rPomme);
        rbPoire = findViewById(R.id.rPoire);
        tvPomme = findViewById(R.id.tvPommes);
        tvPoire = findViewById(R.id.tvPoires);
        boutonCompter = findViewById(R.id.bCompter);

        boutonCompter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compter(v);
            }
        });
    }


    public void compter(View v) {
        if (rbPomme.isChecked()) {
            int nbPomme = Integer.valueOf(tvPomme.getText().toString());
            tvPomme.setText(String.valueOf(nbPomme + 1));
        } else {
            int nbPoire = Integer.valueOf(tvPoire.getText().toString());
            tvPoire.setText(String.valueOf(nbPoire + 1));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Nb Pommes");
        menu.add(0, 2, 0, "Nb Poires");
        menu.add(0, 3, 0, "Quitter");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(this, tvPomme.getText(), Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, tvPoire.getText(), Toast.LENGTH_SHORT).show();
                break;
            case 3:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
