package spotify111;

import lombok.Data;

@Data
public class SpotifyAlbums {
	String name;
	String id;
	Album album;
	SpotifyXUrls external_urls;
}
