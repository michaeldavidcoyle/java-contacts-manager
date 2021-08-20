package contacts;

public class Main {

    private static String[] menu = {
            "1. View contacts.",
            "2. Add a new contact.",
            "3. Search a contact by name.",
            "4. Delete an existing contact.",
            "5. Exit."
    };

    public static void displayMenu() {
        System.out.println("\n----- Main Menu -----");

        for (String item : menu) {
            System.out.println(item);
        }

        System.out.print("Enter an option (1, 2, 3, 4 or 5): ");
    }
}
