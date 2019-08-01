package DefiningClasses.Exercises.Google;

import java.util.ArrayList;

public class Person {
    private String name;
    private Company company;
    private ArrayList<Pokemon> pokemon;
    private ArrayList<Parent> parents;
    private ArrayList<Children> children;
    private Car car;


    public Person(String name) {
        this.name = name;
        this.pokemon = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return this.company;
    }

    public String getName(){
        return this.name;
    }
    public ArrayList<Pokemon> getPokemon() {
        return this.pokemon;
    }

    public ArrayList<Parent> getParents() {
        return this.parents;
    }

    public ArrayList<Children> getChildren() {
        return this.children;
    }

}
