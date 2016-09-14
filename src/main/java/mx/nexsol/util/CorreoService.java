package mx.nexsol.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by ironhide on 24/08/16.
 */
public class CorreoService {


    public boolean enviaCorreoContrasenia() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getInstance(properties, null);
        Message mensaje = new MimeMessage(session);

        try {
            mensaje.setSubject("Nuevo usuario");
            mensaje.setFrom(new InternetAddress("alexalbiazulra@gmail.com", "Alejandro Diaz"));
            mensaje.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("alexalbiazulra@gmail.com")});
            String mensageCuerpo = "se envia correo de prueba";
            mensaje.setText(mensageCuerpo);

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", "alexalbiazulra@gmail.com", "adsolis7");
            transport.sendMessage(mensaje, mensaje.getAllRecipients());
            transport.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


}
