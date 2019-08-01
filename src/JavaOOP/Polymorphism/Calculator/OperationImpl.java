package JavaOOP.Polymorphism.Calculator;

import java.util.ArrayList;
import java.util.List;

public abstract class OperationImpl implements Operation {
    private List<Integer> operands;
    private int result;

    public OperationImpl(){
        this.operands = new ArrayList<>();
    }

    @Override
    public abstract void addOperand(int operand);

    @Override
    public boolean isCompleted() {
        return this.operands.size() == 2;
    }

    @Override
    public int getResult() {
        return this.result;
    }

    public List<Integer> getOperands() {
        return operands;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
