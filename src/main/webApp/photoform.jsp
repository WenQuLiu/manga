<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<script type="text/javascript">
    $(function() {
        $('.tt').datagrid({
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            url:'${pageContext.request.contextPath}/slides/find.do',
            columns:[[
                {field:'slidesshowId',title:'编号标识',width:80},
                {field:'slidesshowPosition',title:'文件名',width:80,sortable:true},
                {field:'slidesshowDescribe',title:'描述信息',width:80,align:'right',sortable:true},
                {field:'slidesshowFlag',title:'轮播图状态',width:80,align:'right',sortable:true,
                    /*formatter: function(value,row,index){
                        if (row.slidesshowFlag=="展示"){
                            return "<a style='color: red'>"+value+"</a>";
                        } else {
                            return value;
                        }
                    }*/
                    styler: function(value,row,index){
                        if (row.slidesshowFlag=="展示"){
                            return 'background-color:#ffee00;color:red;';
                        }
                    }
                },
                {field:'slidesshowUploadtime',title:'轮播图创建时间',width:80,sortable:true}
            ]],

            pagination : true,
            pageList : [ 5, 8, 10, 15, 20 ],
            pageSize : 5,
            toolbar : "#tb1",
            fit:true,
            fitColumns: true,
            singleSelect:true,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="http://192.168.179.129:8888//' + rowData.slidesshowPosition + '" style="height:200px;"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            }
        });
        <shiro:hasRole name="root">
        $("#btn1").linkbutton({
            text : "新增轮播图",
            plain:true,
            iconCls : "icon-add",
            onClick: function(){
                $(".tt1").dialog({
                    width:500,
                    height:300,
                    title:"新增轮播图",
                    iconCls : "icon-add",
                    href:"${pageContext.request.contextPath}/addphoto.jsp",
                    modal:true,
                    shadow:true,
                    buttons:[{
                        iconCls:"icon-save",
                        text:"保存",
                        handler:function(){
                            $("#ff").form("submit",{
                                url:"${pageContext.request.contextPath }/slides/add.do",
                                success:function(res){
                                    if(res=='success'){
                                        $(".tt").datagrid('reload')
                                        //location.href="\${pageContext.request.contextPath}/main.jsp";
                                    }
                                }
                            });
                            $(".tt1").dialog("close");
                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            $(".tt1").dialog("close");
                        }
                    }]
                });
            }
        });
        </shiro:hasRole>
        $("#help").linkbutton({
            text:"帮助",
            plain:true,
            iconCls:"icon-help",
            onClick: function () {

            }
        });
        <shiro:hasRole name="root">
        $("#update").linkbutton({
            text: "修改轮播图",
            plain:true,
            iconCls:"icon-reload",
            onClick: function(){
                var rowData = $(".tt").datagrid('getSelected');
                console.log(rowData);
                $(".tt1").dialog({
                    width:500,
                    height:300,
                    title:"修改轮播图",
                    iconCls:"icon-reload",
                    href:"${pageContext.request.contextPath }/updatephoto.jsp",
                    modal:true,
                    shadow:true,
                    buttons:[{
                        iconCls:"icon-save",
                        text:"保存",
                        handler:function(){
                            $("#uff").form('submit',{
                                url:'${pageContext.request.contextPath }/slides/update.do',
                                success:function(res){
                                    if(res=='success'){
                                        $(".tt").datagrid('reload')
                                        //location.href="\${pageContext.request.contextPath}/main.jsp";
                                    }
                                }
                            });
                            $(".tt1").dialog("close");
                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            $(".tt1").dialog("close");
                        }
                    }],
                    onLoad:function(){
                        $("#uff").form("load",rowData);
                    }

                });
            }
        });
        </shiro:hasRole>
    });
</script>
<div class="tt">
    <table class="tt1"></table>
    <div id="tb1" style="display: none">
        <a id="btn1"></a>
        <a id="update"></a>
        <a id="help"></a>
    </div>
</div>