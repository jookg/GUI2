<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
   <div class="container-fluid">
     <div class="navbar-header">
      <a class="navbar-brand">GMS</a>
     </div>
    <ul class="nav navbar-nav">
       <li class="active"><a onclick="moveTo('common','main')"><span class="glyphicon glyphicon-home"></span> &nbsp; Home</a></li>
       <li class="dropdown">
       <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">회원관리
       <span class="caret"></span></a>
       <ul id="navbar_ul_stu">
       <li><a>회원가입</a></li>
	   <li><a>회원목록</a></li>
	   <li><a>회원상세</a></li>
	   <li><a>회원수정</a></li>
       </ul>
       </li>
         <li class="dropdown">
       <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">성적관리
       <span class="caret"></span></a>
       <ul id="navbar_ul_grade">
       <li><a onclick="moveTo('grade','grade_add')">성적 입력</a></li>
	   <li><a onclick="moveTo('grade','grade_list')">성적 목록</a></li>
	   <li><a onclick="moveTo('grade','grade_detail')">성적 상세</a></li>
	   <li><a onclick="moveTo('grade','grade_update')">성적 수정</a></li>
       </ul>
       </li>
         <li class="dropdown">
       <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">게시판관리
       <span class="caret"></span></a>
       <ul id="navbar_ul_board">
       <li><a onclick="moveTo('board','board_write')">게시글 쓰기</a></li>
		<li><a onclick="moveTo('grade','grade_list')">게시글 목록</a></li>
		<li><a onclick="moveTo('grade','grade_detail')">게시글 상세</a></li>
		<li><a onclick="moveTo('grade','grade_update')">게시글 수정</a></li>
       </ul>
       </li>
     </ul>
     <span class="gms-textcolor-blue gms-inline-block member-span gms-float-right">${sessionScope.user.name} <a id="logout"> 로그아웃</a></span>
  <script>
  function mainLoad(){
	  var u1 =document.getElementById('main_ul_stu');
	  var u2 =document.getElementById("main_ul_grade");
	  var u3 =document.getElementById("main_ul_board");
	  u1.setAttribute("class","list-group");
	  u2.setAttribute("class","list-group");
	  u3.setAttribute("class","list-group");
	  var ul_stu = u1.children;
	  var ul_grade = u2.children;
	  var ul_board = u3.children;
	  var i;
	  for(i=0;i<ul_stu.length;i++){
	  	ul_stu[i].setAttribute("class","list-group-item");
	  }
	  for(i=0;i<ul_grade.length;i++){
	  	ul_grade[i].setAttribute("class","list-group-item");
	  }
	  for(i=0;i<ul_board.length;i++){
	  	ul_board[i].setAttribute("class","list-group-item");
	  }

	  function gms_del(name){
	  	var person = prompt("삭제할 "+name, "입력");
	  }
	  ul_stu[0].setAttribute("onclick","moveTo('member','member_join')");
	  ul_stu[1].setAttribute("onclick","List('member','member_list','1')");
	  ul_stu[2].setAttribute("onclick","moveTo('member','member_detail')");
	  ul_stu[3].setAttribute("onclick","moveTo('member','member_update')");
	  ul_stu[4].setAttribute("onclick","gms_del('회원')");

  }
  function navbarLoad(){
  var logout = document.getElementById("logout");
  var d1 =document.getElementById("navbar_ul_stu");
  var d2 =document.getElementById("navbar_ul_grade");
  var d3 =document.getElementById("navbar_ul_board");
  logout.setAttribute("onclick","log_out()");
  d1.setAttribute("class","dropdown-menu");
  d2.setAttribute("class","dropdown-menu");
  d3.setAttribute("class","dropdown-menu");
  var dl_stu = d1.children;
  var dl_grade = d2.children;
  var dl_board = d3.children;
  
  dl_stu[0].setAttribute("onclick","moveTo('member','member_join')");
  dl_stu[1].setAttribute("onclick","List('member','member_list','1')");
  dl_stu[2].setAttribute("onclick","moveTo('member','member_detail')");
  dl_stu[3].setAttribute("onclick","moveTo('member','member_update')");
  
  }
  window.onload=navbarLoad();
  function log_out(){
	 location.href="${ctx}/common.do?action=logout&page=home";
  }
  function List(dir,page,num){
	  location.href="${ctx}/"+dir+".do?action=list&page="+page+"&num="+num;
  }
  function updateStudent(id){
		location.href="${ctx}/member.do?action=detail&page=member_update&id="+id;
	}
	function deleteStudent(id){
		location.href="${ctx}/member.do?action=delete&page=member_list&id="+id;
	}
	function detailStudent(id){
		location.href="${ctx}/member.do?action=detail&page=member_detail&id="+id;
	}
  function searchStudent(num){
	var search_id=document.getElementById("search_id").value;
	location.href="${ctx}/member.do?action=search&page=member_list&num="+num+"&search_id="+search_id;
  }
  function moveTo(dir,page){
	location.href="${ctx}/"+dir+".do?action=move&page="+page;
}
  function test(){
	  document.querySelector('#updateBtn').onclick=studentInfo;
  }
  function studentInfo(){
	  var id='id',
	  id_val='${requestScope.student.id}',
	  name='name',
	  name_val='${requestScope.student.name}',
	  email='email',
	  email_val='${requestScope.student.email}';
	  sessionStorage.setItem(id,id_val);
	  sessionStorage.setItem(name,name_val);
	  sessionStorage.setItem(email,email_val);
  }
  </script>
  </div>
</nav>