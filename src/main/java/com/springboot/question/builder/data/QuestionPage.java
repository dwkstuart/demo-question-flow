package com.springboot.question.builder.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Data
public class QuestionPage {
    private final String id;
    private String title;
    private String questionText;
    private String questionType;
    private LinkedHashMap<String, String> options;

//    public QuestionPage(String id, String title, String questionText) {
//        this.id = id;
//        this.title = title;
//        this.questionText = questionText;
//    }
//    AnswerType answerType;
}
