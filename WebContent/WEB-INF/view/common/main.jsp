<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="common_head.jsp"></jsp:include>
<div class="jumbotron text-center">
	<h1>Grade Management System</h1>
</div>
<div class="container">
	<div class="row">
		<div class="col-sm-4">
			<div class="gms-font-20"><i class="glyphicon glyphicon-user"></i>학생관리<br/></div><br/>
			<ul id="main_ul_stu">
				<li><a>회원가입</a></li>
				<li><a>회원목록</a></li>
				<li><a>회원상세</a></li>
				<li><a>회원수정</a></li>
				<li><a>회원삭제</a></li>
			</ul>
		</div>
		<div class="col-sm-4">
		<div class="gms-font-20"><i class="glyphicon glyphicon-cloud" style="font-size:25px;"></i>성적관리<br/></div><br/>
			<ul id="main_ul_grade">
				<li><a onclick="moveTo('grade','grade_add')">성적 입력</a></li>
				<li><a onclick="moveTo('grade','grade_list')">성적 목록</a></li>
				<li><a onclick="moveTo('grade','grade_detail')">성적 상세</a></li>
				<li><a onclick="moveTo('grade','grade_update')">성적 수정</a></li>
				<li><a onclick="gms_del('성적')">성적 삭제</a></li>
			</ul>
		</div>
		<div class="col-sm-4">
		<div class="gms-font-20"><i class="glyphicon glyphicon-thumbs-up" style="font-size:25px;"></i>게시판<br/></div><br/>
			<ul id="main_ul_board">
				<li><a onclick="moveTo('board','board_write')">게시글 쓰기</a></li>
				<li><a onclick="moveTo('grade','grade_list')">게시글 목록</a></li>
				<li><a onclick="moveTo('grade','grade_detail')">게시글 상세</a></li>
				<li><a onclick="moveTo('grade','grade_update')">게시글 수정</a></li>
				<li><a onclick="gms_del('게시글')">게시글 삭제</a></li>
			</ul>
		</div>
	</div>
</div>
<script>
window.onload=mainLoad();
</script>
<jsp:include page="./footer.jsp" />
