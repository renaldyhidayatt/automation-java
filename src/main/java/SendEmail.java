import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

class Emailer{
    public static void send(String from, String password, String to, String sub, String msg){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.ethereal.email");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("chester.koelpin@ethereal.email", "wW7jWQJRRs9mce7KyK");
            }
        });

        try{
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
        }catch (MessagingException e){
            throw new RuntimeException(e);
        }
    }
}

public class SendEmail {
    public static void main(String[] args){
        Emailer.send("chester.koelpin@ethereal.email", "wW7jWQJRRs9mce7KyK", "kentang@gmail.com", "Hello", "Good Morning");
        System.out.println("Berhasil kirim email");
    }
}
