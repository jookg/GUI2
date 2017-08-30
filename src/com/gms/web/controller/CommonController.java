package com.gms.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.web.constant.Action;
import com.gms.web.domain.MemberBean;
import com.gms.web.serviceImpl.MemberServiceImpl;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.Separator;

@WebServlet({"/home.do","/common.do"})
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberBean mb=new MemberBean();
		Separator.init(request);
		switch (Separator.cmd.getAction()) {
		case Action.MOVE:
			DispatcherServlet.send(request, response);
			break;
		case Action.LOGIN:
			mb.setId(request.getParameter("id"));
			mb.setPw(request.getParameter("password"));
			Map<String,Object> map=MemberServiceImpl.getInstance().login(mb);
			if(!map.get("page").equals("main")){
			Separator.cmd.setPage("login_fail");
			Separator.cmd.process();
			}
			session.setAttribute("user", map.get("user"));
			DispatcherServlet.send(request, response);
			break;
		case Action.LOGOUT:
			session.invalidate();
			DispatcherServlet.send(request, response);
			break;
		default:
			break;
		}
	}

}
