package com.example.mvvmandmovieapi.Movie.app.data.Models;

import java.util.List;

public class ModelMovieDetails {
    private Boolean adult;
    private String backdrop_path;
    private Object belongs_to_collection;
    private Double budget;
    private List<GenresBean> genres;
    private String homepage;
    private int id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private Double popularity;
    private String poster_path;
    private List<ProductionCompaniesBean> production_companies;
    private List<ProductionCountriesBean> production_countries;
    private String release_date;
    private Double revenue;
    private int runtime;
    private List<SpokenLanguagesBean> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private Boolean video;
    private Double vote_average;
    private int vote_count;


    public Boolean getAdult() {
        return adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public Object getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public Double getBudget() {
        return budget;
    }

    public List<GenresBean> getGenres() {
        return genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public int getId() {
        return id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public List<ProductionCompaniesBean> getProduction_companies() {
        return production_companies;
    }

    public List<ProductionCountriesBean> getProduction_countries() {
        return production_countries;
    }

    public String getRelease_date() {
        return release_date;
    }

    public Double getRevenue() {
        return revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public List<SpokenLanguagesBean> getSpoken_languages() {
        return spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getVideo() {
        return video;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public static class GenresBean {
        private int id;
        private String name;
    }


    public static class ProductionCompaniesBean {
        private int id;
        private String logo_path;
        private String name;
        private String origin_country;
    }


    public static class ProductionCountriesBean {
        private String iso_3166_1;
        private String name;
    }


    public static class SpokenLanguagesBean {
        private String english_name;
        private String iso_639_1;
        private String name;
    }
}
