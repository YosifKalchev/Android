package com.example.quizproject.remote.models.quizApi.questions_models;


public class ResponseModelForQuestions {

    private int response_code;
    public ResultObjForQuestions[] results;

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public ResultObjForQuestions[] getResults() {
        return results;
    }

    public void setResults(ResultObjForQuestions[] results) {
        this.results = results;
    }





}
