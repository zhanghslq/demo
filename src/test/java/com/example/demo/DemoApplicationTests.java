package com.example.demo;

import com.example.demo.mail.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {


	@Resource
	private MailService mailService;
	@Test
	public void contextLoads() {

		mailService.sendSimpleMail("haisong.zhang@ykd.me","springboot 邮件","这是spring boot的第一个邮件");


	}
	@Test
	public void sendHtmlMail() throws MessagingException {

		String content="<html><body><h3>这是一封html邮件</h3></body></html>";
		mailService.sendHtmlMail("haisong.zhang@ykd.me","springboot 邮件",content);


	}
    @Test
    public void sendAttachMail() throws MessagingException {

        String content="<html><body><h3>这是一封附件邮件</h3></body></html>";
        mailService.sendAttachMail("haisong.zhang@ykd.me","springboot 附件邮件",content,"E:\\文档\\contract.sql");


    }



}

