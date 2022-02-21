package com.example.moviereviewmvvm.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.moviereviewmvvm.adapter.MovieListAdapter;
import com.example.moviereviewmvvm.databinding.FragmentMainBinding;
import com.example.moviereviewmvvm.model.MovieModel;
import com.example.moviereviewmvvm.viewmodel.MovieListViewModel;

import java.util.List;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private List<MovieModel> movieModelList;
    private MovieListAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        adapter = new MovieListAdapter(getContext(), movieModelList);
        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        binding.rvMainRecyclerView.setLayoutManager(layoutManager);
        binding.rvMainRecyclerView.setAdapter(adapter);

        MovieListViewModel movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        movieListViewModel.getMoviesListObserver().observe(getViewLifecycleOwner(), movieModels -> {
            if (movieModels != null) {
                movieModelList = movieModels;
                adapter.setData(movieModels);
                binding.tvNoResult.setVisibility(View.GONE);
            } else {
                binding.tvNoResult.setVisibility(View.VISIBLE);
            }
        });
        movieListViewModel.makeApiCall();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}
