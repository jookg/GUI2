package com.gms.web.serviceImpl;

import java.util.List;

import com.gms.web.domain.ArticleBean;
import com.gms.web.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
	
	public static ArticleServiceImpl getInstance() {
		return new ArticleServiceImpl();
	}
	private ArticleServiceImpl() {
		
	}
	@Override
	public String write(ArticleBean bean) {
		
		return (ArticleDAOImpl.getInstance().insert(bean)).equals("1")? "게시 완료":"게시 오류";
	}

	@Override
	public List<ArticleBean> list() {
		
		return ArticleDAOImpl.getInstance().selectAll();
	}

	@Override
	public List<ArticleBean> findById(String id) {
		// TODO Auto-generated method stub
		return ArticleDAOImpl.getInstance().selectById(id);
	}

	@Override
	public ArticleBean findBySeq(String seq) {
		// TODO Auto-generated method stub
		return ArticleDAOImpl.getInstance().selectBySeq(seq);
	}

	@Override
	public String count() {
		// TODO Auto-generated method stub
		return ArticleDAOImpl.getInstance().count();
	}

	@Override
	public String modify(ArticleBean bean) {
		// TODO Auto-generated method stub
		return (ArticleDAOImpl.getInstance().update(bean).equals("1"))? "업데이트성공":"업데이트오류";
	}

	@Override
	public String remove(String seq) {
		// TODO Auto-generated method stub
		return (ArticleDAOImpl.getInstance().delete(seq).equals("1"))? "삭제성공":"삭제오류";
	}

}
