package com.example.moviecatalogueuiux;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int photo;
    private String title, ratings, description, directed, produced, screenplay, basedOn, starring, music, cinematography, edited, productionCompanies, distributed, runningTime, releaseDate;

    int getPhoto() {
        return photo;
    }

    void setPhoto(int photo) {
        this.photo = photo;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getRatings() {
        return ratings;
    }

    void setRatings(String ratings) {
        this.ratings = ratings;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getDirected() {
        return directed;
    }

    void setDirected(String directed) {
        this.directed = directed;
    }

    String getProduced() {
        return produced;
    }

    void setProduced(String produced) {
        this.produced = produced;
    }

    String getScreenplay() {
        return screenplay;
    }

    void setScreenplay(String screenplay) {
        this.screenplay = screenplay;
    }

    String getBasedOn() {
        return basedOn;
    }

    void setBasedOn(String basedOn) {
        this.basedOn = basedOn;
    }

    String getStarring() {
        return starring;
    }

    void setStarring(String starring) {
        this.starring = starring;
    }

    String getMusic() {
        return music;
    }

    void setMusic(String music) {
        this.music = music;
    }

    String getCinematography() {
        return cinematography;
    }

    void setCinematography(String cinematography) {
        this.cinematography = cinematography;
    }

    String getEdited() {
        return edited;
    }

    void setEdited(String edited) {
        this.edited = edited;
    }

    String getProductionCompanies() {
        return productionCompanies;
    }

    void setProductionCompanies(String productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    String getDistributed() {
        return distributed;
    }

    void setDistributed(String distributed) {
        this.distributed = distributed;
    }

    String getRunningTime() {
        return runningTime;
    }

    void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    String getReleaseDate() {
        return releaseDate;
    }

    void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.title);
        dest.writeString(this.ratings);
        dest.writeString(this.description);
        dest.writeString(this.directed);
        dest.writeString(this.produced);
        dest.writeString(this.screenplay);
        dest.writeString(this.basedOn);
        dest.writeString(this.starring);
        dest.writeString(this.music);
        dest.writeString(this.cinematography);
        dest.writeString(this.edited);
        dest.writeString(this.productionCompanies);
        dest.writeString(this.distributed);
        dest.writeString(this.runningTime);
        dest.writeString(this.releaseDate);
    }

    Movie() {
    }

    private Movie(Parcel in) {
        this.photo = in.readInt();
        this.title = in.readString();
        this.ratings = in.readString();
        this.description = in.readString();
        this.directed = in.readString();
        this.produced = in.readString();
        this.screenplay = in.readString();
        this.basedOn = in.readString();
        this.starring = in.readString();
        this.music = in.readString();
        this.cinematography = in.readString();
        this.edited = in.readString();
        this.productionCompanies = in.readString();
        this.distributed = in.readString();
        this.runningTime = in.readString();
        this.releaseDate = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
