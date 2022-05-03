package com.springboot.question.builder.data;

import lombok.Data;

import java.io.Serializable;

@Data
public class Answer implements Serializable {

    private String questionId;
    private String question;
    private String answer;

}
