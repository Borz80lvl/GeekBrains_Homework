package task1;

import java.util.ArrayList;

public class Person {


    private String name;
    //DD:MM:YYYY
    private final int[] date;
    private String mother;
    private String father;
    private ArrayList<Person> children = new ArrayList<>();


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
}
