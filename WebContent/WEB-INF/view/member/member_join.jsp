<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/member.css" />
</head>
<body>
<div id="wrapper" >
	<h1 class="gms-text-center">Join</h1>
	<a href="../index.html" class="gms-float-right">메인으로 이동하기</a><br/>
	<hr />
	<div id="container">
	<form id="join_box" onsubmit="return join_alert();" >
			<fieldset>
				<legend>join information:</legend>
				<span class="gms-textcolor-blue gms-inline-block member-span">ID</span> 
				<input type="text" id="id" name="id" placeholder="아이디" /><br /> 
				<span class="gms-textcolor-blue gms-inline-block member-span">PASSWORD</span> 
				<input type="text" id="pass" name="pass" placeholder="비밀번호" /><br /> 
				<span class="gms-textcolor-blue gms-inline-block member-span">NAME</span> 
				<input type="text" id="name" name="name" placeholder="이름" /><br /> 
				<span class="gms-textcolor-blue gms-inline-block member-span">생년월일</span> 
				<input type="date" id="birth" name="birth" placeholder="주민번호" /><br /> 
				<span class="gms-textcolor-blue gms-inline-block member-span">PHONE</span> 
				<input type="text" id="phone" name="phone" placeholder="폰번호" /><br /> 
				<span class="gms-textcolor-blue gms-inline-block member-span">이메일</span>  
				<input type="email" id="email" placeholder="abc@naver.com" name="email" /><br />
				<span class="gms-textcolor-blue gms-inline-block ">남자</span>
				<input type="radio" name="gender" value="male" checked /> 
				<span class="gms-textcolor-blue gms-inline-block ">여자</span>
				<input type="radio" name="gender" value="female" /><br />
				
				<h3>전공</h3>
				<select name="major" id="">
 	 			<option value="computer">컴퓨터공학</option>
   				<option value="economics" selected>경제학</option>
  				<option value="social">관광학</option>
   				<option value="art">예술</option>
				</select> <br/>
				<h3>수강과목</h3>
				<input type="checkbox" name="subject" value="java" checked="checked"/>자바<br/>
				<input type="checkbox" name="subject" value="c"/>C<br/>
				<input type="checkbox" name="subject" value="html"/>HTML<br/>
				<input type="checkbox" name="subject" value="javascript"/>자바스크립트<br/>
				<input type="checkbox" name="subject" value="sql"/>SQL<br/>
				<input type="checkbox" name="subject" value="python"/>파이썬<br/>
				<input type="hidden" name="action" value="join" />
				<input type="hidden" name="page" value="main" />
				<div align="center">
				<input type="submit" id="join_yes_btn" class="gms-bgcolor-blue" value="회원가입" /> 
				<input type='reset' id="join_no_btn" class="gms-bgcolor-red" value='취소'><br />
				</div>
			</fieldset>
	</form>
	</div>
	<script>
function join_alert(){
	var id=document.getElementById("id").value;
	var pass=document.getElementById("pass").value;
	var name=document.getElementById("name").value;
	var birth=document.getElementById("birth").value;
	if(id===""){
		alert('아이디 없음');
		return false;
	}
	if(pass===""){
		alert('비밀번호 다름');
		return false;
	}
	if(name===""){
		alert('이름 없음');
		return false;
	}
	if(birth===""){
		alert('생일 입력');
		return false;
	}
	var form=document.getElementById('join_box');
	//form.setAttribute('action','${ctx}/member.do');
	//form.setAttribute('method','post');
	//form.submit();
	form.method="post";
	form.action="${ctx}/member.do";
	return true;
}
	</script>
	</div>
	
</body>
</html>