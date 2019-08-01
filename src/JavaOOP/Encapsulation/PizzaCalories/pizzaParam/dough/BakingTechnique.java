package JavaOOP.Encapsulation.PizzaCalories.pizzaParam.dough;

public enum BakingTechnique {
    Crispy(0.9),
	Chewy(1.1),
	Homemade(1.0);

    double getCalories;

    BakingTechnique(double getCalories){
        this.getCalories = getCalories;
    }

}
