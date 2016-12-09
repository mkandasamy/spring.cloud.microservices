package com.kandasm.opm.web.util.dashboard;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetRestClient {
	
	private RestTemplate restTemplate;

	public GetRestClient(){
		this.restTemplate = new RestTemplate();
	}
	
	public <T> T get(String url, Class<T> type){
		return restTemplate.getForObject(url, type);
	}
	
}
