package com.springboot.question.builder.builder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springboot.question.builder.data.QuestionPage;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class QuestionFactory {
//
//    private ArrayList<QuestionPage> questionPageArrayList;


    public static ArrayList<QuestionPage> getQuestionsFromJson() throws Exception {
        Gson gson = new Gson();
        String questionPageJson = readFileAsString("src/main/webapp/questions.json");
        Type questionListType = new TypeToken<ArrayList<QuestionPage>>(){}.getType();
        return gson.fromJson(questionPageJson,questionListType);
    }


    private static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
