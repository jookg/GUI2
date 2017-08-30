package com.gms.web.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gms.web.command.Command;
import com.gms.web.constant.DB;
import com.gms.web.constant.SQL;
import com.gms.web.constant.Vendor;
import com.gms.web.dao.MemberDAO;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;
import com.gms.web.factory.DatabaseFactory;

public class MemberDAOImpl implements MemberDAO {
	Connection conn;
	public static MemberDAOImpl getInstance() {
		
		return new MemberDAOImpl();
	}
	private MemberDAOImpl() {
		conn=null;
	}
	@Override
	public String insert(Map<?,?> map) {
		String rs="";
		MemberBean member= (MemberBean)map.get("member");
		@SuppressWarnings("unchecked")
		List<MajorBean> major=(List<MajorBean>)map.get("major");
		PreparedStatement pstmt=null;
		try {
			conn=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection();
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(SQL.MEMBER_INSERT);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getSsn());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getMajor());
			pstmt.setString(8, "default.jpg");
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement(SQL.MAJOR_INSERT);
			for(int i=0;i<major.size();i++){
			pstmt.setString(1, major.get(i).getMajorId()+(int) (Math.random() * 100 + 1));
			pstmt.setString(2, major.get(i).getTitle());
			pstmt.setString(3, major.get(i).getId());
			pstmt.setString(4, major.get(i).getSubjId());
			rs=String.valueOf(pstmt.executeUpdate());
			}
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(conn !=null){
				try{
					conn.rollback();
				}catch(SQLException ex){
					e.printStackTrace();
				}
			}
		}
		return rs;
	}

	@Override
	public List<?> selectAll(Command cmd) {
		List<StudentBean> list=new ArrayList<>();
		try {
			conn=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection();
			PreparedStatement pstmt=conn.prepareStatement(SQL.STUDENT_LIST);
			pstmt.setString(1, cmd.getStartRow());
			pstmt.setString(2, cmd.getEndRow());
			ResultSet rs= pstmt.executeQuery();
			StudentBean bean=null;
			while(rs.next()){
				bean=new StudentBean();
				bean.setNo(rs.getString(DB.STUDENT_NO));
				bean.setId(rs.getString(DB.MEMBER_ID));
				bean.setPw(rs.getString(DB.MEMBER_PW));
				bean.setName(rs.getString(DB.MEMBER_NAME));
				bean.setSsn(rs.getString(DB.MEMBER_SSN));
				bean.setPhone(rs.getString(DB.MEMBER_PHONE));
				bean.setEmail(rs.getString(DB.MEMBER_EMAIL));
				bean.setTitle(rs.getString(DB.STUDENT_TITLE));
				bean.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public StudentBean selectById(Command cmd) {
		StudentBean bean=new StudentBean();
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.STUDENT_FINDBYID);

			pstmt.setString(1, cmd.getSearch());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setNo(rs.getString(DB.STUDENT_NO));
				bean.setId(rs.getString(DB.MEMBER_ID));
				bean.setPw(rs.getString(DB.MEMBER_PW));
				bean.setName(rs.getString(DB.MEMBER_NAME));
				bean.setSsn(rs.getString(DB.MEMBER_SSN));
				bean.setPhone(rs.getString(DB.MEMBER_PHONE));
				bean.setEmail(rs.getString(DB.MEMBER_EMAIL));
				bean.setTitle(rs.getString(DB.STUDENT_TITLE));
				bean.setRegdate(rs.getString(DB.MEMBER_REGDATE));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bean;
	}

	@Override
	public List<StudentBean> selectByName(Command cmd) {
		List<StudentBean> list=new ArrayList<>();
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.STUDENT_SEARCH);
			
			pstmt.setString(1, "%"+cmd.getSearch()+"%");
			pstmt.setString(2, cmd.getStartRow());
			pstmt.setString(3, cmd.getEndRow());
			ResultSet rs=pstmt.executeQuery();
			StudentBean bean=null;
			while(rs.next()){
				bean=new StudentBean();
				bean.setNo(rs.getString(DB.STUDENT_NO));
				bean.setId(rs.getString(DB.MEMBER_ID));
				bean.setPw(rs.getString(DB.MEMBER_PW));
				bean.setName(rs.getString(DB.MEMBER_NAME));
				bean.setSsn(rs.getString(DB.MEMBER_SSN));
				bean.setPhone(rs.getString(DB.MEMBER_PHONE));
				bean.setEmail(rs.getString(DB.MEMBER_EMAIL));
				bean.setTitle(rs.getString(DB.STUDENT_TITLE));
				bean.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String countMembers(Command cmd) {
		String cnt="";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.STUDENT_COUNT);
			pstmt.setString(1, "%"+cmd.getSearch()+"%");
			ResultSet rs=pstmt.executeQuery();
			 if(rs.next()){
				 cnt=rs.getString("count");
			 }
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public String updatePw(StudentBean member) {
		String rs="";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getId());
			rs= String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

	@Override
	public String delete(Command cmd) {
		String rs="";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1, cmd.getSearch());
			rs= String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

}
