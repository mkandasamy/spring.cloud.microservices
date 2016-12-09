package com.kandasm.opm.web.util.docker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import com.kandasm.opm.web.util.docker.model.DockerStats;
import com.kandasm.opm.web.util.hystrix.ProviderService;

@Component
public class DockerStatsEndpoint implements Endpoint<DockerStats> {
	
	@Value("${docker.container.name}")
	private String containerName;
	
	@Autowired @Qualifier("dockerStatsProviderService")
	private ProviderService<String, DockerStats> dockerStatsProviderService;
	
	@Override
	public String getId() {
		return "docker/stats";
	}

	public boolean isEnabled() {
        return true;
    }
 
    public boolean isSensitive() {
        return true;
    }

	@Override
	public DockerStats invoke() {
		return dockerStatsProviderService.provide(containerName);
	}
	
}
