package spotify111;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.Data;
@Data
public class SpotifyConfig {
	@Bean
	public RequestInterceptor requestInterceptor() {
		return new RequestInterceptor() {
			public void apply(RequestTemplate t) {
				RestTemplate restTemplate = new RestTemplate();

				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
				headers.add("Authorization", "Basic N2RmMmVjZmZjMzdiNGI0N2JjNzEwY2IyYTBlNzU3Mzg6YWQwNzQ0NmZhMDRlNGQwOTk3ZjI4ZGJhM2M2YjNjNmM=");

				MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
				map.add("grant_type","client_credentials");

				HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);

				ResponseEntity<SpotifyTokenResponse> response =
				    restTemplate.exchange("https://accounts.spotify.com/api/token",
				                          HttpMethod.POST,
				                          entity,
				                          SpotifyTokenResponse.class);
				
				SpotifyTokenResponse str = response.getBody();
				System.out.println(str.getAccess_token());
				t.header("Authorization", "Bearer " + str.getAccess_token());
			}
		};
	}
	
}
