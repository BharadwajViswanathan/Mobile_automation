package com.configure;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;



public class otp extends config{
	  static MailosaurClient mailosaur;
	  static MessageSearchParams params;
	  static SearchCriteria criteria;
	  static String serverId;
/**
 * generate an email for otp using mailosaur api
 * @return dynamic email id 
 */
	public static String setemailid(String emailname) {

		String apiKey = prop.getProperty("apiKey");
		serverId = prop.getProperty("serverId");
		String serverDomain = prop.getProperty("serverDomain");

	   mailosaur = new MailosaurClient(apiKey);

		params = new MessageSearchParams();
		params.withServer(serverId);
		String emailid=emailname+"@"+serverDomain;
//		String dynamicemailid = "user"+currenttimewithoutspace()+"@" + serverDomain;
		 criteria = new SearchCriteria();
		
		criteria.withSentTo(emailid);
		

		return emailid;
	}
		//		    System.out.println(message.text().body());
		//		    Pattern pattern = Pattern.compile(".*([0-9]{6}).*");
		//		    Matcher matcher = pattern.matcher(message.text().body());
		//		    matcher.find();
		//		    System.out.println(matcher.group(1));
/**
 * get the email otp based on the setotp using mailosaur api
 * @return email otp
 */
	public static String getemailotp() {	
		Message message = null;
		try {
			message = mailosaur.messages().get(params, criteria);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MailosaurException e) {
         	e.printStackTrace();
		}
		Document doc = Jsoup.parse(message.html().body());

		Elements elements = doc.getElementsByClass("otp-text");
		String verificationCode = elements.get(0).text();
		try {
			mailosaur.messages().deleteAll(serverId);
		} catch (MailosaurException e) {
			e.printStackTrace();
		}
		return verificationCode;
	}
	
}
