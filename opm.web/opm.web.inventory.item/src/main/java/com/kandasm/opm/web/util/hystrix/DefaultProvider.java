package com.kandasm.opm.web.util.hystrix;


@FunctionalInterface
public interface DefaultProvider<T> {
	
	T provide();

}
