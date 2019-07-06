<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="./css/Login.css">
	

  </head>
  <jsp:include page="public_head.jsp" flush="true"></jsp:include>
  <body>
   	<div>
   	<!--  	<div style="float:left">
   			<img alt="找不到图片" src="img/login_bg.jpg">
   		</div>
   		-->
   		<div class="denglu">
   			 <form action="./servlet/LoginServlet" method="post">
			   	 <table align="center">
				   	 <tr>
				    	<td align="center">*登录名：</td>
				    	<td><input type="text" id="username" name="username"></td>
				    </tr>
			    	<tr>
			    		<td align="center">*密码：</td>
			    		<td><input type="password" id="password" name="password"></td>
			    	</tr>
			    	<tr>
				    	<td colspan="2" align="center">
				    		<input type="submit" id="submit" value="登录" >
				    	</td>
			    	</tr>
			    </table>
	    	</form>
   		</div>
   	</div>
  </body>
</html>
