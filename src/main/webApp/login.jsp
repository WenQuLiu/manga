<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="java.net.URLEncoder" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>我家大门</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="css/login.css" type="text/css"></link>
	<script type="text/javascript" src="script/jquery.js"></script>
	<script type="text/javascript" src="script/common.js"></script>
	<script type="text/javascript">
        $(function(){
            //点击更换验证码：
            $("#captchaImage").click(function(){//点击更换验证码
                var img = document.getElementById("captchaImage");
                img.src="${pageContext.request.contextPath}/admin/getVcode.do?rnd="+Math.random();
            });
            //  form 表单提交
            /*$("#loginForm").bind("submit",function(){
                var id = $(".text").val();
                var password = $("#pwd").val();
                //location.href = "/cmfz-admin/admin/login.do?adminId="+id+"&adminPassword="+password;
                return false;
            });*/
        });
		/*function run() {
			var str = "\${cookie.name.value}";
			var name = decodeURI(str);
			document.getElementById("username").value=name;
        }*/
	</script>
</head>
<body onload="run()">
	
		<div class="login">
			<form id="loginForm" action="/cmfz-admin/admin/login.do" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="img/xiaocao.jpg" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input id="username" type="text"  name="adminName" class="text" value="" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input id="pwd" type="password" name="adminPassword" class="text" value="" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="/cmfz-admin/admin/getVcode.do" title="点击更换验证码"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td>
							<label>
								<input type="checkbox" id="isRememberUsername" value="true" name="checkbox"/> 记住用户名
							</label>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">我家</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>