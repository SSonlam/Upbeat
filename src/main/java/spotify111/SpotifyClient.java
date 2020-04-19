package spotify111;




import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(url="https://api.spotify.com/v1", value = "spotifyClient", configuration = SpotifyConfig.class)
public interface SpotifyClient {
	@GetMapping("/recommendations")
	SpotifyTracks getRecomendation(@RequestParam("seed_genres")String search, @RequestParam("limit")String limit);
}
