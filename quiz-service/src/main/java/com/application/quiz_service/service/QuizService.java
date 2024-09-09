package com.application.quiz_service.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.application.quiz_service.dao.QuizDao;
import com.application.quiz_service.feign.QuizInterface;
import com.application.quiz_service.model.*;


@Service
public class QuizService {
    
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        
         List<Integer> questions= quizInterface.getQuestionForQuiz(category, numQ).getBody();
        
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
      // //it happen given id is not in database for this it return which is exception
      // we need to handle this through optional
      // Optional <Quiz> quiz= quizDao.findById(id);
      Quiz quiz = quizDao.findById(id).get();  
    
      List<Integer> questionsIds= quiz.getQuestionsIds();
      ResponseEntity<List<QuestionWrapper>> questions= quizInterface.getQuestionsFromId(questionsIds);
      return questions;
      
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

      ResponseEntity<Integer> score=  quizInterface.getScore(responses);
      return score;
    }

    
     
}
