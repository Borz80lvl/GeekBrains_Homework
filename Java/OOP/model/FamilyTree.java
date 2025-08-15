package model;
import service.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


public class FamilyTree<T> implements Serialazable, Iterable<T> {

    private final List<T> unknowns = new ArrayList<>();


    public List<T> getUnknowns() {
        return unknowns;
    }

    public void addUnknown(T unknown) {
        unknowns.add(unknown);
    }



    @Override
    public String toString() {
        return unknowns.toString();
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
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(unknowns);
    }
}