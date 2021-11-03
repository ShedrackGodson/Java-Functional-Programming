package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // FUNCTION INTERFACE: Takes 1 argument and return 1
        int incrementedValue = increment(1);
        Integer incrementByOneValue = incrementByOneFunction.apply(10);
        System.out.println(incrementByOneValue);

        Integer multiply = multiplyBy10Function.apply(incrementByOneValue);
        System.out.println(multiply);

        Function<Integer, Integer> andByOneAndThenMultiplyByTen = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(andByOneAndThenMultiplyByTen.apply(5));

        Function<Integer, Double> minusBy5 = incrementByOneFunction.andThen(multiplyBy10Function).andThen(minusBy5Function);
        System.out.println(minusBy5.apply(6));

        // BI-FUNCTION: Takes 2 arguments and return 1
        System.out.println(addAndTimesByNumber(5, 10));
        System.out.println(andAndTimesByNumberBiFunction.apply(5, 10));

        // Chain Function and Bi-Function
        System.out.println(
                andAndTimesByNumberBiFunction
                        .apply(300, incrementByOneFunction.andThen(multiplyBy10Function)
                                .andThen(minusBy5Function).apply(500).intValue())
        );

    }

    // Function
    static Function<Integer, Double> minusBy5Function = number -> Double.valueOf(number) - 5;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    // Bi-Function
    static BiFunction<Integer, Integer, Integer> andAndTimesByNumberBiFunction =
        (numberToAddBy, numberToMultiplyBy) -> (numberToAddBy + 1) * numberToMultiplyBy;

    static int increment(int number) {
        return number + 1;
    }

    static int addAndTimesByNumber(int number, int multiplier) {
        return (number + 1) * multiplier;
    }
}
