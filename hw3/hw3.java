package hw3;


import java.io.IOException;
import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;



public class hw3 {
    static Scanner iScanner = new Scanner(System.in);
   
    
    
    public static void main(String[] args) throws SecurityException, IOException {


        System.out.println("Выберите задание (1-3)");
        String task = readNumb();
        switch (task) {
        // Задание 1
            case ("1"):

                break;
        // Задание 2
            case ("2"):
            deleteEven();
                break;
        // Задание 3
            case ("3"):
            infoAboutList();
            break;
        }
       


        iScanner.close();
    }
    
    
    
    public static String readNumb () {
        return iScanner.nextLine();
    }
    
    // Реализовать алгоритм сортировки слиянием

    // ArrayList<Integer> numbs = new ArrayList<Integer>(); 
    // Random rn = new Random();
    // for (int i = 0; i < 8; i++) {
    //     numbs.add(rn.nextInt(50));
    // }
    

    // public static ArrayList<Integer> mergeSort(ArrayList<Integer> listss) {
    //     int cup = listss.size();
    //     if (cup <= 2) {
    //         return listss;
    //     }
    //     int m = 0;
    //     int n = 0;

    //     ArrayList<Integer> listA = new ArrayList<Integer>(cup/2);
    //     ArrayList<Integer> listB = new ArrayList<Integer>(cup - cup/2);


    //     while 


    //     return listss;


        
    // }

    // Пусть дан произвольный список целых чисел, удалить из него чётные числа
 
    public static void deleteEven() {
        ArrayList<Integer> numbs = new ArrayList<Integer>(); 
        Random rn = new Random();
        for (int i = 0; i < 10; i++) {
            numbs.add(rn.nextInt(50));
        }

        System.out.println(numbs);


        for (int i = 0; i < numbs.size(); i++) {
            if (numbs.get(i) % 2 == 0) numbs.remove(i);
            
        }
        System.out.println(numbs);

    }



   // Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.  

    public static void infoAboutList() {
        ArrayList<Integer> numbs = new ArrayList<Integer>(); 
        Random rn = new Random();
        for (int i = 0; i < 10; i++) {
            numbs.add(rn.nextInt(50));
        }

        System.out.println(numbs);

        int minOfList = numbs.get(0);
        int maxOfList = numbs.get(0);
        int sum = 0;

        for (int i = 0; i < numbs.size(); i++) {
            if (numbs.get(i) > maxOfList) maxOfList = numbs.get(i);
            if (numbs.get(i) < minOfList) minOfList = numbs.get(i);
            sum += numbs.get(i);

        }

        System.out.printf("Максимальный элемент массива - %s.\n", maxOfList);

        System.out.printf("Минимальный элемент массива - %s.\n", minOfList);

        System.out.printf("Среднее арифмитическое всех элементов массива - %s.\n", sum/numbs.size());
    }


}
   
