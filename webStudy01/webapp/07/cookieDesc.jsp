<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07/cookieDesc.jsp</title>
</head>
<body>
<h4>Cookie</h4>
<pre>
	Http : Connectionless/Stateless : 비연결지향 무상태 특성
	해당 단점을 보완하는 방법 : session, cookie
	Cookie : 대화 유지를 위한 상태 정보를 클라이언트 쪽에 저장하는 개념.
	1. 쿠키생성
	2. 응답과 함께 클라이언트로 전송
	
	3. 브라우저별 쿠키 저장소에 각기 따로 저장.
	4. 다음 요청이 발생할때 함께 서버로 재전송.
	
	5. 요청에 포함된 쿠키를 통해 상태 복원.
	
	*** 쿠키의 속성
	1. name
	2. value : 문자열만 가능, 특수문자가 포함된다면, URL encoding 방식으로 인코딩 필요.
	3. domain/host
			만약, host name 을 생략하면, 해당 기관의 모든 서버를 대상으로 쿠키 재전송.
			** 주의! 쿠키의 출처와 설정된 domain이 다른 경우, 사용할 수 없음.
		www.naver.com - GTLD(Global Top Level Domain)
		www.naver.co.kr - NTLD(National Top Level Domain)
	4. path : 생략한 경우, 쿠키가 생성된 경로로 설정됨.
			다음 요청이 설정된 경로 이하로 발생한 경우, 쿠키가 재전송됨.
	5. maxAge : 생략시, 기본값으로 세션과 동일한 만료시간이 설정됨(초단위).
			0 : 저장된 쿠키 삭제(maxAge 이외의 나머지 속성이 동일한 쿠키만 삭제됨)
		   -1 : 브라우저 종료시 만료됨.
		
	
	<%
// 		Cookie tmpCookie = new Cookie("firstCookie", "FirstCookie");
// 		response.addCookie(tmpCookie);
		
// 		String cookieValue = URLEncoder.encode("한글 국산 쿠기", "UTF-8");
// 		Cookie kereanCookie = new Cookie("koreanCookie", cookieValue);
// 		response.addCookie(kereanCookie);
		// 톰켓 7.0으로 테스트
// 		Cookie allDomainCookie = new Cookie("allDomainCookie", "ALL~~Domain~");
// 		allDomainCookie.setDomain(".lhj.com");
// 		response.addCookie(allDomainCookie);
// 		Cookie allPath = new Cookie("allPath", "All~Path");
// 		allPath.setPath(request.getContextPath() + "/06");
// 		response.addCookie(allPath);
		Cookie longLive = new Cookie("longLive", "Long~Live");
		longLive.setPath(request.getContextPath());
		longLive.setMaxAge(0);
// 		longLive.setHttpOnly(true);
		longLive.setSecure(true);
		response.addCookie(longLive);
	%>
	<a href="./viewCookie.jsp">동일경로 확인</a>
	<a href="../06/viewCookie.jsp">다른경로 확인</a>
</pre>
</body>
</html>








