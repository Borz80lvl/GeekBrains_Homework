import java.util.*;

public class Printer {


    public static void main(String[] args) {
        // Факториал
        int n = 5;
        System.out.printf("Факториал %d:\n", n);
        System.out.println(task1.Answer.Factorial(n));

        //Вывод всех четных чисел от 1 до 100
        System.out.println("Вывод всех четных чисел от 1 до 100: \n");
        task1.Answer.printEvenNums();

        //Подсчет суммы цифр числа
        n = 12345;
        System.out.printf("Подсчет суммы цифр числа %d: \n", n);
        System.out.println(task1.Answer.sumDigits(n));

        //Нахождение максимального из трех чисел
        int a = 5, b = 10, c = 3;
        System.out.printf("Нахождение максимального чисел %d и %d:\n", a, b);
        System.out.println(task1.Answer.findMaxOfTwo(a, b));
        System.out.printf("Нахождение максимального чисел %d, %d и %d:\n", a, b , c);
        System.out.println(task1.Answer.findMaxOfThree(a, b, c));

        //Формирование URL с параметрами
        System.out.println("Формирование URL с параметрами:\n");
        String baseURL = "https://example.com/search?";
        String params = "query=java&sort=desc&filter=null";
        System.out.println(task2.URLBuilder.buildURL(baseURL,params));

        //Создание CSV-строки из массива объектов
        System.out.println("Создание CSV-строки из массива объектов:\n");
        String[] headers = {"Name", "Age", "City"};
        String[][] data = {
                {"John", "30", "New York"},
                {"Alice", "25", "Los Angeles"},
                {"Bob", "35", "Chicago"}
        };
        System.out.println(task2.CSVGenerator.generateCSV(headers, data));

        //Удаление пустых строк из текста
        String text = "line1\n\nline2\n\nline3\n\n";
        System.out.println("Удаление пустых строк");
        System.out.println("До: \nw");
        System.out.println(text);
        System.out.println("После: \n");
        System.out.println(task2.TextCleaner.removeEmptyLines(text));

        //Логирование операций с массивом во время поиска
        //минимального и максимального элементов
        int[] array = new int[] {9, 4, 8, 3, 1};
        task2.ArrayOperations.findMinMax(array);

        // Удаление отрицательных значений из массива
        System.out.println("Удаление отрицательных значений из массива:\n");
        array = new int[]{-1, 2, -3, 4, -5, 6};
        System.out.printf("До: %s:\n", Arrays.toString(array));
        System.out.println("После:\n");
        System.out.println(Arrays.toString(task3.FilterNegative.filterNegative(array)));

        // Уникальные числа
        array = new int[] {1, 2, 2, 3, 4, 4, 5};
        System.out.printf("Уникальные числа массива %s:\n", Arrays.toString(array));
        System.out.println(Arrays.toString(task3.UniqueElements.getUniqueElements(array)));

        //Длина слов
        String[] strings = new String[]{"cat", "elephant", "dog", "giraffe"};
        System.out.printf("Длина слов %s:\n", Arrays.toString(strings));
        System.out.println(Arrays.toString(task3.FilterStrings.filterShortStrings(strings)));

        //Среднее значение массива
        array = new  int[]{4, 2, 7, 5, 1};
        System.out.printf("Среднее значение массива %s:\n", Arrays.toString(array));
        System.out.println(task3.AverageCalculator.calculateAverage(array));

        //Удаление нечетных строк
        System.out.println("Удаление нечетных строк:\n");
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple");
        list.add("pear");
        list.add("banana");
        list.add("cherry");
        list.add("pear");
        System.out.println("До:\n");
        System.out.println(list);
        LinkedList<String> linkedStrings = new LinkedList<>(list);
        task4.LLTasks.removeOddLengthStrings(linkedStrings);
        System.out.println("После:\n");
        System.out.println(linkedStrings);

        //Реализация стека
        System.out.println("Реализация стека:\n");
        task4.MyStack stack = new task4.MyStack();
        stack.push("apple");
        stack.push("banana");
        stack.push("pear");
        stack.push("grape");
        System.out.println(stack.getElements());
        System.out.println(stack.pop());
        System.out.println(stack.getElements());
        System.out.println(stack.peek());

        // Количество вхождений слова
        LinkedList<String> linkedList = new LinkedList<>(list);
        String value = "apple";
        System.out.printf("Количество вхождений слова %s:\n", value);
        System.out.println(task4.ListUtils.countOccurrences(linkedList, value));

        //Сдвиг очереди
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        n = 2;
        System.out.printf("До сдвига очереди на %d:\n", n);
        System.out.println(deque);
        task4.DequeTasks.rotateDeque(deque, n);
        System.out.printf("После сдвига очереди на %d:\n", n);
        System.out.println(deque);

        //Удаление слова из очереди
        Deque<String> stringDeque = new LinkedList<>(list);
        value = "apple";
        System.out.printf("Удаление слова %s из очереди:\n", value);
        System.out.println("До:\n");
        System.out.println(stringDeque);
        System.out.println("После:\n");
        task4.DequeTasks.removeAllOccurrences(stringDeque, value);
        System.out.println(stringDeque);

        //Студенческий справочник
        System.out.println("Студенческий справочник:\n");
        task5.StudentDirectory studentDirectory = new task5.StudentDirectory();
        studentDirectory.addStudent("Alice", 90);
        studentDirectory.addStudent("Bob", 85);
        studentDirectory.addStudent("Alice", 95);
        System.out.println("Before removal:\n");
        System.out.println(studentDirectory.findStudent("Alice"));
        System.out.println(studentDirectory.getAllStudents());
        studentDirectory.removeStudent("Alice");
        System.out.println("After removal:");
        System.out.println(studentDirectory.findStudent("Alice"));
        System.out.println(studentDirectory.getAllStudents());

        //История посещения веб-сайтов
        task5.BrowserHistory browserHistory = new task5.BrowserHistory();
        browserHistory.visitSite("google.com");
        browserHistory.visitSite("gb.ru");
        browserHistory.visitSite("maps.google.com");
        System.out.println("История посещения веб-сайтов");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.getHistory());

        // Подсчет продуктов в корзине
        task5.ShoppingBasket basket = new task5.ShoppingBasket();
        basket.addProduct("apple", 3);
        basket.addProduct("banana", 2);
        basket.addProduct("apple", 5);
        System.out.println("Basket after adding products:");
        basket.showBasket();
        basket.removeProduct("banana");
        System.out.println("Basket after removing 'banana':");
        basket.showBasket();
        basket.updateQuantity("apple", 10);
        System.out.println("Basket after updating quantity of 'apple':");
        basket.showBasket();
        System.out.println("Quantity of 'apple': " + basket.checkProduct("apple"));
        System.out.println("Quantity of 'banana': " + basket.checkProduct("banana"));

        //Сортировка слиянием
        array = new int[]{38, 27, 43, 3, 9, 82, 10};
        System.out.println("Initial array:");
        System.out.println(Arrays.toString(array));;
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(task5.MergeSort.Sort(array)));

        //Поиск ноутбуков
        Laptops.printUserPreferredLaptops();
    }


}



