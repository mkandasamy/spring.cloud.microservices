package com.kandasm.opm.web.util.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kandasm.opm.web.util.docker.model.DockerStats;
import com.kandasm.opm.web.util.hystrix.DefaultProvider;
import com.kandasm.opm.web.util.hystrix.Provider;
import com.kandasm.opm.web.util.hystrix.ProviderService;

@Service("dockerStatsProviderService")
public class DockerStatsProviderService extends ProviderService<String, DockerStats> {
	
	@Autowired
	private DockerClient dockerClient;
	
	@Override
	public Provider<String, DockerStats> provider(){
		return (id) -> dockerClient.stats(id);
	}
	
	@Override
	public DefaultProvider<DockerStats> defaultProvider() {
		return () -> defaultDockerStats();
	}
	
	public DockerStats defaultDockerStats() {
		return new DockerStats();
	}
}
