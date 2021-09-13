package com.it_academy.practice.junit_basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private int a;
    private int b;
    private ArrayList<Integer> paramList;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public ArrayList<Integer> getParamList() {
        return paramList;
    }

    public Calculator(int[] params) {
        paramList = new ArrayList<>();
        for (int i = 0; i < params.length; i++) {
            paramList.add(params[i]);
        }
    }

    public float getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double calculate(char operation) {

        switch(operation) {
            default: {
                return 0;
            }
            case '-': {
                return a - b;
            }
            case '+': {
                return a + b;
            }
            case '/': {
                try{
                    return a/b;
                }catch (ArithmeticException e){
                    System.out.println("нельзя делить на ноль");
                }
            }
            case '*': {
                return a * b;
            }
            //поменял символ корня на S, потому что jenkins отказывался запускать тест:)
            case 's': {
                return Math.sqrt(a);
            }
            case '^': {
                return Math.pow(a,b);
            }
        }
    }



    public float calculateParams(char operation) {
        int result = paramList.get(0);
        if (paramList.size() < 2) return 0;

        switch (operation) {
            default: {
                return 0;
            }
            case '+': {
                for (int i = 1; i < paramList.size(); i++) {
                    result = result + paramList.get(i);
                }
                return result;
            }
            case '-': {
                for (int i = 1; i < paramList.size(); i++) {
                    result = result - paramList.get(i);
                }
                return result;
            }
        }
    }


    public static int[] inputParameters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество параметров: ");
        int numberOfParameters = scanner.nextInt();
        System.out.println("Ведите " + numberOfParameters + " параметров:");
        int[] paramArray = new int[numberOfParameters];
        int a = 0;
        while (a < numberOfParameters) {
            try {
                int param = scanner.nextInt();
                paramArray[a] = param;
            } catch (Exception e) {
                System.out.println(e);
                break;
            }
            a++;
        }
        return paramArray;
    }

}
