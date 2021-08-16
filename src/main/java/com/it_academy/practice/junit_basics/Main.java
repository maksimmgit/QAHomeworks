package com.it_academy.practice.junit_basics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int [] paramArray = Calculator.inputParameters();

        Calculator calculatorNew = new Calculator(paramArray);
        System.out.println("Сложение: " + calculatorNew.calculateParams('+'));
        System.out.println("Вычитание: " + calculatorNew.calculateParams('-'));
    }
}
