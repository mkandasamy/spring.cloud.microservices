package com.kandasm.opm.web.util.hystrix;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.kandasm.opm.web.util.hystrix.Provider;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;

import rx.Observable;

public class CollectionCommand<ID, T> extends HystrixObservableCommand<List<T>> {
	
	private Provider<ID, T> provider;
	private List<ID> ids;
	
	public CollectionCommand(Provider<ID, T> provider, List<ID> ids){
		super(HystrixCommandGroupKey.Factory.asKey("default"));
		this.provider = provider;
		this.ids = ids;
	}
	
	@Override
	protected Observable<List<T>> construct() {
		return Observable.just(collect(provider, ids));
	}
	
	@Override
    protected Observable<List<T>> resumeWithFallback() {
        return Observable.just(Collections.emptyList());
    }
	
	public List<T> collect(Provider<ID, T> provider, List<ID> ids){
		return ids
				.parallelStream()
				.map(id -> provider.provide(id))
				.collect(Collectors.toList());
	}
}
