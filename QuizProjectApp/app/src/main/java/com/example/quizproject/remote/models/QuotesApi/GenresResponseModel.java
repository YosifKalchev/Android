package com.example.quizproject.remote.models.QuotesApi;

public class GenresResponseModel {

    public int statusCode;
    public String message;
    public PaginationModel pagination;
    public Integer totalQuotes;
    public String[] data;
}
