package com.ling.handlers.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	private static Logger log = LoggerFactory.getLogger(HelloWorldController.class);
	
	@RequestMapping("/helloworld")
	public String hello() {
		log.info("Hello World Test!");
		return "helloworld/success";
	}
}
