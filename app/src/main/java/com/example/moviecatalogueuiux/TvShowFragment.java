package com.example.moviecatalogueuiux;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {


    private static ArrayList<Movie> listMovie;
    RecyclerView rvTv;

    private static String[] data_title;
    private static String[] data_ratings;
    private static String[] data_description;
    private static String[] data_directed;
    private static String[] data_produced;
    private static String[] data_screeplay;
    private static String[] data_based_on;
    private static String[] data_starring;
    private static String[] data_music;
    private static String[] data_cinematography;
    private static String[] data_edited;
    private static String[] data_production_companies;
    private static String[] data_distributed;
    private static String[] data_running_time;
    private static String[] data_release_date;
    private static TypedArray img_photo;


    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTv = view.findViewById(R.id.movie_view);
        rvTv.setHasFixedSize(true);
        prepare();
        addItem();
        recyclerView();
    }

    void recyclerView() {
        rvTv.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieAdapter movieAdapter = new MovieAdapter(listMovie);
        rvTv.setAdapter(movieAdapter);
    }

    private void addItem() {
        listMovie = new ArrayList<>();
        for (int i = 10; i < data_title.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(img_photo.getResourceId(i, -1));
            movie.setTitle(data_title[i]);
            movie.setRatings(data_ratings[i]);
            movie.setDirected(data_directed[i]);
            movie.setProduced(data_produced[i]);
            movie.setScreenplay(data_screeplay[i]);
            movie.setBasedOn(data_based_on[i]);
            movie.setStarring(data_starring[i]);
            movie.setMusic(data_music[i]);
            movie.setCinematography(data_cinematography[i]);
            movie.setEdited(data_edited[i]);
            movie.setProductionCompanies(data_production_companies[i]);
            movie.setDistributed(data_distributed[i]);
            movie.setRunningTime(data_running_time[i]);
            movie.setReleaseDate(data_release_date[i]);
            movie.setDescription(data_description[i]);
            listMovie.add(movie);
        }
    }

    private void prepare() {
        img_photo = getResources().obtainTypedArray(R.array.data_poster_movie);
        data_title = getResources().getStringArray(R.array.data_title_movie);
        data_ratings = getResources().getStringArray(R.array.data_ratings_movie);
        data_directed = getResources().getStringArray(R.array.data_directed_by_movie);
        data_produced = getResources().getStringArray(R.array.data_produced_by_movie);
        data_screeplay = getResources().getStringArray(R.array.data_screenplay_movie);
        data_based_on = getResources().getStringArray(R.array.data_based_on_movie);
        data_starring = getResources().getStringArray(R.array.data_starring_movie);
        data_music = getResources().getStringArray(R.array.data_music_by_movie);
        data_cinematography = getResources().getStringArray(R.array.data_cinematography_movie);
        data_edited = getResources().getStringArray(R.array.data_edited_by_movie);
        data_production_companies = getResources().getStringArray(R.array.data_production_companies_movie);
        data_distributed = getResources().getStringArray(R.array.data_distributed_by_movie);
        data_running_time = getResources().getStringArray(R.array.data_running_time_movie);
        data_release_date = getResources().getStringArray(R.array.data_release_date_movie);
        data_description = getResources().getStringArray(R.array.data_description_movie);
    }
}
