package com.kandasm.opm.web.util.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Service;

import com.kandasm.opm.web.util.docker.model.DockerShortStats;
import com.kandasm.opm.web.util.hystrix.Command;

import rx.Observable;

@Service
public class DashBoardClient {
	
	@Autowired
	private GetRestClient getRestClient;

	public DashBoard getDashBoard(String uri){
		return Observable.zip(
				new Command<String, Info>(
						(u) -> getRestClient.get(u + "/info", Info.class), 
						() -> new Info(), 
						uri
				).toObservable(), 
				new Command<String, Health>(
						(u) -> getRestClient.get(u + "/info", Health.class), 
						() -> Health.outOfService().build(), 
						uri
				).toObservable(), 
				new Command<String, DockerShortStats>(
						(u) -> getRestClient.get(u + "/docker/stats/short", DockerShortStats.class), 
						() -> new DockerShortStats(), 
						uri
				).toObservable(),
				(info, health, docker) -> {
					DashBoard board = new DashBoard();
					board.setInfo(info);
					board.setHealth(health);
					board.setDockerShortStats(docker);
					return board;
				}).toBlocking().first();
	}
}
