package JavaOOP.Exam.MortalEngines.entities;

import JavaOOP.Exam.MortalEngines.entities.interfaces.Fighter;

public class FighterImpl extends BaseMachineImpl implements Fighter {
    private static final double DEFAULT_HEALTH_POINTS = 200;
    private static final double ATTACK_POINTS = 50.0;
    private static final double DEFENCE_POINTS = 25.0;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, DEFAULT_HEALTH_POINTS);
        this.attackPointsModifier();
        this.deffencePointsModifier();
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        super.setHealthPoints(healthPoints);
    }

    @Override
    public boolean getAggressiveMode() {
        return getMode();
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.getMode()) {
            this.setMode(false);
        } else {
            this.setMode(true);
        }

        this.attackPointsModifier();
        this.deffencePointsModifier();
    }

    @Override
    protected void attackPointsModifier() {
        if (getMode()) {
            setAttackPoints(getAttackPoints() + ATTACK_POINTS);
        } else {
            setAttackPoints(getAttackPoints() - ATTACK_POINTS);
        }
    }

    @Override
    protected void deffencePointsModifier() {
        if (getAggressiveMode() == true) {
            setDefensePoints(getDefensePoints() - DEFENCE_POINTS);
        } else {
            setDefensePoints(getDefensePoints() + DEFENCE_POINTS);
        }
    }

    @Override
    public String toString() {
        return " *Type: Fighter\n" + super.toString() + " *Aggressive Mode("
                + (getAggressiveMode() ? "ON" : "OFF") + ")";
    }
}
