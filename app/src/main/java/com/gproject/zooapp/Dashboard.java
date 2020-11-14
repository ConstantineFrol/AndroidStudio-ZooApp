package com.gproject.zooapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gproject.zooapp.model.Animal;
import com.gproject.zooapp.recyclerview.AnimalAdapter;
import com.gproject.zooapp.recyclerview.AnimalCallback;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity implements AnimalCallback {

    private RecyclerView recV_animals;
    private AnimalAdapter animal_adapter;
    private List<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initViews();
        initDataAnimals();
        setupAnimalAdapter();
    }

    private void setupAnimalAdapter() {
        animal_adapter = new AnimalAdapter(animals, this);
        recV_animals.setAdapter(animal_adapter);
    }

    private void initDataAnimals() {

        animals = new ArrayList<>();

        Animal ard = new Animal();
        ard.setDrawableResource(R.drawable.img_1);
        ard.setTitle(this.getResources().getString(R.string.animal_Ard_title));
        ard.setDescription(this.getResources().getString(R.string.animal_Ard_type));
        ard.setDetails(this.getResources().getString(R.string.animal_Ard_des));
        animals.add(ard);

        Animal buf = new Animal();
        buf.setDrawableResource(R.drawable.img_2);
        buf.setTitle(this.getResources().getString(R.string.animal_Buf_title));
        buf.setDescription(this.getResources().getString(R.string.animal_Buf_type));
        buf.setDetails(this.getResources().getString(R.string.animal_Buf_des));
        animals.add(buf);

        Animal tig = new Animal();
        tig.setDrawableResource(R.drawable.img_3);
        tig.setTitle(this.getResources().getString(R.string.animal_Tig_title));
        tig.setDescription(this.getResources().getString(R.string.animal_Tig_type));
        tig.setDetails(this.getResources().getString(R.string.animal_Tig_des));
        animals.add(tig);

        Animal mon = new Animal();
        mon.setDrawableResource(R.drawable.img_4);
        mon.setTitle(this.getResources().getString(R.string.animal_Mon_title));
        mon.setDescription(this.getResources().getString(R.string.animal_Mon_type));
        mon.setDetails(this.getResources().getString(R.string.animal_Mon_des));
        animals.add(mon);

        Animal jag = new Animal();
        jag.setDrawableResource(R.drawable.img_5);
        jag.setTitle(this.getResources().getString(R.string.animal_Jag_title));
        jag.setDescription(this.getResources().getString(R.string.animal_Jag_type));
        jag.setDetails(this.getResources().getString(R.string.animal_Jag_des));
        animals.add(jag);

        Animal cro = new Animal();
        cro.setDrawableResource(R.drawable.img_6);
        cro.setTitle(this.getResources().getString(R.string.animal_Cro_title));
        cro.setDescription(this.getResources().getString(R.string.animal_Cro_type));
        cro.setDetails(this.getResources().getString(R.string.animal_Cro_des));
        animals.add(cro);

        Animal pan = new Animal();
        pan.setDrawableResource(R.drawable.img_7);
        pan.setTitle(this.getResources().getString(R.string.animal_Pan_title));
        pan.setDescription(this.getResources().getString(R.string.animal_Pan_type));
        pan.setDetails(this.getResources().getString(R.string.animal_Pan_des));
        animals.add(pan);

        Animal sna = new Animal();
        sna.setDrawableResource(R.drawable.img_8);
        sna.setTitle(this.getResources().getString(R.string.animal_Snail_title));
        sna.setDescription(this.getResources().getString(R.string.animal_Snail_type));
        sna.setDetails(this.getResources().getString(R.string.animal_Snail_des));
        animals.add(sna);

        Animal ele = new Animal();
        ele.setDrawableResource(R.drawable.img_9);
        ele.setTitle(this.getResources().getString(R.string.animal_Ele_title));
        ele.setDescription(this.getResources().getString(R.string.animal_Ele_type));
        ele.setDetails(this.getResources().getString(R.string.animal_Ele_des));
        animals.add(ele);

        Animal ber = new Animal();
        ber.setDrawableResource(R.drawable.img_10);
        ber.setTitle(this.getResources().getString(R.string.animal_Bear_title));
        ber.setDescription(this.getResources().getString(R.string.animal_Bear_type));
        ber.setDetails(this.getResources().getString(R.string.animal_Bear_des));
        animals.add(ber);
    }

    private void initViews() {
        recV_animals = findViewById(R.id.rv_animals);
        recV_animals.setLayoutManager(new LinearLayoutManager(this));
        recV_animals.setHasFixedSize(true);

    }

    @Override
    public void onAnimalItemClick(
            int pos,
            ImageView container,
            ImageView imgAnimal,
            TextView title,
            TextView animDes,
            TextView details) {

        Intent intent = new Intent(this, AnimalDetailsActivity.class);
        intent.putExtra("animalObj", animals.get(pos));
        Pair<View, String> p1 = Pair.create((View)container, "containerTN");
        Pair<View, String> p2 = Pair.create((View)imgAnimal, "animalTN");
        Pair<View, String> p3 = Pair.create((View)title, "animal_titleTN");
        Pair<View, String> p4 = Pair.create((View)animDes, "animalTN");
        Pair<View, String> p5 = Pair.create((View)details, "animal_detailsTN");





        ActivityOptionsCompat optionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1, p2, p3, p4, p5);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent, optionsCompat.toBundle());
        }else{
            startActivity(intent);
        }

    }
}