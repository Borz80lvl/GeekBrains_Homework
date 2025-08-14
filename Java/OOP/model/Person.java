package model;

import service.Serialazable;

import java.io.*;
import java.util.ArrayList;


public class Person implements Serialazable {


    private String name;
    //DD:MM:YYYY
    private final int[] date;
    private String mother;
    private String father;
    private ArrayList<Person> children = new ArrayList<>();

    @Override
    public String toString() {
        return this.name;
    }

    public Person(String name, int[] date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int[] getDate() {
        return date;
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


    @Override
    public Object getFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(name))) {
            return inputStream.readObject();
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }


    @Override
    public void saveToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(name))) {
            outputStream.writeObject(this);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
