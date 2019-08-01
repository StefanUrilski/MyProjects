package JavaOOP.Polymorphism.Calculator;

public class Extensions {

    public static InputInterpreter buildsInterpreter(CalculationEngine engine) {
        return new InputInterpreterImpl(engine);
    }
}
