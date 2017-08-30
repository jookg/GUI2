package com.gms.web.serviceImpl;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gms.web.constant.DB;
import com.gms.web.constant.SQL;
import com.gms.web.constant.Vendor;
import com.gms.web.dao.ArticleDAO;
import com.gms.web.domain.ArticleBean;
import com.gms.web.factory.DatabaseFactory;

public class ArticleDAOImpl implements ArticleDAO {
	
	public static ArticleDAOImpl getInstance() {
		return new ArticleDAOImpl();
	}
	private ArticleDAOImpl() {
		
	}
	@Override
	public String insert(ArticleBean bean) {
		String rs="";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_INSERT);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			rs= String.valueOf(pstmt.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<ArticleBean> selectAll() {
		List<ArticleBean> list=new ArrayList<>();
		try {
			ResultSet rs=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_LIST).executeQuery();
			ArticleBean ab=null;
			while(rs.next()){
				ab=new ArticleBean();
				ab.setArticleSeq(rs.getInt(DB.BOARD_ARTICLE_SEQ));
				ab.setId(rs.getString(DB.BOARD_ID));
				ab.setTitle(rs.getString(DB.BOARD_TITLE));
				ab.setContent(rs.getString(DB.BOARD_CONTENT));
				ab.setHitcount(rs.getInt(DB.BOARD_HITCOUNT));
				ab.setRegdate(rs.getString(DB.BOARD_REGDATE));
				list.add(ab);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ArticleBean> selectById(String id) {
		List<ArticleBean> list=new ArrayList<>();
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_FINDBYID);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			ArticleBean ab=null;
			while(rs.next()){
				ab=new ArticleBean();
				ab.setArticleSeq(rs.getInt(DB.BOARD_ARTICLE_SEQ));
				ab.setId(rs.getString(DB.BOARD_ID));
				ab.setTitle(rs.getString(DB.BOARD_TITLE));
				ab.setContent(rs.getString(DB.BOARD_CONTENT));
				ab.setHitcount(rs.getInt(DB.BOARD_HITCOUNT));
				ab.setRegdate(rs.getString(DB.BOARD_REGDATE));
				list.add(ab);
				
				DriverManager.getConnection(DB.ORACLE_URL,DB.USERNAME,DB.PASSWORD).createStatement().executeUpdate(
				String.format("update %s set hitcount='%s' where article_seq='%s'", DB.TABLE_BOARD,rs.getInt(DB.BOARD_HITCOUNT)+1,rs.getInt(DB.BOARD_ARTICLE_SEQ)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArticleBean selectBySeq(String seq) {
		ArticleBean ab=new ArticleBean();
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_FINDBYSEQ);
			pstmt.setString(1, seq);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				ab.setArticleSeq(rs.getInt(DB.BOARD_ARTICLE_SEQ));
				ab.setId(rs.getString(DB.BOARD_ID));
				ab.setTitle(rs.getString(DB.BOARD_TITLE));
				ab.setContent(rs.getString(DB.BOARD_CONTENT));
				ab.setHitcount(rs.getInt(DB.BOARD_HITCOUNT));
				ab.setRegdate(rs.getString(DB.BOARD_REGDATE));
				
				PreparedStatement pstmt2=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_UPDATEHIT);
				pstmt2.setInt(1, rs.getInt(DB.BOARD_HITCOUNT)+1);
				pstmt2.setInt(2,rs.getInt(DB.BOARD_ARTICLE_SEQ));
				pstmt2.executeUpdate();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ab;
	}

	@Override
	public String count() {
		String cnt="";
		try {
			ResultSet rs=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_COUNT).executeQuery();
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
	public String update(ArticleBean bean) {
		ArticleBean ab=selectBySeq(String.valueOf(bean.getArticleSeq()));
		String title=bean.getTitle();
		String content=bean.getContent();
		if(title.equals("")){
			title=ab.getTitle();
		}
		if(content.equals("")){
			content=ab.getContent();
		}
		String rs="";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_UPDATE);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bean.getArticleSeq());
			rs= String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String delete(String seq) {
		String rs="";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_DELETE);
			pstmt.setString(1, seq);
			rs= String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
