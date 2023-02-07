package com.kodilla.exercise2_2.event;

import org.springframework.context.ApplicationEvent;

public class CalculateEvent extends ApplicationEvent {
    public CalculateEvent(Object source) {
        super(source);
    }
}
