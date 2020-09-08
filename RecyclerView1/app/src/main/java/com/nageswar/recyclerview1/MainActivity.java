package com.nageswar.recyclerview1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int[] images;
    private String[] movies,actors;
    private RecyclerView recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initData();
        recyclerview = findViewById(R.id.recyclerview);
        RvAdapter rva = new RvAdapter(this);
        recyclerview.setAdapter(rva);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        images = new int[]{R.drawable.avengers,R.drawable.bossbaby,R.drawable.endgame,R.drawable.gabbarsingh,R.drawable.infinitywar,
                R.drawable.interstellar,R.drawable.ironman,R.drawable.kungfupanda,R.drawable.kungfupanda3,R.drawable.lionking};
        movies = new String[]{"The Avengers","Boss Baby","Avengers : Endgame","Gabbarsingh","Avengers : Infinity War",
                "Interstellar","Iron Man","Kung Fu Panda","Kunng Fu Panda 3","The Lion King"};
        actors = new String[]{"Captain America","Baby","Dr Strange","Pavan Kalyan","Spider Man","Cooper","Iron Man","Panda","Panda","Lion"};
    }

    class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder>{

        public RvAdapter(Context context) {
            this.context = context;
        }

        Context context;

        @NonNull
        @Override
        public RvAdapter.RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(context).inflate(R.layout.design,parent,false);
            return new RvViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull RvAdapter.RvViewHolder holder, int position) {

            holder.poster.setImageResource(images[position]);
            holder.mn.setText(movies[position]);
            holder.an.setText(actors[position]);

        }

        @Override
        public int getItemCount() {
            return images.length;
        }

        public class RvViewHolder extends RecyclerView.ViewHolder {

            TextView mn,an;
            ImageView poster;

            public RvViewHolder(@NonNull View itemView) {
                super(itemView);
                mn = itemView.findViewById(R.id.name);
                an = itemView.findViewById(R.id.actor);
                poster = itemView.findViewById(R.id.posters);
            }
        }
    }
}