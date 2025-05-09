package com.project.digitalLibrary.ffff_controllers;


import org.springframework.security.web.csrf.CsrfToken;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class LibraryController {

    @GetMapping("/")
    public String welcomeMessage(HttpServletRequest request) {
        return "Welcome to Digital Library: " + request.getSession().getId();
    }
    
    
	/*
	 * Cookie that is JSESSIONID cookie is ingested in our browser that is used to
	 * maintain the session. It is present in the response header.
	 * 
	 * 
	 * CSRF - CROSS SITE REQUEST FORGERY
	 * 
	 * you will not be able post, put, patch a request, even if you are able to do
	 * GET a request. It is restricted to prevent the CSRF attack, where a hacker
	 * during POST request might forge a field in request like email address to
	 * retrieve the user information.
	 * 
	 * Therefore, with basic authentication, for fetch requests we have to provide a
	 * _csrf token as well.
	 * 
	 * X-CSRF-TOKEN : value
	 * 
	 * And the value can be obtained from the main page html source with an
	 * attribute name "_csrf". Can get through developer tools in chrome
	 * (specifically for WEB)
	 * 
	 * You cannot use same csrf token from web to work with Postman API. Server
	 * itself provides the csrf token to identify, the same user session.
	 * 
	 * In api call get it through --->
	 */
    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
