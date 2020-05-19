<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.DDITStudentVO"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.servlet03.dao.DDITStudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		border-collapse: collapse;
	}
	td,th{
		border:1px solid black;
	}
	.yellow{
		background-color: yellow;
	}
</style>
</head>
<body>
등록된 모든 학생 조회
<h4>
	<a href="<%=request.getContextPath() %>/ddit/regist.do">신규등록</a>
</h4>
<table>
	<thead>
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>나이</th>
			<th>성별</th>
		</tr>
	</thead>
	<tbody>
<%
	DDITStudentVO lastStudent = (DDITStudentVO) session.getAttribute("lastStudent");
	session.removeAttribute("lastStudent");
	List<DDITStudentVO> allStudents = (List) request.getAttribute("allStudents");
	for(DDITStudentVO vo : allStudents){
		String clzName = vo.equals(lastStudent)? "yellow" :"normal";
		%>
		<tr class="<%=clzName %>">
			<td><%=vo.getCode() %></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getAge() %></td>
			<td><%=vo.getGen() %></td>
		</tr>
		<%
	}
%>
	</tbody>
</table>
</body>
</html>










