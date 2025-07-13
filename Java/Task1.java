class Printer {


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
    }


}


class Answer {
    // Нахождение факториала числа
    public static int Factorial(int n ) {
        int sum = 1;
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        }
        for (int i = n; i != 0; i--) {
            sum *= i;
        }
        return sum;

    }

    //Вывод всех четных чисел от 1 до 100
    public static void printEvenNums() {
        for (int i = 2; i < 101; i+=2) {
            System.out.println(i);
        }
    }


    //Подсчет суммы цифр числа
    public  static int sumDigits(int number) {
        String stringNumber = Integer.toString(number);
        int sum = 0;
        for (int i = 0; i != stringNumber.length(); i++) {
            sum += Integer.parseInt(Character.toString(stringNumber.charAt(i)));
        }
        return sum;
    }


    //Нахождение максимального из двух чисел
    public  static  int findMaxOfTwo(int a,int b) {
        return Math.max(a, b);
    }

    //Нахождение максимального из трех чисел
    public static int findMaxOfThree(int a, int b, int c) {
        if (a > b & a > c) {
            return a;
        } else if (b > a & b > c) {
            return b;
        } return c;
    }


}
