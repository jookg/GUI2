<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="../common/common_head.jsp" />
<%@ page import="java.text.SimpleDateFormat" import="java.util.Date" %>
<%@ page import="com.gms.web.util.Clock" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/board.css" />
</head>
<body>
<div id="wrapper">
	<header>
		<h1 id="title">게시물 목록</h1><%=new Clock().now()%>
		<a class="gms-float-right" href="../index.jsp">메인으로 가기</a><br>
	</header>
	<hr/>
		<table id="board_tab">
			<tr id="board_menu">
				<th class="board_data gms-widht-5pro">No.</th>
				<th class="board_data gms-widht-25pro">제목</th>
				<th class="board_data gms-widht-35pro">내용</th>
				<th class="board_data gms-widht-10pro">글쓴이</th>
				<th class="board_data gms-widht-10pro">등록일</th>
				<th class="board_data gms-widht-5pro">조회수</th>
			</tr>
			<tr>
				<td class="board_data">s</td>
				<td class="board_data">s</td>
				<td class="board_data">s</td>
				<td class="board_data">s</td>
				<td class="board_data">s</td>
				<td class="board_data">s</td>

			</tr>
			<tr>
				<td class="board_data">d</td>
				<td class="board_data">d</td>
				<td class="board_data">d</td>
				<td class="board_data">d</td>
				<td class="board_data">d</td>
				<td class="board_data">d</td>
			</tr>
			<tr>
				<td class="board_data">c</td>
				<td class="board_data">c</td>
				<td class="board_data">c</td>
				<td class="board_data">c</td>
				<td class="board_data">c</td>
				<td class="board_data">c</td>
			</tr>
			<tr>
				<td class="board_data">a</td>
				<td class="board_data">a</td>
				<td class="board_data">a</td>
				<td class="board_data">a</td>
				<td class="board_data">a</td>
				<td class="board_data">a</td>
			</tr>
			<tr>
				<td class="board_data">g</td>
				<td class="board_data">g</td>
				<td class="board_data">g</td>
				<td class="board_data">g</td>
				<td class="board_data">g</td>
				<td class="board_data">g</td>
			</tr>
	</table>
</div>

</body>
</html>
<jsp:include page="../common/footer.jsp" />