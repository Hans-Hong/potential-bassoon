<%@page import="kr.or.ddit.utils.CookieUtils"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.Objects"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String message = (String) session.getAttribute("message");
	if(StringUtils.isNotBlank(message)){
		%>
		<script type="text/javascript">
			alert("<%=message %>");
		</script>
		<%
		session.removeAttribute("message");
	}
%>
</head>
<body>
<form action="${pageContext.request.contextPath}/login/login.do" method="post">
<ul>
	<%
		CookieUtils cookieUtils = new CookieUtils(request);
		String saveId = cookieUtils.getCookieValue("idCookie");
	%>
	<li>
		아이디 : <input type="text" name="mem_id" value="<%=Objects.toString(saveId, "") %>"/>
		<input type="checkbox" name="idSave" value="saveId" <%=cookieUtils.exists("idCookie")?"checked":"" %> /> 아디저장
	</li>
	<li>	
		비밀번호 : <input type="text" name="mem_pass" />
		<input type="submit" value="로그인" />
	</li>
</ul>
</form>
</body>
</html>








