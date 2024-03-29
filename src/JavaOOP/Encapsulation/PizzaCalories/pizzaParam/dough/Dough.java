package JavaOOP.Encapsulation.PizzaCalories.pizzaParam.dough;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (! containsFlourType(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (! containsBakingTechnique(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * this.weight) * FlourType.valueOf(this.flourType).getCalories
                        * BakingTechnique.valueOf(this.bakingTechnique).getCalories;
    }

    private boolean containsFlourType(String flourType) {
        for (FlourType flour : FlourType.values()) {
            if (flourType.equals(flour.name())) {
                return true;
            }
        }

        return false;
    }

    private boolean containsBakingTechnique(String bakingTechnique) {
        for (BakingTechnique technique : BakingTechnique.values()) {
            if (bakingTechnique.equals(technique.name())) {
                return true;
            }
        }

        return false;
    }
}
