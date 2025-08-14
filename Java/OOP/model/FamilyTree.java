package model;
import service.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


public class FamilyTree implements Serialazable, Iterable<Person> {
    private TreeMap<String, Person> persons = new TreeMap<>();

    private List<Person> personList = new ArrayList<>();

    public Person findPersonByName(String name) {
        return persons.get(name);
    }

    public TreeMap<String, Person> getPersons() {
        return persons;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void addPerson(Person person) {
        personList.add(person);
        persons.put(person.getName(), person);
    }

    public ArrayList<Person> getChildren(String parent) {
        return persons.get(parent).getChildren();
    }

    @Override
    public String toString() {
        return personList.toString();
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


    @Override
    public Iterator<Person> iterator() {
        return new FamilyTreeIterator(this);
    }

    public List<String> sortByName() {
        List<String> personNames = new ArrayList<>(personList.size());
        for (Person person : personList) {
            personNames.add(person.getName());
        }
        Collections.sort(personNames);
        return personNames;
    }

    public List<Person> sortByBirthYear() {
        List<Integer> dates = new ArrayList<>(personList.size());
        List<Person> result = new ArrayList<>(personList.size());
        for (Person person : personList) {
            dates.add(person.getDate()[2]);
        }
        Collections.sort(dates, Collections.reverseOrder());
        for (Integer date : dates) {
            for (Person person : personList) {
                if (date == person.getDate()[2]) result.add(person);
            }
        }
        return result;
    }
}