<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/actionTag.jsp</title>
</head>
<body>
<h4>Action Tag</h4>
<pre>
	: JSP 스펙에서 기본 제공되는 일종의 커스텀 태그
	커스텀 태그의 사용. &lt;prefix:tagname&gt; --> JSTL
	흐름제어용 엑션 태그
<%-- 	<jsp:include page="/06/fragment.jsp""></jsp:include> <!-- 서버사이드 경로   (동적)--> --%>
	<%--
		pageContext.include("/06/fragment.jsp");	// 동적
	--%>
<%-- 	<%@ include file="/06/fragment.jsp" %>  <!-- 정적 --> --%>
<%-- 	<%=includeeVariable %> --%>
	** include 의 종류
	1. 정적 include : 실행 이전에 jsp 에 해당하는 서블릿 소스를 파싱하는 단계.
					소스를 include
					1) include 지시자 사용 : jsp 파일 하나에 대한 인클루드
					2) web.xml 사용 : 컨텍스트 전체를 대상으로 한 인클루드
	2. 동적 include : Runtime에 실행 결과(data)를 include.
					1) RequestDispatcher 사용
					2) pageContext의 include
					3) jsp include action tag
	
</pre>
</body>
</html>