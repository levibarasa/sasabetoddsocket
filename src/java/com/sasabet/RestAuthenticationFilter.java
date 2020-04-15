/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasabet;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author levi
 */
public class RestAuthenticationFilter  implements javax.servlet.Filter {

  

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
    
        if (request instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//			String authCredentials = httpServletRequest
//					.getHeader(AUTHENTICATION_HEADER);

			// better injected
			AuthenticationService authenticationService = new AuthenticationService();

//			boolean authenticationStatus = authenticationService
//					.authenticate(authCredentials);
            boolean authenticationStatus =  true;


			if (authenticationStatus) {
				filter.doFilter(request, response);
			}
//                        else {
//				if (response instanceof HttpServletResponse) {
//					HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//					httpServletResponse
//							.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//				}
//			}
		}     
    
    }

    @Override
    public void destroy() {
          }
    
      @Override
    public void init(FilterConfig fc) throws ServletException {
          }
}
