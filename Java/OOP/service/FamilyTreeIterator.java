package service;

import model.FamilyTree;
import model.Person;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Person> {
    private int count;
    private List<Person> personList;

    public FamilyTreeIterator(FamilyTree familyTree) {
        this.count = 0;
        this.personList = familyTree.getPersonList();
    }

    @Override
    public boolean hasNext() {
        return count < personList.size();
    }

    @Override
    public Person next() {
        if (!hasNext()) return null;
        return personList.get(count++);
    }
}