package com.kandasm.opm.web.support.docker.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kandasm.opm.web.support.docker.model.DockerStats;
import com.kandasm.opm.web.support.docker.model.custom.DockerShortStatus;
import com.kandasm.opm.web.support.docker.service.ProviderService;

@RestController
public class DockerStatsController {
	
	@Autowired @Qualifier("dockerStatsProviderService")
	private ProviderService<String, DockerStats> dockerStatsProviderService;
	
	
	@RequestMapping("/docker/stats")
    public DockerStats stats(@RequestParam String containerId) {
		DockerStats dockerStats = dockerStatsProviderService.provide(containerId);
		return dockerStats;
	}
	
	@RequestMapping("/docker/stats/short")
    public DockerShortStatus shortStats(@RequestParam String containerId) {
		DockerStats dockerStats = dockerStatsProviderService.provide(containerId);
		DockerShortStatus shortStatus = shortStatus(dockerStats);
		shortStatus.setContainerId(containerId);
		return shortStatus;
	}
	
	private DockerShortStatus shortStatus(DockerStats dockerStats){
		DockerShortStatus dockerShortStatus = new DockerShortStatus();
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
	
}
