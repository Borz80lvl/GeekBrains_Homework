import java.util.*;

class task5 {


    //Студенческий справочник
    static class StudentDirectory {
        private static final HashMap<String, ArrayList<Integer>> studentMap = new HashMap<>();


        public void addStudent(String name, Integer grade) {
            ArrayList<Integer> tempArrayList = new ArrayList<>();
            if (studentMap.containsKey(name)) {
                studentMap.get(name).add(grade);
            } else {
                tempArrayList.add(grade);
                studentMap.put(name, tempArrayList);
            }
        }


        public ArrayList<Integer> findStudent(String name) {
            if (studentMap.containsKey(name)) {
                return studentMap.get(name);
            }
            return new ArrayList<>();
        }


        public HashMap<String, ArrayList<Integer>> getAllStudents() {
            return studentMap;
        }


        public  void removeStudent(String name) {
            studentMap.remove(name);
        }


    }

    //История посещения веб-сайтов
    static class BrowserHistory {
        private static final Deque<String> browserHistory = new LinkedList<>();


        void visitSite(String site) {
            browserHistory.add(site);
        }


        String back(int steps) {
            if (browserHistory.size() <= steps) {
                return null;
            }
            return browserHistory.stream().skip(steps).findFirst().toString().replaceAll("Optional", "");
        }


        Deque<String> getHistory() {
            return browserHistory;
        }


    }

    //Подсчет продуктов в корзине
    static  class ShoppingBasket {
        private final HashMap<String, Integer> basket = new HashMap<>();


        void  addProduct(String product, Integer quantity) {
            if (basket.containsKey(product)) {
                basket.put(product, basket.get(product) + quantity);
            } else {
                basket.put(product, quantity);
            }
        }


        void removeProduct(String product) {
            basket.remove(product);
        }


        void updateQuantity(String product, Integer quantity) {
            if (basket.containsKey(product)) {
                basket.put(product, basket.get(product) + quantity);
            }
        }


        int checkProduct(String product) {
            return basket.getOrDefault(product, 0);
        }


        void showBasket() {
            System.out.println(basket);
        }


    }


    static  class MergeSort {


        //Сортировка слиянием
        static int[] Sort(int[] array) {
            if (array == null) {
                return new int[0];
            } else if (array.length < 2) {
                return array;
            }
            int[] left = new int[array.length / 2];
            System.arraycopy(array, 0, left, 0, left.length);

            int[] right = new int[array.length - array.length / 2];
            System.arraycopy(array, array.length / 2, right, 0, right.length);

            left = Sort(left);
            right = Sort(right);

            return merge(left, right, new int[0]);

        }


        public static int[] merge(int[] left, int[] right, int[] result) {
            result = new int[left.length + right.length];
            int positionA = 0, positionB = 0;

            for (int i = 0; i < result.length; i++) {
                if (positionA == left.length){
                    result[i] = right[positionB];
                    positionB++;
                } else if (positionB == right.length) {
                    result[i] = left[positionA];
                    positionA++;
                } else if (left[positionA] < right[positionB]) {
                    result[i] = left[positionA];
                    positionA++;
                } else {
                    result[i] = right[positionB];
                    positionB++;
                }
            }
            return result;
        }


    }


}