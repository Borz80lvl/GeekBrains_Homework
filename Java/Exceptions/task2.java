import java.util.Arrays;
import java.util.regex.PatternSyntaxException;

public class task2 {
    // 1
    public static String validateDate(String date) {
        try {
            String[] dateSplit = date.split("-");
            int year = Integer.parseInt(dateSplit[0]);
            int month = Integer.parseInt(dateSplit[1]);
            int day = Integer.parseInt(dateSplit[2]);
            if (year < 1 || year > 9999) {
                return "YearException: Year is not correct";
            }
            if (month < 1 || month > 12) {
                return "MonthException: Month is not correct";
            }
            if (day < 1 || day > 31) {
                return "DayException: Day is not correct";
            }
            if (month == 2) {
                if (day > 29) {
                    return "FebruaryException: February has maximum 29 days";
                }
            }
            return "Date is correct";
        } catch (IndexOutOfBoundsException | NumberFormatException indexOutOrNumberFormatException) {
            return String.format("%s ", indexOutOrNumberFormatException.getClass().getSimpleName());
        }
    }

    // 2
    public static boolean isPalindrome(String string) {
        if (string.isEmpty()) {
            return false;
        } else if (string.length() == 1) {
            return true;
        }
        int i = 0;
        int j = string.length() - 1;
        while (i < string.length() & j > 0) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // 3
    public static String[] sortStrings(String[] strings) {
        try {
            for (int i = 0; i < strings.length - 1; i++) {
                for (int j = 1; j < strings.length; j++) {
                    if (Character.codePointAt(strings[i], 0) > Character.codePointAt(strings[j], 0)) {
                        String temp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = temp;
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getClass().getSimpleName());
        }
        return strings;
    }
    // 4
    public static double findAverage(int[] numbers) {
        try {
            int arrayLength = numbers.length;
            int sum = Arrays.stream(numbers).sum();
            return (double) sum / arrayLength;
        } catch (Exception exception) {
            System.out.println(exception.getClass().getSimpleName());
            return Double.NaN;
        }
    }
}
