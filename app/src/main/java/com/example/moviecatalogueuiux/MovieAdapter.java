package com.example.moviecatalogueuiux;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<Movie> listMovie;

    MovieAdapter(ArrayList<Movie> listHero) {
        this.listMovie = listHero;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        Movie movie = listMovie.get(position);
        Glide.with(viewHolder.itemView.getContext())
                .load(movie.getPhoto())
                .into(viewHolder.img_photo);

        viewHolder.tv_title.setText(movie.getTitle());
        viewHolder.tv_description.setText(movie.getDescription());
        viewHolder.tv_ratings.setText(movie.getRatings());
        viewHolder.tv_release.setText(movie.getReleaseDate());
        viewHolder.tv_running_time.setText(movie.getRunningTime());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewHolder.itemView.getContext(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.EXTRA, listMovie.get(position));
                viewHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title, tv_description, tv_release, tv_ratings, tv_running_time;
        private ImageView img_photo;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_name);
            tv_description = itemView.findViewById(R.id.tv_description);
            img_photo = itemView.findViewById(R.id.img_item_photo);
            tv_ratings = itemView.findViewById(R.id.ratings);
            tv_release = itemView.findViewById(R.id.release_date);
            tv_running_time = itemView.findViewById(R.id.running_time);
        }
    }
}
