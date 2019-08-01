package Exam.DemoExam.second.softUniParking;

public class Car {
    private String make;
    private String model;
    private int horsePower;
    private String registrationNumber;

    public Car(String make, String model, int horsePower, String registrationNumber) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    @Override
    public String toString() {
        return  "Make: " + this.make + System.lineSeparator() +
                "Model: " + this.model + System.lineSeparator() +
                "HorsePower: " + this.horsePower + System.lineSeparator() +
                "RegistrationNumber: " + this.registrationNumber;
    }

}
