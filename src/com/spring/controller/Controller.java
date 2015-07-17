package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.user.User;

//实现接口或使用controller注解
@org.springframework.stereotype.Controller
public class Controller {

	//标注在方法上,可以标注在类上和方法上缩小访问范围
	//其中login和/login效果一样,http://localhost:8080/SpringMVC/login
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(User user){
		//spring会根据表单name值自动填入User的相对应的字段
		String username=user.getUsername(); 
		String password=user.getPassword();
		System.out.println(username+":"+password);
		
		if ("admin".equals(username)&&"admin".equals(password)) {
			ModelAndView view=new ModelAndView("home");
			//可以添加一些数据传给home.jsp
			view.addObject("message", "hello");
			return view;
		}else {
			ModelAndView view=new ModelAndView("error");
			return view;
		}	
	}
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest arg0,
//			HttpServletResponse arg1) throws Exception {
//		// TODO Auto-generated method stub
//		//根据配置会返回/WEB-INF/home.jsp
//		//ModelAndView对象是包含视图和业务数据的混合对象，即是说通过此对象，我们
//		//可以知道所返回的相应页面（比如这里返回home.jsp页面），也可以在相应的页面中获取此对象所
//		//包含的业务数据
//		//接收参数
//		String username=(String)arg0.getParameter("username"); 
//		String password=(String)arg0.getParameter("password");
//		
//		if ("admin".equals(username)&&"admin".equals(password)) {
//			ModelAndView view=new ModelAndView("home");
//			//可以添加一些数据传给home.jsp
//			view.addObject("message", "hello");
//			return view;
//		}else {
//			ModelAndView view=new ModelAndView("error");
//			return view;
//		}
//	}

}
