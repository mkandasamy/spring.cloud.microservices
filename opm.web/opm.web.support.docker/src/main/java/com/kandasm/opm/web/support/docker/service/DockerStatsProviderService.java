package com.kandasm.opm.web.support.docker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kandasm.opm.web.support.docker.client.DockerClient;
import com.kandasm.opm.web.support.docker.hystrix.DefaultProvider;
import com.kandasm.opm.web.support.docker.hystrix.Provider;
import com.kandasm.opm.web.support.docker.model.DockerStats;

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
		DockerStats defaultItem = new DockerStats();
		return defaultItem;
	}
}
