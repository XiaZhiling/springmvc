package com.ling.handlers.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mvc")
public class SpringmvcController {
	private static Logger log = LoggerFactory.getLogger(SpringmvcController.class);
	private static final String SUCCESS = "springmvc/success";
	
	
	/**
	 * 1. @RequestMapping 除了修饰方法, 还可来修饰类 
	 * 2. 
	 * 	1). 类定义处: 提供初步的请求映射信息。相对于 WEB 应用的根目录
	 * 	2). 方法处: 提供进一步的细分映射信息。 相对于类定义处的 URL。若类定义处未标注 @RequestMapping，则方法处标记的 URL相对于 WEB 应用的根目录
	 */
	//localhost:8080/spring.spring-mvc/mvc/testRequestMapping
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		log.info("RequestMapping Test!!!");
		return SUCCESS;
	}
	
	/**
	 * 常用: 使用 method 属性来指定请求方式
	 */
	//localhost:8080/spring.spring-mvc/mvc/testMethod
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod() {
		log.info("Method Test!!!");
		return SUCCESS;
	}
	
	/**
	 * 了解: 可以使用 params 和 headers 来更加精确的映射请求. params 和 headers 支持简单的表达式.
	 * -param1: 表示请求必须包含名为 param1 的请求参数 
	 * -!param1: 表示请求不能包含名为 param1 的请求参数
	 * -param1 != value1: 表示请求包含名为 param1 的请求参数，但其值不能为 value1
	 * -{“param1=value1”, “param2”}: 请求必须包含名为 param1 和param2的两个请求参数，且 param1 参数的值必须为 value1
	 */
	@RequestMapping(value="/testParamsAndHeaders",params = {"userName","age!=10"},
			headers = { "Accept-Language=en-US,zh;q=0.8"})
	public String testParamsAndHeaders() {
		log.info("ParamsAndHeaders Test!!!");
		return SUCCESS;
	}
	
	/**
	 * @RequestMapping 还支持 Ant 风格的 URL
	 * ?：匹配文件名中的一个字符
	 * *：匹配文件名中的任意字符
	 * **：** 匹配多层路径
	 * @return
	 */
	@RequestMapping("/testAntPath/*/abc")
	public String testAntPath() {
		log.info("AntPath Test!!!");
		return SUCCESS;
	}
	
	/**
	 * @PathVariable 可以来映射 URL 中的占位符到目标方法的参数中.
	 */
	//   /mvc/testPathVariable/123
	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id")Integer id) {
		log.info("PathVariable Test:id ={}",id);
		return SUCCESS;
	}
	
	/**
	 * Rest 风格的 URL. 以 CRUD 为例: 
	 * 新增: /order POST 
	 * 修改: /order/1 PUT update?id=1 
	 * 获取:/order/1 GET get?id=1 
	 * 删除: /order/1 DELETE delete?id=1
	 * 
	 * 如何发送 PUT 请求和 DELETE 请求呢 ? 
	 * 1. 需要配置 HiddenHttpMethodFilter 
	 * 2. 需要发送 POST 请求
	 * 3. 需要在发送 POST 请求时携带一个 name="_method" 的隐藏域, 值为 DELETE 或 PUT
	 * 
	 * 在 SpringMVC 的目标方法中如何得到 id 呢? 使用 @PathVariable 注解
	 * 
	 */
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.GET)
	public String testRest(@PathVariable("id")Integer id) {
		log.info("Rest Get Test:id={}!!!",id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest",method=RequestMethod.POST)
	public String testRest() {
		log.info("Rest Post Test!!!");
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.DELETE)
	public String testRestDelete(@PathVariable("id")Integer id) {
		log.info("Rest Delete Test!!!");
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.PUT)
	public String testRestPut(@PathVariable("id")Integer id) {
		log.info("Rest Put Test!!!");
		return SUCCESS;
	}
	
	
	/**
	 * @RequestParam 来映射请求参数. value 值即请求参数的参数名 required 该参数是否必须. 默认为 true
	 *               defaultValue 请求参数的默认值
	 */
	@RequestMapping(value="/testRequestParams")
	public String testRequestParams(@RequestParam(value="userName")String name,
			@RequestParam(value="age",required=false,defaultValue="0")Integer age){
		log.info("RequestParams Test:userName={},age={}",name,age);
		return SUCCESS;
	}
	
	/**
	 * 了解: 映射请求头信息 用法同 @RequestParam
	 */
	@RequestMapping(value="testRequestHeader")
	public String testRequestHeader(@RequestHeader(value = "Accept-Language")String al){
		log.info("RequestHeader Test:al={}",al);
		return SUCCESS;
	}
	
	
	/**
	 * 了解:@CookieValue: 映射一个 Cookie 值. 属性同 @RequestParam
	 */
	@RequestMapping(value="/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId){
		log.info("CookieValue Test:JSESSIONID={}",sessionId);
		return SUCCESS;
	}
	
	
	

}
