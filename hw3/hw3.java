

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
            ArrayList<Integer> numbs = fillArrayList();
            System.out.println(numbs);
            mergeSort(numbs);
            System.out.println(mergeSort(numbs));
            
                break;
        // Задание 2
            case ("2"):

            System.out.println(deleteEven(fillArrayList()));
                break;
        // Задание 3
            case ("3"):
            infoAboutList(fillArrayList());
            break;
        }
       


        iScanner.close();
    }
    
    
    
    public static String readNumb () {
        return iScanner.nextLine();
    }
    
    public static ArrayList<Integer> fillArrayList() {
        ArrayList<Integer> numbs = new ArrayList<Integer>(); 
        Random rn = new Random();
        for (int i = 0; i < 4; i++) {
            numbs.add(rn.nextInt(50));
        }
        return numbs;
    }
    // Реализовать алгоритм сортировки слиянием


    

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> listss) {
        int cup = listss.size();
        if (cup <= 1) {
            return listss;
        }
        int m = 0;
        int n = 0;

        ArrayList<Integer> listResult = new ArrayList<Integer>(cup);
        ArrayList<Integer> listA = new ArrayList<Integer>(cup/2);
        ArrayList<Integer> listB = new ArrayList<Integer>(cup - cup/2);

        for (int i = 0; i < cup; i++) {
            if (i < cup / 2) listA.add(listss.get(i));
            else listB.add(listss.get(i));
        }


        while (m < listA.size() && n < listB.size()) {
            if (listA.get(m) <= listB.get(n)){ 
                listResult.add(listA.get(m));
                m++;
            }
            else {
                listResult.add(listB.get(n));
                n++;               
            }
        }

        while (m < listA.size()) {
            listResult.add(listA.get(m));
            m++;
        }

        while (n < listB.size()) {
            listResult.add(listB.get(n));
            n++;
        }


       // System.out.println(listA);
       // System.out.println(listB);

        return mergeSort(listss); // не разобрался как рекурсивно правильно вызвать


        
    }

    // Пусть дан произвольный список целых чисел, удалить из него чётные числа
 
    public static ArrayList<Integer>  deleteEven(ArrayList<Integer> numbs) {
        for (int i = 0; i < numbs.size(); i++) {
            if (numbs.get(i) % 2 == 0) numbs.remove(i);
            
        }
        return numbs;
    }



   // Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.  

    public static void infoAboutList(ArrayList<Integer> numbs) {


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
   
