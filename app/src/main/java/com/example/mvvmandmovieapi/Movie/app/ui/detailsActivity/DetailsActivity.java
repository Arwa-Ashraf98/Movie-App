package com.example.mvvmandmovieapi.Movie.app.ui.detailsActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mvvmandmovieapi.Movie.app.data.Models.ModelMovieDetails;
import com.example.mvvmandmovieapi.databinding.ActivityDetailsBinding;
import com.example.mvvmandmovieapi.Movie.app.helper.Const;

import io.reactivex.disposables.CompositeDisposable;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;
    private CompositeDisposable dd = new CompositeDisposable();
    private DetailsViewModel detailsViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int movieId = getIntent().getIntExtra(Const.MOVIE_ID, 0);
        getDetailsMovie(movieId);
    }

    private void getDetailsMovie(int movieId) {
        detailsViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);
        detailsViewModel.getDetails(movieId, Const.API_KEY);
        detailsViewModel.detailsLiveData.observe(this, new Observer<ModelMovieDetails>() {
            @Override
            public void onChanged(ModelMovieDetails modelMovieDetails) {
                // initView
                initView(modelMovieDetails);

            }
        });
        detailsViewModel.errorLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(DetailsActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

    }


//    private void getDetailsMovie(int movieId) {
//        RetrofitConnection.getServices()
//                .getMovieDetailsRx(movieId, Const.API_KEY)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<ModelMovieDetails>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        dd.add(d);
//                    }
//
//                    @Override
//                    public void onSuccess(ModelMovieDetails modelMovieDetails) {
//                        initView(modelMovieDetails);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Toast.makeText(DetailsActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }

    private void initView(ModelMovieDetails modelDetailsMovies) {
        binding.textDescription.setText(modelDetailsMovies.getOverview());
        binding.textReleaseDate.setText(modelDetailsMovies.getRelease_date());
        binding.textTitle.setText(modelDetailsMovies.getTitle());
        binding.textVoteCount.setText(modelDetailsMovies.getVote_count() + "");
        Glide.with(this)
                .load(Const.BASE_URL_IMAGE + modelDetailsMovies.getPoster_path())
                .into(binding.imageMovie);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        dd.clear();
    }
}