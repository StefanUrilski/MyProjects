package Exam.DemoExam.second.softUniParking;

public class Parking {
    /*
    private Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.capacity = capacity;
        this.cars = new HashMap<>();
    }

    public String addCar(Car car) {
        String result = "";
        if (this.cars.containsKey(car.getRegistrationNumber())) {
            result = "Car with that registration number, already exists!";
        } else if (this.cars.size() == capacity) {
            result = "Parking is full!";
        } else {
            this.cars.put(car.getRegistrationNumber(), car);
            result = String.format("Successfully added new car %s %s", car.getMake(), car.getRegistrationNumber());
        }
        return result;
    }

    public String removeCar(String registrationNumber) {
        String result = "";
        if (!this.cars.containsKey(registrationNumber)) {
            result = "Car with that registration number, doesn't exists!";
        } else {
            this.cars.remove(registrationNumber);
            result = "Successfully removed " + registrationNumber;
        }
        return result;
    }

    public Car getCar(String registrationNumber) {
        return this.cars.get(registrationNumber);
    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers) {
        for (String number : registrationNumbers) {
            removeCar(number);
        }
    }

    public int getCount() {
        return this.cars.size();
    }
    */
}
