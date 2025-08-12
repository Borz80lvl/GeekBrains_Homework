package task2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.TreeMap;

public class FamilyTree implements Serialazable {
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

    @Override
    public Object getFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("familyTree"))) {
            return inputStream.readObject();
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }


    @Override
    public void saveToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("familyTree"))) {
            outputStream.writeObject(this);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}