package com.kandasm.opm.web.util.dashboard;

import org.springframework.boot.actuate.health.Health;

import com.kandasm.opm.web.util.docker.model.DockerShortStats;

public class DashBoard {
	
	private Info info;
	private Health health;
	private DockerShortStats dockerShortStats;
	
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public Health getHealth() {
		return health;
	}
	public void setHealth(Health health) {
		this.health = health;
	}
	public DockerShortStats getDockerShortStats() {
		return dockerShortStats;
	}
	public void setDockerShortStats(DockerShortStats dockerShortStats) {
		this.dockerShortStats = dockerShortStats;
	}
}
