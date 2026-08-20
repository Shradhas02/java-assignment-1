import java.util.Scanner;

public class OctalBinaryConverter {

    // Octal -> Binary
    static String octalToBinary(String octal) {
        StringBuilder binary = new StringBuilder();
        String[] octToBin = {"000","001","010","011","100","101","110","111"};
        for (char c : octal.toCharArray()) {
            int digit = c - '0';
            if (digit < 0 || digit > 7) {
                throw new IllegalArgumentException("Invalid octal digit: " + c);
            }
            binary.append(octToBin[digit]);
        }
        return binary.toString();
    }

    // Binary -> Octal
    static String binaryToOctal(String binary) {
        // Pad on the left so length is a multiple of 3
        while (binary.length() % 3 != 0) {
            binary = "0" + binary;
        }
        StringBuilder octal = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 3) {
            String group = binary.substring(i, i + 3);
            int value = Integer.parseInt(group, 2); // base-2 parse
            octal.append(value);
        }
        return octal.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Octal to Binary\n2. Binary to Octal");
        int choice = sc.nextInt();
        System.out.print("Enter the number: ");
        String input = sc.next();

        if (choice == 1) {
            System.out.println("Binary: " + octalToBinary(input));
        } else {
            System.out.println("Octal: " + binaryToOctal(input));
        }
        sc.close();
    }
}