package mx.nexsol.util;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by ironhide on 24/08/16.
 */

@Service
public class CorreoService implements Serializable {

    public boolean enviaCorreoContrasenia(String contrasena, String usuario) {
        System.out.println("Entro al service de correo");
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFacto   ry.fallback", "false");

        Session session = Session.getInstance(properties, null);
        Message mensaje = new MimeMessage(session);

        try {
            mensaje.setSubject("Nuevo usuario");
            mensaje.setFrom(new InternetAddress("alexalbiazulra@gmail.com", "Alejandro Diaz"));
            mensaje.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("alexalbiazulra@gmail.com")});
            String mensageCuerpo = "Se ha generado una nueva cuenta. Usuario: " + usuario + " Contrasena: " + contrasena;
            mensaje.setText(mensageCuerpo);

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", "alexalbiazulra@gmail.com", "adsolis7");
            transport.sendMessage(mensaje, mensaje.getAllRecipients());
            transport.close();
            System.out.println("Se supone que ya lo mando");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
