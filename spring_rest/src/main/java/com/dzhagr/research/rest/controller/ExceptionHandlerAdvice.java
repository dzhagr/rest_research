package com.dzhagr.research.rest.controller;

import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Author: adzhagriev
 * Date: 3/22/13
 * Time: 11:51 AM
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private static Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(ObjectNotFoundException.class)
    public void handleException(Exception e, HttpServletResponse response) {
        logger.error("", e);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
