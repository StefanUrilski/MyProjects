package DefiningClasses.Exercises.PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        while (! line.equals("Tournament")) {
            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];

            Trainer trainer = new Trainer(trainerName);
            Pokemon pokemon = new Pokemon(tokens[1], tokens[2], Integer.valueOf(tokens[3]));

            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).getPokemons().add(pokemon);

            line = reader.readLine();
        }

        line = reader.readLine();

        while (!line.equals("End")) {
            for (Trainer trainer : trainers.values()) {
                if (trainer.containsElement(line)) {
                    trainer.addBadge();
                } else {
                    trainer.receivePenalty();
                }
                trainer.removeTheDead();
            }

            line = reader.readLine();
        }
        trainers.entrySet().stream()
                .sorted((f, s) -> Integer.compare(s.getValue().getBadges(), f.getValue().getBadges()))
                .forEach((trainer) -> System.out.println(trainer.getValue()));

    }
}
