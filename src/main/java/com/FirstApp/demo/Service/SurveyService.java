package com.FirstApp.demo.Service;

import com.FirstApp.demo.model.Question;
import com.FirstApp.demo.model.Survey;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SurveyService {
    private static List<Survey> surveys = new ArrayList<>();

    static {
        Question question1 = new Question("Question1",
                "Largest Country in the World", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));
        Question question2 = new Question("Question2",
                "Most Populus Country in the World", "China", Arrays.asList(
                "India", "Russia", "United States", "China"));
        Question question3 = new Question("Question3",
                "Highest GDP in the World", "United States", Arrays.asList(
                "India", "Russia", "United States", "China"));
        Question question4 = new Question("Question4",
                "Second largest english speaking country", "India", Arrays
                .asList("India", "Russia", "United States", "China"));

        List<Question> questions = new ArrayList<>(Arrays.asList(question1,
                question2, question3, question4));

        Survey survey = new Survey("Survey1", "My Favorite Survey",
                "Description of the Survey", questions);

        surveys.add(survey);
    }
    public List<Survey> retrieveAllSurveys(){
        return surveys;
    }
    public Survey retrieveSurvey(String surveyId){
        for(Survey survey: surveys){
            if(survey.getId().equals(surveyId)) {
                return survey;
            }
        }
        return null;
    }
    public List<Question> retrieveQuestions(String surveyId) {
        Survey survey = retrieveSurvey(surveyId);

        if (survey == null) {
            return null;
        }
        for (Question question : survey.getQuestions()) {
            String questionId = " ";
            if (question.getId().equals(questionId)) {
                return (List<Question>) question;
            }
        }

        return survey.getQuestions();
    }
    @GetMapping(path = "/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveQuestion(String surveyId, String questionId){
        Survey survey = retrieveSurvey(surveyId);

        if (survey == null) {
            return null;
        }

        for (Question question : survey.getQuestions()) {
            if (question.getId().equals(questionId)) {
                return question;
            }
        }

        return null;
    }
    private SecureRandom random = new SecureRandom();

    public Question addQuestion(String surveyId, Question question) {
        Survey survey = retrieveSurvey(surveyId);

        if (survey == null) {
            return null;
        }

        String randomId = new BigInteger(130, random).toString(32);
        question.setId(randomId);

        survey.getQuestions().add(question);

        return question;
    }
}
