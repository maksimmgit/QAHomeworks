package com.it_academy.practice.junit_basics;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;


import java.util.stream.Stream;

public class CalcArguments implements ArgumentsProvider {



    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context){
        return Stream.of(
                Arguments.of(new Calculator(calcArguments(1),calcArguments(2))),
                Arguments.of(new Calculator(calcArguments(3),calcArguments(4)))
            );
        }

    public int calcArguments(int ... a){
        System.out.println("Число аргументов: " + a.length);
        System.out.println("Содержимое: ");
        int n = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random()*200);
            n = a[i];
        }
        return n;
    }



}
