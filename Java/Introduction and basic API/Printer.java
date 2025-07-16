import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Printer {


    public static void main(String[] args) {
        // Факториал
        int n = 5;
        System.out.println(task1.Answer.Factorial(n));

        //Вывод всех четных чисел от 1 до 100
        task1.Answer.printEvenNums();

        //Подсчет суммы цифр числа
        int number = 12345;
        System.out.println(task1.Answer.sumDigits(number));

        //Нахождение максимального из трех чисел
        int a = 5, b = 10, c = 3;
        System.out.println(task1.Answer.findMaxOfTwo(a, b));
        System.out.println(task1.Answer.findMaxOfThree(a, b, c));

        //Формирование URL с параметрами
        String baseURL = "https://example.com/search?";
        String params = "query=java&sort=desc&filter=null";
        System.out.println(task2.URLBuilder.buildURL(baseURL,params));

        //Создание CSV-строки из массива объектов
        String[] headers = {"Name", "Age", "City"};
        String[][] data = {
                {"John", "30", "New York"},
                {"Alice", "25", "Los Angeles"},
                {"Bob", "35", "Chicago"}
        };
        System.out.println(task2.CSVGenerator.generateCSV(headers, data));

        //Удаление пустых строк из текста
        String text = "line1\n\nline2\n\nline3\n\n";
        System.out.println(task2.TextCleaner.removeEmptyLines(text));

        //Логирование операций с массивом во время поиска
        //минимального и максимального элементов
        int[] array = new int[] {9, 4, 8, 3, 1};
        task2.ArrayOperations.findMinMax(array);

        // Удаление отрицательных значений из массива
        int[] numbers = new int[]{-1, 2, -3, 4, -5, 6};
        System.out.println(Arrays.toString(task3.FilterNegative.filterNegative(numbers)));

        // Уникальные числа
        int[] uniqueArray = new int[] {1, 2, 2, 3, 4, 4, 5};
        System.out.println(Arrays.toString(task3.UniqueElements.getUniqueElements(uniqueArray)));

        //Длина слов
        String[] strings = new String[]{"cat", "elephant", "dog", "giraffe"};
        System.out.println(Arrays.toString(task3.FilterStrings.filterShortStrings(strings)));

        //Среднее значение массива
        int[] meanArray = new  int[]{4, 2, 7, 5, 1};
        System.out.println(task3.AverageCalculator.calculateAverage(meanArray));

    }


}



