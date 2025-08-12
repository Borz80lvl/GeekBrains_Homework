import task2.*;


public class Printer {

    public static void main(String[] args) {
        //Task 1
        FamilyTree familyTree = new FamilyTree();
        Person john = new Person("John", new int[]{5, 6, 2000});
        Person emma = new Person("Emma", new int[]{2, 12, 1996});
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
    }
}
