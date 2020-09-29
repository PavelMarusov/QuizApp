
package com.example.quizapp.ui.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryModel {

    @SerializedName("trivia_categories")
    @Expose
    private List<Trivia_category> trivia_categories = null;

    public List<Trivia_category> getTrivia_categories() {
        return trivia_categories;
    }

    public void setTrivia_categories(List<Trivia_category> trivia_categories) {
        this.trivia_categories = trivia_categories;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "trivia_categories=" + trivia_categories +
                '}';
    }
}
