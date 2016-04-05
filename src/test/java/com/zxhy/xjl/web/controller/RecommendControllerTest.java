package com.zxhy.xjl.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;


public class RecommendControllerTest extends BaseControllerTest{
	private static Log log = LogFactory.getLog(RecommendControllerTest.class);
	@Autowired
	private RealNameAuthController controller;
	@Override
	Object getController() {
		return this.controller;
	}
	
	@Test
	public void logon(){
		String uri = "/task/1";
		String resp = this.mockGet(uri, null);
		System.out.println("logon:" + resp);
	}
	
	@Test
	public void register() {
		String uri = "/register";
		RealNameAuthTask task =new RealNameAuthTask();
		task.setPhone("234");
		task.setProcessName("测试用户");
		task.setTaskId("1");
		task.setTaskName("测试任务");
		String resp = this.mockPost(uri, "{phone:123,taskId:2}");
		System.out.println("register:" + resp);
	}
}
