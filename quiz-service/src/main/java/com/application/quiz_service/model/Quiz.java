package com.application.quiz_service.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Quiz {

     @Id //this is represent id is primary
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // this is automatically generate value of id 

    private Integer id;
    private String title;
    
    @ElementCollection
    private List<Integer>questionsIds;

}
