package com.example.eventmanager.usefulclasses;



import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class Participant implements EventObserver, NotificationService{
    private String id;
    private String nom;
    private String email;

    //Getters and setters
    public String getId() {
        return id;
    }
    public Participant(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
   
    @Override
    public void update(Evenement event, String notificationType) {
        String subject = "Notification about " + event.getNom();
        String message;
        
        switch (notificationType) {
            case "CANCELLED":
                message = "The event " + event.getNom() + " has been canceled.";
                break;
            case "MODIFIED":
                message = "The event " + event.getNom() + " has been updated. New details: " + event.getDate();
                break;
            default:
                message = "There's an update regarding " + event.getNom();
        }
        
        envoyerNotification(subject, message);
    }
    @Override
    public String envoyerNotification(String subject, String message) {
        
        final String senderEmail = "enowarreyntow@gmail.com"; // Replace with your email
        final String senderPassword = "James Reiderz"; // Replace with your email password
        final String smtpHost = "smtp.gmail.com"; // Replace with your SMTP server (e.g., smtp.gmail.com for Gmail)
        final int smtpPort = 587; // Common SMTP port (use 465 for SSL)

        //Implementation to send email
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(senderEmail, senderPassword);
        }
        });
        try {
            // Create the email message
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(senderEmail));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(this.email)); // Send to participant's email
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);
    
            // Send the email
            Transport.send(mimeMessage);
            System.out.println("Email sent successfully to " + this.email);
            return "Email sent successfully to " + this.email;
        } catch (MessagingException e) {
            System.out.println("Error occured");
            return "Failed to send email: " + e.getMessage();
        }
        
    }
    
}
