package email;

import email.MailSenderInfo;
import email.SimpleMailSender;

//�������Ҫ�������ʼ�   
public class Sender {
	public static void sendmail(String address,String text){
		MailSenderInfo mailInfo = new MailSenderInfo();    
	    mailInfo.setMailServerHost("smtp.163.com");    
	    mailInfo.setMailServerPort("25");    
	    mailInfo.setValidate(true);    
	    
	    mailInfo.setUserName("chuanyi1993@163.com");    
	    mailInfo.setPassword("60205000lf");  
	    mailInfo.setFromAddress("chuanyi1993@163.com");    
	    mailInfo.setToAddress(address);    
	    mailInfo.setSubject("�׶�԰֪ͨ");    
	    mailInfo.setContent(text);         
	    SimpleMailSender sms = new SimpleMailSender();   
        sms.sendTextMail(mailInfo);//���������ʽ   
		
	}
}
