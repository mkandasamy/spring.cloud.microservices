package com.kandasm.opm.web.util.dashboard;

public class Info {
	private String service;
	private String hostname;
	private String port;
	private String zone;
	private String docker;
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getDocker() {
		return docker;
	}
	public void setDocker(String docker) {
		this.docker = docker;
	}
}
