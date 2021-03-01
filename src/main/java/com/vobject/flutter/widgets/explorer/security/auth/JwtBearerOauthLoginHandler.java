package com.vobject.flutter.widgets.explorer.security.auth;

import javax.inject.Singleton;

import io.micronaut.security.handlers.RedirectingLoginHandler;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author limcheekin@vobject.com
 */
@Singleton
public class JwtBearerOauthLoginHandler implements RedirectingLoginHandler {
    private static final Logger LOG = LoggerFactory.getLogger(JwtBearerOauthLoginHandler.class);
    
    public JwtBearerOauthLoginHandler() {}
    
    @Override
    public MutableHttpResponse<?> loginSuccess(UserDetails userDetails, HttpRequest<?> request) {
        LOG.info("userDetails.getUsername() {}, userDetails.getAttributes() {}", userDetails.getUsername(), userDetails.getAttributes("roles", "username"));
        LOG.info("request {}", request);
        return HttpResponse.ok();
    }

    @Override
    public MutableHttpResponse<?> loginRefresh(UserDetails userDetails, String refreshToken, HttpRequest<?> request) {
        LOG.info("userDetails {}, refreshToken {}, request {}", userDetails, refreshToken, request);
        return HttpResponse.ok();
    }

    @Override
    public MutableHttpResponse<?> loginFailed(AuthenticationResponse authenticationResponse, HttpRequest<?> request) {
        LOG.info("authenticationResponse, request {}", authenticationResponse, request);
        return HttpResponse.ok();
    }    
}
