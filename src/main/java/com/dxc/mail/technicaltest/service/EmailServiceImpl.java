package com.dxc.mail.technicaltest.service;

import com.dxc.mail.technicaltest.constants.SecurityConstants;
import com.dxc.mail.technicaltest.util.SecurityHelper;
import com.dxc.mail.technicaltest.vo.Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailServiceImpl implements  EmailService {
    public void send(Email email) throws Exception {

        int index= 0;

        try {
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", "localhost");
            properties.setProperty("mail.smtp.port", "portnumber");
            properties.setProperty("mail.smtp.auth", "true");
            properties.setProperty("mail.smtp.starttls.enable", "true");
            final String userName = email.getFromAddress();
            final String password = email.getPassword();

            Session session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(userName, password);
                        }
                    });

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(email.getFromAddress()));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getToAddress()));
            message.setSubject(email.getSubject());
            message.setContent(message, email.getMailContent());
            String algorithmFormat = getAlgorthimFormat(email.isHtml(), email.isInternalServer());
            SecurityHelper.encrypt(email.getMailContent(), "securityKey", algorithmFormat);
            Transport.send(message);
            System.out.println("mail went successfully");
        }  catch ( MessagingException exp) {
               ++index;
             if(exp.getNextException() instanceof  Exception ) {
                 if(index < 3) {
                     send(email);
                 }

             }
        }
    }

    private String getAlgorthimFormat(boolean isHtml, boolean isInternalServer) {

        if (isHtml) {
            if (isInternalServer) {
                return SecurityConstants.DES_ALGORITHM;
            } else {
                return SecurityConstants.AES_ALGORITHM;
            }
        } else if(!isInternalServer) {
            return SecurityConstants.DES_ALGORITHM;
        } else  {
            return null;
        }
    }
}