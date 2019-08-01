package DefiningClasses.Exercises.RowData;

public class Car {
    private String model;
    private int horsePower;
    private String cargo;
    private double firstFrontLeftTire;
    private double secondFrontRightTire;
    private double thirdBackLeftTire;
    private double fourthBackRightTire;

    public Car(String model, int horsePower, String cargo, double firstFrontLeftTire,
               double secondFrontRightTire, double thirdBackLeftTire, double fourthBackRightTire) {
        this.model = model;
        this.horsePower = horsePower;
        this.cargo = cargo;
        this.firstFrontLeftTire = firstFrontLeftTire;
        this.secondFrontRightTire = secondFrontRightTire;
        this.thirdBackLeftTire = thirdBackLeftTire;
        this.fourthBackRightTire = fourthBackRightTire;
    }

    public Car() {

    }


    public String getCargo() {
        return this.cargo;
    }


    public boolean checkPressure() {
        return firstFrontLeftTire < 1 || secondFrontRightTire < 1 || thirdBackLeftTire < 1 || fourthBackRightTire < 1;
    }

    public boolean checkPower() {
        return this.horsePower > 250;
    }
    @Override
    public String toString() {
        return this.model;
    }
}
