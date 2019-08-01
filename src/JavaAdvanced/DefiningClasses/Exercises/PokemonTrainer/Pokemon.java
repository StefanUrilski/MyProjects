package DefiningClasses.Exercises.PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public boolean isDead(){
        return this.health <= 0;
    }

    public boolean checkElement(String element) {
        return this.element.equals(element);
    }

    public void takeHealth() {
        this.health -= 10;
    }
}
