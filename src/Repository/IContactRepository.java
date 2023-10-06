package Repository;


import Model.Contact;
import java.util.ArrayList;

/**
 *
 * @author tuanh
 */

public interface IContactRepository {
    void createContact(ArrayList<Contact> contacts);
    void printAllContact(ArrayList<Contact> contacts);
    void deleteContactd(ArrayList<Contact> contacts);
}

