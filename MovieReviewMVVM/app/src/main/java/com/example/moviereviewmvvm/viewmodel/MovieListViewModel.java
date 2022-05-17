package com.example.moviereviewmvvm.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviereviewmvvm.model.MemeModel;
import com.example.moviereviewmvvm.model.MovieModel;
import com.example.moviereviewmvvm.network.APIService;
import com.example.moviereviewmvvm.network.RetrofitInstance;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {

    //observe the changes
    private MutableLiveData<MovieModel> movieModelResponse;

    public MovieListViewModel() {
        movieModelResponse = new MutableLiveData<>();
    }

    public MutableLiveData<MovieModel> getMoviesListObserver() {
        return movieModelResponse;
    }

    public void makeApiCall(OnApiResultListener<List<MemeModel>> callback) {
        APIService apiService = RetrofitInstance.getRetrofitClient().create(APIService.class);
        apiService.getMovieList().enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(@NonNull Call<MovieModel> call, @NonNull Response<MovieModel> response) {

                if (response.isSuccessful()) {
                    movieModelResponse.postValue(response.body());
                    assert response.body() != null;
                    List<MemeModel> memeModels = Arrays.asList(response.body().data);
                    callback.onSuccess(memeModels);
                } else {
                    Log.e("MainFragment", "Call failed");
                }
            }

            @Override
            public void onFailure(@NonNull Call<MovieModel> call, @NonNull Throwable t) {
//                moviesList.postValue(null);
                Log.e("MainFragment", "Call failed", t);
            }
        });
    }

    public interface OnApiResultListener<T> {
        void onSuccess(T data);
        void onFailure();
    }
}
