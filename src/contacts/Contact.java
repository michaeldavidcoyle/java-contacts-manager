package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    protected static List<Contact> contacts = new ArrayList<>();

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toFileString() {
        return String.format("%s %s %s", this.getFirstName(), this.getLastName(), this.getPhoneNumber());
    }

    public String toConsoleString() {
        return String.format("%s %s | %s", this.getFirstName(), this.getLastName(), this.getPhoneNumber());
    }

    public static List<Contact> getContacts() {
        return contacts;
    }

    public static void populateContactsList() throws IOException {
        List<String> contactLines = FileIO.readFile();

        String[] contactInfo;

        for (String line : contactLines) {
            contactInfo = line.split(" ");
            contacts.add(new Contact(contactInfo[0], contactInfo[1], contactInfo[2]));
        }
    }

    public static void displayContacts(List<Contact> contactsList) {
        System.out.println("\nName     |     Phone Number");
        System.out.println("---------------------------");

        for (Contact contact: contactsList){
            System.out.println(contact.toConsoleString());
        }
    }

    public static void addContacts() {
        Input input = new Input();

        boolean wantsToContinue = true;

        System.out.println("\n----- Add New Contacts -----");

        String firstName;
        String lastName;
        String phoneNumber;
        Contact contact;

        do {
            firstName  = input.getString("Enter first name: ");
            lastName = input.getString("Enter last name: ");
            phoneNumber = input.getString("Enter phone number: ");

            wantsToContinue = input.yesNo("Add another contact? [y/n] ");

            contact = new Contact(firstName, lastName, phoneNumber);
            contacts.add(contact);
        } while (wantsToContinue);
    }

    public static List<Contact> findContact() {
        Input input = new Input();

        List<Contact> contactsMatch = new ArrayList<>();

        System.out.println("\n--------- Search Contacts ---------\n");

        String name = input.getString("Enter name: ");

        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(name)) {
                contactsMatch.add(contact);
            }

            if (contact.getLastName().equalsIgnoreCase(name)) {
                contactsMatch.add(contact);
            }
        }

        return contactsMatch;
    }

    public static void deleteContact() {
        Input input = new Input();

        System.out.println("\n--------- Delete Contact ---------\n");
        String name = input.getString("Enter name: ");

        String first;
        String last;

        boolean confirmDelete;

        ArrayList<Contact> contactsToDelete = new ArrayList<>();

        for (Contact contact: contacts) {
            first = contact.getFirstName();
            last = contact.getLastName();

            if (first.equalsIgnoreCase(name) || last.equalsIgnoreCase(name)) {
                System.out.println("Match found: ");
                System.out.println(contact.toConsoleString());

                confirmDelete = input.yesNo("Do you want to delete this contact? [y/n] ");

                if (confirmDelete) {
                    contactsToDelete.add(contact);
                }
            }
        }

        for (Contact contact : contactsToDelete) {
            contacts.remove(contact);
        }
    }
}
