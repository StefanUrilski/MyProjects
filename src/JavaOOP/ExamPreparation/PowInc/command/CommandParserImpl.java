package JavaOOP.ExamPreparation.PowInc.command;

import JavaOOP.ExamPreparation.PowInc.MessageWriter;
import JavaOOP.ExamPreparation.PowInc.repository.Repository;

public class CommandParserImpl {
    private Repository repository;

    public CommandParserImpl() {
        this.repository = new Repository();
    }

    public void execute(String input) {
        String[] tokens = input.split("[|\\s]+");
        String command = tokens[0];

        switch (command) {
            case "RegisterCleansingCenter":
                RegisterCleansingCenter cleansingCenter = new RegisterCleansingCenter();
                cleansingCenter.execute(tokens, this.repository.getCleansingCenter());
                break;
            case "RegisterAdoptionCenter":
                RegisterAdoptionCenter adoptionCenter = new RegisterAdoptionCenter();
                adoptionCenter.execute(tokens, this.repository.getAdoptionCenter());
                break;
            case "RegisterCastrationCenter":
                RegisterCastrationCenter registerCastrationCenter = new RegisterCastrationCenter();
                registerCastrationCenter.execute(tokens, this.repository.getCastrationCenter());
                break;
            case "RegisterDog":
                RegisterDog registerDog = new RegisterDog();
                registerDog.execute(tokens, this.repository.getAdoptionCenter());
                break;
            case "RegisterCat":
                RegisterCat registerCat = new RegisterCat();
                registerCat.execute(tokens, this.repository.getAdoptionCenter());
                break;
            case "SendForCleansing":
                SendForCleansing send = new SendForCleansing();
                send.execute(tokens, this.repository.getAdoptionCenter(), this.repository.getCleansingCenter());
                break;
            case"SendForCastration":
                SendForCastration sendForCastration = new SendForCastration();
                sendForCastration.execute(tokens, this.repository.getAdoptionCenter(), this.repository.getCastrationCenter());
                break;
            case "Cleanse":
                CleanseAnimals cleanseAnimals = new CleanseAnimals();
                cleanseAnimals.execute(tokens[1], this.repository.getCleansingCenter(), this.repository.getAdoptionCenter());
                break;
            case "Castrate":
                CastrateAnimals castrateAnimals = new CastrateAnimals();
                castrateAnimals.execute(tokens[1], this.repository.getCastrationCenter(), this.repository.getAdoptionCenter());
                break;
            case "Adopt":
                this.repository.getAdoptionCenter().get(tokens[1]).adopted();
                break;
            case "CastrationStatistics":
                MessageWriter writer = new MessageWriter();
                writer.write(castrationStatisticsInfo());
                break;
            case "Paw":
                MessageWriter messageWriter = new MessageWriter();
                messageWriter.write(pawPawPawahInfo());
                break;
        }
    }

    private String castrationStatisticsInfo() {
        return  "Paw Inc. Regular Castration Statistics" + System.lineSeparator() +
                "Castration Centers: " + this.repository.castrationCenterCount() + System.lineSeparator() +
                "Castrated Animals: " + this.repository.castratedAnimalsNames();
    }

    private String pawPawPawahInfo() {
        return  "Paw Incorporative Regular Statistics" + System.lineSeparator() +
                "Adoption Centers: " + this.repository.adoptionCenterCount() + System.lineSeparator() +
                "Cleansing Centers: " + this.repository.cleansingCenterCount() + System.lineSeparator() +
                "Adopted Animals: " + this.repository.adoptedAnimalsNames() + System.lineSeparator() +
                "Cleansed Animals: " + this.repository.cleansedAnimalsNames() + System.lineSeparator() +
                "Animals Awaiting Adoption: " + this.repository.awaitingAdoptionCount() + System.lineSeparator() +
                "Animals Awaiting Cleansing: " + this.repository.awaitingCleansingCount();

    }
}
