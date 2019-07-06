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
    
    <title>My JSP 'Sp_xiangqing.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/Sp_xiangqing.css">

  </head>
  <script type="text/javascript">
  	function sub(){
  		var a = document.getElementById("input_number").value;
		//var input = document.getElementById("input_number");
		if(a>1){
			a = parseInt(a) - 1;	
		}
		document.getElementById("input_number").value = a;
  	}
  	
  	function add(){
  		var a = document.getElementById("input_number").value;
		//var input = document.getElementById("input_number");
		if(a < 10){
			a = parseInt(a) + 1;	
		}
		document.getElementById("input_number").value = a;
  	}
  	
  	function go_sp_car(){
  		var uri = "http://localhost:8080/Fosu_Project/servlet/SP_carServlet?id=";
  		var id = <%=request.getParameter("id")%>
  		var number = document.getElementById("input_number").value;
  		location = uri+id+"&number="+number;
  	}
  	
  </script>
   <jsp:include page="public_head.jsp" flush="true"></jsp:include>
  <body>
  	<!--  <c:forEach var="c" items="${sp_info_list }" varStatus="status">
							<li id="selbgc11">
								<dl class="item-des">
									<dt>
										<a href="<%=basePath%>servlet/IndexServlet?id=${c.id}">
											<img  alt="无法显示图片" src="./img/${c.sp_img }" width="132" height="96" />
										</a>
									</dt>
									<dd>
										<s>¥:${c.old_price }  </s>
								 		<strong>¥:${c.new_price } </strong>
								 	</dd>
								  	<dd>
								  		<h2><a href="item.do?id=1" title="Cetaphil丝塔芙洗面奶(法国) 200ml 极其温和的配方 卓越的保湿功效 严谨的生产方式 " target="_self">${c.sp_info }</a></h2>
								  	</dd>
								</dl>
							  </li>
							
		</c:forEach> -->
			 <c:forEach var="c" items="${sp_info_list }" varStatus="status">
							<div class="head">
								${c.sp_info }
							</div>
							
							<div class="content">
								<div class="content_left">
									<img  alt="无法显示图片" src="./img/${c.sp_img }" width="132" height="96" />
								</div>
								<div class="content_right">
									<ul>
										<li>供应商：Cetaphil丝塔芙洗面奶</li>
										<li>出产地：法国</li>
										<li>定价：¥:${c.old_price }</li>
										<li class="special">疯狂价：¥:${c.new_price } (7折)</li>
										<li>库存：100 下单后立刻发货</li>
										<li class="special">促销信息：该商品参加满减活动，购买活动商品每满300元，可减100现金</li>
									</ul>
									<div class="content_buy">
										<span>我要买：</span>
										<button id="but1" name="but1" onclick="javascript:sub();">-</button>
										<input type="text" id="input_number" name="input_number" value="1" disabled="disabled" style="width:60px;text-align:center;">
										<button id="but1" name="but1" onclick="javascript:add();" >+</button>
									</div>
									<div class="content_button">
										<a href="javascript:go_sp_car();">
											<img alt="找不到图片" src="./img/add_car.png">
										</a>
									</div>
								</div>
							</div>
		</c:forEach>
  </body>
</html>
