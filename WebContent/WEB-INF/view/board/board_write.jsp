<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="../common/common_head.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/board.css" />
</head>
<body>
<div id="wrapper">
	<h1 class="gms-text-center">글쓰기</h1>
	<a href="../index.html" style="float: right">메인으로 이동하기</a>
	<br />
	<hr />
		<div id="container">
			<form action="" method="get">
				<input type="text" id="title" placeholder="제목"  /><br />
				<textarea name="message" rows="10" cols="40">The cat was playing in the garden.</textarea>
				<br> <input type="submit" class="gms-bgcolor-blue" value="글쓰기">
			</form>
		</div>
	</div>
</body>
</html>
<jsp:include page="../common/footer.jsp" />