package functionalinterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // FUNCTION INTERFACE
        int incrementedValue = increment(1);
        Integer incrementByOneValue = incrementByOneFunction.apply(10);
        System.out.println(incrementByOneValue);

        Integer multiply = multiplyBy10Function.apply(incrementByOneValue);
        System.out.println(multiply);

        Function<Integer, Integer> andByOneAndThenMultiplyByTen = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(andByOneAndThenMultiplyByTen.apply(5));

        Function<Integer, Double> minusBy5 = incrementByOneFunction.andThen(multiplyBy10Function).andThen(minusBy5Function);
        System.out.println(minusBy5.apply(6));

        // BI-FUNCTION


    }

    static Function<Integer, Double> minusBy5Function = number -> Double.valueOf(number) - 5;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static int increment(int number) {
        return number + 1;
    }
}
