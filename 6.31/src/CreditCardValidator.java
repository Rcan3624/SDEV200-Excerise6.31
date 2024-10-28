import java.util.Scanner;
/*
Credit card numbers follow certain patterns. A credit card number must have between 13 and 16 digits. It must start with

4 for Visa cards

5 for Master cards

37 for American Express cards

6 for Discover cards


 */



public class CreditCardValidator {

    /** Return true if the card number is valid */
   public static boolean isValid(long number) {
       int sumOfAllPlaces = sumOfOddPlace(number) + sumOfDoubleEvenPlace(number);
       if ((sumOfAllPlaces % 10) == 0) {
           return true;
       }
        return false;
    }

    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number) {
        int sumOfEvenPlaces = 0;

        String numberString = Long.toString(number);
        int cardNumberLength = numberString.length();
        for (int i = cardNumberLength - 2; i >= 0; i = i - 2) {
            int digit = getDigit(Integer.parseInt(numberString.substring(i, i + 1)));
            digit = digit * 2;
            sumOfEvenPlaces += digit;
        }
        return sumOfEvenPlaces;
    }

    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number) {
        if (number >= 10 ) {
            return (number - 9);
        } else {
            return number;
        }
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number) {
        int sumOfOddPlaces = 0;

        String numberString = Long.toString(number);
        int cardNumberLength = numberString.length();
        for (int i = cardNumberLength - 1; i >= 0; i = i - 2) {
            int digit = Integer.parseInt(numberString.substring(i, i + 1));
            sumOfOddPlaces += digit;
        }
        return sumOfOddPlaces;
    }

    /** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(long number, int d) {
        String userCardString = Long.toString(number);
        String prefixString = Integer.toString(d);

        if (userCardString.startsWith(prefixString)) {
            return true;
        }

        return false;
    }

    /** Return the number of digits in d */
   public static int getSize(long d) {
       int size = Long.toString(d).length();
//       System.out.println(size);
        return size;
    }

    /** Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number. */
    //public static long getPrefix(long number, int k)


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user to enter credit card
        System.out.println("Enter a credit card number as a long integer: ");
        long userCreditCard = input.nextLong();
        System.out.println("User Card: " + userCreditCard);
        int numberOfDigits = getSize(userCreditCard);
        if ((numberOfDigits < 13) || (numberOfDigits > 16)){
            System.out.println(userCreditCard + " is invalid");
        } else if (!((prefixMatched(userCreditCard, 37))
                || (prefixMatched(userCreditCard, 4))
                || (prefixMatched(userCreditCard, 5))
                || (prefixMatched(userCreditCard, 6))) ) {
            System.out.println(userCreditCard + " is invalid");

        } else if (!(isValid(userCreditCard))) {
            System.out.println(userCreditCard + " is invalid");
        } else {
            System.out.println(userCreditCard + " is valid");
        }
    }
}