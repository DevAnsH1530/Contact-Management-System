
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}


public class ContactManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();
        while (true) {

            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Sort Contacts by Name");
            System.out.println("4. List Contacts");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                addContact(contacts, scanner);
                break;
                case 2:
                searchContact(contacts, scanner);
                break;
                case 3:
                sortContacts(contacts);
                break;
                case 4:
                listContacts(contacts);
                break;
                case 5:
                deleteContact(contacts, scanner);
                break;
                case 6:
                System.out.println("Exiting the Contact Management System.");
                System.exit(0);
                break;
                default:
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
// Add a new contact to the list
    private static void addContact(ArrayList<Contact> contacts, Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.next();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.next();

        System.out.print("Enter Email: ");
        String email = scanner.next();

        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }
// Search for a contact by name, phone number, or email
    private static void searchContact(ArrayList<Contact> contacts, Scanner scanner) {
        System.out.print("Search by Name, Phone Number, or Email: ");
        String searchQuery = scanner.next();
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchQuery) ||
            contact.getPhoneNumber().equals(searchQuery) ||
            contact.getEmail().equalsIgnoreCase(searchQuery)) {
                System.out.println("Contact found: " + contact);
                return;
            }
        }
        System.out.println("Contact not found.");
    }
// Sort contacts by name in ascending order
    private static void sortContacts(ArrayList<Contact> contacts) {
        Collections.sort(contacts, Comparator.comparing(Contact::getName));
        System.out.println("Contacts sorted by name in ascending order.");
    }
// List all contacts
    private static void listContacts(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
    // Delete a contact
    private static void deleteContact(ArrayList<Contact> contacts, Scanner scanner) {
        System.out.print("Enter Name, Phone Number, or Email to delete: ");
        String deleteQuery = scanner.next();
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(deleteQuery) ||
            contact.getPhoneNumber().equals(deleteQuery) ||
            contact.getEmail().equalsIgnoreCase(deleteQuery)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
    }
}