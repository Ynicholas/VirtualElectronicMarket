<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rigishter.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/register.css">

  </head>
  <!-- 引入jquery包 -->
  <script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript">
  	$(function(){
  		//username 的失去焦点事件
  		$("#username").blur(function(){
  			//1.获得input中的数据
  			var username = $("#username").val();
  			
  			//2.定义正则表达式的变量:邮箱正则
  			var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
  			
  			//3.定义一个标志位
  			var flag = false;
  			var messige = "";
  			if(reg.test(username)){
  				messige = "恭喜，可以正常注册！";
  				//修改标志位
  				flag = true;
  			}else{
  				messige = "输入邮箱不合法";
  			}
  			if(flag){
  					//ajax操作
			  		//.ajax,load,get,post
			  		
			  		//准备传输的数据，JSON数据
			  		var json = {username:$("#username").val()};
			  		$.post("./servlet/UserAjaxServlet",json,function(data,textStatus){
			  			if(data=="true"){
			  				$("#user_reg").text("可以正常注册").css('color','#2a00ff').css('font','12px 宋体');
			  			}else{
			  				$("#user_reg").text("用户已经被注册").css('color','red').css('font','12px 宋体');
			  			}
			  		
			  		});
  		
  			}else{
  				$("#user_reg").text(messige).css('color','red').css('font','12px 宋体');
  			}

  			
  		});
  		

  		
  		$("#password").blur(function(){
  			//1.获得input中的数据
  			var password = $("#password").val();
  			
  			//2.定义正则表达式的变量:邮箱正则
  			var reg1 = /^[a-zA-Z]\w{5,17}$/;
  			
  			//3.定义一个标志位
  			var flag = false;
  			var messige = "";
  			if(reg1.test(password)){
  				messige = "密码符合要求";
  				//修改标志位
  				flag = true;
  			}else{
  				messige = "密码不符合要求,以字母开头，长度在6~18之间，只能包含字母、数字和下划线";
  			}
  			if(flag){
  				$("#pass_reg").text(messige).css('color','#2a00ff').css('font','12px 宋体');
  			}else{
  				$("#pass_reg").text(messige).css('color','red').css('font','12px 宋体');
  			}
  		});
  		
  		$("#password1").blur(function(){
  			var password = $("#password").val();
  			var password1 = $("#password1").val();
  			if(password != password1){
  				$("#pw").text("两次密码不一致!").css('color','red').css('font','12px 宋体');
  			}else{
  				$("#pw").text("两次密码一致!").css('color','#2a00ff').css('font','12px 宋体');
  			}
  		});
  	});
  </script>
  <jsp:include page="public_head.jsp" flush="true"></jsp:include>
  <body>
    <div id="text1">
    	个人用户信息
    </div>
    <div id="form1">
	   	 <form action="./servlet/UserServlet" method="post">
		   	 <table align="center">
			   	 <tr>
			    	<td align="center">*账号：</td>
			    	<td><input type="text" id="username" name="username"></td>
			    	<td id="user_reg"></td>
			    </tr>
		    	<tr>
		    		<td align="center">*密码：</td>
		    		<td><input type="password" id="password" name="password"></td>
		    		<td id="pass_reg"></td>
		    	</tr>
		    	<tr>
			    	<td align="center">*确认密码：</td>
			    	<td><input type="password" id="password1" name="password1"></td>
			    	<td id="pw"></td>
		    	</tr>
		    	<tr>
			    	<td colspan="2" align="center">
			    		<input type="submit" id="submit" value="我同意，并注册" >
			    	</td>
		    	</tr>
		    </table>
	    </form>
    </div>
   
  </body>
 
</html>
