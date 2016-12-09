package com.kandasm.opm.web.support.proxy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

import java.net.URI;

@Configuration
public class JwtConfiguration {
    
	@Value("${opm.web.support.auth.token-public-key-file}")
	private String tokenPublicKeyFile;
	
	@Value("${spring.cloud.config.uri}")
	private String springCloudConfigUri;
	
    @Autowired
    JwtAccessTokenConverter jwtAccessTokenConverter;


    @Bean
    @Qualifier("tokenStore")
    public TokenStore tokenStore() {

        System.out.println("Created JwtTokenStore");
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {
        JwtAccessTokenConverter converter =  new JwtAccessTokenConverter();
        String publicKey = null;
        try {
        	Resource publicKeyResource = new UrlResource(
					new URI(springCloudConfigUri + "/download?file=" + tokenPublicKeyFile + "&type=keys"));
            publicKey = new String(FileCopyUtils.copyToByteArray(publicKeyResource.getInputStream()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        converter.setVerifierKey(publicKey);
        return converter;
    }
}