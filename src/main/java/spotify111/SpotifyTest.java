package spotify111;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Profile("default")
@Configuration
public class SpotifyTest {
	@Autowired
	SpotifyService spotifyService;
	List<UserInfo> phoneNumberList = new ArrayList<UserInfo>();
	@Scheduled(fixedRate = 60000)
	public void spotifyLoop() {
		spotifyService.doSomething(phoneNumberList);
	}
}
