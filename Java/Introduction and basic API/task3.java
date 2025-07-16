import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class  task3 {


    class  FilterNegative {

        // Удаление отрицательных значений из массива
        public static int[] filterNegative(int[] array) {
            List<Integer> numbers = new ArrayList<Integer>(array.length);
            for (Integer number : array) {
                numbers.add(number);
            }
            numbers.removeIf(number -> (number <= 0));
            array = new int[numbers.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = numbers.get(i);
            }
            return array;
        }


    }

    class  UniqueElements {

        //Уникальные числа
        public  static int[] getUniqueElements(int[] array) {
            Set<Integer> elements = new HashSet<Integer>();
            for (int i = 0; i < array.length; i++) {
                elements.add(array[i]);
            }
            array = new int[elements.size()];
            for (int i = 0; i < elements.size(); i++) {
                array[i] = elements.stream().toList().get(i);
            }
            return array;
        }


    }


    class FilterStrings {

        //Длина слов
        public static  String[] filterShortStrings(String[] array) {
            List<String> strings = new ArrayList<String>();
            for (String word : array) {
                if (word.length() > 3) {
                    strings.add(word);
                }
            }
            array = new String[strings.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = strings.get(i);
            }
            return array;
        }

    }


    class AverageCalculator {

        //Среднее значение массива
        public  static int calculateAverage(int[] array) {
            int mean = 0;
            float sum = 0.0f;
            for (int number : array) {
                sum += number;
            }
            mean = Math.round(sum / array.length);
            return mean;
        }
    }

}