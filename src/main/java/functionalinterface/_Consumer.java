package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer shedrack = new Customer("Shedrack", "+255762547915");

        // Normal Function
        greetCustomer(shedrack);

        // Consumer Functional Interface
        greetCustomerConsumer.accept(shedrack);

        // Normal Function Implementation to emulate BiConsumer
        normalFunctionalBiConsumer(shedrack, 24);

        // Bi Consumer Interface Implementation
        functionalBiConsumer.accept(shedrack, 27);
    }

    // Consumer Function Interface
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName + ", thanks for registering " + customer.customerPhone);

    // Function Approach to implement Consumer
    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering " + customer.customerPhone);
    }

    // Function Approach to implement BiConsumer
    static void normalFunctionalBiConsumer(Customer customer, Integer age) {
        System.out.println("Hello, my name is " + customer.customerName + ", I am " + age + " years oldie!");
    }

    // BiConsumer Functional Interface Implementation
    static BiConsumer<Customer, Integer> functionalBiConsumer = (customer, age) ->
            System.out.println("Hello, my name is " + customer.customerName + ", I am " + age + " years oldie!");

    static class Customer {
        private final String customerName;
        private final String customerPhone;

        Customer(String customerName, String customerPhone) {
            this.customerName = customerName;
            this.customerPhone = customerPhone;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerName='" + customerName + '\'' +
                    ", customerPhone='" + customerPhone + '\'' +
                    '}';
        }
    }
}
