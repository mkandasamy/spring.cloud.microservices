package com.kandasm.opm.web.support.auth.config;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
	
	@Value("${opm.web.support.auth.client-id}")
	private String clientId;
	
	@Value("${opm.web.support.auth.client-secret}")
	private String clientSecret;
	
	@Value("${opm.web.support.auth.client-scope}")
	private String clientScope;
	
	@Value("${opm.web.support.auth.token-secret}")
	private String tokenSecret;
	
	@Value("${opm.web.support.auth.token-key}")
	private String tokenKey;
	
	@Value("${opm.web.support.auth.token-private-key-file}")
	private String tokenPrivateKeyFile;
	
	@Value("${spring.cloud.config.uri}")
	private String springCloudConfigUri;
	
	@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(clientId)
                .scopes(clientScope)
                .autoApprove(true)
                .authorities(new String[] {"READ", "WRITE"})
                .authorizedGrantTypes("implicit","refresh_token", "password", "authorization_code")
                .secret(clientSecret);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore()).tokenEnhancer(jwtTokenEnhancer()).authenticationManager(authenticationManager);
    }

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtTokenEnhancer());
    }

    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {
    	JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    	
    	try {
			Resource privateKey = new UrlResource(
					new URI(springCloudConfigUri + "/download?file=" + tokenPrivateKeyFile + "&type=keys"));
			KeyStoreKeyFactory keyStoreKeyFactory = 
		        		new KeyStoreKeyFactory(privateKey, tokenSecret.toCharArray());
			converter.setKeyPair(keyStoreKeyFactory.getKeyPair(tokenKey));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
    			
        return converter;
    }
}