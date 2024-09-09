package com.application.question_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.question_service.model.Question;
import com.application.question_service.model.QuestionWrapper;
import com.application.question_service.model.Response;
import com.application.question_service.service.QuestionService;


@RestController
@RequestMapping("question")

public class QuestionController {
    
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
      return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }  
    
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
     return questionService.addQuestion(question);
    }

    @GetMapping("Generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName , @RequestParam Integer numQuestions){
       return questionService.getQuestionForQuiz(categoryName,numQuestions);
    }


    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionsIds){
      return questionService.getQuestionsFromId(questionsIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
       return questionService.getScore(responses);
    }
}
