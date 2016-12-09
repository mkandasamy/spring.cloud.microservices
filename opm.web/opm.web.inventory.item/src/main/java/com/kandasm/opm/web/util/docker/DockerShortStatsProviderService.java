package com.kandasm.opm.web.util.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kandasm.opm.web.util.docker.model.DockerShortStats;
import com.kandasm.opm.web.util.hystrix.DefaultProvider;
import com.kandasm.opm.web.util.hystrix.Provider;
import com.kandasm.opm.web.util.hystrix.ProviderService;

@Service("dockerShortStatsProviderService")
public class DockerShortStatsProviderService extends ProviderService<String, DockerShortStats> {
	
	@Autowired
	private DockerClient dockerClient;
	
	@Override
	public Provider<String, DockerShortStats> provider(){
		return (id) -> dockerClient.shortStats(id);
	}
	
	@Override
	public DefaultProvider<DockerShortStats> defaultProvider() {
		return () -> defaultDockerStats();
	}
	
	public DockerShortStats defaultDockerStats() {
		return new DockerShortStats();
	}
}
