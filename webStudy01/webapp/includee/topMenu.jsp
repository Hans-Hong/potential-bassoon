<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">Company name</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
<div class="container d-flex flex-column flex-md-row justify-content-between">
    <a class="py-2" href="#" aria-label="Product">
      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mx-auto" role="img" viewBox="0 0 24 24" focusable="false"><title>Product</title><circle cx="12" cy="12" r="10"></circle><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"></path></svg>
    </a>
    <a class="py-2 d-none d-md-inline-block" href="#">회원관리</a>
    <a class="py-2 d-none d-md-inline-block" href="#">상품관리</a>
    <a class="py-2 d-none d-md-inline-block" href="#">거래처관리</a>
    <a class="py-2 d-none d-md-inline-block" href="#">게시판</a>
    <a class="py-2 d-none d-md-inline-block" href="#">방명록</a>
    <%
    	MemberVO authUser = (MemberVO)session.getAttribute("authUser");
    	if(authUser==null){
		%>
    	<a class="py-2 d-none d-md-inline-block" href="<%=request.getContextPath() %>/login/loginForm.jsp">로그인</a>
		<%    		
    	}else{
    	%>
    	<a class="py-2 d-none d-md-inline-block" href="#"><%=authUser.getMem_name() %>님</a>
    	<a id="logoutBtn" class="py-2 d-none d-md-inline-block" href="#"> 로그아웃</a>
    	<%	
    	}
    %>
    <form id="logoutForm" action="<%=request.getContextPath() %>/login/logout.do" method="post"></form>
  </div>
</nav>
<script type="text/javascript">
	var logoutForm = $("#logoutForm");
	$("#logoutBtn").on("click", function(){
		logoutForm.submit();
	});
</script>


