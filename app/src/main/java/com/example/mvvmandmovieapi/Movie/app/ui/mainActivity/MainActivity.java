package com.example.mvvmandmovieapi.Movie.app.ui.mainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmandmovieapi.Movie.app.Adapters.AdapterMovie;
import com.example.mvvmandmovieapi.Movie.app.data.Models.ModelMovie;
import com.example.mvvmandmovieapi.Movie.app.helper.Const;
import com.example.mvvmandmovieapi.Movie.app.ui.detailsActivity.DetailsActivity;
import com.example.mvvmandmovieapi.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private HomeViewModel homeViewModel;
    private final AdapterMovie adapter = new AdapterMovie();
    private List<ModelMovie.ResultsBean> list = new ArrayList<>();
    private CompositeDisposable dd = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        getData(Const.API_KEY);
        onClicks();

    }


    private void getData(String apiKey) {
        // calling api
        homeViewModel.getAllMovie(apiKey);
        // observe on data
        homeViewModel.movieLiveData.observe(this, new Observer<ModelMovie>() {
            @Override
            public void onChanged(ModelMovie modelMovie) {
                list = modelMovie.getResults();
                adapter.setList((ArrayList<ModelMovie.ResultsBean>) list);
                binding.recyclerMovie.setAdapter(adapter);

            }
        });
        // observe on error
        homeViewModel.errorLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
        // observe on progressBar
        homeViewModel.progressBarLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.progressbar.setVisibility(integer);
//                if (integer==1){
//                    binding.progressbar.setVisibility(View.VISIBLE);
//                }else if (integer==0){
//                    binding.progressbar.setVisibility(View.GONE);
//                }
            }
        });
    }

    private void onClicks() {
        adapter.setOnItemListener(new AdapterMovie.onItemListener() {
            @Override
            public void onItemClick(int movieId) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(Const.MOVIE_ID, movieId);
                startActivity(intent);

            }
        });

    }

    // by using RxJava

//    private void getData(){
//        binding.progressbar.setVisibility(View.VISIBLE);
//        RetrofitConnection.getServices()
//                .getAllMoviesRx(Const.API_KEY)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<ModelMovie>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        binding.progressbar.setVisibility(View.GONE);
//
//                    }
//
//                    @Override
//                    public void onSuccess(ModelMovie modelMovies) {
//                        list = modelMovies.getResults();
//                        adapter.setList((ArrayList<ModelMovie.ResultsBean>) list);
//                        binding.recyclerMovie.setAdapter(adapter);
//                        binding.progressbar.setVisibility(View.GONE);
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        binding.progressbar.setVisibility(View.GONE);
//
//                    }
//                });
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        dd.clear();
    }
}