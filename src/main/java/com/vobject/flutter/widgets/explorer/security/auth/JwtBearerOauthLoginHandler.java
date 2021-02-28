package com.vobject.flutter.widgets.explorer.security.auth;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.inject.Singleton;

import io.micronaut.security.handlers.RedirectingLoginHandler;
import io.micronaut.security.token.jwt.generator.AccessRefreshTokenGenerator;
import io.micronaut.security.token.jwt.render.AccessRefreshToken;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.functional.ThrowingSupplier;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;
import io.micronaut.security.config.RedirectConfiguration;
import io.micronaut.security.config.RefreshRedirectConfiguration;
import io.micronaut.security.errors.OauthErrorResponseException;
import io.micronaut.security.errors.ObtainingAuthorizationErrorCode;
import io.micronaut.security.errors.PriorToLoginPersistence;
import io.micronaut.security.config.SecurityConfigurationProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author limcheekin@vobject.com
 */
//@Requires(property = SecurityConfigurationProperties.PREFIX + ".authentication", value = "bearer")
@Singleton
public class JwtBearerOauthLoginHandler implements RedirectingLoginHandler {
    private static final Logger LOG = LoggerFactory.getLogger(JwtBearerOauthLoginHandler.class);
    /*protected final String loginFailure;
    protected final String loginSuccess;
    protected final String refresh;
    protected final AccessRefreshTokenGenerator accessRefreshTokenGenerator;
    */
    //protected final PriorToLoginPersistence priorToLoginPersistence;

    //@Inject
    public JwtBearerOauthLoginHandler(RedirectConfiguration redirectConfiguration,
        AccessRefreshTokenGenerator accessRefreshTokenGenerator) {
            /*
        this.loginFailure = redirectConfiguration.getLoginFailure();
        this.loginSuccess = redirectConfiguration.getLoginSuccess();
        RefreshRedirectConfiguration refreshConfig = redirectConfiguration.getRefresh();
        this.refresh = refreshConfig.isEnabled() ? refreshConfig.getUrl() : null;
        this.accessRefreshTokenGenerator = accessRefreshTokenGenerator;
        */
        //this.priorToLoginPersistence = priorToLoginPersistence;

        //LOG.info("loginSuccess {}, loginFailure {}, refresh {}", loginSuccess, loginFailure, refresh);
    }    

    @Override
    public MutableHttpResponse<?> loginSuccess(UserDetails userDetails, HttpRequest<?> request) {
        LOG.info("userDetails.getUsername() {}, userDetails.getAttributes() {}", userDetails.getUsername(), userDetails.getAttributes("roles", "username"));
        LOG.info("request {}", request);
        //try {
            //MutableHttpResponse<?> response = HttpResponse.status(HttpStatus.SEE_OTHER);
            /*ThrowingSupplier<URI, URISyntaxException> uriSupplier = () -> new URI(loginSuccess);
            if (priorToLoginPersistence != null) {
                Optional<URI> originalUri = priorToLoginPersistence.getOriginalUri(request, response);
                if (originalUri.isPresent()) {
                    uriSupplier = originalUri::get;
                }
            }

            response.getHeaders().location(uriSupplier.get());
            */
            /*AccessRefreshToken accessRefreshToken = accessRefreshTokenGenerator.generate(userDetails)
            .orElseThrow(() -> new OauthErrorResponseException(ObtainingAuthorizationErrorCode.SERVER_ERROR, "Cannot obtain an access token", null));
            response.body(accessRefreshToken);
            
            return response;*/
        //} catch (URISyntaxException e) {
        //    return HttpResponse.serverError();
        //}
        return HttpResponse.ok();
    }

    @Override
    public MutableHttpResponse<?> loginRefresh(UserDetails userDetails, String refreshToken, HttpRequest<?> request) {
        LOG.info("userDetails {}, refreshToken {}, request {}", userDetails, refreshToken, request);
        /*MutableHttpResponse<?> response;
        try {
            if (refresh != null) {
                response = HttpResponse.seeOther(new URI(refresh)); 
            } else {
                response = HttpResponse.ok();
            }
            AccessRefreshToken accessRefreshToken = accessRefreshTokenGenerator.generate(refreshToken, userDetails)
            .orElseThrow(() -> new OauthErrorResponseException(ObtainingAuthorizationErrorCode.SERVER_ERROR, "Cannot obtain an access token", null));
            response.body(accessRefreshToken);
            return response;
        } catch (URISyntaxException e) {
            return HttpResponse.serverError();
        }*/
        return HttpResponse.ok();
    }

    @Override
    public MutableHttpResponse<?> loginFailed(AuthenticationResponse authenticationResponse, HttpRequest<?> request) {
        LOG.info("authenticationResponse, request {}", authenticationResponse, request);
        /*try {
            URI location = new URI(loginFailure);
            return HttpResponse.seeOther(location);
        } catch (URISyntaxException e) {
            return HttpResponse.serverError();
        }*/
        return HttpResponse.ok();
    }
    
}
