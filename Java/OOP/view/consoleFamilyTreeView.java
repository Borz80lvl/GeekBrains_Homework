package view;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class consoleFamilyTreeView implements familyTreeView {
    @Override
    public void print(Object object) {
        System.out.println(object.toString());
    }

    @Override
    public void showMainMenu() {
        System.out.println("0 --- Выход\n");
        System.out.println("1 --- Показать семейное древо\n");
        System.out.println("2 --- Показать семейное древо из файла\n");
        System.out.println("3 --- Сохранить семейное древо в файл\n");
        System.out.println("4 --- Добавить члена семейного древа\n");

    }


}
