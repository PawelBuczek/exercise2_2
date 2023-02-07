package com.kodilla.exercise2_2.event;

public class AdditionEvent extends CalculateEvent {
    private final double firstNumber;
    private final double secondNumber;

    public AdditionEvent(Object source, double firstNumber, double secondNumber) {
        super(source);
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }
}
