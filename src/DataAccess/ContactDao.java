/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Common.Library;
import Model.Contact;
import java.util.ArrayList;

/**
 *
 * @author Xuan Vinh
 */
public class ContactDao {
    private static ContactDao instance = null;
    Library library;
    
    ArrayList<Contact> list;

    public ContactDao() {

        library = new Library();
        list = new ArrayList<>();
    }
    
    public static ContactDao Instance() {
        if (instance == null) {
            synchronized (ContactDao.class) {
                if (instance == null) {
                    instance = new ContactDao();
                }
            }
        }
        return instance;
    }
    public void createContact(ArrayList<Contact> contacts) {
        int i = 1;
        System.out.println("------------------------------- Create new contact ---------------------------------");
        while (true) {
            int contactId = i++;
            System.out.print("Enter first name: ");
            String firstName = library.inputString();
            System.out.print("Enter last name: ");
            String lastName = library.inputString();
            System.out.print("Enter group: ");
            String group = library.inputString();
            System.out.print("Enter address: ");
            String address = library.inputString();
            System.out.print("Enter phone: ");
            String phone = library.inputPhone();

            Contact c = new Contact(contactId, firstName +" "+ lastName, group, address, phone, firstName, lastName);
            if (library.checkIdExist(contacts, contactId)) {
                contacts.add(c);
            System.err.println("Create success!");
            }

                System.out.print("Do you want to create more students (Y/N): ");
            if (!library.inputYesNo()) {
                return;
            }
            
        }
    }
    public void printAllContact(ArrayList<Contact> contacts) {
        System.out.println("------------------------------- Display all list ---------------------------------");
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        //print infomation of contact from first to last list contact
        for (Contact contact : contacts) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getContactId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }
    
    public void deleteContactd(ArrayList<Contact> contacts) {
        System.out.print("Enter id: ");
        int idDelete = library.inputInt();
        Contact contactDelete = getContactById(contacts, idDelete);
        if (contactDelete == null) {
            System.err.println("Not found contact.");
            return;
        } else {
            contacts.remove(contactDelete);
        }
        System.err.println("Delete successful.");
    }

    //get contact by id
    public Contact getContactById(ArrayList<Contact> contacts, int idDelete) {
        for (Contact contact : contacts) {
            if (contact.getContactId() == idDelete) {
                return contact;
            }
        }
        return null;
    }

}
