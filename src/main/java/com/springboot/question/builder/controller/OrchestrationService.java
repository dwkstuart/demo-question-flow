package com.springboot.question.builder.controller;

import com.springboot.question.builder.builder.QuestionFactory;
import com.springboot.question.builder.data.QuestionFlow;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrchestrationService {

    private Map<String, QuestionFlow> questionFlowMap = new HashMap<>();

    public OrchestrationService() {
        setUpTestFlows();
    }

    private void setUpTestFlows() {
        QuestionFlow questionFlowName = null;
        try {
            questionFlowName = new QuestionFlow(QuestionFactory.getQuestionsFromJson(), "DetailsFlow");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        questionFlowMap.put(questionFlowName.getFlowName(), questionFlowName);
        questionFlowMap.size();
    }

    public QuestionFlow getFlowByName(String name){
        return questionFlowMap.get(name);
    }
}
