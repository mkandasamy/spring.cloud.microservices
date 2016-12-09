package com.kandasm.opm.web.support.docker.client;

import com.kandasm.opm.web.support.docker.model.DockerStats;
import com.kandasm.opm.web.support.docker.model.custom.DockerCreate;


public interface DockerClient {
	
	public DockerStats create(DockerCreate dockerCreate);
	
	public boolean destroy(String containerId);
	
	public DockerStats stats(String containerId);

}
