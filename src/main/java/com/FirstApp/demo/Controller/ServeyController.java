package com.FirstApp.demo.Controller;

import com.FirstApp.demo.Service.SurveyService;
import com.FirstApp.demo.model.Question;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ServeyController {
    private SurveyService surveyService;

    public List<Question> retrieveQuestions(@PathVariable String surveyId){
        return surveyService.retrieveQuestions(surveyId);
    }
}
