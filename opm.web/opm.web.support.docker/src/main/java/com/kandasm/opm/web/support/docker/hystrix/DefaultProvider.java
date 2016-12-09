package com.kandasm.opm.web.support.docker.hystrix;


@FunctionalInterface
public interface DefaultProvider<T> {
	
	T provide();

}
