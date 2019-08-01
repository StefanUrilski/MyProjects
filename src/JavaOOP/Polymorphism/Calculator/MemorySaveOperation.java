package JavaOOP.Polymorphism.Calculator;

import java.util.ArrayDeque;

public class MemorySaveOperation extends OperationImpl {
    private CalculationEngine engine;
    private ArrayDeque<Integer> memory;

    public MemorySaveOperation(CalculationEngine engine) {
        this.engine = engine;
    }

    @Override
    public void addOperand(int operand) {
        if (this.memory == null) { init(); }
        this.memory.push(this.engine.getCurrentResult());
    }

    @Override
    public int getResult() {
        return this.memory.pop();
    }

    private void init() {
        this.memory = new ArrayDeque<>();
    }
}
