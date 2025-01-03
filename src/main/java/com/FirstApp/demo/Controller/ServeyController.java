package com.FirstApp.demo.Controller;

import com.FirstApp.demo.Service.SurveyService;
import com.FirstApp.demo.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ServeyController {
    @Autowired
    private SurveyService surveyService;

    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> retrieveQuestions(@PathVariable String surveyId){
        return surveyService.retrieveQuestions(surveyId);
    }

    public Question retrieveDetailsForQuestion(@PathVariable String surveyId, @PathVariable String questionId){
        return surveyService.retrieveQuestion(surveyId,questionId);
    }
}
