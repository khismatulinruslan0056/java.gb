// Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объём ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные и максимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
// Доп задание
// Отсортировать ноутбуки получившегося множества. На выбор: 
// По возрастанию имени ноутбука в алфавитном порядке
// По цене по убыванию

package hw6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class hw6 {

    public static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
    
        Laptop Mac = new Laptop();
        Laptop Asus = new Laptop("Asus FA506IC - HN042W", 82, "black", 2300, "SSD", 15, 6, 512, 8);
        Laptop Dell = new Laptop("DELL G15", 75, "grey", 2450, "SSD", 16, 6, 512, 8) ;
        Laptop Huawei = new Laptop("Huawei matebook", 80, "cosmic grey", 1710, "SSD", 16, 8, 512, 16);
        Laptop Acer = new Laptop("ACER aspire A515-57-74MS", 81, "grey", 1800, "SSD",15,10,512,16);
        Laptop Lenovo = new Laptop("LENOVO ideapad 3 15ITL6", 30, "grey", 3600, "HDD",15,2,1024, 4);

        
        ArrayList<Laptop> laptops = new ArrayList<>();
        laptops.add(Mac);
        laptops.add(Asus);
        laptops.add(Dell);
        laptops.add(Huawei);
        laptops.add(Acer);
        laptops.add(Lenovo);

        int numb = filtView();
        HashMap<String, Integer> filHashMap = filtProduct(numb, laptops);
        System.out.println(filHashMap);
    }

    public static int filtView() {
        System.out.println("Выберите параметр для фильтра: ");        
        System.out.println("1. Диагональ экрана");
        System.out.println("2. Объем накопителя");
        System.out.println("3. Количество ядер");
        System.out.println("4. Объем оперативной памяти");
        System.out.println("5. Цена");
        int numb = Integer.parseInt(readNumb());
        return numb;
    }

    public static HashMap<String, Integer> filtProduct(int numb, ArrayList<Laptop> laptops) {
        int min = 0; 
        int max = 0;
        switch (numb) {
            case 1:
                System.out.println("Введите ограничения для диагонали экрана");
                min = Integer.parseInt(readNumb());
                max = Integer.parseInt(readNumb());
                if (min > max) {
                    int tmp = min;
                    min = max;
                    max = tmp;
                }

                HashMap<String, Integer> filtScreenSize = new HashMap<>();
                for (Laptop el : laptops) {
                    el.filtScreenSize(min, max, filtScreenSize);
                }
                return filtScreenSize;

            case 2:
                System.out.println("Введите ограничения для объема накопителя");
                min = Integer.parseInt(readNumb());
                max = Integer.parseInt(readNumb());
                if (min > max) {
                    int tmp = min;
                    min = max;
                    max = tmp;
                }

                HashMap<String, Integer> filtDiscCapasity = new HashMap<>();
                for (Laptop el : laptops) {
                    el.filtDiskCapacity(min, max, filtDiscCapasity);
                }

                return filtDiscCapasity;

            case 3:
                System.out.println("Введите ограничения для количества ядер");
                min = Integer.parseInt(readNumb());
                max = Integer.parseInt(readNumb());
                if (min > max) {
                    int tmp = min;
                    min = max;
                    max = tmp;
                }

                HashMap<String, Integer> filtNumbOfCores = new HashMap<>();
                for (Laptop el : laptops) {
                    el.filtNumbOfCores(min, max, filtNumbOfCores);
                }

                return filtNumbOfCores;

            case 4:
                System.out.println("Введите ограничения для оперативной памяти");
                min = Integer.parseInt(readNumb());
                max = Integer.parseInt(readNumb());
                if (min > max) {
                    int tmp = min;
                    min = max;
                    max = tmp;
                }

                HashMap<String, Integer> filtAmountOFRAM = new HashMap<>();
                for (Laptop el : laptops) {
                    el.filtAmountOfRAM(min, max, filtAmountOFRAM);;
                }
                return filtAmountOFRAM;

            case 5:
                System.out.println("Введите ограничения для цены");
                min = Integer.parseInt(readNumb());
                max = Integer.parseInt(readNumb());
                if (min > max) {
                    int tmp = min;
                    min = max;
                    max = tmp;
                }

                HashMap<String, Integer> filtPrice = new HashMap<>();
                for (Laptop el : laptops) {
                    el.filtPrice(min, max, filtPrice);
                }
                return filtPrice;
        }
        return null;
    }

    public static String readNumb() {
        try {
            return iScanner.nextLine();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}




class Laptop {
    String brand;
    Integer price;
    String color;
    Integer weight;    
    String diskType;
    Integer screenSize;
    Integer numbOfCores;
    Integer diskCapacity;
    Integer amountOfRAM;

    void printInfo() {
        System.out.println("Ноутбук " + brand +", цвет - " + color + ", вес - " + weight + " грамм, диагональ экрана "
        + screenSize + "накопитель " + diskType + "объемом " + diskCapacity + " гб, количество ядер - " + 
        numbOfCores + " гб, оперативная память объемом - "+ amountOfRAM + " гб, цена - " + price + " тыс. рублей.");
    }

    Laptop() {
        this.brand = "Apple MacBook Air";
        this.price = 199;
        this.color = "Space grey";
        this.weight = 1500; 
        this.diskType = "SSD";
        this.screenSize = 13;
        this.numbOfCores = 8;
        this.diskCapacity = 256;
        this.amountOfRAM = 8;
    }

    Laptop(String brand, int price, String color, int weight, 
    String diskType, int screenSize, int numbOfCores, int diskCapacity, int amountOfRAM ) {
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.weight = weight; 
        this.diskType = diskType;
        this.screenSize = screenSize;
        this.numbOfCores = numbOfCores;
        this.diskCapacity = diskCapacity;
        this.amountOfRAM = amountOfRAM;
    }

    public void filtScreenSize(Integer min, Integer max, HashMap<String, Integer> filtProducts) {
        if (screenSize > min && screenSize < max) filtProducts.put(brand, screenSize);
    }

    public void filtNumbOfCores(Integer min, Integer max, HashMap<String, Integer> filtProducts) {
        if (numbOfCores > min && numbOfCores < max) filtProducts.put(brand, numbOfCores);
    }

    public void filtDiskCapacity(Integer min, Integer max, HashMap<String, Integer> filtProducts) {
        if (diskCapacity > min && diskCapacity < max) filtProducts.put(brand, diskCapacity);
    }

    public void filtAmountOfRAM(Integer min, Integer max, HashMap<String, Integer> filtProducts) {
        if (amountOfRAM > min && amountOfRAM < max) filtProducts.put(brand, amountOfRAM);
    }

    public void filtPrice(Integer min, Integer max, HashMap<String, Integer> filtProducts) {
        if (price > min && price < max) filtProducts.put(brand, price);
    }

}

