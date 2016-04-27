package com.ling.handlers.springmvc.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ling.handlers.springmvc.entities.User;

@Controller
@RequestMapping("/form")
public class FormBindController {
	
	private static Logger log = LoggerFactory.getLogger(FormBindController.class);
	private static final String SUCCESS = "springmvc/success";
	
	
	/**
	 * Spring MVC 会按请求参数名和 POJO 属性名进行自动匹配， 自动为该对象填充属性值。支持级联属性。
	 * 如：dept.deptId、dept.address.tel 等
	 */
	@RequestMapping(value="/testPojo")
	public String testPojo(User user) {
		log.info("POJO Test:{}",user);
		return SUCCESS;
	}
	
	/**
	 * 可以使用 Serlvet 原生的 API 作为目标方法的参数 具体支持以下类型
	 * 
	 * HttpServletRequest 
	 * HttpServletResponse 
	 * HttpSession
	 * java.security.Principal 
	 * Locale InputStream 
	 * OutputStream 
	 * Reader 
	 * Writer
	 * @throws IOException 
	 */
	@RequestMapping(value="/testServletAPI")
	public String testServletAPI(HttpServletRequest request,HttpServletResponse response) {
		log.info("Servlet API Test:resquest={},response={}",request,response);
		return SUCCESS;
	}
	
	/**
	 * 目标方法的返回值可以是 ModelAndView 类型。 
	 * 其中可以包含视图和模型信息
	 * SpringMVC 会把 ModelAndView 的 model 中数据放入到 request 域对象中. 
	 * @return
	 */
	@RequestMapping(value="/testModelAndView")
	public ModelAndView testModelAndView(){
		ModelAndView mav = new ModelAndView(SUCCESS);
		//添加模型数据到mav
		mav.addObject("time", new Date());
		log.info("Test ModelAndView:mv={}",mav);
		return mav;
	}
	
	/**
	 * 目标方法可以添加 Map 类型(实际上也可以是 Model 类型或 ModelMap 类型)的参数. 
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/testMap")
	public String testMap(Map<String, Object> map) {
		map.put("names", Arrays.asList("TOM","Jerry","Mike"));
		log.info("Test Map:map={}",map);
		return SUCCESS;
	}

}
