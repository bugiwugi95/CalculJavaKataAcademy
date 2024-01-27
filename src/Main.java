import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String expression = scanner.nextLine();

            String[] str = expression.split(" ");
            if (str.length != 3) {
                throw new Exception();
            }

            int a, b ;
            boolean isRoman ;
            try {
                a = Integer.parseInt(str[0]);
                b = Integer.parseInt(str[2]);
                isRoman = false;


            } catch (Exception e) {
                a = convertRomanToArabic(str[0]);
                b = convertRomanToArabic(str[2]);
                isRoman = true;
            }

            char op = str[1].charAt(0);
            if (op != '+' && op != '-' && op != '*' && op != '/') {
                throw new Exception();
            }

            int result = arithmeticOperation(a, op, b);

            if (isRoman) {
                if (result <= 0) {
                    throw new Exception();
                }
                String romanResult = convertArabicToRoman(result);
                System.out.println(calc(romanResult));
            } else {
                System.out.println(calc(String.valueOf(result)));
            }
        }


    //
    //


    public static int convertRomanToArabic(String romanNumber) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        int previousNumber = 0;
        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            int currentNumber = map.get(romanNumber.charAt(i));
            if (currentNumber >= previousNumber) {
                result += currentNumber;
            } else {
                result -= currentNumber;
            }
            previousNumber = currentNumber;

        }

        return result;

    }


    private static String convertArabicToRoman(int arabic) {
        StringBuilder roman = new StringBuilder();
        while (arabic >= 1000) {
            roman.append("M");
            arabic -= 1000;
        }
        while (arabic >= 900) {
            roman.append("CM");
            arabic -= 900;
        }
        while (arabic >= 500) {
            roman.append("D");
            arabic -= 500;
        }
        while (arabic >= 400) {
            roman.append("CD");
            arabic -= 400;
        }
        while (arabic >= 100) {
            roman.append("C");
            arabic -= 100;
        }
        while (arabic >= 90) {
            roman.append("XC");
            arabic -= 90;
        }
        while (arabic >= 50) {
            roman.append("L");
            arabic -= 50;
        }
        while (arabic >= 40) {
            roman.append("XL");
            arabic -= 40;
        }
        while (arabic >= 10) {
            roman.append("X");
            arabic -= 10;
        }
        while (arabic >= 9) {
            roman.append("IX");
            arabic -= 9;
        }
        while (arabic >= 5) {
            roman.append("V");
            arabic -= 5;
        }
        while (arabic >= 4) {
            roman.append("IV");
            arabic -= 4;
        }
        while (arabic >= 1) {
            roman.append("I");
            arabic -= 1;
        }

        return roman.toString();
    }

    public static int arithmeticOperation(int a, char op, int b) {
        int result = 0;
        switch (op) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> result = a / b;
        }
        if (a < 0 || a > 10 && b < 10){
            System.out.println("A Допустимые числа для ввода: от 1 до 10");
            result = 0;
        } else if (b < 0 || b > 10 && a < 10) {
            System.out.println("B Допустимые числа для ввода: от 1 до 10");
            result = 0;
        }

        return result;
    }

    public static String calc(String input) {
        return input;
    }
}