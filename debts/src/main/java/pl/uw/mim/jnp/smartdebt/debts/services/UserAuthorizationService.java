package pl.uw.mim.jnp.smartdebt.debts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.uw.mim.jnp.smartdebt.debts.models.constants.Constants;

@Service
public class UserAuthorizationService {

	@Autowired
	private RestTemplate restTemplate;

	public Boolean authorizeToken(String jwt) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(Constants.AUTHORIZATION_HEADER_STRING, jwt);
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		ResponseEntity<String> response = restTemplate.postForEntity(Constants.USER_SERVICE_AUTHORIZATION_URL, entity, String.class);
		return response.getStatusCode().equals(HttpStatus.OK);
	}
}
