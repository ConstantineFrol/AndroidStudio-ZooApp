package com.gproject.zooapp.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.gproject.zooapp.R;
import com.gproject.zooapp.model.Animal;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.animalviewholder> {

    // Create list of animalsObj
    private List<Animal> mdata;
    private AnimalCallback callback; //initialize interface class

    public AnimalAdapter(List<Animal> mdata, AnimalCallback callback) {
        this.mdata = mdata;
        this.callback = callback;
    }

    @NonNull
    @Override
    public animalviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.animal_board, parent, false);
        return new animalviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull animalviewholder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(mdata.get(position).getDrawableResource())
                .transforms(new CenterCrop(), new RoundedCorners(8))
                .into(holder.imgAnimal);
        mdata.get(position).getDetails().equals("");
        holder.bindAnimal(mdata.get(position));
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }



    public class animalviewholder extends RecyclerView.ViewHolder {

        ImageView imgAnimal, container;
        TextView title, description, details;

        public animalviewholder(@NonNull View itemView) {
            super(itemView);
            imgAnimal = itemView.findViewById(R.id.animal_img);
            container = itemView.findViewById(R.id.container);
            title = itemView.findViewById(R.id.animalName);
            description = itemView.findViewById(R.id.animal_des);
            details = itemView.findViewById(R.id.animal_details);

            itemView.setOnClickListener(v ->
                    callback.onAnimalItemClick(getAdapterPosition(),
                            container,
                            imgAnimal,
                            title,
                            description,
                            details)
            );
        }

        void bindAnimal(final Animal animal){
            imgAnimal.setImageResource(animal.getDrawableResource());
            container.setBackgroundResource(R.color.light_medium_green);
            title.setText(animal.getTitle());
            description.setText(animal.getDescription());
            details.setText("");

        }
    }
}
