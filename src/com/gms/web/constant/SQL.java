package com.gms.web.constant;

public class SQL {
	public static final String MEMBER_INSERT=String.format("insert into %s(%s,%s,%s,%s,%s,%s,%s,%s,%s) values(?,?,?,?,?,?,?,?,SYSDATE)",DB.TABLE_MEMBER,DB.MEMBER_ID,DB.MEMBER_PW,DB.MEMBER_NAME,DB.MEMBER_SSN,DB.MEMBER_PHONE,DB.MEMBER_EMAIL,DB.MEMBER_MAJOR,DB.MEMBER_PROFILE,DB.MEMBER_REGDATE);
	public static final String MEMBER_LIST=String.format("select * from %s", DB.TABLE_MEMBER);
	public static final String MEMBER_FINDBYNAME=String.format("select * from %s where %s=?", DB.TABLE_MEMBER,DB.MEMBER_NAME);
	public static final String MEMBER_FINDBYID=String.format("select * from %s where %s=?", DB.TABLE_MEMBER,DB.MEMBER_ID);
	public static final String MEMBER_COUNT=String.format("select count(*) as count from %s", DB.TABLE_MEMBER);
	public static final String MEMBER_UPDATE=String.format("update %s set %s=? where %s=?", DB.TABLE_MEMBER,DB.MEMBER_PW,DB.MEMBER_ID);
	public static final String MEMBER_DELETE=String.format("delete from %s where %s=?", DB.TABLE_MEMBER,DB.MEMBER_ID);
	
	public static final String BOARD_INSERT=String.format("insert into %s(%s,%s,%s,%s,%s,%s) values(article_seq.nextval,?,?,?,0,SYSDATE)",DB.TABLE_BOARD,DB.BOARD_ARTICLE_SEQ,DB.BOARD_ID,DB.BOARD_TITLE,DB.BOARD_CONTENT,DB.BOARD_HITCOUNT,DB.BOARD_REGDATE);
	public static final String BOARD_LIST=String.format("select * from %s", DB.TABLE_BOARD);
	public static final String BOARD_UPDATE=String.format("update %s set %s=?, %s=? where %s=?", DB.TABLE_BOARD,DB.BOARD_TITLE,DB.BOARD_CONTENT,DB.BOARD_ARTICLE_SEQ);
	public static final String BOARD_DELETE=String.format("delete from %s where %s=?", DB.TABLE_BOARD,DB.BOARD_ARTICLE_SEQ);
	public static final String BOARD_COUNT=String.format("select count(*) as count from %s", DB.TABLE_BOARD);
	public static final String BOARD_FINDBYSEQ=String.format("select * from %s where %s=?", DB.TABLE_BOARD,DB.BOARD_ARTICLE_SEQ);
	public static final String BOARD_FINDBYID=String.format("select * from %s where %s=?", DB.TABLE_BOARD,DB.BOARD_ID);
	public static final String BOARD_UPDATEHIT=String.format("update %s set %s=? where %s=?", DB.TABLE_BOARD,DB.BOARD_HITCOUNT,DB.BOARD_ARTICLE_SEQ);

	public static final String MAJOR_INSERT=String.format("insert into %s(major_id,title,id,subj_id) values(?,?,?,?)", DB.TABLE_MAJOR);
	public static final String STUDENT_LIST=String.format("select t.* from (select rownum rnum, s.* from %s s)t where t.rnum between ? and ?", DB.TABLE_STUDENT);
	public static final String STUDENT_COUNT=String.format("select count(*) as count from %s where %s like ? ", DB.TABLE_STUDENT,"name");
	public static final String STUDENT_SEARCH=String.format("select t2.* from (select rownum seq, t.* from(select * from %s where %s like ? order by no desc) t) t2 where t2.seq between ? and ?", DB.TABLE_STUDENT,"name");
	public static final String STUDENT_FINDBYID=String.format("select * from %s where %s=?", DB.TABLE_STUDENT,DB.MEMBER_ID);
}
