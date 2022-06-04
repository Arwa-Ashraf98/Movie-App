package com.example.mvvmandmovieapi.Movie.app.ui.mainActivity;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmandmovieapi.Movie.app.data.Models.ModelMovie;
import com.example.mvvmandmovieapi.Movie.app.data.Network.RetrofitConnection;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {
    MutableLiveData<ModelMovie> movieLiveData = new MutableLiveData<>();
    MutableLiveData<String> errorLiveData = new MutableLiveData<>();
    MutableLiveData<Integer> progressBarLiveData = new MutableLiveData<>();
    CompositeDisposable dd = new CompositeDisposable();

    void getAllMovie(String apiKey) {
        progressBarLiveData.setValue(View.VISIBLE);
        RetrofitConnection.getServices()
                .getAllMoviesRx(apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ModelMovie>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        dd.add(d);

                    }

                    @Override
                    public void onSuccess(ModelMovie modelMovie) {
                        // this is like interface to sen data to mainActivity
                        movieLiveData.setValue(modelMovie);
                        progressBarLiveData.setValue(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorLiveData.setValue(e.getLocalizedMessage());
                        progressBarLiveData.setValue(View.GONE);

                    }
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        dd.clear();
    }
}
