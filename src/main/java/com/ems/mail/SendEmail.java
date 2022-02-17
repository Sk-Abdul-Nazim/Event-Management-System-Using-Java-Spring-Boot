package com.ems.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;  
  

public class SendEmail  
{  
	@Autowired
    private static JavaMailSender javaMailSender;
    

    public static SimpleMailMessage  sendEmail() {

//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo("sknazim1818@gmail.com");
//
//        msg.setSubject("Testing from Spring Boot");
//        msg.setText("Hello World \n Spring Boot Email");
//
//        javaMailSender.send(msg);
    	
    
    		SimpleMailMessage message = new SimpleMailMessage();
    		message.setTo("sknazim1818@gmail.com");
    		message.setFrom("sknazim4749@gmail.com");
    		message.setSubject("Important email");
    	    message.setText("FATAL - Application crash. Save your job !!");
    	    return message;
    	}

}


//
////Send an HTML email and a file attachment.
//
//
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//void sendEmailWithAttachment() throws MessagingException, IOException {
//
//    MimeMessage msg = javaMailSender.createMimeMessage();
//
//    // true = multipart message
//    MimeMessageHelper helper = new MimeMessageHelper(msg, true);
//    
//    helper.setTo("to_@email");
//
//    helper.setSubject("Testing from Spring Boot");
//
//    // default = text/plain
//    //helper.setText("Check attachment for image!");
//
//    // true = text/html
//    helper.setText("<h1>Check attachment for image!</h1>", true);
//
//    // hard coded a file path
//    //FileSystemResource file = new FileSystemResource(new File("path/android.png"));
//
//    helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));
//
//    javaMailSender.send(msg);
//
//}