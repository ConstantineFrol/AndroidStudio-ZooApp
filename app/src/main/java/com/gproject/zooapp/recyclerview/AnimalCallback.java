package com.gproject.zooapp.recyclerview;

import android.widget.ImageView;
import android.widget.TextView;

/*************
 * Interface *
 *************/

public interface AnimalCallback {

    void onAnimalItemClick
            (
                    int pos,
                    ImageView container,
                    ImageView imgAnimal,
                    TextView title,
                    TextView animDes,
                    TextView details
            );
}
