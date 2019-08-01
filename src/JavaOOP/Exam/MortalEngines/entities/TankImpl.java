package JavaOOP.Exam.MortalEngines.entities;

import JavaOOP.Exam.MortalEngines.entities.interfaces.Tank;

public class TankImpl extends BaseMachineImpl implements Tank {
    private static final double DEFAULT_HEALTH_POINTS = 100;
    private static final double ATTACK_POINTS = 40.0;
    private static final double DEFENCE_POINTS = 30.0;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, DEFAULT_HEALTH_POINTS);
        this.attackPointsModifier();
        this.deffencePointsModifier();
    }

    @Override
    public boolean getDefenseMode() {
        return this.getMode();
    }

    @Override
    public void toggleDefenseMode() {
        if (this.getDefenseMode() == true) {
            this.setMode(false);
        } else {
            setMode(true);
        }

        this.attackPointsModifier();
        this.deffencePointsModifier();
    }

    @Override
    protected void attackPointsModifier() {
        if (getDefenseMode() == true) {
            setAttackPoints(getAttackPoints() - ATTACK_POINTS);
        } else {
            setAttackPoints(getAttackPoints() + ATTACK_POINTS);
        }
    }

    @Override
    protected void deffencePointsModifier() {
        if (getDefenseMode() == true) {
            setDefensePoints(getDefensePoints() + DEFENCE_POINTS);
        } else {
            setDefensePoints(getDefensePoints() - DEFENCE_POINTS);
        }
    }

    @Override
    public String toString() {
        return " *Type: Tank\n" + super.toString() + " *Defense Mode(" + (getDefenseMode() ? "ON" : "OFF") + ")\n";
    }
}
