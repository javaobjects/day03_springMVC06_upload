package com.tencent.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
* <p>Title: CustomerExceptionHandler</p>  
* <p>
*	Description: 
*   自定义异常处理器:
*   	1. 自定义类实现HandlerExceptionResolver接口
*   	
*   	2. 重写resolveException方法
*   
*   	3. 在spring-mvc.xml中配置管理全局异常处理器
*   
*   		<!-- 6.配置全局异常处理器 -->
*   		<bean id="exceptionHandler" class="com.tencent.exception.CustomerExceptionHandler" ></bean>
* </p> 
* @author xianxian 
* @date 2019年10月17日
 */
public class CustomerExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2,
			Exception ex) {
		
		System.out.println("系统发生异常了:" + ex.getMessage());
		
		ModelAndView mav = new ModelAndView();
		
		//1. 保存异常信息(日志记录、发送邮件)
		mav.addObject("exceptionMessage",ex.getMessage());
		
		//2. 跳转指定异常页面
		mav.setViewName("fail");
		
		return mav;
	}
}
