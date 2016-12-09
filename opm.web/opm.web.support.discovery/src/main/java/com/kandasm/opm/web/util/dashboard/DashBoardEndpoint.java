package com.kandasm.opm.web.util.dashboard;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class DashBoardEndpoint implements Endpoint<Map<String, DashBoard>> {
	
	@Autowired
	private DashBoardProviderService dashBoardProviderService;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Override
	public String getId() {
		return "dashboard";
	}

	public boolean isEnabled() {
        return true;
    }
 
    public boolean isSensitive() {
        return true;
    }

	@Override
	public Map<String, DashBoard> invoke() {
		
		List<String> uriList = discoveryClient
			.getServices()
			.parallelStream()
			.map(service -> discoveryClient.getInstances(service))
			.flatMap(instances -> instances.stream())
			.map(instance -> instance.getUri().toString())
			.collect(Collectors.toList());
		
		return dashBoardProviderService.provideMap(uriList);
	}
	
}
