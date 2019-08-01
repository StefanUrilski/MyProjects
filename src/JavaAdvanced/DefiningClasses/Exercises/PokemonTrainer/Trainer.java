package DefiningClasses.Exercises.PokemonTrainer;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private int badges;
    private ArrayList<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public ArrayList<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public int getBadges() {
        return badges;
    }

    public void addBadge() {
        this.badges++;
    }

    public boolean containsElement(String element) {
        for (Pokemon p : pokemons) {
            if (p.checkElement(element)) {
                return true;
            }
        }
        return false;
    }

    public void receivePenalty() {
        for (Pokemon p : pokemons) {
            p.takeHealth();
        }
    }

    public void removeTheDead() {
        pokemons.removeIf(Pokemon::isDead);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", name, badges, pokemons.size());
    }
}
