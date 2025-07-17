import java.util.Deque;
import java.util.LinkedList;


class task4 {


    static class  LLTasks {


        //Удаление нечетных строк
        public  static void removeOddLengthStrings(LinkedList<String> stringsList){
            for (int i = 0; i < stringsList.size(); i++) {
                if (stringsList.get(i).length() % 2 != 0){
                    stringsList.poll();
                }
            }
        }


    }

    //Реализация стека
    static class  MyStack {

        private final LinkedList<String> myStack = new LinkedList<>();

        //добавляет элемент на вершину стека
        public  void  push(String element){
            myStack.addFirst(element);
        }

        //возвращает элемент с вершины и удаляет его
        public  String pop(){
            return myStack.removeFirst();
        }


        //возвращает элемент с вершины, не удаляя
        public String peek(){
            return myStack.getFirst();
        }


        //возвращает все элементы стека
        public  LinkedList<String> getElements(){
            return myStack;
        }


    }


    static class ListUtils {

        // Количество вхождений слова
        public static int countOccurrences(LinkedList<String> list, String value) {
            int count = 0;
            if (list.isEmpty()) {
                return count;
            }
            for (String string : list){
                if (string.equals(value)){
                    count++;
                }
            }
            return count;
        }


    }


    static  class DequeTasks {

        //Сдвиг очереди
        public  static void rotateDeque(Deque<Integer> deque, int n){
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                deque.addLast(deque.removeFirst());
                }
            } else if (n < 0) {
                for (int i = 0; i > n; i--) {
                    deque.addFirst(deque.removeLast());
                }
            }
        }


        //Удаление слова из очереди
        public static void removeAllOccurrences(Deque<String> deque, String value) {
            while (deque.contains(value)) {
                deque.removeFirstOccurrence(value);
            }
        }


    }


}