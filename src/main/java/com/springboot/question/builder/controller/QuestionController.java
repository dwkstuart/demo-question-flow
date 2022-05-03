package com.springboot.question.builder.controller;

import com.springboot.question.builder.data.Answer;
import com.springboot.question.builder.data.QuestionFlow;
import com.springboot.question.builder.data.QuestionPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class QuestionController {

    private final OrchestrationService orchestrationService;

    @Autowired
    public QuestionController(final OrchestrationService orchestrationService) {
        this.orchestrationService = orchestrationService;
    }


    @GetMapping(value = "/question/{flow}")
    public ModelAndView displayQuestion(@PathVariable(value = "flow") String flowName) {
        ModelAndView model = new ModelAndView();
        QuestionFlow questionFlow = orchestrationService.getFlowByName(flowName);
        if (questionFlow != null) {
            QuestionPage questionPage = questionFlow.getCurrentQuestion();
            model.addObject(questionPage);
        }
        model.addObject("flow", flowName);
        model.addObject("answer", questionFlow.getCurrentAnswer());
        model.setViewName("question");
        return model;
    }

    @GetMapping(value = "/question/{flow}/complete")
    public ModelAndView testController(@PathVariable(value = "flow") String flowName) {
        ModelAndView model = new ModelAndView();
        QuestionFlow questionFlow = orchestrationService.getFlowByName(flowName);
        model.addObject("json", questionFlow.exportAsFlowAsJson());
        model.setViewName("complete");
        return model;
    }

    @PostMapping(value = "/question/{flow}")
    public String saveQuestion(@PathVariable(value = "flow") String flowName,
                               Answer answer) {

        Boolean flowFinished = orchestrationService.getFlowByName(flowName).
                saveAnswerIsFlowComplete(answer, false);
        String destination = flowFinished ? flowName + "/complete" : flowName;
        return "redirect:/freemarker/question/" + destination;
    }
}