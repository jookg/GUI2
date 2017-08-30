<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  <!--@디렉티브  -->
 <%@ page import="com.gms.web.constant.DB" import="java.sql.*"%>
  <% 
	Class.forName(DB.ORACLE_DRIVER);
	Connection conn= DriverManager.getConnection(DB.ORACLE_URL,DB.USERNAME,DB.PASSWORD);
	Statement stmt=conn.createStatement();
	String sql="SELECT * FROM Member WHERE id='joo'";
	ResultSet rs=stmt.executeQuery(sql);
	String findName="";
	if(rs.next()){
		findName=rs.getString("name");
	}
  %> <!-- 스크립트립 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=findName%></h1> <!--sysout  -->
</body>
</html>