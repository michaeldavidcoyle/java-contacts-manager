package contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static String[] menu = {
            "1. View contacts.",
            "2. Add a new contact.",
            "3. Search a contact by name.",
            "4. Delete an existing contact.",
            "5. Exit."
    };

    public static void displayMenu() {
        System.out.println("\n------------ Main Menu ------------");

        for (String item : menu) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Input input = new Input();

        try {
            Contact.populateContactsList();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int selection;

        do {
            displayMenu();
            selection = input.getInt("Enter an option (1, 2, 3, 4 or 5): ", 1, 5);

            switch (selection) {
                case 1:
                    Contact.displayContacts(Contact.getContacts());
                    break;
                case 2:
                    Contact.addContacts();
                    break;
                case 3:
                    List<Contact> contactSearch = Contact.findContact();

                    if (contactSearch.size() == 0){
                        System.out.println("Sorry, name not found.");
                    } else {
                         Contact.displayContacts(contactSearch);
                    }

                    break;
                case 4:
                    Contact.deleteContact();
                    break;
                case 5:
                    System.out.println("\nGoodbye.");
                    break;
            }
        } while (selection != 5);

        List<String> contacts = new ArrayList<>();

        for (Contact contact : Contact.getContacts()) {
            contacts.add(contact.toFileString());
        }

        try {
            FileIO.writeFile(contacts);
        } catch (IOException e) {
            System.out.println("There was a problem writing to file.");
        }
    }
}
