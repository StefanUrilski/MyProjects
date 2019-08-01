package JavaOOP.CommunicationAndEvents.DependencyInversion.common;

import JavaOOP.CommunicationAndEvents.DependencyInversion.interfaces.Strategy;
import JavaOOP.CommunicationAndEvents.DependencyInversion.strategy.AddingStrategy;
import JavaOOP.CommunicationAndEvents.DependencyInversion.strategy.DivisionSrategy;
import JavaOOP.CommunicationAndEvents.DependencyInversion.strategy.MultiplicationStrategy;
import JavaOOP.CommunicationAndEvents.DependencyInversion.strategy.SubtractingStrategy;

class StrategyFactory {

    static Strategy getStrategy(String operator) {
        Strategy strategy = null;
        switch (operator) {
            case "+":
                strategy = new AddingStrategy();
                break;
            case "-":
                strategy = new SubtractingStrategy();
                break;
            case "*":
                strategy = new MultiplicationStrategy();
                break;
            case "/":
                strategy = new DivisionSrategy();
                break;
        }

        return strategy;
    }
}
