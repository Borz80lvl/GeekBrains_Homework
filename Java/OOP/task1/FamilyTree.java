package task1;

import java.util.ArrayList;
import java.util.TreeMap;

public class FamilyTree {
    private TreeMap<String, Person> persons = new TreeMap<>();

    public Person findPersonByName(String name) {
        return persons.get(name);
    }

    public TreeMap<String, Person> getPersons() {
        return persons;
    }
    public void addPerson(Person person) {
        persons.put(person.getName(), person);
    }

    public ArrayList<Person> getChildren(String parent) {
        return persons.get(parent).getChildren();
    }
}