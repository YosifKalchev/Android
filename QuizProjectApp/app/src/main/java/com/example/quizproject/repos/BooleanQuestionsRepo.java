package com.example.quizproject.repos;


import com.example.quizproject.models.Result;

public class BooleanQuestionsRepo {

    private Result[] categoryTwoQuestions;

    private static BooleanQuestionsRepo instance;

    public static BooleanQuestionsRepo getInstance() {
        if(instance == null) instance = new BooleanQuestionsRepo();
        return instance;
    }

    private BooleanQuestionsRepo() {
        this.categoryTwoQuestions = new Result[]{};
    }

    public Result[] getCategoryTwoQuestions() {
        return categoryTwoQuestions;
    }

    public void setCategoryTwoQuestions(Result[] categoryTwoQuestions) {
        this.categoryTwoQuestions = categoryTwoQuestions;
    }

    public String getQuestion(int i){
        return categoryTwoQuestions[i].question;
    }

    public String[] getIncorrectAnswers(int i){
        return categoryTwoQuestions[i].incorrect_answers;
    }

    public String getCorrectAnswer(int i){
        return categoryTwoQuestions[i].correct_answer;
    }
}
