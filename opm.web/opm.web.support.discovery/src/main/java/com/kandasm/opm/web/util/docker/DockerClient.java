package com.kandasm.opm.web.util.docker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kandasm.opm.web.util.docker.model.DockerShortStats;
import com.kandasm.opm.web.util.docker.model.DockerStats;

@Service
public class DockerClient {
	
	@Value("${HOST_NAME:localhost}")
	private String hostname;
	
	@Value("${DOCKER_ENDPOINT:http://${HOST_NAME:localhost}:4243}")
	private String dockerEndpoint;

	private RestTemplate restTemplate;
	
	public DockerClient(){
		this.restTemplate = new RestTemplate();
		this.restTemplate.setMessageConverters(getMessageConverters());
		this.restTemplate.getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request,body);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response;
        });
	}
	
	public DockerStats stats(String containerName){
		String url = dockerEndpoint + "/containers/" + containerName +  "/stats";
		DockerStats dockerStats = restTemplate.getForObject(url, DockerStats.class);
		return dockerStats;
	}
	
	public DockerShortStats shortStats(String containerName){
		return shortStatus(stats(containerName));
	}
	
	private DockerShortStats shortStatus(DockerStats dockerStats){
		DockerShortStats dockerShortStatus = new DockerShortStats();
		dockerShortStatus.setCpuUsage(cpu(dockerStats).toString());
		dockerShortStatus.setMemoryUsage(memory(dockerStats).toString());
		return dockerShortStatus;		
	}
	
	private BigDecimal cpu(DockerStats dockerStats){
		int core = dockerStats.getCpuStats().getCpuUsage().getPercpuUsage().size();
		if(core == 0 ) core = 1;
		
		dockerStats.getPrecpuStats().getCpuUsage().setTotalUsage(null);
		
		BigDecimal cpuPreUsageDecimal = new BigDecimal(Optional
				.ofNullable(dockerStats.getPrecpuStats().getCpuUsage().getTotalUsage())
				.orElse(0L)
				.longValue());
		BigDecimal cpuPreSysUsageDecimal = new BigDecimal(Optional
				.ofNullable(dockerStats.getPrecpuStats().getSystemCpuUsage())
				.orElse(0L)
				.longValue());
		BigDecimal cpuUsageDecimal = new BigDecimal(Optional
				.ofNullable(dockerStats.getCpuStats().getCpuUsage().getTotalUsage())
				.orElse(0L)
				.longValue());
		BigDecimal cpuSysUsageDecimal = new BigDecimal(Optional
				.ofNullable(dockerStats.getCpuStats().getSystemCpuUsage())
				.orElse(0L)
				.longValue());
		
		BigDecimal cpuDelta = cpuUsageDecimal.subtract(cpuPreUsageDecimal);
		BigDecimal cpuSysDelta = Optional.of(cpuSysUsageDecimal.subtract(cpuPreSysUsageDecimal)).map(bd -> {
					return bd.equals(new BigDecimal("0")) ? new BigDecimal(1L) : bd; }
				).get();
		
		return cpuDelta
				.divide(cpuSysDelta, 6, RoundingMode.HALF_UP)
				.multiply(new BigDecimal(core * 100))
				.setScale(2, RoundingMode.HALF_UP);
	}
	
	private BigDecimal memory(DockerStats dockerStats){
		
		BigDecimal usage = new BigDecimal(Optional
				.ofNullable(dockerStats.getMemoryStats().getUsage())
				.orElse(0L)
				.longValue());
		BigDecimal limit = new BigDecimal(Optional
				.ofNullable(dockerStats.getMemoryStats().getLimit())
				.orElse(1L)
				.longValue());
		
		return usage.divide(limit, 2, RoundingMode.HALF_UP)
				.multiply(new BigDecimal(100))
				.setScale(2, RoundingMode.HALF_UP);
	}
	
	private List<HttpMessageConverter<?>> getMessageConverters() {
	    List<HttpMessageConverter<?>> converters = 
	      new ArrayList<HttpMessageConverter<?>>();
	    converters.add(new MappingJackson2HttpMessageConverter());
	    return converters;
	}
	
}
