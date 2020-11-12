package library.service.imp;

import com.sun.mail.smtp.SMTPTransport;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

import static javax.mail.Message.RecipientType.CC;
import static javax.mail.Message.RecipientType.TO;
import static library.constant.EmailConstant.*;

//Edited
@Service
public class EmailService {

    public void sendEmail(String firstName, String password, String email) throws MessagingException {

        Message message = createEmail(firstName, password, email);

        SMTPTransport smtpTransport = (SMTPTransport) getEmailSession().getTransport(TRANSFER_PROTOCOL);
        smtpTransport.connect(SMTP_SERVER_GMAIL, USERNAME, PASSWORD);
        smtpTransport.sendMessage(message, message.getAllRecipients());
        smtpTransport.close();
    }

    private Message createEmail(String firstName, String password, String email) throws MessagingException {

        Message message = new MimeMessage(getEmailSession());
        
        message.setFrom(new InternetAddress(EMAIL_FROM));
        message.setRecipients(TO, InternetAddress.parse(email, false));
        message.setRecipients(CC, InternetAddress.parse(EMAIL_CC, false));
        message.setSubject(EMAIL_SUBJECT);
        message.setText("Text message");
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }

    private Session getEmailSession() {
        Properties properties = System.getProperties();
        properties.put(HOST_SMTP, SMTP_SERVER_GMAIL);
        properties.put(AUTH_SMTP, true);
        properties.put(PORT_SMPT, PORT_DEFAULT);
        properties.put(STARTTLS_ENABLE_SMTP, true);
        properties.put(STARTTLS_REQUIRED_SMTP, true);
        return Session.getInstance(properties, null);
    }
}
