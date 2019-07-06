<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SP_car.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="./css/SP_car.css">

  </head>
  <script type="text/javascript">
  	var juti;
  	function sub(juti){
  		var juti2=juti+"";
  		var a = document.getElementById(juti2).value;
  		a=parseInt(a);
		//var input = document.getElementById("input_number");
		if(a>1){
			a = a - 1;	
		}
		document.getElementById(juti2).value = a;
  	}
  	
  	function add(juti){
  		var juti2=juti+"";
  		var a = document.getElementById(juti2).value;
  		a=parseInt(a);
		//var input = document.getElementById("input_number");
		if(a < 10){
			a = a + 1;	
		}
		document.getElementById(juti2).value = a;
  	}
  	
  	function go_sp_car(){
  		var uri = "http://localhost:8080/Fosu_Project/servlet/SP_cardelServlet?sp_id=";
  		var id = <%=request.getParameter("id")%>
  		location = uri+id;
  	}
  	
  </script>
   <jsp:include page="public_head.jsp" flush="true"></jsp:include>
  <body>

	
	<table class="sp_car_table">
		<thead>
			<tr>
				<th><input type="checkbox" id="checkALL"></th>
				<th>商品名称</th>
				<th>积分</th>
				<th>疯狂价</th>
				<th>小计</th>
				<th>数量</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${sp_carinfoList }" varStatus="status">
				<tr>
					<td style="width:5%;"><input type="checkbox" name="checkItem" value=${item.id}/></td>
					<td style="width:35%;">
						<div class="table_img">
							<img src="./img/${c.sp_img }">
						</div>
						<div  class="table_info">
						  <span>
						    ${c.sp_info }
						  </span>
						</div>
					</td>
					<td style="width:10%;">0</td>
					<td style="width:15%;">￥${c.old_price }(0.7折)</td> 
					<td style="width:15%;">￥${c.new_price }</td>
					<td style="width:10%;">
						<button id="but1" name="but1" onclick="javascript:sub('input_number_${c.id}');">-</button>
						<input type="text" id="input_number_${c.id }" name="input_number" value="${c.number }" disabled="disabled" style="width:30px;text-align:center;">
						<button id="but1" name="but1" onclick="javascript:add('input_number_${c.id}');" >+</button>
					</td>
					<td style="width:10%;">
						<a href="./servlet/SP_cardelServlet?id=${c.id}">移除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="SP_car_bottom">
		<ul class="SP_car_ul_bottom">
			<li>数量总计：<span style="color:red;font-weight:900;">5</span>（件）</li>
			<li>金额总计：￥&nbsp;<span style="color:red;font-weight:900;">207.13</span>&nbsp;（折后价）</li>
			<li><div class="SP_car_gou"><a href="<%=basePath %>servlet/IndexServlet">继续购物</a></div><div class="SP_car_jie"><a>结&nbsp;算</a></div></li>
		</ul>
	</div>
  </body>
  <jsp:include page="public_bottom.jsp" flush="true"></jsp:include>
</html>
