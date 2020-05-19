<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>
	<%=request.getAttribute("newStudent") %>
	<%=request.getAttribute("errors") %>
</h4>
<!-- 이름(name), 생년월일(birthday), 나이(age), 학력(grade), 성별(gen), 자격증(license), 경력사항(career) -->

<form method="post">
<pre>
	이름 : <input type="text" name="name" />
	생일 : <input type="date" name="birthday" />
	나이 : <input type="number" name="age" />
	학력 : <select name="grade">
			<option value>학력</option>
			<%
				Map<String, String> gradeMap = (Map)request.getAttribute("gradeMap");
				for( Entry<String, String> entry : gradeMap.entrySet()){
					%>
						<option value="<%=entry.getKey() %>"><%=entry.getValue() %></option>
					<%
				}
			%>
		 </select>
	성별 :<label><input type="radio" name="gen" value="F">여자</label>
		 <label><input type="radio" name="gen" value="M">남자</label>	 
	자격증 : 
		<select name="license" multiple>
			<%
			Map<String, String> licenseMap = (Map)request.getAttribute("licenseMap");
				Iterator<String> keys = licenseMap.keySet().iterator();
				while(keys.hasNext()){
					String code = keys.next();
					String name = licenseMap.get(code);
					%>
					<option value="<%=code %>"><%=name %></option>
					<%
				}
			%>
		</select>
	경력사항 : 
		<textarea name="career" rows="5" cols="50"></textarea>
	<button type="submit">등록</button>			 
	<button type="reset">취소</button>			 
	<button type="button">걍버튼</button>			 
</pre>	
</form>
</body>
</html>














