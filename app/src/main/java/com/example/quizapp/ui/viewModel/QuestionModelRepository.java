package com.example.quizapp.ui.viewModel;

import com.example.quizapp.ui.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionModelRepository {

    public List <QuestionModel> getQuestionList (){
        List <QuestionModel> list = new ArrayList<>();
        list.add(new QuestionModel("Земля круглая?","Да","Да","Нет","Нет",false));
        list.add(new QuestionModel("Сколько букв в слова мама","1","2","3","4",true));
        list.add(new QuestionModel("Какой город является столицей Мадагаскара",
                "Бишкек",
                "Москва",
                "Антананариву",
                "Каир",
                true));
        list.add(new QuestionModel("java - это обьектно ориентированный язык програмирования",
                "Да",
                "Да",
                "Нет",
                "Нет",
                false));
        list.add(new QuestionModel("Правда ли что чисто Пи = 3,14",
                "Да",
                "Да",
                "Нет",
                "Нет",
                false));
        list.add(new QuestionModel("Кто автор Закона всемирного тяготения",
                "И.Ньютон",
                "Д.Минделеев",
                "П.Марусов",
                "Такого законе нет",
                true));
        list.add(new QuestionModel("Кыргызстан - входило когда либо в состаав СССР?",
                "Да",
                "Да",
                "Нет",
                "Нет",
                false));
        list.add(new QuestionModel("Сколько будет 2+2*2",
                "8",
                "6",
                "16",
                "0",
                true));

        return list;
    }
}
