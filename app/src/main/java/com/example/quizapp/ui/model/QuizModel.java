
package com.example.quizapp.ui.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuizModel {

    @SerializedName("response_code")
    @Expose
    private Integer response_code;
    @SerializedName("results")
    @Expose
    private List<ResultQuiz> results = null;

    public Integer getResponse_code() {
        return response_code;
    }

    public void setResponse_code(Integer response_code) {
        this.response_code = response_code;
    }

    public List<ResultQuiz> getResults() {
        return results;
    }

    public void setResults(List<ResultQuiz> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "QuizModel{" +
                "response_code=" + response_code +
                ", results=" + results +
                '}';
    }
}
