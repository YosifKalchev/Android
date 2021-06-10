package com.example.quizproject.fragments;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.quizproject.R;
import com.example.quizproject.remote.models.quizApi.QuizApiService;
import com.example.quizproject.remote.models.quizApi.categories_models.ResponseModelForCategories;
import com.example.quizproject.remote.models.quizApi.categories_models.ResponseObjectForCategories;
import com.example.quizproject.remote.models.quizApi.questions_models.ResponseModelForQuestions;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateGameFragment extends Fragment {

    private Spinner spnFirstCategories;
    private Spinner spnSecondCategories;
    private Spinner spnDifficultySelector;
    private Button btnCreateGame;
    private List<String> categories;
    private ArrayAdapter<String> difficultyAdapter;
    private ArrayAdapter<String> spinnerAdapter;
    private QuizApiService serviceQuiz;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewInit(view);
        setUpToolbar(view);

        //todo set adapter for spinner and give it list of categories via API call
    }

    private void viewInit(@NotNull View view) {

        initView(view);
        setupQuizRetrofit();
        loadCategoriesFromApi(view);
        createAdapters();

        spnFirstCategories.setAdapter(spinnerAdapter);
        spnSecondCategories.setAdapter(spinnerAdapter);
        spnDifficultySelector.setAdapter(difficultyAdapter);



        //todo set spinner values
        //todo set button clickListener and add the created game to GameRepository
    }

    private void loadCategoriesFromApi(View view) {


    }

    private void createAdapters() {
        categories = new ArrayList<>();
        categories.add("Science");
        categories.add("Movies");

        List<String> difficulty = Arrays.asList("easy", "medium", "hard");

        difficultyAdapter = new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, difficulty);
        spinnerAdapter = new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, categories);

    }

    private void setupQuizRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://opentdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serviceQuiz = retrofit.create(QuizApiService.class);
    }

    private void initView(@NotNull View view) {
        spnFirstCategories = view.findViewById(R.id.spnFirstCategorySelector);
        spnSecondCategories = view.findViewById(R.id.spnSecondCategorySelector);
        spnDifficultySelector = view.findViewById(R.id.spnGameDifficultySelector);
        btnCreateGame = view.findViewById(R.id.btnCreateGame);
    }

    private void setUpToolbar(@NotNull View view) {

        Toolbar toolbar = view.findViewById(R.id.toolbarGameTab);
        toolbar.setTitle("Create game");
        toolbar.setNavigationOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_createGameFragment_to_mainFragment);

        });
        toolbar.inflateMenu(R.menu.menu_game_tb);
    }
}
