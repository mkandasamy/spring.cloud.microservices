package com.kandasm.opm.web.support.docker.service;

import java.util.List;
import java.util.Map;

import com.kandasm.opm.web.support.docker.hystrix.CollectionCommand;
import com.kandasm.opm.web.support.docker.hystrix.Command;
import com.kandasm.opm.web.support.docker.hystrix.DefaultProvider;
import com.kandasm.opm.web.support.docker.hystrix.MapCommand;
import com.kandasm.opm.web.support.docker.hystrix.Provider;

public abstract class ProviderService<ID, T> {
	
	public T provide(ID id){
		return new Command<ID, T>(
			provider(), 
			defaultProvider(), 
			id
		).toObservable().toBlocking().first();
	}
	
	public List<T> provideList(List<ID> ids){
		return new CollectionCommand<ID, T>(
				provider(), 
				ids
		).toObservable().toBlocking().first();
	}
	
	public Map<ID, T> provideMap(List<ID> ids){
		return new MapCommand<ID, T>(
				provider(), 
				ids
		).toObservable().toBlocking().first();
	}
	
	public abstract Provider<ID, T> provider();
	
	public abstract DefaultProvider<T> defaultProvider();
	

}
