package com.kodilla.exercise2_2.service;

import com.kodilla.exercise2_2.event.*;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CalculationManager implements ApplicationListener<CalculateEvent> {

    @Override
    public void onApplicationEvent(CalculateEvent event) {
        if (event instanceof AdditionEvent) {
            doApplication((AdditionEvent) event);
        }
        if (event instanceof SubtractionEvent) {
            doSubtraction((SubtractionEvent) event);
        }
        if (event instanceof MultiplicationEvent) {
            doMultiplication((MultiplicationEvent) event);
        }
        if (event instanceof DivisionEvent) {
            doDivision((DivisionEvent) event);
        }
    }

    public void doApplication(AdditionEvent event) {
        System.out.println("Adding numbers: " + event.getFirstNumber() + ", " + event.getSecondNumber());
    }
    public void doSubtraction(SubtractionEvent event) {
        System.out.println("Subtracting numbers: " + event.getFirstNumber() + ", " + event.getSecondNumber());
    }
    public void doMultiplication(MultiplicationEvent event) {
        System.out.println("Multiplying numbers: " + event.getFirstNumber() + ", " + event.getSecondNumber());
    }
    public void doDivision(DivisionEvent event) {
        System.out.println("Dividing numbers: " + event.getFirstNumber() + ", " + event.getSecondNumber());
    }
}