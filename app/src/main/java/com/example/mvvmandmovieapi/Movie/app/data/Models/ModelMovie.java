package com.example.mvvmandmovieapi.Movie.app.data.Models;

import java.util.List;

public class ModelMovie {
    private int page;
    private List<ResultsBean> results;
    private int total_pages;
    private int total_results;

    public int getPage() {
        return page;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public static class ResultsBean {
        private Boolean adult;
        private String backdrop_path;
        private List<Integer> genre_ids;
        private int id;
        private String original_language;
        private String original_title;
        private String overview;
        private Double popularity;
        private String poster_path;
        private String release_date;
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

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public int getId() {
            return id;
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

        public String getRelease_date() {
            return release_date;
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
    }
}
