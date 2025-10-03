package presenter;

import view.*;
import model.*;

import java.util.Scanner;


public class consoleFamilyTreePresenter<T extends Member> {

    familyTree<T> familyTree = new familyTree<>();

    public void showTree() {
        System.out.println(this.familyTree.toString());
    }

    public void showTreeFromFile() {
        System.out.println(this.familyTree.getFromFile().toString());
    }


    public void showMember(T member) {
        System.out.println(this.familyTree.getMember(member));
    }


    public void showMemberFromFile(T member) {
        showMember(this.familyTree.getFromFile().getMember(member));
    }

    public void addMember(T member) {
        this.familyTree.addMember(member);
    }

    public int start() {
        Scanner userInput;
        consoleFamilyTreeView view = new consoleFamilyTreeView();
        int userNumber;
        while (true) {
            view.showMainMenu();
            userInput = new Scanner(System.in);
            if (userInput.hasNextInt()) {
                userNumber = userInput.nextInt();
                switch (userNumber) {
                    case 0:
                        return 0;
                    case 1:
                        showTree();
                        break;
                    case 2:
                        showTreeFromFile();
                        break;
                    case 3:
                        this.familyTree.saveToFile();
                        System.out.println("Семейное древо сохранено.");
                        break;
                    case 4:
                        String firstName;
                        int birthYear;
                        String otherInformation;
                        Member member = new Member();
                        System.out.println("Введите имя члена семейного древа: ");
                        if (userInput.hasNext()) {
                            firstName = userInput.next();
                            member.setFirstName(firstName);
                        }
                        userInput.reset();
                        System.out.println("Введите год рождения: ");
                        if (userInput.hasNextInt()) {
                            birthYear = userInput.nextInt();
                            member.setBirthYear(birthYear);
                        }
                        userInput.reset();
                        System.out.println("Введите доп. информацию о члене семейного древа: ");
                        if (userInput.hasNext()) {
                            otherInformation = userInput.next();
                            member.setOtherInformation(otherInformation);
                        }
                        this.familyTree.addMember((T) member);
                        System.out.println("Член семейного древа добавлен.");
                        break;
                }
            }
        }
    }
}
