package com.application.quiz_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    
 
    @Id //this is represent id is primary
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // this is automatically generate value of id 

    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String dificultylevel;
    private String category;

}
