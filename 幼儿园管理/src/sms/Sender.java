package sms;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import windows.Window;
public class Sender {
	public static void sendSms(String number,String text) throws Exception{
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn"); 
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//��ͷ�ļ�������ת��
		NameValuePair[] data ={ new NameValuePair("Uid", "�Ϻ����2"),
				new NameValuePair("Key", "b5190d608ccaeed72c89"),
				new NameValuePair("smsMob",number),
				new NameValuePair("smsText",text)};
		post.setRequestBody(data);

		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		for(Header h : headers)
		{
		System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
		System.out.println(result);
		switch(Integer.parseInt(result)){
		case -1:windows.Window.messageWindow("", "û�и��û��˻�");break;
		case -2:windows.Window.messageWindow("", "�ӿ���Կ����ȷ\n�����˻���½����");break;
		case -21:windows.Window.messageWindow("", "MD5�ӿ���Կ���ܲ���ȷ");break;
		case -3:windows.Window.messageWindow("", "������������");break;
		case -11:windows.Window.messageWindow("", "���û�������");break;
		case -14:windows.Window.messageWindow("", "�������ݳ��ַǷ��ַ�");;break;
		case -4:windows.Window.messageWindow("", "�ֻ���ʽ����ȷ");break;
		case -41:windows.Window.messageWindow("", "�ֻ�����Ϊ��");break;
		case -42:windows.Window.messageWindow("", "��������Ϊ��");break;
		case -51:windows.Window.messageWindow("", "����ǩ����ʽ����ȷ\n�ӿ�ǩ����ʽΪ��ǩ������");;break;
		case -6:windows.Window.messageWindow("", "ip����");break;
		default :windows.Window.messageWindow("", "�ѷ��ͳɹ�"+Integer.parseInt(result)+"������");
		
		}
	

		post.releaseConnection();

	}
	
}
