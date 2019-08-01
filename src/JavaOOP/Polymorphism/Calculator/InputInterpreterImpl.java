package JavaOOP.Polymorphism.Calculator;

public class InputInterpreterImpl extends InputInterpreter {
    private CalculationEngine engine;
    private MemorySaveOperation memorySaveOperation;

    public InputInterpreterImpl(CalculationEngine engine) {
        super(engine);
        this.engine = engine;
    }

    @Override
    public Operation getOperation(String operation) {
        switch (operation) {
            case "*":
                return super.getOperation(operation);
            case "/":
                return new DivisionOperation();
            case "ms":
                if (this.memorySaveOperation == null) {
                    this.memorySaveOperation = new MemorySaveOperation(this.engine);
                }
                return this.memorySaveOperation;
            case "mr":
                return new MemoryRecallOperation(this.engine, this.memorySaveOperation);
                default:
                    return null;
        }
    }
}
