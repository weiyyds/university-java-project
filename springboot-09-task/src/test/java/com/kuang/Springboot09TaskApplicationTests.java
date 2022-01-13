package com.kuang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TaskApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void contextLoads() {
        //一个简单的邮件发送完成！
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("毕业快乐!");//设置邮件主题
        mailMessage.setText("大专三年就快结束了，面临就业，你准备好了吗？");
        mailMessage.setTo("2659934495@qq.com");
        mailMessage.setFrom("2659934495@qq.com");
        mailSender.send(mailMessage);

    }
    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件发送完成！
        //MimeMessage mimeMessage = new MimeMessage();
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("小狂神你好呀！");
        helper.setText("<p style='color:red'>毕业快乐</p>",true);
        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\admin\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\admin\\Desktop\\2.jpg"));
        helper.setTo("2659934495@qq.com");
        helper.setFrom("2659934495@qq.com");
        mailSender.send(mimeMessage);

    }
    //把邮件封装成工具类
    /**
     *
     * @param html
     * @param subject
     * @param text
     * @throws MessagingException
     * @Author 少伟
     */

    public void toSendMail(Boolean html,String subject,String text) throws MessagingException {
        //一个复杂的邮件发送完成！
        //MimeMessage mimeMessage = new MimeMessage();
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);
        helper.setSubject(subject);
        helper.setText(text,html);
        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\admin\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\admin\\Desktop\\2.jpg"));
        helper.setTo("2659934495@qq.com");
        helper.setFrom("2659934495@qq.com");
        mailSender.send(mimeMessage);
    }

}
