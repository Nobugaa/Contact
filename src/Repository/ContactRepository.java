
package Repository;


import DataAccess.ContactDao;
import Model.Contact;
import java.util.ArrayList;


public class ContactRepository implements IContactRepository{
private ArrayList<Contact> contacts;

    @Override
    public void createContact(ArrayList<Contact> contacts) {
        ContactDao.Instance().createContact(contacts);
    }

    @Override
    public void printAllContact(ArrayList<Contact> contacts) {
        ContactDao.Instance().printAllContact(contacts);
    }

    @Override
    public void deleteContactd(ArrayList<Contact> contacts) {
        ContactDao.Instance().deleteContactd(contacts);
    }

    
}
