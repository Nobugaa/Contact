package Main;

import Controller.ContactManager;
import Model.Contact;

public class Main {

    public static void main(String[] args) {
        Contact contact = new Contact();
        new ContactManager(contact).run();
    }
}
