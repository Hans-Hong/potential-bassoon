<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/eventPropagation.jsp</title>
<style type="text/css">
	div{
		padding:10px;
		border:1px solid black;
	}
</style>
<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
</head>
<body>
<h4>이벤트 전파</h4>
<pre>
	Bubbling : 하위 엘리먼트로부터 가장 상위에 있는 엘리먼트로 이벤트 전파
	Capturing : 상위 엘리먼트로 부터 하위 엘리먼트로 이벤트 전파
</pre>
<div id="outer">
	<div id="middle">
		<div id="inner">
			여기를 클릭할것.		
		</div>
	</div>
</div>
<button id="newBtn">새로 만들기</button>
<script type="text/javascript">
	var divs = document.querySelectorAll("div");
// 	divs.forEach(function(div){
// 		div.addEventListener("click", function(event){
// 			let id = this.id;
// 			alert(id);
// 		}, true); // true : capturing  false : Bubbling  기본 : false
// 	});
	$("#newBtn").on("click", function(){
		$("#inner").append($("<div>").prop("id", "newInner").text("새로만든 디브"));
		alert(divs.length);
	});
	var divs = $("body").on("click", "#inner", function(event){
		let id = $(this).prop("id");
// 		if(id=="middle"){
// 			event.stopPropagation();
// 		}
		alert(id);
	});
	
</script>
</body>
</html>










