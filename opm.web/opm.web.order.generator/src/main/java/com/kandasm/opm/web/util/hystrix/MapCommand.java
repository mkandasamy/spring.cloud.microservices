package com.kandasm.opm.web.util.hystrix;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kandasm.opm.web.util.hystrix.Provider;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;

import rx.Observable;

public class MapCommand<ID, T> extends HystrixObservableCommand<Map<ID, T>> {
	
	private Provider<ID, T> provider;
	private List<ID> ids;
	
	public MapCommand(Provider<ID, T> provider, List<ID> ids){
		super(HystrixCommandGroupKey.Factory.asKey("default"));
		this.provider = provider;
		this.ids = ids;
	}
	
	@Override
	protected Observable<Map<ID, T>> construct() {
		return Observable.just(collect(provider, ids));
	}
	
	@Override
    protected Observable<Map<ID, T>> resumeWithFallback() {
        return Observable.just(Collections.emptyMap());
    }
	
	public Map<ID, T> collect(Provider<ID, T> provider, List<ID> ids){
		return ids
				.parallelStream()
				.collect(Collectors.toMap(
						id -> id,
						id -> provider.provide(id)
				));
	}
}
