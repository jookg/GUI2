package com.gms.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.web.command.Command;
import com.gms.web.constant.Action;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.proxy.BlockHandler;
import com.gms.web.proxy.PageHandler;
import com.gms.web.proxy.PageProxy;
import com.gms.web.service.MemberService;
import com.gms.web.serviceImpl.MemberServiceImpl;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.ParamsIterator;
import com.gms.web.util.Separator;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Separator.init(request);
		Command cmd= new Command();
		MemberBean mb=new MemberBean();
		MemberService service=MemberServiceImpl.getInstance();
		Map<?,?> map=new HashMap<>();
		PageProxy pxy=new PageProxy(request);
		pxy.setPageSize(5);
		pxy.setBlockSize(5);
		
		switch (Separator.cmd.getAction()) {
		case Action.MOVE:
			DispatcherServlet.send(request, response);
			break;
		case Action.JOIN:
			map = ParamsIterator.execute(request);
			mb.setId(map.get("id").toString());
			mb.setPw(map.get("pass").toString());
			mb.setName(map.get("name").toString());
			mb.setSsn(map.get("birth").toString());
			mb.setPhone(map.get("phone").toString());
			mb.setEmail(map.get("email").toString());
			mb.setMajor(map.get("major").toString());
			String[] subjects=map.get("subject").toString().split(",");
			List<MajorBean> list=new ArrayList<>();
			MajorBean mj=null;
			for(int i=0; i<subjects.length;i++){
				mj = new MajorBean();
				mj.setId(map.get("id").toString());
				mj.setTitle(map.get("name").toString());
				mj.setMajorId(map.get("major").toString());
				mj.setSubjId(subjects[i]);
				list.add(mj);
			}
			Map<String,Object> tempMap=new HashMap<>();
			tempMap.put("member", mb);
			tempMap.put("major", list);
			String rs=MemberServiceImpl.getInstance().addMember(tempMap);
			Separator.cmd.setDir("common");
			Separator.cmd.process();
			System.out.println("결과: "+rs);
			DispatcherServlet.send(request, response);
			break;
		case Action.LIST:
			cmd.setSearch(request.getParameter("search_id"));
			pxy.setTheNumberOfRows(Integer.parseInt(service.countMembers(cmd)));
			pxy.setPageNumber(Integer.parseInt(request.getParameter("num")));
			pxy.execute(BlockHandler.attr(pxy),service.getMembers(PageHandler.attr(pxy)));
			DispatcherServlet.send(request, response);
			break;
		case Action.UPDATE:
			cmd.setSearch(request.getParameter("id"));
			service.modify(service.findById(cmd));
			DispatcherServlet.send(request, response);
			break;
		case Action.DELETE:
			cmd.setSearch(request.getParameter("id"));
			service.remove(cmd);
			response.sendRedirect("member.do?action=list&page=member_list&num=1");
			break;
		case Action.DETAIL:
			cmd.setSearch(request.getParameter("id"));
			request.setAttribute("student", service.findById(cmd));
			DispatcherServlet.send(request, response);
			break;
		case Action.SEARCH:
			map=ParamsIterator.execute(request);
			cmd.setSearch(String.valueOf(map.get("search_id")));
			pxy.setTheNumberOfRows(Integer.parseInt(service.countMembers(cmd)));
			cmd.setPageNumber(request.getParameter("num"));
			pxy.setPageNumber(Integer.parseInt(cmd.getPageNumber()));
			cmd=PageHandler.attr(pxy);
			cmd.setColumn("name");
			cmd.setSearch(String.valueOf(map.get("search_id")));
			request.setAttribute("searchn", String.valueOf(map.get("search_id")));
			pxy.execute(BlockHandler.attr(pxy),service.findByName(cmd));
			DispatcherServlet.send(request, response);
			break;
		default:
			System.out.println("ACTION FAIL");
			break;
		}
		
	}

}
