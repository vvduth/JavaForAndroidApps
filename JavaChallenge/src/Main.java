import java.util.ArrayList;
import java.util.Scanner;

//import org.graalvm.compiler.nodes.NodeView.Default;

//import jdk.internal.org.objectweb.asm.Handle;

public class Main {

    private static ArrayList<Contact> contacts ;
    private static Scanner sc ;
    private static int id = 0 ;
    public static void main(String[] args) throws Exception {
        contacts = new ArrayList<>();
        System.out.println("Phone book simulator. Developed by Duc Thai");
        openMenu();
    }

    private static void openMenu(){
        System.out.println("Hello, choose one: " + 
                            "\n\t1. Manage Contacts" +
                            "\n\t2. Messages" + 
                            "\n\t3. Quit. "  );

        sc = new Scanner((System.in));
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                manageContacts();
                break;
            case 2 :
                manageMessages();
                break ;
            default:
                openMenu();
                break ;
        }

    }

private static void sendNewMess(){
    System.out.println("Enter the name of the recipient: ");
    String name = sc.next();
    if (name.equals("")){
        System.out.println("Please enter the name: ");
        sendNewMess();
    } else {
        boolean doesExist = false ;
        for (Contact c : contacts){
            if (c.getName().equals(name)){
                
                doesExist = true ;
            } 
        
        }
        if ( doesExist){
            System.out.println("Enter the message: ");
            String text = sc.next();
            if(text.equals("")){
                System.out.print("Please entet real text:");
                sendNewMess();
            } else {
                id++;
                Message newMess = new Message(text, name, id);
                for (Contact c: contacts) {
                    if (c.getName().equals(name)){
                        ArrayList<Message> newMesses = c.getMessages();
                        newMesses.add(newMess);
                        Contact currentContact = c;
                        currentContact.setMessages(newMesses);
                        contacts.remove(c);
                        contacts.add(currentContact);
                    } 

                    
                }
            }
            openMenu();
            
        } else {
            System.out.println("Sorry, no result, please check the name again");
        }
        
    }
}

private static void showAllMess(){
    ArrayList<Message> allMess = new ArrayList<>();
    for ( Contact c: contacts ){
        allMess.addAll(c.getMessages());
    }

    if (allMess.size() > 0){
        for (Message  m : allMess ){
            m.getDetails();
            System.out.println("*********************");
        }
    } else {
        System.out.println("You do not have any message with this people");
    }
    openMenu();
}

private static void manageMessages(){
        System.out.println("Welcome to messages, choose one: " + 
                            "\n\t1. Show all mess" +
                            "\n\t2. Send a new mes" + 
                            "\n\t3. Go back "  );
        int choice  = sc.nextInt();
        switch(choice){
            case 1:
                showAllMess();
                break ;
            case 2:
                sendNewMess();
                break ;
            default:
                openMenu();
                break;
    }
  }

private static void manageContacts(){
        System.out.println("Welcome to contact, choose one: " + 
                            "\n\t1. Show all contacts" +
                            "\n\t2. Add a new contact" + 
                            "\n\t3. Search for a new contact. "+
                            "\n\t4. Delete a contact" +
                            "\n\t5. Go back to previous section"  );
        int choice  = sc.nextInt();
        switch(choice){
            case 1:
                showAllContacts();
                break ;
            case 2:
                addNewContact();
                break ;
            case 3:
                searchForContact();
                break ;
            case 4:
                deleteContact();
                break ;
            default:
                openMenu();
                break;
    }
  }



private static void deleteContact(){
    System.out.println("Enter the name of the contact you want to delete:");
    String name = sc.next();
    if (name.equals("")){
        System.out.println("Please enter the name: ");
        deleteContact();
    } else {
        boolean doesExist = false ;
        for (Contact c : contacts){
            if (c.getName().equals(name)){
                
                doesExist = true ;
                contacts.remove(c);
            } 
        
        }
        if ( !doesExist){
            System.out.println("Sorry, no result, please check the name again");
        }
    }
    openMenu();
}

private static void searchForContact(){
    System.out.println("Enter the name of the contact you are looking for: ");
    String name = sc.next() ;
    if (name.equals("")){
        System.out.println("Please enter the name: ");
        searchForContact();
    } else {
        boolean doesExist = false ;
        for (Contact c : contacts){
            if (c.getName().equals(name)){
                c.getDetails();
                doesExist = true ;
            } 
        
        }
        if ( !doesExist){
            System.out.println("Sorry, no result, please check the name again");
        }
    }
    openMenu();
}

private static void showAllContacts(){
      for (Contact c: contacts){
          c.getDetails();
          System.out.println("*********************");
      }
      openMenu();
  }

private static void addNewContact(){
    System.out.println("Enter name :");
    String name = sc.next();
    System.out.println("Enter number: ");
    String number = sc.next();
    System.out.println("Enter email: ");
    String email = sc.next();

    if( name.equals("") || number.equals("")||email.equals("") ){
        System.out.println("Enter all the info please.");
        addNewContact();
    } else {
        boolean doesExist = false ;
        for (Contact c : contacts){
            if (c.getName().equals(name)){
                doesExist = true;
                
            } 
        }
        if (doesExist){
            System.out.println("Name " + name + " is existed in the list, check and enter again: ");
            addNewContact();
        } else {
            Contact contact = new Contact(name, number, email);
            contacts.add(contact);
            System.out.println("Added.");
        }
       
    }
    openMenu();
}
}