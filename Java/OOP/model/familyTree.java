package model;

import java.io.*;
import java.util.*;


public class familyTree<T extends Member> implements Serializable, Iterable<T> {

    private final List<T> members = new ArrayList<>();


    public List<T> getMembers() {
        return members;
    }

    public void addMember(T member) {
        members.add(member);
    }

    public T getMember(T member) {
        return this.members.get(members.indexOf(member));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Family Tree Members = {\n");
        for (int i = 0; i < members.size(); i++) {
            stringBuilder.append(members.get(i).toString()).append(", ");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 2).append("\n}").toString();
    }

    public familyTree<T> getFromFile() {
        try (FileInputStream fileInputStream = new FileInputStream("familyTree");
             ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)) {
            return (familyTree<T>) inputStream.readObject();
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
            return null;
        }
    }


    public void saveToFile() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("familyTree");
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {
            outputStream.writeObject(this);
            outputStream.flush();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public List<String> sortByName() {
        List<String> personNames = new ArrayList<>(members.size());
        for (T member : members) {
            personNames.add(member.getFirstName());
        }
        Collections.sort(personNames);
        return personNames;
    }


    public List<T> sortByBirthYear() {
        List<Integer> dates = new ArrayList<>(members.size());
        List<T> result = new ArrayList<>(members.size());
        for (T member : members) {
            dates.add(member.getBirthYear());
        }
        Collections.sort(dates, Collections.reverseOrder());
        for (Integer date : dates) {
            for (T member : members) {
                if (date == member.getBirthYear()) result.add(member);
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new familyTreeIterator<>(members);
    }
}