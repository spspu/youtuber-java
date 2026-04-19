package com.mainapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendOtpEmail(String email, String otp) throws MessagingException {

    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

//        helper.setFrom("your-email@gmail.com"); //sender email
        helper.setTo(email);
        helper.setSubject("Verify OTP");

        String content = """
                <div>
                    <h3>OTP Verification</h3>
                    <p>Click below link to verify your account:</p>
                    <a href="http://localhost:8080/verify-account?email=%s&otp=%s" target="_blank">
                        Verify Account
                    </a>
                </div>
                """.formatted(email, otp);

        helper.setText(content, true);

        javaMailSender.send(mimeMessage);
    }
    
    public void sendSetPasswordEmail(String email) throws MessagingException {

    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

//        helper.setFrom("your-email@gmail.com"); 
        helper.setTo(email);
        helper.setSubject("Set Password");

        String content = """
                <div>
                    <h3>Set Password</h3>
                    <p>Click below link to set password:</p>
                    <a href="http://localhost:8080/set-password?email=%s" target="_blank">
                        Set Password
                    </a>
                </div>
                """.formatted(email);

        helper.setText(content, true);

        javaMailSender.send(mimeMessage);
    }
    
    
}