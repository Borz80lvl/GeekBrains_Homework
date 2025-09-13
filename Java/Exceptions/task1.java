import java.util.ArrayList;
import java.util.Arrays;

public class task1 {
    // 1
    public static int convertAndSum(String[] stringNumbers) {
        int sum = 0;
        for (String stringNumber: stringNumbers) {
            try {
                sum += Integer.parseInt(stringNumber);
            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException);
                return 0;
            }
            if (sum > 100) {
                System.out.println(new ArithmeticException("Превышен лимит суммы").getMessage());
                return 0;
            }
        }
        return sum;
    }
    // 2
    public static int[] mergeAndValidateArrays(int[] x, int[] y) {
        if (x.length != y.length) {
            System.out.println(new IllegalArgumentException());
            return null;
        } else {
            for (int i = 0; i < x.length; i++) {
                if (x[i] < 0 || y[i] < 0) {
                    System.out.println(new RuntimeException("Обнаружен отрицательный элемент"));
                    return null;
                }
            }
        }
        ArrayList result = new ArrayList(x.length + y.length);
        for (int i = 0; i < x.length; i++) {
            result.add(x[i]);
            result.add(y[i]);
        }
        int[] ZZZ = new int[result.size()];
        for (int i = 0; i < ZZZ.length; i++) {
            ZZZ[i] = (int) result.get(i);
        }
        return ZZZ;
    }
    // 3
    public static int[] subArraysWithExceptionHandling(int[] x, int[] y) {
        if (x.length != y.length) {
            System.out.println(new IllegalArgumentException("Массивы разной длины"));
            return null;
        }
        int[] result = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            var diff = x[i] - y[i];
            if (diff < 0) {
                System.out.println(new RuntimeException("Отрицательный резутьтат разности"));
                return null;
            } else {
                result[i] = diff;
            }
        }
        return result;
    }
    // 4
    public static String[] findAndReplace(String[] strings, String stringForSearch, String stringForReplace) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(stringForSearch)) {
                strings[i] = stringForReplace;
                return strings;
            }
        }
        ArrayList<Exception> errorsArray = new ArrayList<>();
        errorsArray.add(new RuntimeException("Строка ' %s ' не найдена".formatted(stringForSearch)));
        String[] errors = new String[errorsArray.size()];
        for (int i = 0; i < errors.length; i++) {
            errors[i] = errorsArray.get(i).toString();
        }
        return errors;
    }

}
