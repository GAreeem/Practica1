package mx.edu.utez.secondapp.models.pokemon;

import mx.edu.utez.secondapp.models.user.Person;

public class Pokemon {
    private  Long id;
    private String name;
    private double ps;
    private double hp;
    private double power;
    private double weight;
    private double heigth;
    private String abilities;
    private Person person;
    private PokemonType type;

    public Pokemon() {
    }

    public Pokemon(Long id, String name, double ps, double hp, double power, double weight, double heigth, String abilities, Person person, PokemonType type) {
        this.id = id;
        this.name = name;
        this.ps = ps;
        this.hp = hp;
        this.power = power;
        this.weight = weight;
        this.heigth = heigth;
        this.abilities = abilities;
        this.person = person;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPs() {
        return ps;
    }

    public void setPs(double ps) {
        this.ps = ps;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }
}
