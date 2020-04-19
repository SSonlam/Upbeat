package spotify111;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SpotifyService {
	@Autowired
	SpotifyClient spotifyClient;
	
	public void doSomething(List<UserInfo> phoneNumberList) {
		
		UserInfo temp = new UserInfo();
		temp.setNumber("12064223070");
		phoneNumberList.add(temp);
		SpotifyTracks st = spotifyClient.getRecomendation("happy", "100");
		List<SpotifyAlbums> sa = st.getTracks();
		System.out.println(sa.size());
		int size = sa.size();
		int randomNumber = randomNumberGenerator(size);		
		String songUrl = sa.get(randomNumber).getExternal_urls().getSpotify();	
		
		for(int i = 0; i < phoneNumberList.size(); i++) {
			if(phoneNumberList.get(i).haveNotSent(songUrl)) {
				PhoneTexter phoneTexter = new PhoneTexter();
				phoneTexter.sendText(songUrl,phoneNumberList.get(i).getNumber());
				phoneNumberList.get(i).addToSongList(songUrl);
			}else {
				songUrl = sa.get(randomNumber).getExternal_urls().getSpotify();	
				--i;
			}
		}
	}
	private int randomNumberGenerator(int passedInt){
		double randomNumberStart = Math.random() * passedInt;
		return (int)(Math.round(randomNumberStart));
	}
}
