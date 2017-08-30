package com.gms.web.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gms.web.command.Command;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;
import com.gms.web.service.MemberService;

public class MemberServiceImpl implements MemberService {
	Map<String, MemberBean> map;

	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}

	private MemberServiceImpl() {
		map = new HashMap<>();
	}

	@Override
	public String addMember(Map<String,Object> map) {
		//MemberBean m=(MemberBean)map.get("member");
		//List<MajorBean> list =(List<MajorBean>)map.get("major");
		return (MemberDAOImpl.getInstance().insert(map).equals("1")) ? "등록성공" : "등록오류";//(MemberDAOImpl.getInstance().insert(member).equals("1")) ? "가입성공" : "가입오류";
		// map.put(member.getId(), member);
	}

	@Override
	public List<?> getMembers(Command cmd) {
		/*
		 * Set<String> keys=map.keySet(); for(String s:keys){
		 * list.add(map.get(s)); }
		 */
		return MemberDAOImpl.getInstance().selectAll(cmd);
	}

	@Override
	public String countMembers(Command cmd) {
		return MemberDAOImpl.getInstance().countMembers(cmd);
	}

	@Override
	public StudentBean findById(Command cmd) {

		return MemberDAOImpl.getInstance().selectById(cmd);
	}

	@Override
	public List<StudentBean> findByName(Command cmd) {
		/*
		 * Set<String> keys=map.keySet(); for (String s : keys) {
		 * if(name.equals(map.get(s).getName())){ searchList.add(map.get(s)); }
		 * }
		 */
		return MemberDAOImpl.getInstance().selectByName(cmd);
	}

	@Override
	public String modify(StudentBean member) {
		// map.get(member.getId()).setPw(member.getPw());
		return (MemberDAOImpl.getInstance().updatePw(member).equals("1")) ? "업데이트완료" : "업데이트오류";
	}

	@Override
	public String remove(Command cmd) {
		// map.remove(id);
		return (MemberDAOImpl.getInstance().delete(cmd).equals("1")) ? "삭제성공" : "삭제오류";
	}

	@Override
	public Map<String,Object> login(MemberBean bean) {
		Map<String,Object> map= new HashMap<>();
		Command cmd=new Command();
		cmd.setSearch(bean.getId());
		StudentBean mb = findById(cmd);
		String page= mb.getId()!=null? bean.getPw().equals(mb.getPw())? "main":"login_fail" : "login_fail";
		map.put("page", page);
		map.put("user", mb);
		return map;
	}
}
