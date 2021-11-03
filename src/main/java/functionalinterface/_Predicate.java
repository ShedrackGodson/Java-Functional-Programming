package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("0767546734"));
        System.out.println(isPhoneNumberValid("0667546734"));
        System.out.println(phoneNumberPredicate.test("0775450734"));
    }

    // Normal Function Validation
    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 10;
    }

    // Predicate Function Validation
    static Predicate<String> phoneNumberPredicate = phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 10;
}
