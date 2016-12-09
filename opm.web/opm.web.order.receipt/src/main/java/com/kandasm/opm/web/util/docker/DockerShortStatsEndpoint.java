package com.kandasm.opm.web.util.docker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import com.kandasm.opm.web.util.docker.model.DockerShortStats;
import com.kandasm.opm.web.util.hystrix.ProviderService;

@Component
public class DockerShortStatsEndpoint implements Endpoint<DockerShortStats> {
	
	@Autowired @Qualifier("dockerShortStatsProviderService")
	private ProviderService<String, DockerShortStats> dockerShortStatsProviderService;
	
	@Value("${docker.container.name}")
	private String containerName;
	
	@Override
	public String getId() {
		return "docker/stats/short";
	}

	public boolean isEnabled() {
        return true;
    }
 
    public boolean isSensitive() {
        return true;
    }

	@Override
	public DockerShortStats invoke() {
		return dockerShortStatsProviderService.provide(containerName);
	}
	
}
