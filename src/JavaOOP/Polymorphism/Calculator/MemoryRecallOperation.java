package JavaOOP.Polymorphism.Calculator;

public class MemoryRecallOperation extends OperationImpl {
    private CalculationEngine engine;
    private MemorySaveOperation memorySaveOperation;

    public MemoryRecallOperation(CalculationEngine engine, MemorySaveOperation memorySaveOperation) {
        this.engine = engine;
        this.memorySaveOperation = memorySaveOperation;
    }

    @Override
    public void addOperand(int operand) {
        //engine.pushNumber(memorySaveOperation.getResult());
    }

    @Override
    public boolean isCompleted() {
        return true;
    }

    @Override
    public int getResult() {
        return memorySaveOperation.getResult();
    }


}
