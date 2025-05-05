package hw4;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class hw4 {
    static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Выберите задание (1-3)");
        String task = readNumb();
        LinkedList<Integer> initList = fillLinkedList(10);
        switch (task) {
        // Задание 1
            case ("1"):

                System.out.println(initList);
                System.out.println(reversListIntegers(initList));
                break;
        // Задание 2
            case ("2"):

                System.out.println(initList);
                System.out.println(enqueueList(initList));
                System.out.println(dequeueList(initList));
                firstElemList(initList);
                break;
        // Задание 3
            case ("3"):
                calc();
            break;
        }
        iScanner.close();
    }


    
    // Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёет «перевёрнутый» список.

    public static LinkedList<Integer> reversListIntegers(LinkedList<Integer> initList) {
        LinkedList<Integer> reversList = new LinkedList<>();
        for (int i = initList.size() - 1; i >= 0; i--) {
            reversList.add(initList.get(i));
        }
        return reversList;
    }

    public static LinkedList<Integer> fillLinkedList(int numb) {

        LinkedList<Integer> initList = new LinkedList<>();
        Random rand = new Random();
        for (int i = 0; i < numb; i++ ) {
            initList.add(rand.nextInt(10));
        }
        return initList;
    }


    // Реализуйте очередь с помощью LinkedList со следующими методами:
        // • enqueue() — помещает элемент в конец очереди,
        // • dequeue() — возвращает первый элемент из очереди и удаляет его,
        // • first() — возвращает первый элемент из очереди, не удаляя.

    public static LinkedList<Integer> enqueueList(LinkedList<Integer> initList) {
        for (int i = 0; i < initList.size(); i++) {
            if (i == 0) initList.set(initList.size()-1, initList.get(i));   
            else initList.set(i-1, initList.get(i));                
        }
        return initList;
    }

    public static LinkedList<Integer> dequeueList(LinkedList<Integer> initList) {
        System.out.println("Первый элемент - " + initList.get(0));
        initList.remove(0);
        return initList;
    }
    
    public static void firstElemList(LinkedList<Integer> initList) {
        System.out.println("Первый элемент - " + initList.get(0));
    }

        // В калькулятор добавьте возможность отменить последнюю операцию.
        
    public static void calc() {
            
        Stack<Integer> allResult = new Stack<>();
        String status = "";
        String canselOperation = "";
    
        while (!status.toUpperCase().equals("СТОП")) {
            int result = 0;
            System.out.println("Введите первое число:");
            int numbA = Integer.parseInt(readNumb());
            System.out.println("Введите второе число:");
            int numbB = Integer.parseInt(readNumb());
            System.out.println("Введите операцию:");
            String sign = readNumb();
    
            switch (sign) {
                case ("+"):
                    result = numbA + numbB;
                    break;
                case ("-"):
                    result = numbA - numbB;
                    break;
                case ("*"):
                    result = numbA * numbB;
                    break;
                case ("/"):
                    if (numbB !=0) result = numbA / numbB;
                    else System.out.println("Нельзя делить на 0!");
                    break;
            }
        
            System.out.println("Результат");
            System.out.println(result);
            allResult.push(result);
            System.out.println("Если вы хотите отменить послендюю операцию введите \"ОТМЕНА\"");
            canselOperation = readNumb();
            if (!canselOperation.isEmpty() && canselOperation.toUpperCase().equals("ОТМЕНА")) {
                allResult.pop();
                result = allResult.peek();
                System.out.println("Результат");
                System.out.println(result);
            }
            System.out.println("Введите \"СТОП\", чтобы закончить");
            status = readNumb();
        }
    }

    public static String readNumb () {
        return iScanner.nextLine();
    }
}