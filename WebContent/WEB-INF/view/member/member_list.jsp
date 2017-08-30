<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../common/common_head.jsp" />


<h1 class="gms-text-center">회원 목록</h1>
<a href="${ctx}/index.jsp" class="gms-float-right">메인으로 이동하기</a>
<br />
<hr />
<div>
<div class="row" style="width:500px; margin:0 auto;">
  <div class="col-lg-6" style="width:500px;">
    <div class="input-group">
      <input type="text" id="search_id" name="search" class="form-control" value="${requestScope.searchn}" placeholder="Search for...">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button" onclick="searchStudent('1')">Go!</button>
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row -->
	<table id="member_list_tab" style="margin-top:50px;">
		<tr>
			<th>no.</th>
			<th>아이디</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>과목</th>
			<th>등록일</th>
			<th>수정/삭제</th>
		</tr>
		<c:forEach var="i" items="${requestScope.list}">
			<tr>
				<td>${i.no}</td>
				<td>${i.id}</td>
				<td><a onclick="detailStudent('${i.id}')"> ${i.name}</a></td>
				<td>${i.ssn}</td>
				<td>${i.phone}</td>
				<td>${i.email}</td>
				<td>${i.title}</td>
				<td>${i.regdate}</td>
				<td><a onclick="updateStudent('${i.id}')">수정</a>/<a onclick="deleteStudent('${i.id}')">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<nav aria-label="Page navigation" style="width:400px; margin: 0 auto;">
		<ul class="pagination">
		<c:if test="${requestScope.prevBlock gt 0 }">
			<li><a href="#" style="height:34px;"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
			<li><a onclick="List('member','member_list',${requestScope.startPage}-${requestScope.blockSize})" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
		</c:if>
			<c:forEach varStatus="i" begin="${requestScope.startPage}" end="${requestScope.endPage}" step="1">
			<c:choose>
			<c:when test="${i.index eq requestScope.pageNumber}">
			<li class="active"><a>${i.index}</a></li>
			</c:when>
			<c:otherwise>
			<li onclick="searchStudent('${i.index}')"><a>${i.index}</a></li>
			</c:otherwise>
			</c:choose>
			</c:forEach>
		<c:if test="${requestScope.endBlock le requestScope.theNumberOfPages}">
			<li><a onclick="List('member','member_list',${requestScope.startPage+requestScope.blockSize})" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
			<li><a href="#" style="height:34px;"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
		</c:if>
		</ul>
	</nav>
</div>
<script>

</script>
<jsp:include page="../common/footer.jsp" />