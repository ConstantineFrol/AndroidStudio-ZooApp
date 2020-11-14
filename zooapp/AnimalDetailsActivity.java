package com.gproject.zooapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.gproject.zooapp.model.Animal;

public class AnimalDetailsActivity extends AppCompatActivity {

    ImageView img_animal;
    TextView nameAnimal, descAnimal, detailsAnimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        img_animal = findViewById(R.id.animal_img);
        nameAnimal = findViewById(R.id.animalName);
        detailsAnimal = findViewById(R.id.details_info);
        Animal item = (Animal) getIntent().getExtras().getSerializable("animalObj");
        Toast.makeText(this, "You pressed on " + item.getTitle(), Toast.LENGTH_SHORT).show();

        loadAnimalData(item);

    }

    private void loadAnimalData(Animal item) {
        Glide.with(this).load(item.getDrawableResource()).into(img_animal);
        nameAnimal.setText(item.getTitle());
        detailsAnimal.setText(item.getDetails());
    }
}