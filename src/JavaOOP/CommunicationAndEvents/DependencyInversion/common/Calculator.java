package JavaOOP.CommunicationAndEvents.DependencyInversion.common;

import JavaOOP.CommunicationAndEvents.DependencyInversion.interfaces.Strategy;
import JavaOOP.CommunicationAndEvents.DependencyInversion.strategy.AddingStrategy;

public class Calculator {
//    private int[] operands;
    private Strategy strategy;

    public Calculator() {
//        this.operands = new int[2];
        this.strategy = new AddingStrategy();
    }

    public void changeStrategy(String operator) {
        strategy = StrategyFactory.getStrategy(operator);
    }

    public int calculate(int first, int second) {
        return strategy.calculate(first, second);
    }

}
