package contacts;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    protected static List<Contact> contacts;

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

    public String format() {
        return String.format("%s %s %s", this.getFirstName(), this.getLastName(), this.getPhoneNumber());
    }

    public static List<Contact> getContacts() {
        return contacts;
    }

    public static void addContacts() {
        Input input = new Input();

        boolean wantsToContinue = true;

        System.out.println("\n----- Add New Contacts -----");

        do {
            String firstName = input.getString("Enter first name: ");
            String lastName = input.getString("Enter last name: ");
            String phoneNumber = input.getString("Enter phone number: ");

            Contact contact = new Contact(firstName, lastName, phoneNumber);

            contacts.add(contact);

            wantsToContinue = input.yesNo("Add another contact? [y/n] ");
        } while (wantsToContinue);
    }
}
