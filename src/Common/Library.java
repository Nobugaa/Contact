/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import Model.Contact;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
   
    private Scanner sc = new Scanner(System.in);
    private String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";
    
    public int inputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String inputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
    public int inputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input number!");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String inputPhone() {
        //loop until user input correct
        while (true) {
            String result = inputString();
            if (result.matches(VALID_PHONE)) {
                return result;
            }
            System.err.println("Please input Phone flow: \n"
                    + "• 1234567890\n"
                    + "• 123-456-7890 \n"
                    + "• 123-456-7890 x1234\n"
                    + "• 123-456-7890 ext1234\n"
                    + "• (123)-456-7890\n"
                    + "• 123.456.7890\n"
                    + "• 123 456 7890");
            System.out.print("Enter again: ");
        }
    }  
  
    public boolean inputYesNo() {
        while (true) {
            String result = inputString().trim();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public boolean checkIdExist(ArrayList<Contact> contacts, int id) {
        for (Contact c : contacts) {
            if (c.getContactId() == id) {
                System.err.println("Id existed!");
                return false;
            }
        }
        return true;
    }
    
  
}