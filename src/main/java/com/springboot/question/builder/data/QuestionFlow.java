package com.springboot.question.builder.data;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class QuestionFlow {

    private final String flowName;
    private final QuestionPage[] questionPages;
    private final Map<String,Answer> answers;
    private int currentQuestionIndex;

    public QuestionFlow(ArrayList<QuestionPage> questionList, String flowName){
        this.flowName = flowName;
        this.questionPages = questionList.toArray(QuestionPage[]::new);
        this.answers = new HashMap<>();
    }

    public QuestionPage getCurrentQuestion(){

        return questionPages[currentQuestionIndex];
    }

    public Boolean saveAnswerIsFlowComplete(Answer answer, Boolean cleardownRestOfFlow){
        answers.put(getCurrentQuestion().getId(), answer);
        currentQuestionIndex++;
        return (currentQuestionIndex == questionPages.length);
//        if(cleardownRestOfFlow){
//            IntStream.range(currentQuestionIndex, questionPages.length)
//                    .forEach(remainingQuestion -> answers[remainingQuestion].setAnswer(null));
//        }

    }
    public Answer getCurrentAnswer(){
        String currentQuestionId = questionPages[currentQuestionIndex].getId();
        Answer answer = null;
        if(answers.containsKey(currentQuestionId)){
            answer = answers.get(currentQuestionId);
        }
        return answer;
    }

    public void previousQuestion(){
        currentQuestionIndex--;
    }

    public String exportAsFlowAsJson(){

        Gson gson = new Gson();
        String json = gson.toJson(answers);
        return json;
    }

    public String getFlowName(){
        return flowName;
    }

}
