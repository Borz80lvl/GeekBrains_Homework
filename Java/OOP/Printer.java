import model.FamilyTree;
import model.Person;
import service.*;

import java.util.Iterator;

public class Printer {

    public static void main(String[] args) {
        //Task 1
        FamilyTree familyTree = new FamilyTree();
        Person john = new Person("John", new int[]{5, 6, 1996});
        Person emma = new Person("Emma", new int[]{2, 12, 2000});
        Person isabella = new Person("Isabella", new int[]{2, 12, 2010});
        isabella.setMother(emma.getName());
        isabella.setFather(john.getName());
        john.addChild(isabella);
        emma.addChild(isabella);
        familyTree.addPerson(john);
        familyTree.addPerson(emma);
        familyTree.addPerson(isabella);
        System.out.printf("Emma's and John's chils: %s\n", isabella.getName());

        //Task 2
        isabella.saveToFile();
        isabella.getFromFile();
        familyTree.saveToFile();
        familyTree.getFromFile();

        //Task 3
        Iterator<Person> familyIterator = familyTree.iterator();
        while (familyIterator.hasNext()) System.out.println(familyIterator.next());
        System.out.println("Сортировка по имени:\n");
        System.out.printf("Before: %s\n", familyTree);
        System.out.printf("After: %s\n\n", familyTree.sortByName());
        System.out.println("Сортировка по году рождения:\n");
        System.out.printf("Before: %s\n", familyTree);
        System.out.printf("After %s\n", familyTree.sortByBirthYear());
    }
}
