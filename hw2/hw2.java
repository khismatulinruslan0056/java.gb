package hw2;


import java.io.IOException;
import java.util.Arrays;

import java.util.Scanner;
import java.util.logging.*;


public class hw2 {
    static Scanner iScanner = new Scanner(System.in);
    static Logger logger = Logger.getLogger(hw2.class.getName());
    
    
    public static void main(String[] args) throws SecurityException, IOException {


        System.out.println("Выберите задание (1-4)");
        String task = readNumb();
        switch (task) {
        // Задание 1
            case ("1"):
                String str = "{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}";
                System.out.println(sqlStr(str));
                break;
        // Задание 2
            case ("2"):
        int[] _arr = fillArray(10);
        printArray(_arr);
        bubbleSort(_arr);
        printArray(_arr);
                break;
        // Задание 3
            case ("3"):

        


                break;
        // Задание 4
            case ("4"):
                calc();
                break;
        }
       
        
  
        iScanner.close();
    }
    
    
    
    public static String readNumb () {
        return iScanner.nextLine();
    }
    
    // Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
    // используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
    // Если значение null, то параметр не должен попадать в запрос.
    // Параметры для фильтрации: String str = "{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}";
    // Результат "select * from students where “name” = “Ivanov” and “country”=”Russia” ...
    
    public static String sqlStr(String str) {
        
        String strRequest = "select * from students where ";
        String[] man = new String[]{"\"name\" = ", " \"country\" = ", " \"city\" = ", " \"age\" = "};
        String _str = str.replaceAll("[^a-zA-Z: ]", "");
        String[] valuesStr = _str.split(" ");
        int count = 0;
        for (int i = 0; i < valuesStr.length; i++) {
    
            if (valuesStr[i].indexOf("null") == -1) {
    
                String[] graph = valuesStr[i].split(":");
    
                if (count == 0) strRequest += man[i] + "\"" + graph[1] + "\"";
                else strRequest += " and" + man[i] + "\"" + graph[1] + "\"";
                count++;
            }
        } 
        
        return strRequest;
        
    }


 // Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

    public static int[] fillArray(int N) {
        int[] arrOld = new int[N];
        for (int j = 0; j < arrOld.length; j++) {
            arrOld[j] = (int)(Math.random()*10);   
        }     
        return arrOld;
    }

    public static void printArray(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");  
        }     
        System.out.println();
    }

    public static int[] bubbleSort(int[] arr) {
        try {
            FileHandler fh = new FileHandler("logger_task2.log");
            logger.addHandler(fh);
            SimpleFormatter sf = new SimpleFormatter();

            fh.setFormatter(sf);
            logger.setUseParentHandlers(false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    
    

        int tmp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    logger.info(Arrays.toString(arr));
                }  
                
            }
        }   
        return arr;
    }


    //     ** Дана json строка (можно сохранить в файл и читать из файла)
    // [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, 
    // {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, 
    // {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
    // Написать метод(ы), который распарсит json и, используя StringBuilder, 
    // создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет]. Пример вывода:
    // Студент Иванов получил 5 по предмету Математика.
    // Студент Петрова получил 4 по предмету Информатика.
    // Студент Краснов получил 5 по предмету Физика.




    // К калькулятору из предыдущего дз добавить логирование.

    public static void calc() {
        try {
            FileHandler fh = new FileHandler("logger_task4.log");
            logger.addHandler(fh);
            SimpleFormatter sf = new SimpleFormatter();

            fh.setFormatter(sf);
            logger.setUseParentHandlers(false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int status = -1;

        while (status != 0) {
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
            String resForLog = numbA + " " + sign + " " + numbB + " = " + result;
            logger.info(resForLog);
            System.out.println("Результат");
            System.out.println(result);
            System.out.println("Введите 0, чтобы закончить");
            status = Integer.parseInt(readNumb());

            String statusForLog = "статус ";
            statusForLog += status == 0 ? status + " - выход из калькулятора" : status + " - следующая операция";
            logger.info(statusForLog);
        }
    }



}
