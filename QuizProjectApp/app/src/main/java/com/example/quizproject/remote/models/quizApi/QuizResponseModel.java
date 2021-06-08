package com.example.quizproject.remote.models.quizApi;


public class QuizResponseModel {

    private int response_code;
    public ResultObject[] results;

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public ResultObject[] getResults() {
        return results;
    }

    public void setResults(ResultObject[] results) {
        this.results = results;
    }





}
