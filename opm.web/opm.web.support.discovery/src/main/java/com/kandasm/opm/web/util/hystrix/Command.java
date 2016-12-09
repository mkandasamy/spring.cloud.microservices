package com.kandasm.opm.web.util.hystrix;

import com.kandasm.opm.web.util.hystrix.DefaultProvider;
import com.kandasm.opm.web.util.hystrix.Provider;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;

import rx.Observable;

public class Command<ID, T> extends HystrixObservableCommand<T> {
	
	private Provider<ID, T> provider;
	private DefaultProvider<T> defaultProvider;
	private ID id;
	
	public Command(Provider<ID, T> provider, DefaultProvider<T> defaultProvider, ID id){
		super(HystrixCommandGroupKey.Factory.asKey("default"));
		this.provider = provider;
		this.defaultProvider = defaultProvider;
		this.id = id;
	}
	
	@Override
	protected Observable<T> construct() {
		return Observable.just(provider.provide(id));
	}
	
	@Override
    protected Observable<T> resumeWithFallback() {
        return Observable.just(defaultProvider.provide());
    }
}
