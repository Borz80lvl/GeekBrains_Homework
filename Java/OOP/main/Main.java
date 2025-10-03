package main;

import model.familyTree;
import model.Person;
import presenter.*;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        //Task 1
        System.out.println("\n====== Task 1 ======");
        familyTree<Person> familyTree = new familyTree<>();
        Person john = new Person("John", 1996);
        Person emma = new Person("Emma", 2000);
        Person isabella = new Person("Isabella", 2010);
        isabella.setMother(emma.getFirstName());
        isabella.setFather(john.getFirstName());
        john.addChild(isabella);
        emma.addChild(isabella);
        familyTree.addMember(john);
        familyTree.addMember(emma);
        familyTree.addMember(isabella);
        System.out.printf("Emma's and John's children: %s\n", isabella.getFirstName());

        //Task 2
        System.out.println("\n====== Task 2 ======\n");
        isabella.saveToFile();
        isabella.getFromFile();
        familyTree.saveToFile();
        familyTree.getFromFile();

        //Task 3
        System.out.println("\n====== Task 3 ======");
        Iterator<Person> familyIterator = familyTree.iterator();
        while (familyIterator.hasNext()) System.out.println(familyIterator.next());
        System.out.println("\nСортировка по имени:");
        System.out.printf("До: %s\n", familyTree);
        System.out.printf("После: %s\n\n", familyTree.sortByName());
        System.out.println("Сортировка по году рождения:");
        System.out.printf("До: %s\n", familyTree);
        System.out.printf("После: %s\n", familyTree.sortByBirthYear());

        //Task 4
        System.out.println("\n====== Task 4 ======");
        consoleFamilyTreePresenter<Person> presenter = new consoleFamilyTreePresenter<>();
        presenter.start();

    }
}
