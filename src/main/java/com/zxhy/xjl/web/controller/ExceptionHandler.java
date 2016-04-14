package com.zxhy.xjl.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;




public class ExceptionHandler extends AbstractHandlerExceptionResolver {
	private static Log log = LogFactory.getLog(ExceptionHandler.class);
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		 log.debug("执行controller有异常发生");
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setCharacterEncoding("UTF-8");
		 response.setHeader("Cache-Control","no-cache, must-revalidate");
		 try {
		        ObjectMapper mapper = new ObjectMapper();  
		        ErrorMessge errorMessge = new ErrorMessge();
		        errorMessge.setMsg(ex.getMessage());
		        log.debug("errorMessage:" + errorMessge.getMsg());
		        log.debug("mapper.asString:" + mapper.writeValueAsString(errorMessge));
		        response.getWriter().write(mapper.writeValueAsString(errorMessge));
			  } catch (IOException e) {
				  throw new RuntimeException(e);
			 }
		return null;
	}
	
}
