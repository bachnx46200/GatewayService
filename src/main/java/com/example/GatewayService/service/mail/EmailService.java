//package com.example.GatewayService.service.mail;
//
//import com.example.GatewayService.DTOs.EmailDTO;
//import com.example.GatewayService.service.IMessageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import javax.ma
//
//@Service
//public class EmailService implements IMessageService<EmailDTO> {
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Override
//    public boolean sendMessage(EmailDTO emailDTO) {
//        try {
//            //create mail message
//            MimeMessage message = mailSender.createMimeMessage();
//
//            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
//
//            message.setContent(emailDTO.getContent(), "text/html");
//
//            helper.setTo(emailDTO.getRecipients());
//
//            helper.setSubject(emailDTO.getSubject());
//
//            //send mail
//            mailSender.send(message);
//
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
