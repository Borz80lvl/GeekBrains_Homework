package model;


import java.io.*;
import java.util.ArrayList;


public class Person extends Member implements Serializable {

    private String firstname = super.firstName;
    private int birthYear = super.birthYear;
    private String mother;
    private String father;
    private ArrayList<Person> children = new ArrayList<>();

    @Override
    public String toString() {
        return this.firstName;
    }

    public Person(String firstName, int birthYear) {
        this.firstName = firstName;
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public String getMother() {
        return mother;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }


    public void setMother(String mother) {
        this.mother = mother;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getFather() {
        return father;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }


    public Object getFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(this.firstName))) {
            return inputStream.readObject();
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }


    public void saveToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(this.firstName))) {
            outputStream.writeObject(this);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
