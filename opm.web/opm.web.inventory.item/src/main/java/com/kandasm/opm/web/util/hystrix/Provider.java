package com.kandasm.opm.web.util.hystrix;


@FunctionalInterface
public interface Provider<ID, T> {
	
	T provide(ID id);

}
