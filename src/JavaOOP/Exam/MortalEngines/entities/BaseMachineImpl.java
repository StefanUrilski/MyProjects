package JavaOOP.Exam.MortalEngines.entities;

public abstract class BaseMachineImpl extends BaseMachine {
    private boolean mode = true;

    protected BaseMachineImpl(String name, double attackPoints, double defensePoints, double healthPoints) {
        super(name, attackPoints, defensePoints, healthPoints);
    }

    public boolean getMode() {
        return mode;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
    }

    protected abstract void attackPointsModifier();

    protected abstract void deffencePointsModifier();
}
