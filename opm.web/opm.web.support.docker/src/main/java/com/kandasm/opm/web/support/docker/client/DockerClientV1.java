package com.kandasm.opm.web.support.docker.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.kandasm.opm.web.support.docker.model.DockerStats;
import com.kandasm.opm.web.support.docker.model.custom.DockerCreate;

@Component
public class DockerClientV1 implements DockerClient {
	
	@Autowired
	private Environment environment; 

	@Override
	public DockerStats create(DockerCreate dockerCreate) {
		return null;
	}

	@Override
	public boolean destroy(String containerId) {
		return false;
	}

	@Override
	public DockerStats stats(String containerId) {
		
		String url = "http://" + environment.getProperty("HOST_NAME") + ":4243";
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(getMessageConverters());
		restTemplate.getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request,body);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response;
        });
		
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("stream", "0");
		DockerStats dockerStats = restTemplate.getForObject(
				url + "/containers/" + containerId +  "/stats", 
				DockerStats.class,
				urlVariables);
		
		return dockerStats;
	}
	
	private List<HttpMessageConverter<?>> getMessageConverters() {
	    List<HttpMessageConverter<?>> converters = 
	      new ArrayList<HttpMessageConverter<?>>();
	    converters.add(new MappingJackson2HttpMessageConverter());
	    return converters;
	}
	
}
