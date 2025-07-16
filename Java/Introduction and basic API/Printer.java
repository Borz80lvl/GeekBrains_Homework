public class Printer {


    public static void main(String[] args) {
        // Факториал
        int n = 5;
        System.out.println(Answer.Factorial(n));

        //Вывод всех четных чисел от 1 до 100
        Answer.printEvenNums();

        //Подсчет суммы цифр числа
        int number = 12345;
        System.out.println(Answer.sumDigits(number));

        //Нахождение максимального из трех чисел
        int a = 5, b = 10, c = 3;
        System.out.println(Answer.findMaxOfTwo(a, b));
        System.out.println(Answer.findMaxOfThree(a, b, c));

        //Формирование URL с параметрами
        String baseURL = "https://example.com/search?";
        String params = "query=java&sort=desc&filter=null";
        System.out.println(URLBuilder.buildURL(baseURL,params));

        //Создание CSV-строки из массива объектов
        String[] headers = {"Name", "Age", "City"};
        String[][] data = {
                {"John", "30", "New York"},
                {"Alice", "25", "Los Angeles"},
                {"Bob", "35", "Chicago"}
        };
        System.out.println(CSVGenerator.generateCSV(headers, data));

        //Удаление пустых строк из текста
        String text = "line1\n\nline2\n\nline3\n\n";
        System.out.println(TextCleaner.removeEmptyLines(text));

        //Логирование операций с массивом во время поиска
        //минимального и максимального элементов
        int[] array = new int[] {9, 4, 8, 3, 1};
        ArrayOperations.findMinMax(array);
    }


}



