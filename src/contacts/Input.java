package contacts;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        return this.scanner.next();
    }

    public String getString(String prompt) {
        System.out.print(prompt);
        return this.scanner.next();
    }

    public boolean yesNo() {
        return this.getString().toLowerCase().contains("y");
    }

    public boolean yesNo(String prompt) {
        return this.getString(prompt).toLowerCase().contains("y");
    }

    public int getInt() {
        String userInput = this.getString();
        int userInt;

        try {
            userInt = Integer.valueOf(userInput); // IntelliJ suggests using parseInt
        } catch (NumberFormatException e) {
            System.out.printf("\"%s\" is not a valid number. Please try again: ", userInput);
            return this.getInt();
        }

        return userInt;
    }

    public int getInt(String prompt) {
        System.out.print(prompt);
        return this.getInt();
    }

    public int getInt(int min, int max) {
        int userInt = this.getInt();

        if (userInt < min || userInt > max) {
            System.out.print("Sorry, that's not within the range. Please try again: ");
            return this.getInt(min, max);
        } else {
            return userInt;
        }
    }

    public int getInt(String prompt, int min, int max) {
        System.out.print(prompt);
        return this.getInt(min, max);
    }
}

