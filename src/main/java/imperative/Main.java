package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Person.Gender.*;

public class Main {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Shedrack", MALE),
                new Person("Tabitha", FEMALE),
                new Person("Edward", MALE),
                new Person("Abednego", MALE),
                new Person("Seth", MALE),
                new Person("Obadiah", MALE),
                new Person("Godson", MALE),
                new Person("Josephine", FEMALE)
        );

        System.out.println("// Imperative Approach");
        // Imperative Approach
        List<Person> females = new ArrayList<>();
        for(Person person : people) {
            if(FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for(Person female : females) {
            System.out.println(female);
        }

        System.out.println("// Declarative approach");
        // Declarative approach
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        List<Person> females2 = people.stream()
                        .filter(personPredicate)
                        .collect(Collectors.toList());
        females2.forEach(System.out::println);

    }

    static class Person {
        private final String name;
        private final Gender gender;

        enum Gender {
            MALE, FEMALE
        }

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
}
