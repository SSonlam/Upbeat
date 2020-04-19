package spotify111;

import com.twilio.Twilio; 
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.chat.v1.service.User;
import com.twilio.type.PhoneNumber; 

import java.net.URI;
import java.util.List;
import java.math.BigDecimal; 
 

public class PhoneTexter { 
    private static final String ACCOUNT_SID = "ACcc17563600a356f37b0e153cddab67a3";
	private static final String AUTH_TOKEN = "ace9d7706566031d5bc2e0c3c38266a2";
	List<UserInfo> textList; 
	// Find your Account Sid and Token at twilio.com/console 

    public void sendText(String song, String phoneNumber) {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber(phoneNumber), 
                new com.twilio.type.PhoneNumber("+12028901045"), "Here is your daily song to keep your spirits up! (:" +  
                song)
            .create();
        System.out.println(message.getSid()); 
    }
}