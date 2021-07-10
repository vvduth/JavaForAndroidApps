public class Message {
    private String text ;
    private String recipient;
    private int id ; // does not require but 4 the future

   public Message(String text, String recipient, int id ){
       this.text = text;
       this.recipient = recipient;
       this.id = id ;
   }

   public void getDetails(){
       System.out.println("Contact name: " + recipient + 
       "\nMessage: " + text + 
       "\nId: " + id);
   }

   public void setText(String text) {
       this.text = text;
   }
   public String getText(){
       return text;
   }
   public void setRecipient(String recipient){
       this.recipient = recipient;
   }
   public String getRecipient(){
       return recipient;
   }
   public void setId(int id){
       this.id = id ;
   }
   public int getId(){
       return id ;
   }
}
