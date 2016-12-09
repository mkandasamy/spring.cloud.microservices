package com.kandasm.opm.web.util.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kandasm.opm.web.util.hystrix.DefaultProvider;
import com.kandasm.opm.web.util.hystrix.Provider;
import com.kandasm.opm.web.util.hystrix.ProviderService;

@Service("dashBoardProviderService")
public class DashBoardProviderService extends ProviderService<String, DashBoard> {
	
	@Autowired
	private DashBoardClient dashBoardClient;
	
	@Override
	public Provider<String, DashBoard> provider() {
		return (uri) -> dashBoardClient.getDashBoard(uri);
	}

	@Override
	public DefaultProvider<DashBoard> defaultProvider() {
		return () -> new DashBoard();
	}

}
