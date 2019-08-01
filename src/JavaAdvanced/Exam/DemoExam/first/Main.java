package Exam.DemoExam.first;

import java.util.HashMap;

class Repository {
    private int accountsCount = 0;
    private Person person;

    private HashMap<Integer, Person> repository;

    public Repository() {
        this.repository = new HashMap<>();
    }

    public void add(Person person) {
        this.repository.put(this.accountsCount++, person);
    }

    public Person get(int id) {
        return this.repository.get(id);
    }

    public boolean update(int id, Person newPerson) {
        if (this.repository.containsKey(id)) {
            this.repository.replace(id, newPerson);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        if (this.repository.containsKey(id)) {
            this.repository.remove(id);
            return true;
        }
        return false;
    }

    public int getCount() {
        return this.repository.size();
    }
}
class Person {
    private String name;
    private int age;
    private String birthDate;

    public Person(String name, int age, String birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return  "Name: " + this.name + System.lineSeparator() +
                "Age: " + this.age + System.lineSeparator() +
                "Birthday: " +  this.birthDate + System.lineSeparator();
    }
}
public class Main {
    public static void main(String[] args) {

        //Initialize the repository
        Repository repository = new Repository();

        //Initialize Person
        Person person = new Person("Pesho", 14, "13-07-2004");

        //Add two JavaOOP.Exam.MortalEngines.entities
        repository.add(person);

        //Initialize second Person object
        Person secondPerson = new Person("Gosho", 42, "21-09-1976");
        repository.add(secondPerson);

        System.out.println(repository.get(0).toString());
        //Name: Pesho
        //Age: 14
        //Birthday: 13-07-2004

        System.out.println(repository.get(1).toString());
        //Name: Gosho
        //Age: 42
        //Birthday: 21-09-1976


        //Update person with id 1
        repository.update(1, new Person("Success", 20, "01-01-1999"));

        System.out.println(repository.get(1).toString());
        //Name: Success
        //Age: 20
        //Birthday: 01-01-1999

        //Delete entity
        repository.delete(0);

        System.out.println(repository.getCount());
        //1

    }
}