package com.example.quizapp.ui.database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.quizapp.ui.model.ResultModel;

import java.util.List;

@Dao
public interface QuestionDao {

    @Insert
    long insert(ResultModel resultModel);

    @Query("SELECT * FROM resultmodel WHERE id=:id")
    ResultModel getById(int id);

    @Query("DELETE FROM ResultModel")
    void deleteAll();

    @Query("SELECT * FROM resultmodel")
    List<ResultModel> getAll();
    @Query("SELECT * FROM resultmodel")
    LiveData<List<ResultModel>> getUpdate();


}
