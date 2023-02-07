package com.kodilla.exercise2_2.service;

import com.kodilla.exercise2_2.event.*;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@Component
public class CalculationManager implements ApplicationListener<CalculateEvent> {

    Logger logger = Logger.getLogger("my-logger");

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
        logger.log(new LogRecord(Level.INFO,
                "Adding numbers: " + event.getFirstNumber() + ", " + event.getSecondNumber()));
    }
    public void doSubtraction(SubtractionEvent event) {
        logger.log(new LogRecord(Level.INFO,
                "Subtracting numbers: " + event.getFirstNumber() + ", " + event.getSecondNumber()));
    }
    public void doMultiplication(MultiplicationEvent event) {
        logger.log(new LogRecord(Level.INFO,
                "Multiplying numbers: " + event.getFirstNumber() + ", " + event.getSecondNumber()));
    }
    public void doDivision(DivisionEvent event) {
        logger.log(new LogRecord(Level.INFO,
                "Dividing numbers: " + event.getFirstNumber() + ", " + event.getSecondNumber()));
    }
}