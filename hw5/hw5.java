package hw5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class hw5 {
    static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Выберите задание (1-3)");
        String task = readNumb();
        
        switch (task) {
        // Задание 1
            case ("1"):
                System.out.println(returnMap());
                break;
        // Задание 2
            case ("2"):
                String[] fio = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова",
                "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};
                countName(fio);
                break;
        // Задание 3
            case ("3"):
                int[] arr = {2, 5, 123, 1, 54, 34};
                printArray(arr);
                System.out.println();
                printArray(finalSort(arr));
             
                break;
        }

        iScanner.close();
        
    }

    public static String readNumb () {
        return iScanner.nextLine();
    }

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

    public static HashMap<String, ArrayList<Integer>> returnMap() {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        String status = "";
        while (!status.toUpperCase().equals("СТОП")) {
            System.out.println("Введите имя и фамилию");
            String fio = readNumb();
            ArrayList<Integer> numbs = new ArrayList<Integer>(); 
            String statusNumb = "0";

            while (!statusNumb.toUpperCase().equals("СТОП")){
                System.out.println("Введите номер");
                numbs.add(Integer.parseInt(readNumb()));
                System.out.println("Введите \"СТОП\", чтобы закончить ввод номеров");
                statusNumb = readNumb();
            }

            map.put(fio, numbs);
            System.out.println("Введите \"СТОП\", чтобы закончить заполнение телефонной книги");
            status = readNumb();
        }

        return map;
        
    }
    // Дан список сотрудников:
    // Иван Иванов
    // Светлана Петрова
    // Кристина Белова
    // Анна Мусина
    // Анна Крутова
    // Иван Юрин
    // Петр Лыков
    // Павел Чернов
    // Петр Чернышов
    // Мария Федорова
    // Марина Светлова
    // Мария Савина
    // Мария Рыкова
    // Марина Лугова
    // Анна Владимирова
    // Иван Мечников
    // Петр Петин
    // Иван Ежов
    // Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. 
    // Отсортировать по убыванию популярности.


    public static void countName(String[] fio) {
    
        HashMap<String, Integer> countName = new HashMap<>();

        for (String el : fio) {
            String[] fios =  el.split(" ");

            if (!countName.containsKey(fios[0])) countName.put(fios[0], 1);
            else countName.put(fios[0], countName.get(fios[0]) + 1);

        }
        
        countName.entrySet().stream().
        sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
        forEach(System.out::println);
        
    }

    // Реализовать алгоритм пирамидальной сортировки (HeapSort).



        public static void heapSort(int[] arr, int n, int i) { // сравнивает элементы в одном узле 
            int parentNode = i;
            int leftChild = 2 * i + 1;
            int rightChild = leftChild + 1;

            if (leftChild < n && arr[parentNode] < arr[leftChild]) parentNode = leftChild;
            if (rightChild < n && arr[parentNode] < arr[rightChild]) parentNode = rightChild;

            if (parentNode != i) {
                int tmp = arr[i];
                arr[i] = arr[parentNode];
                arr[parentNode] = tmp; // поменяли значения в массиве местами, дальнейший расчет продолжается с начальным элементом на новом месте
            
                printArray(arr);
                System.out.println(); 
                heapSort(arr,n, parentNode); //  рекурсивно спускаемся вниз 

  
        } 
    }


        public static int[] finalSort(int[] arr) {
            for (int i = 2 * arr.length; i >= 0; i--) { // строим двоичное дерево
                heapSort(arr,arr.length, i);
            }

            for (int i = arr.length - 1; i >=0; i--) { // остальная сортировка
                int tmp = arr[0];
                arr[0] = arr[i];
                arr[i] = tmp;
                printArray(arr);
                System.out.println(); 
                heapSort(arr,i, 0);
            }

          return arr;  
        }
        
        public static void printArray(int[] arr) {
            for (int i = 0; i <arr.length; i++ ) {
                System.out.print(arr[i] + " ");
            }
        }
}
