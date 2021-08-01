package com.it_academy.practice.junit_basics;

public class Calculator {

    private int a;
    private int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
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

    public float calculate(char operation) {
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
                return a / b;
            }
            case '*': {
                return a * b;
            }
        }
    }


    /**
     * Возведение в степень самописным алгоритмом с 1 курса java.
     * Включена проверка на отрицательную степень.
     *
     * @return
     */
    public double pow(){
        double result = 1;
        if (b >=0) {
            if (b == 1) {
                return a;
            }
            int x = 0;
            while (x < b) {
                result = result * a;
                x++;
            }
            return result;
        }else{
            b = -b;
            for(long i = 0; i < b; i++) {
                result *= a;
            }
            return 1 / result;
        }
    }


    /*
    Привёл их к double чтобы не трогать оригинальный класс calculator и чтобы не писать две пачки аргументов.
     */
    public double root(){
        double c = a*1.0;
        double d = b*1.0;
        if(c<0 && d%2 == 0){
            System.out.println("Invalid Degree");
            return 0;
        }else {
            return Math.pow(c, (1 / d));
        }
    }


}
