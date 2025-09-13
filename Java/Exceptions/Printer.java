import java.util.Arrays;

public class Printer {
    public static void main(String[] args) {
        // Task 1
        // 1
        String[] correctStrings = new String[] {"59", "15", "4", "10", "12"};
        String[] incorrectStrings = new String[] {"22", "%", "ab", "10", "122"};
        String[] correctNotLessLimitStrings = new String[] {"22", "2", "4", "10", "122"};
        System.out.println(task1.convertAndSum(correctStrings));
        System.out.println(task1.convertAndSum(incorrectStrings));
        System.out.println(task1.convertAndSum(correctNotLessLimitStrings));
        // 2
        int[] correctArrayX = new int[] {1, 3, 5};
        int[] correctArrayY = new int[] {2, 4, 6};
        int[] longerArrayX = new int[] {1, 3, 5, 7, 9};
        int[] incorrectArrayX = new int[] {1, -3, 5};
        System.out.println(Arrays.toString(task1.mergeAndValidateArrays(correctArrayX, correctArrayY)));
        System.out.println(Arrays.toString(task1.mergeAndValidateArrays(longerArrayX, correctArrayY)));
        System.out.println(Arrays.toString(task1.mergeAndValidateArrays(incorrectArrayX, correctArrayY)));
        // 3
        correctArrayX = new int[] {5, 6, 8};
        System.out.println(Arrays.toString(task1.subArraysWithExceptionHandling(correctArrayX, correctArrayY)));
        System.out.println(Arrays.toString(task1.subArraysWithExceptionHandling(longerArrayX, correctArrayY)));
        System.out.println(Arrays.toString(task1.subArraysWithExceptionHandling(correctArrayY, correctArrayX)));
        // 4
        String[] worlds = new String[] {"Hello ", "Python ","!"};
        System.out.println(Arrays.toString(task1.findAndReplace(worlds,"Python ","World ")));
        System.out.println(Arrays.toString(task1.findAndReplace(worlds, "cat", "rat")));
    }
}
