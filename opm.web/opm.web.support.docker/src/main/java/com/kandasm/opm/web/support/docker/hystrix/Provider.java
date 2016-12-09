package com.kandasm.opm.web.support.docker.hystrix;


@FunctionalInterface
public interface Provider<ID, T> {
	
	T provide(ID id);

}
