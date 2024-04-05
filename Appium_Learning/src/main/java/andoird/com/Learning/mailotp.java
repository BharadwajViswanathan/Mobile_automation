package andoird.com.Learning;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class mailotp {


	@Test
	private void mailotpvalidation() throws IOException, MailosaurException {
		String apiKey = "9mpUGSR6HXFkkoCQt8PcP2obknAjKFyE";
		String serverId = "smyotckn";
		String serverDomain = "smyotckn.mailosaur.net";


		MailosaurClient mailosaur = new MailosaurClient(apiKey);


		MessageSearchParams params = new MessageSearchParams();
		params.withServer(serverId);


		SearchCriteria criteria = new SearchCriteria();
		criteria.withSentTo("ranjith@" + serverDomain);

		Message message = mailosaur.messages().get(params, criteria);

		//		    System.out.println(message.text().body());
		//		    Pattern pattern = Pattern.compile(".*([0-9]{6}).*");
		//		    Matcher matcher = pattern.matcher(message.text().body());
		//		    matcher.find();
		//
		//		    System.out.println(matcher.group(1));

		Document doc = Jsoup.parse(message.html().body());

		Elements elements = doc.getElementsByClass("otp-text");
		String verificationCode = elements.get(0).text();
	
		
		mailosaur.messages().deleteAll(serverId);
		System.out.println(verificationCode);
	}
}
