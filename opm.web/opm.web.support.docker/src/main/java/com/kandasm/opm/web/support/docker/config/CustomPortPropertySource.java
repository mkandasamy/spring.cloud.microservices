package com.kandasm.opm.web.support.docker.config;


import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
//import org.springframework.stereotype.Component;

//@Component
public class CustomPortPropertySource extends PropertySource<String> {
		
		private Integer port;
		
		@Autowired
	    private ConfigurableEnvironment configurableEnvironment;
		
	    public CustomPortPropertySource() {
	    	super("custom.port");
	    }
	    
	    @Override
	    public String getProperty(String name) {
	    	if(name.equals("custom.port.assign"))
	    		return getPort().toString();
	    	if(name.equals("custom.port.hostname"))
	    		try {return InetAddress.getLocalHost().getHostName();} catch (Exception e) {}
	    	if(name.equals("eureka.instance.non-secure-port"))
	    		return getPort().toString();
	    	return null;
	    }
	    
	    public Integer getPort() {
	    	if(port == null)
	    		port = generate();
	    	Boolean cache = true;
	    	String c = configurableEnvironment.getProperty("custom.port.cache");
	    		if(c != null)
	    			cache = new Boolean(c);
	    	if(cache)
	    		return port;
	    	return generate();
		}
	    
	    private Integer generate(){
	    	Boolean checkAvailable = true;
	    	String ca = configurableEnvironment.getProperty("custom.port.check-available");
	    	if(ca != null)
	    		checkAvailable = new Boolean(ca);
	    	
	    	String start = configurableEnvironment.getProperty("custom.port.start");
	    	String end = configurableEnvironment.getProperty("custom.port.end");
	    	Integer min = start == null ? 0 : Integer.parseInt(start);
	    	Integer max = end == null ? 65535 : Integer.parseInt(end);
	    	Integer mi = Math.min(min,  max);
	    	Integer mx = Math.max(min,  max);
	    	min = Math.max(mi, 0);
	    	max = Math.min(mx, 65535);
	    	
	    	int random = random(min, max);
	    	if(!checkAvailable)
	    		return random;
	    	
	    	int maxAttempt = max - min;
	    	int attempt = 0;
	    	while(!available(random) && attempt < maxAttempt){
	    		attempt++;
	    		random = random(min, max);
	    	}
	    	return random;
	    }
	    
	    private boolean available(Integer port){
	        try (
        		ServerSocket ss = new ServerSocket(port);
        		DatagramSocket ds = new java.net.DatagramSocket(port);
	        ) {
	        	ss.setReuseAddress(true);
	        	ds.setReuseAddress(true);
	            return true;
	        } catch (IOException e) {
	        	return false;
	        } 
	    }
	    
		private static int random(int min, int max){
			return min + (int)(Math.random() * ((max - min)));
		}
	}