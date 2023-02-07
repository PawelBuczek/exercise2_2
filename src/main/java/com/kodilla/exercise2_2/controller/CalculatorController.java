package com.kodilla.exercise2_2.controller;

import com.kodilla.exercise2_2.event.AdditionEvent;
import com.kodilla.exercise2_2.event.DivisionEvent;
import com.kodilla.exercise2_2.event.MultiplicationEvent;
import com.kodilla.exercise2_2.event.SubtractionEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    //http://localhost:8080/calculator/add?firstNumber=2.0&secondNumber=6.0
    @GetMapping(path = "add")
    public String add(Double firstNumber, Double secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            return "please provide values for firstNumber and secondNumber";
        }
        publisher.publishEvent(
                new AdditionEvent(
                        this,
                        firstNumber,
                        secondNumber));
        return "answer is: " + (firstNumber + secondNumber);
    }

    //http://localhost:8080/calculator/add?firstNumber=2.0&secondNumber=6.0
    @GetMapping(path = "subtract")
    public String subtract(Double firstNumber, Double secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            return "please provide values for firstNumber and secondNumber";
        }
        publisher.publishEvent(
                new SubtractionEvent(
                        this,
                        firstNumber,
                        secondNumber));
        return "answer is: " + (firstNumber - secondNumber);
    }

    //http://localhost:8080/calculator/multiply?firstNumber=2.0&secondNumber=6.0
    @GetMapping(path = "multiply")
    public String multiply(Double firstNumber, Double secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            return "please provide values for firstNumber and secondNumber";
        }
        publisher.publishEvent(
                new MultiplicationEvent(
                        this,
                        firstNumber,
                        secondNumber));
        return "answer is: " + (firstNumber * secondNumber);
    }

    //http://localhost:8080/calculator/divide?firstNumber=2.0&secondNumber=6.0
    @GetMapping(path = "divide")
    public String divide(Double firstNumber, Double secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            return "please provide values for firstNumber and secondNumber";
        }
        publisher.publishEvent(
                new DivisionEvent(
                        this,
                        firstNumber,
                        secondNumber));
        if (secondNumber == 0) {
            return "error - division by zero";
        } else {
            return "answer is: " + (firstNumber / secondNumber);
        }

    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

}