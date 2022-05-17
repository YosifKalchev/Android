package com.example.moviereviewmvvm.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.moviereviewmvvm.adapter.MovieListAdapter;
import com.example.moviereviewmvvm.databinding.FragmentMainBinding;
import com.example.moviereviewmvvm.model.MemeModel;
import com.example.moviereviewmvvm.model.MovieModel;
import com.example.moviereviewmvvm.viewmodel.MovieListViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private List<MemeModel> memesList;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        memesList = new ArrayList<>();
//        memesList.add(new MemeModel("Meme 1", "https:\\/\\/i.imgflip.com\\/1g8my4.jpg"));
//        memesList.add(new MemeModel("Meme 33", "https:\\/\\/i.imgflip.com\\/1ur9b0.jpg"));
//        memesList.add(new MemeModel("Meme 34", "https:\\/\\/i.imgflip.com\\/9iz9.jpg"));
        MovieListViewModel movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        movieListViewModel.makeApiCall(new MovieListViewModel.OnApiResultListener<List<MemeModel>>() {
            @Override
            public void onSuccess(List<MemeModel> data) {
                Toast.makeText(getContext(), "All is O.K.", Toast.LENGTH_SHORT).show();
                MovieListAdapter adapter = new MovieListAdapter(getContext(), data);
                LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
                binding.rvMainRecyclerView.setLayoutManager(layoutManager);
                binding.rvMainRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure() {
                Toast.makeText(getContext(), "Load failed!", Toast.LENGTH_SHORT).show();
            }
        });

//        MovieListAdapter adapter = new MovieListAdapter(getContext(), memesList);
//
//        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
//        binding.rvMainRecyclerView.setLayoutManager(layoutManager);
//        binding.rvMainRecyclerView.setAdapter(adapter);


//        movieListViewModel.getMoviesListObserver().observe(getViewLifecycleOwner(), new Observer<MovieModel>() {
//            @Override
//            public void onChanged(MovieModel movieModel) {
//                    adapter.setData(Arrays.asList(movieModel.data));
//            }
//        });

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
