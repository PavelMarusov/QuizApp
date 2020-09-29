package com.example.quizapp.ui.data.network;

import android.util.Log;

import com.example.quizapp.ui.model.CategoryModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class QuizAppService {
    Retrofit retrofit= new Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    QuizApi service = retrofit.create(QuizApi.class);
    public void getCategories(QuizApiCallback callback){
Call<CategoryModel> call =service.getCategory();
call.enqueue(new Callback<CategoryModel>() {
    @Override
    public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
        if (response.isSuccessful()&&response.body()!=null){
            callback.onSuccess(response.body());
        Log.d("pop","onResponse" + response.body());}
    }

    @Override
    public void onFailure(Call<CategoryModel> call, Throwable t) {
        callback.onFailure(t);
        Log.d("pop","onFailure " + t.getMessage());
    }
});
    }



public interface QuizApiCallback{
    void onSuccess(CategoryModel categoryModel);
    void onFailure(Throwable th);

    }

    public interface QuizApi {
        @GET ("api_category.php")
        Call<CategoryModel> getCategory();
    }
}
