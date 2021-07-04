package kr.co.mySpring.mail.controller;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mySpring.mail.MailVO.MailVO;

@Controller
public class sendMailController {
	
	@Autowired 
	private JavaMailSenderImpl mailSender;

	
	
	@RequestMapping(value = "/sendMail.do") 
	public String sendMail(final MailVO mailVO) { 
		final MimeMessagePreparator preparator = new MimeMessagePreparator() { 
			
			@Override public void prepare(MimeMessage mimeMessage) throws Exception { 
				final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8"); 
				helper.setFrom(mailVO.getFrom()); 
				helper.setTo(mailVO.getTo()); 
				helper.setSubject(mailVO.getSubject()); 
				helper.setText(mailVO.getContents(), true);
				
				FileSystemResource file = new FileSystemResource(new File("/tmp/java.jpg")); 
				helper.addAttachment("java.jpg", file);
			} 
		}; 
		mailSender.send(preparator); 
		return "succesMail"; 
	}
	
}
