package Controller;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class app {
 // Find your Account SID and Auth Token at twilio.com/console
 // and set the environment variables. See http://twil.io/secure
 public static final String ACCOUNT_SID = "ACf692c6f6c0d7d550adf4c5040b2b980f";
 public static final String AUTH_TOKEN = "db19ba5d87e1177b73c9a55f1a16c706";

 public static void main(String[] args) {
     Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
     Message message = Message.creator(
             new com.twilio.type.PhoneNumber("whatsapp:+212689346213"),
             new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
             "Twilio is working!")
         .create();

     System.out.println(message.getSid());
 }
}
