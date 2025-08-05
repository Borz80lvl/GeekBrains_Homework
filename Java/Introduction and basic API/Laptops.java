import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Laptops {
    //Список предпочтений пользователя
    static ArrayList<Object> userPreferences = new ArrayList<>(Arrays.asList(new Object[5]));
    //Список имеющихся ноутбуков
     private static final ArrayList<Laptop> laptops = new ArrayList<>(Arrays.asList(new Laptop(
                        "ASUS TUF A15",
                        "AMD Ryzen 9 4900H",
                        "NVIDIA GTX 1660 Ti",
                        16,1000,
                        "Windows 11"),
                        new Laptop("ASUS X551MA",
                        "Intel Celeron",
                        "Intel HD Graphics",
                        8,500,
                        "Dual Boot: LinuxMint Debian Edition и Windows 10 Домашняя x64"),
                        new Laptop("Asus TUF A15",
                        "AMD Ryzen 5 4600H",
                        "NVIDIA GTX 1650 Ti",
                        24,1000,
                        "Windows 11"),
                        new Laptop("MSI Raider GE77 HX - 12U",
                        "Intel Core i9 12400HX",
                        "NVIDIA RTX 3080 Ti",
                        64, 2000,
                        "Windows 11 Домашняя"),
                        new Laptop("Acer Nitro 5",
                        "Intel Core i5 10300H",
                        "NVIDIA GTX 1650 Ti",
                        12, 512,
                        "Windows 10 Домашняя x64"),
                        new Laptop("HP Omen",
                       "AMD Ryzen 5 5600H",
                       "AMD Radeon RX 6600 M",
                       16, 512,
                       "Windows 10 Домашняя x64"),
                        new Laptop("Lenovo Slim 3",
                       "AMD Ryzen 5 610 M",
                       "AMD Radeon RX 6600M",
                       8, 512,
                       "Windows 10 Домашняя x64"),
                       new Laptop("HONOR MagicBook X16",
                      "AMD Ryzen 5 7640HS",
                      "AMD Radeon 760 M",
                      16, 512,
                      "Windows 11 Домашняя"),
                      new Laptop("HONOR MagicBook X16 Plus",
                      "AMD Ryzen 7 8845HS",
                      "AMD Radeon 780 M",
                      32, 1000,
                      "Windows 11 Home"),
                      new Laptop("VANWIN",
                      "AMD Ryzen 7 6800H",
                      "AMD Radeon 680 M",
                      16, 512,
                      "Windows 11 Pro"),
                      new Laptop("Ninkear Tuf-Book A15 Pro",
                      "AMD Ryzen 5 7430U",
                      "AMD Radeon 660 M",
                      16, 512,
                      "Windows 11 Pro"),
                      new Laptop("IRBIS Blizzard",
                      "AMD Ryzen 5 6600H",
                      "AMD Radeon RX 6650 M",
                      16, 512,
                      "Windows 11 Home"),
                      new Laptop("Romilia",
                      "AMD Ryzen 7 7840S",
                      "AMD Radeon 780 1M",
                      32, 1024,
                      "Windows 11 Pro"),
                      new Laptop("HP Laptop",
                      "AMD Athlon 300U",
                      "AMD Radeon 530",
                      8, 256,
                      "Windows 10")));

     /*
     Функция для получения предпочтений пользователя
     в терминал будет выводиться цифры и рядом критерии которые соответствуют этим цифрам
      */
    private static ArrayList<Object> getUserPreferences() {
        // Переменная для хранения цифр которые пользователь еще не ввел
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4"));
        //Переменная для хранения критерий которые пользователь еще не ввел
        ArrayList<String> parts = (ArrayList<String>) Laptop.parts.clone();
        //Сканер для получения данных от пользователя
        Scanner scanner;
        while (true) {
            //Если список цифр пустой значит пользователь уже выбрал все критерии
            if (numbers.isEmpty()) {
                return userPreferences;
            }
            //Вывод критериев
            System.out.println("Введите цифру соответствующую необходимому критерию:\n");
            System.out.println("0 - Выход\n");
            for (int i = 1; i < numbers.size(); i++) {
                System.out.printf("%s - %s\n", numbers.get(i), parts.get(i));
            }
            scanner = new Scanner(System.in);
            //Цифра/Число пользователя которое должно соответствовать одному из критериев
            if (scanner.hasNextInt()) {
                int userNumber = scanner.nextInt();
                //Если пользователь ввел 0, то возвращаем его предпочтения
                if (userNumber == 0) {
                    scanner.close();
                    return userPreferences;
                    //Если пользователь ввел корректную цифру
                } else if (userNumber <= 4 && userNumber > 0) {
                    switch (userNumber) {
                        //1 - это процессор
                        case 1:
                            //Если пользователь еще не выбирал процессор
                            if (numbers.stream().filter(str -> str.equals("1")).count() == 1) {
                                //Убираем цифру 1
                                numbers.remove("1");
                                //Убираем критерий - Процессор
                                parts.remove(Laptop.parts.get(1));
                                System.out.println("В наличии только ноутбуки с процессорами:\nAMD Ryzen/AMD Athlon и Intel Core");
                                System.out.println("Введите предпочитаемый процессор: ");
                                scanner = new Scanner(System.in);
                                if (scanner.hasNextLine()) {
                                    String userCPU = scanner.nextLine();
                                    //Назначаем предпочитаемый процессор в предпочтениях пользователя
                                    userPreferences.set(1, userCPU);
                                }
                            }
                            break;
                        //2 - это видеокарта
                        case 2:
                            //Если пользователь еще не выбирал видеокарту
                            if (numbers.stream().filter(str -> str.equals("2")).count() == 1) {
                                //Убираем цифру 2
                                numbers.remove("2");
                                //Убираем критерий - Видеокарта
                                parts.remove(Laptop.parts.get(2));
                                System.out.println("В наличии только ноутбуки с видеокартами:\nNVIDIA RTX/GTX/GT и AMD Radeon RX и RN");
                                System.out.println("Введите предпочитаемую видеокарту: ");
                                scanner = new Scanner(System.in);
                                if (scanner.hasNextLine()) {
                                    String userGPU = scanner.nextLine();
                                    //Назначаем предпочитаемую видеокарту в предпочтениях пользователя
                                    userPreferences.set(2, userGPU);
                                }
                            }
                            break;
                        //3 - это оперативная память
                        case 3:
                            //Если пользователь еще не выбирал оперативную память
                            if (numbers.stream().filter(str -> str.equals("3")).count() == 1) {
                                //Убираем цифру 3
                                numbers.remove("3");
                                //Убираем критерий - Оперативная память
                                parts.remove(Laptop.parts.get(3));
                                System.out.println("Введите предпочитаемое количество оперативной памяти: ");
                                if (scanner.hasNextInt()) {
                                    int userRAM = scanner.nextInt();
                                    //Назначаем предпочитаемый объем оперативной памяти в предпочтениях пользователя
                                    userPreferences.set(3, userRAM);
                                }
                            }
                            break;
                        //4 - это объем памяти
                        case 4:
                            //Если пользователь еще не выбирал объем памяти
                            if (numbers.stream().filter(str -> str.equals("4")).count() == 1) {
                                //Убираем цифру 4
                                numbers.remove("4");
                                //Убираем критерий - Объем памяти
                                parts.remove(Laptop.parts.get(4));
                                System.out.println("Введите предпочитаемое количество объема жесткого диска: ");
                                if (scanner.hasNextInt()) {
                                    int userStorage = scanner.nextInt();
                                    //Назначаем предпочитаемый объем памяти в предпочтениях пользователя
                                    userPreferences.set(4, userStorage);
                                }
                            }
                            break;
                    }
                }
            }
        }
    }
    public static void printUserPreferredLaptops() {
        //Список ноутбуков которые подходят под фильтры пользователя
        ArrayList<Laptop> preferredLaptops = new ArrayList<>();
        //Переменная хранящая предпочтения пользователя
        ArrayList<Object> preferences = Laptops.getUserPreferences();
        for (Laptop laptop : laptops) {
            if (laptop.CPU != null && laptop.GPU != null && laptop.RAM != null) {
                //Процессор подходящий под предпочтения пользователя
                Integer preferredCPU = laptop.compareCPU((String) preferences.get(1));
                //Видеокарта подходящая под предпочтения пользователя
                Integer preferredGPU = laptop.compareGPU((String) preferences.get(2));
                //Количество оперативной памяти подходящее под предпочтения пользователя
                Integer preferredRAM = null;
                if (preferences.get(3) != null) {
                    //Количество оперативной памяти подходящее под предпочтения пользователя
                    preferredRAM = Integer.compare(laptop.RAM, (Integer) preferences.get(3));
                }
                //Объем памяти подходящий под предпочтения пользователя
                Integer preferredStorage = null;
                if (preferences.get(4) != null) {
                    //Объем памяти подходящий под предпочтения пользователя
                    preferredStorage = Integer.compare(laptop.Storage, (Integer) preferences.get(4));
                }
                //Все комплектующие подходящие под предпочтения пользователя
                ArrayList<Integer> preferredParts = new ArrayList<>(Arrays.asList(
                        0, preferredCPU, preferredGPU, preferredRAM, preferredStorage));
                //Индексы всех комплектующих
                ArrayList<Integer> indexes = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
                //Находим индексы с null значениями и исключаем их из индексов
                for (int i = 1; i < preferences.size(); i++) {
                    if (preferences.get(i) == null) {
                        indexes.remove((Integer) i);
                    }
                }
                if (!indexes.isEmpty()) {
                    //Если количество подходящих под критерии пользователя комплектующих столько же сколько и индексов
                    if (indexes.stream().filter(i -> preferredParts.get(i) != null && preferredParts.get(i) >= 0).count() == indexes.size()) {
                        preferredLaptops.add(laptop);
                    }
                } else {
                    preferredLaptops.add(laptop);
                }

            }
        }
        for (Laptop laptop : preferredLaptops) {
            laptop.getInfo();
        }
    }


}