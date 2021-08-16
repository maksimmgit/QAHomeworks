package com.it_academy.practice.junit_basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    int a;
    int b;


    private static Stream<Arguments> obviousTests() {
        return Stream.of(
                Arguments.of(5, -5, 0),
                Arguments.of(5, 5, 10),
                Arguments.of(2, 5, 7),
                Arguments.of(-4, 4, 0),
                Arguments.of(-3, -3, 5),
                Arguments.of(50, -30, 999));
    }

    @ParameterizedTest
    @MethodSource("obviousTests")
    @DisplayName("Операция +")
    public void testAddition(int a, int b, int c){
        Assertions.assertEquals(c, new Calculator(a,b).calculate('+'));
    }

    @ParameterizedTest
    @CsvSource({"50,40,10","0,-5,-5"})//почему ошибка при вычитании?
    @DisplayName("Операция -")
    public void testSubtraction(int a, int b, int c){
        Assertions.assertEquals(c, new Calculator(a,b).calculate('-'));
    }

    @ParameterizedTest
    @MethodSource("obviousTests")
    @DisplayName("Операция /")
    public void testDiv(){
        Assertions.assertEquals(1, new Calculator(a,b).calculate('/'));
    }

    @ParameterizedTest
    @MethodSource("obviousTests")
    @DisplayName("Операция /")
    public void testMultipl(){
        Assertions.assertEquals(1, new Calculator(a,b).calculate('*'));
    }


    @Test
    @DisplayName("Калькулятор с некорректными входными данными")
    public void testCorrectData() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/file1.txt"));
        System.out.println(sc.nextLine());
        System.out.println(sc.nextLine());
        Assertions.assertThrows(NumberFormatException.class, () ->
                new Calculator(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())).calculate('/'));
    }

    @Test
    @DisplayName("Значения, выходящие за рамки диапазона.")
    public void testInfinite(){
        Assertions.assertThrows(ArithmeticException.class,
                () -> new Calculator(Math.toIntExact(9999999999L),Integer.MAX_VALUE).calculate('*'));
    }

    @Test
    @DisplayName("Проверяем деление на 0. ")
    public void divByZero(){
        Assertions.assertEquals(0, new Calculator(5,0).calculate('/'));
    }

    @Test
    @DisplayName("Проверить деление на типичную ошибку")
    public void divByZero2(){
        Assertions.assertThrows(ArithmeticException.class,
                ()-> new Calculator(5,0).calculate('/'));
    }


    /*
    В общем, я здесь долго думал как вывести сообщение исходя из текущих знаний и пришёл к выводу,
    что надо заваливать .assertTrue и выводить информационное сообщение о том, что на 0 делить нельзя.
    Если я неправильно понял условие задачи, то поясните куда смотреть и я перепишу.
     */
    @Test
    @DisplayName("Деление на 0")
    public void divByZero1(){
        Assertions.assertThrows(ArithmeticException.class,
                ()-> new Calculator(5,0).calculate('/'));
        Assertions.assertTrue(assertThrows(ArithmeticException.class,
                ()-> new Calculator(5,0).calculate('/')).equals(Exception.class), "Делить на ноль нельзя");
    }


    private static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of(5, -5),
                Arguments.of(5, 5),
                Arguments.of(5),
                Arguments.of(5, 5, 7));
    }

    @ParameterizedTest
    @MethodSource("params")
    @DisplayName("Проверка любым количеством параметров")
    public void calcParams(int... params){
        Assertions.assertEquals(5, new Calculator(params).calculateParams('+'));

    }



    private static Stream<Arguments> pow() {
        return Stream.of(
                Arguments.of(5, -5),
                Arguments.of(5, 5),
                Arguments.of(2, 5),
                Arguments.of(-4, 4),
                Arguments.of(-3, -3));
    }

    //Реализована проверка только по первой паре аргументов, дальше в ответах можно смотреть.
    @ParameterizedTest
    @MethodSource("pow")
    @DisplayName("Тестирование возведения в степень")
    public void calcPow(int a, int b){
        Assertions.assertEquals(0.00032,new Calculator(a,b).calculate('^'));
    }


    private static Stream<Arguments> rootArgs() {
        return Stream.of(
                Arguments.of(100, 2),
                Arguments.of(555, 5),
                Arguments.of(200, 2),
                Arguments.of(999, 3),
                Arguments.of(100, 2));
    }

    @ParameterizedTest
    @MethodSource("rootArgs")
    @DisplayName("Тестирование взятия корня")
    public void root(int a, int b){
        Assertions.assertEquals(10, new Calculator(a,b).calculate('√'));
    }






}
