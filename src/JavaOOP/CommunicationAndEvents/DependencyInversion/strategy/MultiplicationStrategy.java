package JavaOOP.CommunicationAndEvents.DependencyInversion.strategy;

import JavaOOP.CommunicationAndEvents.DependencyInversion.interfaces.Strategy;

public class MultiplicationStrategy implements Strategy {

    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}
