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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="./css/index.css">
	<link rel="stylesheet" type="text/css" href="./css/main.css">

	<link rel="stylesheet" type="text/css" href="./css/font-awesome-4.7.0/css/font-awesome.css">
  </head>
  <jsp:include page="public_head.jsp" flush="true"></jsp:include>
  <body>
  	<div class="content">
		<div class="wupinfl">
			<span class="wupinflh">物品分类</span>
			<ul>
				<li><a href="<%=basePath %>servlet/IndexServlet?type=1&info_sous"><span>护肤</span><i class="fa fa-angle-right"></i></a></li>
				<li><a href="<%=basePath %>servlet/IndexServlet?type=2&info_sous"><span>彩妆</span><i class="fa fa-angle-right"></i></a></li>
				<li><a href="<%=basePath %>servlet/IndexServlet?type=3&info_sous"><span>香气</span><i class="fa fa-angle-right"></i></a></li>
				<li><a href="<%=basePath %>servlet/IndexServlet?type=4&info_sous"><span>男士专区</span><i class="fa fa-angle-right"></i></a></li>
				<li><a href="<%=basePath %>servlet/IndexServlet?type=5&info_sous"><span>美容类</span><i class="fa fa-angle-right"></i></a></li>
				<li><a href="<%=basePath %>servlet/IndexServlet?type=6&info_sous"><span>减肥类</span><i class="fa fa-angle-right"></i></a></li>
				<li><a href="<%=basePath %>servlet/IndexServlet?type=7&info_sous"><span>家用电品</span><i class="fa fa-angle-right"></i></a></li>
				<li><a href="<%=basePath %>servlet/IndexServlet?type=8&info_sous"><span>生活类</span><i class="fa fa-angle-right"></i></a></li>
			</ul>
		</div>
		<div class="shopping-list">
			<div style="float:right;width:766px;text-align:center;">
				<div style="padding:10px 0;">
					<form action="./servlet/IndexServlet" >
				  		物品类型：
				  		<select name="type">
					  			
					  				<option value="1">护肤</option>
					  			
					  				<option value="2">彩妆</option>
					  			
					  				<option value="3">香气</option>
					  			
					  				<option value="4">男士专区</option>
					  			
					  				<option value="5">美容类</option>
					  			
					  				<option value="6">减肥类</option>
					  			
					  				<option value="7">家用电品</option>
					  			
					  				<option value="8">生活类</option>
					  			
				  		</select>
					    <input name="info_sous" id="info_sous" type="text" value="" size="50"/>
					    <input type="submit" id="sb" name="sb" value="搜索"/>
				  	</form>
				</div>
				<div class="shopping-list-xiangxi" id="sp_list">
					<ul class="shopping-list-xiangxi-head" >
						<li><a href="" id="sp_one">护肤</a></li>
					</ul>
					
					<div class="sales-queue" id="tabs-1" style="background-color:white;margin-top:0px;">
					    <ul class="goods-queue3">	
					    <c:forEach var="c" items="${sp_info_list }" varStatus="status">
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
								  		<h2><a href="<%=basePath%>servlet/IndexServlet?id=${c.id}">${c.sp_info }</a></h2>
								  	</dd>
								</dl>
							  </li>
							
							  <c:if test = "${status.count%4==0 }">
							  
							  
							
							  </c:if>
						</c:forEach>
						</ul>
						
		<!--				
						<ul class="goods-queue3">	
							<li id="selbgc11">
								<dl class="item-des">
									<dt>
										<a href="item.do?id=1" title="Cetaphil丝塔芙洗面奶(法国) 200ml 极其温和的配方 卓越的保湿功效 严谨的生产方式 " target="_self">
											<img src="./img/20130331_1_1.jpg" width="132" height="96" />
										</a>
									</dt>
									<dd>
										<s>¥:108.00  </s>
								 		<strong>¥:75.60 </strong>
								 	</dd>
								  	<dd>
								  		<h2><a href="item.do?id=1" title="Cetaphil丝塔芙洗面奶(法国) 200ml 极其温和的配方 卓越的保湿功效 严谨的生产方式 " target="_self">Cetaphil丝塔芙洗面奶(法国) 200ml 极其温和的配方 卓越的保湿功效 严谨的生产方式 </a></h2>
								  	</dd>
								</dl>
							  </li>
						</ul>
			  -->
						
						
						<div class="pagebottom" id="pager" style="clear:both;"></div>
					</div> 
				</div>
					
			</div>
		</div>
	</div>
  </body>
  <jsp:include page="public_bottom.jsp" flush="true"></jsp:include>
</html>
