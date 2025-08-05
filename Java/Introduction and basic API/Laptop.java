import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Laptop {
    // !!! К сожалению Macbook пока невключительны !!!
    public static final ArrayList<String> parts = new ArrayList<>(Arrays.asList(
            "Модель",
            "Процессор",
            "Видеокарта",
            "Оперативная память",
            "Объем памяти",
            "Операционная система"));
    String name;
    //Модель процессора ноутбука типа - "<Бренд> <Линейка> <Поколение> <Серия>"
    //Примеры:
    // AMD Ryzen 9 4600
    // Intel Core i5 12400F

    // !!! У AMD ТОЛЬКО ЛИНЕЙКА Ryzen И Athlon,У Intel ТОЛЬКО ЛИНЕЙКА Core !!!

    // !!! МАРКИРОВКИ ПРОЦЕССОРОВ НЕВКЛЮЧИТЕЛЬНЫ И МОЖНО ПИСАТЬ СЛИТНО С СЕРИЕЙ !!!

    String CPU;
    //Модель видеокарты типа - "<Бренд> <Линейка> <ПоколениеСерия>/<Серия> <ПоколениеСерия> <Маркировка>"
    //Серии и маркировки пишутся отдельно через пробел, если маркировок больше одной, то
    //все маркировки пишутся слитно НО все равно отдельно от серии
    //Бренд и линейки нужно писать так как в примерах ниже и никак иначе
    //Примеры:
    // NVIDIA GTX 1660
    // NVIDIA GTX 1660 Ti/OC/Super
    // AMD Radeon RX 6600
    // AMD Radeon RX 6600 XT
    // AMD Radeon 610
    // AMD Radeon R9 M290 X
    // AMD Radeon R7 M370
    // AMD Radeon RX 6850 MXT

    // !!! ВИДЕОКАРТЫ Intel, AMD FireFox,Pro И Vega И NVIDIA TITAN И MX НЕВКЛЮЧИТЕЛЬНЫ !!!

    // !!! У NVIDIA ТОЛЬКО СЕРИИ GTX, RTX И GT, А У AMD только RX,R2,R4,R7,R9 И ТИПА AMD Radeon 530 и похожие !!!

    String GPU;
    //Оперативная память в Гигабайтах
    Integer RAM;
    //Объем памяти в Гигабайтах
    Integer Storage;
    //Операционная система
    String OS;
    //Характеристики ноутбука в виде словаря/Map
    final HashMap<String, Object> configuration = new HashMap<>(5);

    public Laptop(String name, String CPU, String GPU, Integer RAM, Integer Storage, String OS) {
        //Присваиваем имя именно этому ноутбуку
        this.name = name;
        //Добавляем в его словарь значение имени его модели с ключом Имя
        this.configuration.put("Name", name);
        //Переменная для хранения корректности имени модели процессора/видеокарты
        boolean isValid = false;
        //Если в названии модели 3 пробела(Это значит, что название модели правильное)
        if (CPU.chars().filter(ch -> ch == ' ').count() == 3 && CPU.split(" ").length == 4) {
            //Имя процессора в виде массива строк
            String[] CPUname = CPU.split(" ");
            //Если это процессор Intel
            //Если после Intel идет слово Core и после слова Core идет первым буква i
            if (CPU.startsWith("Intel") && CPUname[1].equals("Core") && CPUname[2].charAt(0) == 'i') {
                //Если длина слова которое идет после Core равна 2
                if (CPUname[2].length() == 2) {
                    //Проверка цифра ли идет после буквы i
                    if (Character.isDigit(CPUname[2].charAt(1))) {
                        //Проверка правильно ли введено поколение процессора Intel
                        if ("3579".chars().filter(ch -> ch == CPUname[2].charAt(1)).count() == 1) {
                            //Если символы с 1 по 4 цифры
                            if (CPUname[3].substring(0, 4).chars().filter(Character::isDigit).count() == 4) {
                                isValid = true;
                            }
                        }
                    }
                }
                //Если после бренда Ryzen идет слово Athlon или Ryzen
            } else if (CPU.startsWith("AMD") && (CPUname[1].equals("Athlon") || CPUname[1].equals("Ryzen"))) {
                //Если символ после линейки цифра и она корректная
                if (Character.isDigit(CPUname[2].charAt(0))) {
                    if ("3579".chars().filter(ch -> ch == CPUname[2].charAt(0)).count() == 1) {
                        //Если символы с 1 по 4 цифры
                        if (CPUname[3].substring(0, 4).chars().filter(Character::isDigit).count() == 4) {
                            isValid = true;
                        }
                    }
                }
            }
        }
        if (isValid) {
            this.CPU = CPU;
            this.configuration.put("CPU", CPU);
        } else {
            this.CPU = null;
            this.configuration.put("CPU", null);
        }
        //Изменяем значение переменной для проверки корректности имени модели видеокарты
        isValid = false;
        if (GPU.chars().filter(ch -> ch == ' ').count() >= 2) {
            if (GPU.split(" ").length >= 3) {
                //Переменная хранящая модель видеокарты в виде массива строк
                String[] GPUname = GPU.split(" ");
                //Если имя модели видеокарты начинается с NVIDIA, а после бренда идет слово RTX, GTX или GT
                if (GPU.startsWith("NVIDIA") && (GPUname[1].equals("RTX") || GPUname[1].equals("GTX") || GPUname[1].equals("GT"))) {
                    //Если поколение и серия корректны и являются цифрами
                    if (GPUname[2].chars().filter(Character::isDigit).count() == 4) {
                        //Если приписки нет
                        if (GPUname.length == 3) isValid = true;
                        //Если приписка есть
                        else if (GPUname.length == 4) {
                            //Если приписка корректна
                            if (GPUname[3].equals("Super") || GPUname[3].equals("Ti") || GPUname[3].equals("OC")) {
                                isValid = true;
                            }
                        }
                    }
                //Если после бренда AMD идет линейка Radeon
                } else if (GPU.startsWith("AMD") && GPUname[1].equals("Radeon")) {
                    //Если это не поколения RX и RN
                    if (!GPUname[2].equals("RX") && GPUname[2].charAt(0) != 'R') {
                        if (GPUname[2].chars().filter(Character::isDigit).count() == GPUname[2].length()) {
                            if (GPUname.length == 3 || GPUname.length == 4) isValid = true;
                        }
                    } else if (!GPUname[2].equals("RX") && GPUname[2].charAt(0) == 'R') {
                        if (Character.isDigit(GPUname[2].charAt(1)) && GPUname.length == 4 && GPUname[2].length() == 2) {
                            if ("24579".chars().filter(ch -> ch == GPUname[2].charAt(1)).count() == 1) {
                                if (GPUname[3].charAt(0) == 'M') {
                                    if (GPUname[3].substring(1).chars().filter(Character::isDigit).count() == 3) {
                                        isValid = true;
                                    }
                                }
                            }
                        }
                    } else if (GPUname[2].equals("RX")) {
                        if (GPUname.length >= 4) {
                            if (GPUname[3].chars().filter(Character::isDigit).count() == GPUname[3].length()) {
                                isValid = true;
                            }
                        }
                    }
                }
            }
        }
        if (isValid) {
            this.GPU = GPU;
            this.configuration.put("GPU", GPU);
        } else {
            this.GPU = null;
            this.configuration.put("GPU", null);
        }
        if (RAM <= 128) {
            this.RAM = RAM;
            this.configuration.put("RAM", RAM);
        } else {
            this.RAM = null;
            this.configuration.put("RAM", null);
        }
        this.Storage = Storage;
        this.configuration.put("Storage", Storage);
        this.OS = OS;
        this.configuration.put("OS", OS);


    }

    @Override
    public String toString() {
        StringBuilder laptop = new StringBuilder();
        laptop.append(String.format("%s --- %s\n", parts.getFirst(), name));
        laptop.append(String.format("%s --- %s\n", parts.get(1),CPU));
        laptop.append(String.format("%s --- %s\n", parts.get(2),GPU));
        laptop.append(String.format("%s --- %dGb\n", parts.get(3),RAM));
        laptop.append(String.format("%s --- %dGb\n", parts.get(4),Storage));
        laptop.append(String.format("%s --- %s\n", parts.get(5),OS));
        return laptop.toString();
    }

    public void getInfo() {
        System.out.println(this.toString());
    }


    /*
    Метод для сравнения процессоров
    Все почти как в Integer.compare():
    -1 --- сравниваемый процессор слабее, а введенный мощнее
     0 --- сравниваемый процессор и введенный одинаковы
     1 --- сравниваемый мощнее, а введенный слабее
     и null если сравнить не получится
     */
    public Integer compareCPU(String CPU) {
        if (CPU == null) return null;
        //Если введенный процессор вовсе и не процессор
        if (!CPU.startsWith("AMD") && !CPU.startsWith("Intel")) return null;
        if (CPU.length() > 25) return null;
        if (CPU.chars().filter(ch -> ch == ' ').findAny().isPresent()) {
            if (CPU.split(" ").length > 1) {
                //Если введенный процессор Intel, но не Core
                if (CPU.startsWith("Intel")) {
                    if (!CPU.split(" ")[1].equals("Core")) return null;
                }
                //Если процессоры разные
                if (!this.CPU.split(" ")[0].equals(CPU.split(" ")[0])) return null;
            } else if (CPU.startsWith("AMD") && this.CPU.startsWith("AMD")) return 0;
            else if (CPU.startsWith("Intel") && this.CPU.startsWith("Intel")) return 0;
        }
        //Если имя модели введенного процессора просто AMD
        // или просто AMD Ryzen/AMD Athlon
        if (CPU.startsWith("AMD") && this.CPU.startsWith("AMD")) {
            //Если имя модели это состоит только из названия бренда
            if (!CPU.contains(" ")) return 0;
            //Если имя модели просто AMD Ryzen/AMD Athlon
            if (CPU.charAt(3) == ' ') {
                if (CPU.split(" ").length == 2) {
                    //Если оба процессора AMD Ryzen
                    if (CPU.split(" ")[1].equals("Ryzen") && this.CPU.split(" ")[1].equals("Ryzen")) return 0;
                    //Если оба процессора AMD Athlon
                    else if (CPU.split(" ")[1].equals("Athlon") && this.CPU.split(" ")[1].equals("Athlon")) return 0;
                    //Если сравниваемый процессор Ryzen, а введенный Athlon
                    else if (CPU.split(" ")[1].equals("Athlon") && this.CPU.split(" ")[1].equals("Ryzen")) return 1;
                } else if (CPU.trim().equals("AMD")) return 0;
            }
        //Если они оба Intel
        } else if (CPU.startsWith("Intel") && this.CPU.startsWith("Intel")) {
            if (!CPU.contains(" ")) {
                return 0;
            } else if (CPU.trim().startsWith("Intel") && CPU.trim().length() == 5) {
                return 0;
            }

        }
        //Если пробелов в имени модели введенного процессора больше или равно двум
        if (CPU.chars().filter(ch -> ch == ' ').count() >= 2) {
            if (CPU.split(" ").length >= 3) {
                //Модель сравниваемого процессора в виде массива
                String[] xCPU = this.CPU.split(" ");
                //Модель введенного процессора в виде массива
                String[] yCPU = CPU.split(" ");
                //Если они оба AMD
                if (this.CPU.startsWith("AMD") && CPU.startsWith("AMD")) {
                    //Если сравниваемый процессор Athlon а введенный Ryzen
                    if (xCPU[1].equals("Athlon") && yCPU[1].equals("Ryzen")) return -1;
                        //Если наоборот
                    else if (xCPU[1].equals("Ryzen") && yCPU[1].equals("Athlon")) return 1;
                        //Если оба процессора Athlon
                    else if (xCPU[1].equals("Athlon") && yCPU[1].equals("Athlon")) {
                        return Integer.compare(Integer.parseInt(xCPU[2]), Integer.parseInt(yCPU[2]));
                        //Если оба процессора Ryzen
                    } else {
                        //Если у введенного процессора корректное поколение
                        if (yCPU[2].length() == 1 && Character.isDigit(yCPU[2].charAt(0))) {
                            //Если цифра поколения введенного процессора корректная
                            if ("3579".chars().filter(ch -> ch == yCPU[2].charAt(0)).count() == 1) {
                                //Если поколение сравниваемого процессора меньше введенного
                                if (Integer.parseInt(xCPU[2]) < Integer.parseInt(yCPU[2])) return -1;
                                    //Если поколения процессоров равны
                                else if (Integer.parseInt(xCPU[2]) == Integer.parseInt(yCPU[2])) {
                                    //Если у введенного процессора нет серии
                                    if (yCPU.length == 3) return 0;
                                        //Если у введенного процессора есть серия
                                    else if (yCPU.length == 4) {
                                        //Если серия введенного процессора корректна
                                        if (yCPU[3].length() > 4) {
                                            //Если первые 4 символа в серии введенного процессора цифры
                                            if (yCPU[3].substring(0, 4).chars().filter(Character::isDigit).count() == 4) {
                                                return Integer.compare(Integer.parseInt(xCPU[3].substring(0, 4)), Integer.parseInt(yCPU[3]));
                                            }
                                        }
                                    }
                                    //Если поколение сравниваемого процессора больше введенного
                                } else return 1;
                            }
                        }
                    }
                    //Если оба процессора Intel
                } else if (CPU.startsWith("Intel") && this.CPU.startsWith("Intel")) {
                    //Если после линейки Core в модели процессора идет первым буква i и дальше только один символ
                    if (yCPU[2].charAt(0) == 'i' && yCPU[2].length() == 2) {
                        //Если символ после i цифра
                        if (Character.isDigit(yCPU[2].charAt(1))) {
                            if ("3579".chars().filter(ch -> ch == yCPU[2].charAt(1)).count() == 1) {
                                //Если поколение сравниваемого процессора меньше введенного
                                if (Integer.parseInt(xCPU[2].substring(1)) < Integer.parseInt(yCPU[2].substring(1)))
                                    return -1;
                                    //Если поколения процессоров равны
                                else if (Integer.parseInt(xCPU[2].substring(1)) == Integer.parseInt(yCPU[2].substring(1))) {
                                    //Если у введенного процессора нет серии
                                    if (yCPU.length == 3) return 0;
                                        //Если у введенного процессора есть серия
                                    else if (yCPU.length == 4) {
                                        //Если серия введенного процессора корректна
                                        if (yCPU[3].length() > 4) {
                                            //Если первые 4 символа в серии введенного процессора цифры
                                            if (yCPU[3].substring(0, 4).chars().filter(Character::isDigit).count() == 4) {
                                                return Integer.compare(Integer.parseInt(xCPU[3].substring(0, 4)), Integer.parseInt(yCPU[3].substring(0, 4)));
                                            }
                                        }
                                    }
                                    //Если поколение сравниваемого процессора больше введенного
                                } else return 1;
                            }
                        }
                    }
                }
            }
        }
        //Если какой-то иной случай
        return null;
    }

    /*
    Метод для сравнения видеокарт
    Все почти как в Integer.compare():
    -1 --- сравниваемая видеокарта слабее, а введенная мощнее
     0 --- сравниваемая видеокарта и введенная одинаковы
     1 --- сравниваемая видеокарта мощнее, а введенная слабее
     и null если сравнить видеокарты не получится
     */
    public Integer compareGPU(String GPU) {
        if (GPU == null) return null;
        //Если введенная видеокарта вовсе и не видеокарта
        if (!GPU.startsWith("NVIDIA") && !GPU.startsWith("AMD")) return null;
        if (GPU.contains(" ")) {
            if (GPU.length() >= 7 && GPU.startsWith("NVIDIA")) {
                if (GPU.charAt(6) == ' ') {
                    if (GPU.split(" ").length == 2) {
                        //Если видеокарты разные
                        if (!this.GPU.split(" ")[0].equals(GPU.split(" ")[0])) return null;
                        if (GPU.split(" ")[1].equals("Radeon")) return 0;
                        switch (GPU.split(" ")[1]) {
                            case "RTX":
                                if (!this.GPU.split(" ")[1].equals("RTX")) return -1;
                                return 0;
                            case "GT":
                                if (!this.GPU.split(" ")[1].equals("GT")) return 1;
                                return 0;
                            case "GTX":
                                if (this.GPU.split(" ")[1].equals("RTX")) return 1;
                                else if (this.CPU.split(" ")[1].equals("GT")) return -1;
                                return 0;
                            default:
                                return null;
                        }
                    } else if (GPU.split(" ").length == 1) {
                        if (GPU.startsWith("NVIDIA") && this.GPU.startsWith("NVIDIA")) return 0;
                        else if (GPU.startsWith("AMD") && this.GPU.startsWith("AMD")) return 0;
                    }
                }
            }
            else if (GPU.length() >= 4 && GPU.startsWith("AMD")) {
                if (GPU.charAt(3) == ' ') {
                    if (GPU.split(" ").length == 2) {
                        if (GPU.split(" ")[1].equals("Radeon") && this.GPU.startsWith("AMD")) return 0;
                    }
                    if (GPU.trim().strip().equals("AMD") && this.GPU.startsWith("AMD")) return 0;
                }
            }
        } else if (GPU.length() == 6 && GPU.startsWith("NVIDIA") && this.GPU.startsWith("NVIDIA")) return 0;
        else if (GPU.length() == 3 && GPU.startsWith("AMD") && this.GPU.startsWith("AMD")) return 0;
        //Если хоть одна из них Vega(встройка) или Pro
        if (GPU.contains("Vega") || GPU.contains("Pro") || GPU.contains("Titan")) {
            return null;
        }
        if (GPU.chars().filter(ch -> ch == ' ').count() >= 2) {
            if (GPU.split(" ").length >= 3) {
                //Модель сравниваемой видеокарты в виде массива
                String[] xGPU = this.GPU.split(" ");
                //Модель введенной видеокарты в виде массива
                String[] yGPU = GPU.split(" ");
                //Если они оба NVIDIA
                if (this.GPU.startsWith("NVIDIA") && GPU.startsWith("NVIDIA")) {
                    if (!GPU.contains(" ")) return 0;
                    //Если сравниваемая видеокарта NVIDIA серии RTX, а введенная нет
                    if (xGPU[1].equals("RTX") && !yGPU[1].equals("RTX")) return 1;
                        //Если введенная видеокарта NVIDIA серии RTX, а сравниваемая нет
                    else if (yGPU[1].equals("RTX") && !xGPU[1].equals("RTX")) return -1;
                    //Если сравниваемая видеокарта NVIDIA серии GTX, а введенная GT
                    if (xGPU[1].equals("GTX") && yGPU[1].equals("GT")) return 1;
                        //Если наоборот
                    else if (yGPU[1].equals("GTX") && xGPU[1].equals("GT")) return -1;
                    //Если серии видеокарт равны
                    if (xGPU[1].equals(yGPU[1])) {
                        //Сравниваем поколения и серии
                        switch (Integer.compare(Integer.parseInt(xGPU[2]), Integer.parseInt(yGPU[2]))) {
                            //Введенная видеокарта мощнее
                            case -1:
                                return -1;
                            //Поколения и серии видеокарт одинаковые, сравниваем маркировки
                            case 0:
                                //Если маркировок нет
                                if (yGPU.length == 3) return 0;
                                //Если маркировки есть
                                if (yGPU.length == 4) {
                                    //Если маркировка сравниваемой видеокарты Super, а введенной нет
                                    if (xGPU[3].equals("Super") && !yGPU[3].equals("Super")) return 1;
                                        //Если маркировка введенной видеокарты Super, а сравниваемой нет
                                    else if (yGPU[3].equals("Super") && !xGPU[3].equals("Super")) return -1;
                                        //Если маркировка сравниваемой видеокарты Ti, а введенной OC
                                    else if (xGPU[3].equals("Ti") && yGPU[3].equals("OC")) return 1;
                                        //Если наоборот
                                    else if (yGPU[3].equals("Ti") && xGPU[3].equals("OC")) return -1;
                                        //Если маркировки равны
                                    else if (xGPU[3].equals(yGPU[3])) return 0;
                                }
                                //Если поколение и серия введенной видеокарты больше сравниваемой
                            case 1:
                                return 1;
                        }
                    }
                    //Если обе видеокарты AMD
                } else if (this.GPU.startsWith("AMD") && GPU.startsWith("AMD")){
                    if (!GPU.contains(" ")) return 0;
                    //Если введенная видеокарта не Radeon
                    if (!GPU.contains("Radeon")) return null;
                    //Если сравниваемая видеокарта RX, а введенная нет
                    if (xGPU[2].equals("RX") && !yGPU[2].equals("RX")) return 1;
                        //Если наоборот
                    else if (!xGPU[2].equals("RX") && yGPU[2].equals("RX")) return -1;
                        //Если сравниваемая видеокарта R9 или ниже
                    else if ((!xGPU[2].equals("RX") && xGPU[2].charAt(0) == 'R') && yGPU[2].charAt(0) != 'R') return -1;
                    //Если введенная видеокарта R9 или ниже
                    if ((!yGPU[2].equals("RX") && yGPU[2].charAt(0) == 'R') && xGPU[2].charAt(0) != 'R') return 1;
                    //Если обе видеокарты без букв RX или без R7, R9 и т.д.
                    if (xGPU[2].charAt(0) != 'R' && yGPU[2].charAt(0) != 'R') {
                        //Если серия сравниваемой видеокарты больше
                        if (Integer.parseInt(xGPU[2]) > Integer.parseInt(yGPU[2])) {
                            return 1;
                            //Если наоборот
                        } else if (Integer.parseInt(xGPU[2]) < Integer.parseInt(yGPU[2])) {
                            return -1;
                            //Если они одинаковые та видеокарта у которой есть маркировка мощнее
                        } else if (Integer.parseInt(xGPU[2]) == Integer.parseInt(yGPU[2])) {
                            return Integer.compare(xGPU.length, yGPU.length);
                        }
                        //Если обе видеокарты R9 или ниже
                    } else if (!xGPU[2].equals("RX") && xGPU[2].charAt(0) == 'R' && yGPU[2].charAt(0) == 'R') {
                        //Если поколение сравниваемой видеокарты меньше чем поколение введенной
                        if (Integer.parseInt(xGPU[2].substring(1)) < Integer.parseInt(yGPU[2].substring(1))) return -1;
                            //Если поколения одинаковые
                        else if (Integer.parseInt(xGPU[2].substring(1)) == Integer.parseInt(yGPU[2].substring(1))) {
                            //Если одинаковые серии, то мощнее та видеокарта у которой есть маркировка
                            if (Integer.parseInt(xGPU[3].substring(1)) == Integer.parseInt(yGPU[3].substring(1))) {
                                return Integer.compare(xGPU.length, yGPU.length);
                            } else
                                return Integer.compare(Integer.parseInt(xGPU[2].substring(1)), Integer.parseInt(yGPU[2].substring(1)));
                        }
                        //Если обе видеокарты RX
                    } else {
                        //Если серия видеокарт одинаковая
                        if (Integer.parseInt(xGPU[3]) == Integer.parseInt(yGPU[3])) {
                            //Если у сравниваемой видеокарты есть маркировка
                            if (xGPU.length == 5 && yGPU.length != 5) return 1;
                                //Если у введенной видеокарты есть маркировка
                            else if (yGPU.length == 5 && xGPU.length != 5) return -1;
                                //Если у обеих видеокарт есть маркировка
                            else if (xGPU.length == 5) {
                                //У сравниваемой маркировка M(мощнее), а у введенной S(слабее)
                                if (xGPU[4].charAt(0) == 'M' && yGPU[4].charAt(0) == 'S') return 1;
                                //Если наоборот
                                if (xGPU[4].charAt(0) == 'S' && yGPU[4].charAt(0) == 'M') return -1;
                                //Если обе видеокарты маркировки одинаковые
                                if (xGPU[4].equals(yGPU[4])) return 0;
                                //Если первая маркировка видеокарт одинаковая, но у сравниваемой есть еще маркировка X или XT
                                if (xGPU[4].contains("X") && xGPU[4].charAt(0) == yGPU[4].charAt(0)) return 1;
                                //Если первая маркировка одинаковая, но у введенной видеокарты есть маркировка X или XT
                                if (yGPU[4].contains("X") && xGPU[4].charAt(0) == yGPU[4].charAt(0)) return -1;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }


    public void printCPU() {
        System.out.println(CPU);
    }


    public void printGPU() {
        System.out.println(GPU);
    }
}
