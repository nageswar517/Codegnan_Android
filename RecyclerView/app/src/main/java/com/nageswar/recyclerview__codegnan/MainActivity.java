package com.nageswar.recyclerview__codegnan;

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
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        recyclerView = findViewById(R.id.recyclerview);
        RvAdapter rva = new RvAdapter(this);
        recyclerView.setAdapter(rva);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void initData() {
        images = new int[]{R.drawable.avengers,R.drawable.bossbaby,R.drawable.gabbarsingh,R.drawable.infinitywar,
        R.drawable.interstellar,R.drawable.ironman,R.drawable.kungfupanda,R.drawable.kungfupanda3,R.drawable.lionking,R.drawable.endgame};

        movies = new String[]{"Avengers","Boss Baby","Gabbarsingh","Infinity War","Interstellar","Ironman","Kungfu Panda","Kungfu Panda 3","Lion King","Endgame"};
        actors = new String[]{"Captain America","Baby","PavanKalyan","Spider Man","Cooper","Iron Man","Panda","Panda","Lion","Dr Strange"};
    }

    class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder> {

        Context context;

        public RvAdapter(Context context) {
            this.context = context;
        }

        //this method will attach laout to all entries in recycler view
        @NonNull
        @Override
        public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(context).inflate(R.layout.one_row_design,parent,false);
            return new RvViewHolder(v);
        }

        //this method will populate the data in the right place
        @Override
        public void onBindViewHolder(@NonNull RvViewHolder holder, int position) {
            holder.poster.setImageResource(images[position]);
            holder.mn.setText(movies[position]);
            holder.an.setText(actors[position]);
        }

        //return the total number of recycler view elements
        @Override
        public int getItemCount() {
            return images.length;
        }

        public class RvViewHolder extends RecyclerView.ViewHolder {
            TextView mn,an;
            ImageView poster;
            public RvViewHolder(@NonNull View itemView) {
                super(itemView);
                mn = itemView.findViewById(R.id.movie_name);
                an = itemView.findViewById(R.id.actor);
                poster = itemView.findViewById(R.id.movie_posters);
            }
        }
    }
}