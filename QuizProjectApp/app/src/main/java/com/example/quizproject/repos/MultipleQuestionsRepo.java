package com.example.quizproject.repos;


import com.example.quizproject.models.Result;

public class MultipleQuestionsRepo {

    private Result[] categoryOneQuestions;

    private static MultipleQuestionsRepo instance;

    public static MultipleQuestionsRepo getInstance() {
        if(instance == null) instance = new MultipleQuestionsRepo();
        return instance;
    }

    private MultipleQuestionsRepo() {
        this.categoryOneQuestions = new Result[]{};
    }

    public Result[] categoryOneQuestions() {
        return categoryOneQuestions;
    }

    public void setCategoryOneQuestions(Result[] categoryOneQuestions) {
        this.categoryOneQuestions = categoryOneQuestions;
    }

    public String getQuestion(int i){
        return categoryOneQuestions[i].question;
    }

    public String[] getIncorrectAnswers(int i){
        return categoryOneQuestions[i].incorrect_answers;
    }

    public String getCorrectAnswer(int i){
        return categoryOneQuestions[i].correct_answer;
    }
}
