package com.zxhy.xjl.web.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class RealNameAuthController {
	private static final Log log = LogFactory.getLog(RealNameAuthController.class);
	@ResponseBody
	@RequestMapping(value="/task/{taskId}", method=RequestMethod.GET)
	public RealNameAuthTask logon(@PathVariable String taskId){
		log.debug("logon taskId:" + taskId);
			RealNameAuthTask task =new RealNameAuthTask();
			task.setPhone("234");
			task.setProcessName("测试用户");
			task.setTaskId("1");
			task.setTaskName("测试任务");
			if (true){
				throw new RuntimeException("主动出发一个异常");
			}
			return task;
	}
	@ResponseBody
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void register(@RequestBody RealNameAuthTask task){
		log.debug("register:" +task.getPhone());
	}
}
