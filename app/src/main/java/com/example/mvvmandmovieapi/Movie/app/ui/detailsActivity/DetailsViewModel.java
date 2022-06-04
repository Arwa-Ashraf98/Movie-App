package com.example.mvvmandmovieapi.Movie.app.ui.detailsActivity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmandmovieapi.Movie.app.data.Models.ModelMovieDetails;
import com.example.mvvmandmovieapi.Movie.app.data.Network.RetrofitConnection;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailsViewModel extends ViewModel {

    MutableLiveData<ModelMovieDetails> detailsLiveData = new MutableLiveData<>();
    MutableLiveData<String> errorLiveData = new MutableLiveData<>();
    CompositeDisposable disposable = new CompositeDisposable();

    void getDetails(int movieId, String apiKey) {
        RetrofitConnection.getServices()
                .getMovieDetailsRx(movieId, apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ModelMovieDetails>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);

                    }

                    @Override
                    public void onSuccess(ModelMovieDetails modelMovieDetails) {
                        detailsLiveData.setValue(modelMovieDetails);

                    }

                    @Override
                    public void onError(Throwable e) {
                        errorLiveData.setValue(e.getLocalizedMessage());

                    }
                });

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}

