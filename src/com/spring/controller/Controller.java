package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.user.User;

//ʵ�ֽӿڻ�ʹ��controllerע��
@org.springframework.stereotype.Controller
public class Controller {

	//��ע�ڷ�����,���Ա�ע�����Ϻͷ�������С���ʷ�Χ
	//����login��/loginЧ��һ��,http://localhost:8080/SpringMVC/login
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(User user){
		//spring����ݱ�nameֵ�Զ�����User�����Ӧ���ֶ�
		String username=user.getUsername(); 
		String password=user.getPassword();
		System.out.println(username+":"+password);
		
		if ("admin".equals(username)&&"admin".equals(password)) {
			ModelAndView view=new ModelAndView("home");
			//�������һЩ���ݴ���home.jsp
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
//		//�������û᷵��/WEB-INF/home.jsp
//		//ModelAndView�����ǰ�����ͼ��ҵ�����ݵĻ�϶��󣬼���˵ͨ���˶�������
//		//����֪�������ص���Ӧҳ�棨�������ﷵ��home.jspҳ�棩��Ҳ��������Ӧ��ҳ���л�ȡ�˶�����
//		//������ҵ������
//		//���ղ���
//		String username=(String)arg0.getParameter("username"); 
//		String password=(String)arg0.getParameter("password");
//		
//		if ("admin".equals(username)&&"admin".equals(password)) {
//			ModelAndView view=new ModelAndView("home");
//			//�������һЩ���ݴ���home.jsp
//			view.addObject("message", "hello");
//			return view;
//		}else {
//			ModelAndView view=new ModelAndView("error");
//			return view;
//		}
//	}

}
