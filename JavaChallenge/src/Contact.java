import java.util.ArrayList;

public class Contact {
    private String name ;
    private String number ;
    private String email;
    private ArrayList<Message> messages ;

    public Contact(String name , String number , String email, ArrayList<Message> messages){
        this.name = name ;
        this.number = number ;
        this.email = email;
        this.messages = messages ;
    }

    public Contact (String name, String number, String email){ //for create a new contact. it will not have any mess
        this.name = name ;
        this.number = number;
        this.email = email ;
        this.messages = new ArrayList<>(); // empty list
    }
    
    public void setName(String name ){
        this.name = name ;
    }
    public String getName(){
        return name ;
    }
    public void setNumber(String number){
        this.number = number ;
    }
    public String getNumber(){
        return number ;
    }
    public void setEmail(String email){
        this.email = email  ;
    }
    public String getEmail(){
        return email ;
    }
    public void setMessages(ArrayList<Message> messages){
       this.messages = messages;
    }

    public ArrayList<Message> getMessages(){
        return messages ;
    } 
    
    public void getDetails(){
        System.out.println("name: " + this.name  + 
        "\nnumber: " + this.number + 
        "\nEmail: " + this.email);
    }


}
