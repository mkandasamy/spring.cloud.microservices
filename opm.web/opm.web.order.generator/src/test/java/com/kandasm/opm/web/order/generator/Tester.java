package com.kandasm.opm.web.order.generator;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kandasm.opm.web.order.generator.rest.model.Generate;

public class Tester {

	public static void main111(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Generate generate = new Generate();
		generate.setDestinations(5L);
		generate.setOrderLines(4L);
		generate.setItems(3L);
		generate.setRecipients(3L);
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0Nzk5MTM2MTksInVzZXJfbmFtZSI6IndyaXRlciIsImF1dGhvcml0aWVzIjpbIlJFQUQiLCJXUklURSJdLCJqdGkiOiI1ZjUxYzk1Zi00YTVlLTQwODMtODI4NC1jOGI1OTRjNDdiYjAiLCJjbGllbnRfaWQiOiJvcG1fd2ViIiwic2NvcGUiOlsiV0VCIl19.NR6FarlQU2t8Anrs5abt5rpWoi6jlZqirCNGK3HNukpJL5VxKqniC1WdVy5hSC3YKiqV-gDcOoo692iGFIajU_uQWXVRcpov5L8NuWvanR94N8JLSQtN702NWYvXbjyVPgt_D4p_-ppyjxHLorYDR7LGZdSv1misacBWWMEFNW0TMml3Y470dh0EK6BCv8pxi027idrMDNz2P1TXe9eaV3WNx1Oms5Jit_rCHCWwTOjXVllv06w2SvCILnhGTge8-j_lB90S6LFUwZpVC2VhHrO4RY15_VQxOau7ON5uSFprLLByi6Y-oXWudGK3cYzQ0ss_h54bpNvZ5B76uk_-PA");
				
		HttpEntity<Generate> entity = new HttpEntity<>(generate, headers);
		
		ResponseEntity<String> resp = restTemplate.exchange(
				"http://tccmkandasamy.hibbertnet.com:10141/test", 
				HttpMethod.POST,
				entity,
			    String.class);
		
		System.out.println(resp.getBody());
	}

}
