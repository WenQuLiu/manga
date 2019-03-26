<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>my manga kingdom</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/IconExtension.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/datagrid-detailview.js"></script>
	<script type="text/javascript" src="js/wangEditor.min.js"></script>
	<script type="text/javascript" src="js/echarts.js"></script>
	<script type="text/javascript" src="js/echarts-gl.min.js"></script>
	<script type="text/javascript" src="js/china.js"></script>
	<script type="text/javascript" src="js/vintage.js"></script>
	<script type="text/javascript">
	var username = "<shiro:user><shiro:principal/></shiro:user>";
    $.post("${pageContext.request.contextPath}/admin/rmname.do","adminName="+username);
	function addTab(menuName,menuUrl,menuIcon){
	    var b = $("#tt").tabs("exists",menuName);
	    if(b){
			$("#tt").tabs("select",menuName);
		}else{
	        $("#tt").tabs("add",{
	            title:menuName,
                iconCls:menuIcon,
				closable:true,
                href:"${pageContext.request.contextPath}/"+menuUrl
			});
		}
	}
	$(function(){
        $.ajax({
			url:"${pageContext.request.contextPath}/menu/show.do",
			dataType:"json",
			success:function(res){
			    $.each(res,function(index,obj){
			        var content = "";
			        $.each(obj.menus,function (index1,obj1) {
                        content += "<p style=\"text-align: center\"><a class=\"easyui-linkbutton\" data-options=\"iconCls:'"+obj1.menuIcon+"',plain:true\" onclick=\"addTab('"+obj1.menuName+"','"+obj1.menuUrl+"','"+obj1.menuIcon+"')\">"+obj1.menuName+"</a></p>"
                    })

                    $("#aa").accordion('add',{
                        title:obj.menuName,
						iconCls:obj.menuIcon,
						content:content,
                    });
				});
            }
		});

	});
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  peru">
    	<div style="font-size: 24px;color:black;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >my manga kingdom</div>
    	<shiro:user><div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎光临:<shiro:principal/> &nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/logout.do" class="easyui-linkbutton" data-options="iconCls:'icon-01'">离开</a></div></shiro:user>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: peru">
    	<div style="text-align: center;font-size:15px; color: black;font-family: 楷体" >&copy;我的动漫王国</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;">
			</div>
		</div>  
    </div>   
</body> 
</html>