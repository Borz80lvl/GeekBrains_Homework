import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

class  task2 {


    class  URLBuilder {

        //Формирование URL с параметрами
        public static String buildURL(String baseURL, String params) {
            StringBuilder resultURL = new StringBuilder(baseURL);
            for (String item : params.split("&")) {
                if (!item.split("=")[1].equals("null")) {
                    resultURL.append(item);
                }
            }
            return resultURL.toString();
        }


    }


    class  CSVGenerator {

        //Создание CSV-строки из массива объектов
        public  static String generateCSV(String[] headers,String[][] data) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < headers.length; i++) {
                result.append(headers[i]);
                if (i == headers.length - 1) {
                    result.append("\n");
                } else {
                    result.append(", ");
                }
            }
            for (String[] row : data) {
                for (int i = 0; i < row.length; i++) {
                    result.append(row[i]);
                    if (i == row.length - 1) {
                        result.append("\n");
                    } else {
                        result.append(", ");
                    }
                }
            }
            return result.toString();
        }
    }


    class TextCleaner {

        //Удаление пустых строк из текста
        public  static String removeEmptyLines(String text) {
            int start = 0, end = 0;
            StringBuilder result = new StringBuilder(text);
            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(i) == '\n') {
                    start = i;
                    while (result.charAt(i) == '\n') {
                        if (i != result.length() - 1) {
                            i++;
                        } else {
                            i++;
                            break;
                        }
                    }
                    end = i;
                    result.replace(start, end, "\n");
                    i = start + 1;
                }
            }
            return result.toString();

        }
    }



    class ArrayOperations {
        private static File log;

        //Поиск минимального и максимальных значений и запись
        public static void findMinMax(int[] array) {
            int max = Arrays.stream(array).max().getAsInt();
            int min = Arrays.stream(array).min().getAsInt();
            logStep(min, max);
        }

        //Записывание в файл min и max
        private static void logStep(int min, int max) {
            log = new File("log.txt");
            LocalDate date = LocalDate.now();
            String formatline = String.format("%d-%d-%d %d:%d ",
                    date.getYear(), date.getMonth().getValue(), date.getDayOfMonth(),
                    LocalDateTime.now().getHour(), LocalDateTime.now().getMinute());
            StringBuilder line = new StringBuilder(formatline);
            try (FileWriter fileWriter = new FileWriter(log)) {
                fileWriter.append(String.format(line.append("{%d}, {%d}").toString(), min, max));
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }


    }



}