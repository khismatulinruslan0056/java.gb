package hw1;

import java.util.Scanner;

public class hw1 {

    public static void main(String[] args) {
        System.out.println("Выберите задание (1-4)");
        String task = readNumb();
        switch (task) {
        // Задание 1
            case ("1"):
                System.out.println("Введите число: ");
                int N = Integer.parseInt(readNumb());
                System.out.println(numbTriangle(N));
                System.out.println(numbFact(N));
                break;
        // Задание 2
            case ("2"):
                simpleNumb();
                break;
        // Задание 3
            case ("3"):
                calc();
                break;
        // Задание 4
            case ("4"):
                System.out.println("Для решения уравнения типа '2? + ?5 = 69' введите числа уравнения");
                System.out.println("Первое число (Пример: 2?)");
                int A = checkNumb(readNumb());
                System.out.println("Второе число (Пример: ?5)");
                int B = checkNumb(readNumb());
                System.out.println("Третье число (Пример: 69)");
                int C = checkNumb(readNumb());
                solveEquat(A, B, C);
                break;
        }
        

    }

    public static int numbTriangle(int numb) {
        int result = 0; 
        for (int i = 1; i <= numb; i++) {
            result += i;
        }
        return result;
    }

    public static int numbFact(int numb) {
        int result = 1; 
        for (int i = 1; i <= numb; i++) {
            result *= i;
        }
        return result;
    }

    public static void simpleNumb() {
        for (int i = 1; i <= 1000; i++) {
            int count = 0;
            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                if (i%j == 0) count++;
                if (count > 1) break; 

            }
            if (count == 1) System.out.print(i + " ");
        }
    }



    public static String readNumb () {
        Scanner iScanner = new Scanner(System.in);
        String numb = iScanner.nextLine();
    //    iScanner.close();
        return numb;
    }

    public static void calc() {

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

            System.out.println("Результат");
            System.out.println(result);
            System.out.println("Введите 0, чтобы закончить");
            status = Integer.parseInt(readNumb());
        }



    }

    public static int checkNumb (String numb) {

        Boolean check = false; 
        Boolean checkA = false; 
        Boolean checkB = false; 
        try
        {
            Integer.parseInt(numb);
            check = true;
        } catch (Exception e) {
            check = false;
        }
 
        String numbA = "";
        String numbB = "";
        numbA += numb.charAt(0);
        numbB += numb.charAt(1);

        try
        {
            Integer.parseInt(numbA);
            checkA = true;
        } catch (Exception e) {
            checkA = false;
        }
        
        try
        {
            Integer.parseInt(numbB);
            checkB = true;
        } catch (Exception e) {
            checkB = false;
        }

        if (check) {
            return Integer.parseInt(numb);
        }
        else if (checkA) {
            return Integer.parseInt(numbA);
        }
        else if (checkB) {
            return Integer.parseInt(numbB);
        }
        return 0;

    }


    public static void solveEquat (int A, int B, int C) {
        int desNum = -1;
        for (int i = 0; i < 10; i++) {
            if (A * 10 + i + i * 10 + B == C) desNum = i;
 
        }
        if (desNum != -1) System.out.printf("%s%s + %s%s = %s", A, desNum, desNum, B, C);
        else System.out.println("Нет решений!");

    }

}
