package JavaOOP.Polymorphism.Calculator;

public class DivisionOperation extends OperationImpl {

    @Override
    public void addOperand(int operand) {
        this.getOperands().add(operand);

        if (this.isCompleted()) {
            this.setResult(this.getOperands().get(0) / this.getOperands().get(1));
        }
    }

}
