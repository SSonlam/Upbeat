package spotify111;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
	private static final String NULL = null;
	String phoneNumber;
	List<String> songs = new ArrayList<String>();
	UserInfo(){}
	
	public void setNumber(String inputNumber) {
		this.phoneNumber = inputNumber;
	}
	public String getNumber() {
		return this.phoneNumber;
	}
	public boolean haveNotSent(String inputSong) {
		for(int i = 0; i < songs.size(); i++) {
			
			if(songs.get(i) == NULL) {
				System.out.println("hello 1234");
				return true;
			}
			
			if(songs.get(i) == inputSong) {
				return false;
			}
			
		}
		return true;
	}
	
	public void addToSongList(String inputSong) {
		songs.add(inputSong);
	}
}
