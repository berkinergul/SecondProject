package com.example.secondproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerLectures;
    private TextView txtCoffee,txtCaffeineRatio;
    private ImageView ImageViewCoffees;
    private RatingBar ratingBar;
    private Button buttonOrder;
    private SeekBar seekBarCaffeineRatio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerLectures = findViewById(R.id.spinnerCoffees);
        txtCoffee = findViewById(R.id.txtSelectedCoffe);
        txtCaffeineRatio = findViewById(R.id.txtCaffeineRatio);
        ratingBar = findViewById(R.id.ratingBar);
        buttonOrder = findViewById(R.id.btnOrder);
        seekBarCaffeineRatio = findViewById(R.id.seekBarCaffeineRatio);
        ImageViewCoffees = findViewById(R.id.ImageViewCoffee);


        ArrayAdapter adapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.arrayCoffee, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLectures.setAdapter(adapter);

        spinnerLectures.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] arrayCoffee = getResources().getStringArray(R.array.arrayCoffee);
                txtCoffee.setText("You have chosen " + arrayCoffee[position]);
                switch (arrayCoffee[position]){
                    case "Latte":
                        ImageViewCoffees.setImageResource(R.drawable.latte);
                        break;
                    case "Americano":
                        ImageViewCoffees.setImageResource(R.drawable.americano);
                        break;

                    case "Turkish Coffee":
                        ImageViewCoffees.setImageResource(R.drawable.turkish_coffee);
                        break;
                    case "Cold Brew":
                        ImageViewCoffees.setImageResource(R.drawable.cold_brew);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        seekBarCaffeineRatio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtCaffeineRatio.setText("Caffeine Ratio: %" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = String.valueOf(ratingBar.getRating());
                Toast.makeText(MainActivity.this,message + "star(s) given!",Toast.LENGTH_SHORT).show();

            }
        });


    }
}