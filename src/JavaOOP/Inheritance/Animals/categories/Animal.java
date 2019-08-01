package JavaOOP.Inheritance.Animals.categories;

public class Animal {
    private final String INVALID_INPUT_MESSAGE = "Invalid input!";
    private final String SONG_MESSAGE = "Not implemented!";
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        this.age = age;
    }

    private void setGender(String gender) {
        if (!(gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Male"))) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        this.gender = gender;
    }

    public String produceSound(){
        return SONG_MESSAGE;
    }

}