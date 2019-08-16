package com.example.moviecatalogueuiux;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class DetailsActivity extends AppCompatActivity {

    public static final String EXTRA = "extra";

    ImageView img_photo;
    TextView the_title, ratings, description, directed, produced, screenplay, based_on, starring, music, cinematography, edited, production_companies, distributed, running_time, release_date;
    RatingBar ratingBar;
    Button btn_watch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        img_photo = findViewById(R.id.img_item_photo);
        the_title = findViewById(R.id.tv_name);
        ratingBar = findViewById(R.id.rating_bar);
        ratings = findViewById(R.id.ratings);
        description = findViewById(R.id.description);
        directed = findViewById(R.id.directed_by);
        produced = findViewById(R.id.produced_by);
        screenplay = findViewById(R.id.screenplay_by);
        based_on = findViewById(R.id.based_on);
        starring = findViewById(R.id.starring);
        music = findViewById(R.id.music_by);
        cinematography = findViewById(R.id.cinematography);
        edited = findViewById(R.id.edited_by);
        production_companies = findViewById(R.id.production_companies);
        distributed = findViewById(R.id.distributed_by);
        running_time = findViewById(R.id.running_time);
        release_date = findViewById(R.id.release_date);
        btn_watch = findViewById(R.id.watch);

        Movie movie = getIntent().getParcelableExtra(EXTRA);
        setActionBarTitle(movie.getTitle());
        setActionBarBackground(getDrawable(R.drawable.toolbar));
        Glide.with(this).load(movie.getPhoto()).into(img_photo);
        the_title.setText(movie.getTitle());
        ratings.setText(movie.getRatings());
        directed.setText(movie.getDirected());
        produced.setText(movie.getProduced());
        screenplay.setText(movie.getScreenplay());
        based_on.setText(movie.getBasedOn());
        starring.setText(movie.getStarring());
        music.setText(movie.getMusic());
        cinematography.setText(movie.getCinematography());
        edited.setText(movie.getEdited());
        production_companies.setText(movie.getProductionCompanies());
        distributed.setText(movie.getDistributed());
        running_time.setText(movie.getRunningTime());
        release_date.setText(movie.getReleaseDate());
        description.setText(movie.getDescription());

        if (movie.getRatings().equals("8.0 / 10.0") || movie.getRatings().equals("8.1 / 10.0") || movie.getRatings().equals("8.3 / 10.0") || movie.getRatings().equals("8.4 / 10.0") || movie.getRatings().equals("8.5 / 10.0") || movie.getRatings().equals("8.7 / 10.0")) {
            ratingBar.setRating(4.0f);
        } else if (movie.getRatings().equals("9.1 / 10.0") || movie.getRatings().equals("9.2 / 10.0") || movie.getRatings().equals("9.3 / 10.0") || movie.getRatings().equals("9.4 / 10.0") || movie.getRatings().equals("9.5 / 10.0")) {
            ratingBar.setRating(4.5f);
        }

        btn_watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.netflix.com/");
                Intent watch = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(watch);
            }
        });

    }

    private void setActionBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    private void setActionBarBackground(Drawable background) {
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(background);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else if (item.getItemId() == R.id.share) {
            Movie movie = getIntent().getParcelableExtra(EXTRA);
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            String shareBody = movie.getTitle() +
                    "\n\nWow ! This movie looks so cool !" +
                    "\n\nCome and check it at this link !" +
                    "\nhttps://www.github.com/maulanarasoky" +
                    "\n\nOr in this link !" +
                    "\nhttps://www.mul-code.blogspot.com";
            String shareSubject = "Movie Catalogue";
            share.putExtra(Intent.EXTRA_TEXT, shareBody);
            share.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
            startActivity(Intent.createChooser(share, "Share Using"));
        }
        return super.onOptionsItemSelected(item);
    }
}
