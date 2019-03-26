<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {

        $('.gtt').datagrid({
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            url:'${pageContext.request.contextPath}/guru/find.do',
            columns:[[
                {field:'guruId',title:'类别编号',width:80},
                {field:'guruName',title:'类别名称',width:80,sortable:true},
                {field:'guruPhoto',title:'类别图像',width:80,align:'right',sortable:true},
                {field:'guruContent',title:'简介',width:80,align:'right',sortable:true}
            ]],
            pagination : true,
            pageList : [ 5, 8, 10, 15, 20 ],
            pageSize : 5,
            toolbar : "#gtb1",
            fit:true,
            fitColumns: true,
            singleSelect:true,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="http://localhost:8080/cmfz-admin/upload/' + rowData.guruId + '.jpg" style="height:200px;"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            }
        });

        $("#exporeExcel").linkbutton({
            text:"批量导出",
            plain:true,
            iconCls : "icon-save",
            onClick:function () {
                window.location.href="${pageContext.request.contextPath}/guru/explore.do"
            }
        });

        $("#gbtn1").linkbutton({
            text : "新增上师",
            plain:true,
            iconCls : "icon-add",
            onClick: function(){
                $(".gtt1").dialog({
            width:500,
            height:300,
            title:"新增上师",
            iconCls : "icon-add",
            href:"${pageContext.request.contextPath}/addguru.jsp",
            modal:true,
            shadow:true,
            buttons:[{
                iconCls:"icon-save",
                text:"保存",
                handler:function(){
                    $("#gff").form("submit",{
                        url:"${pageContext.request.contextPath }/guru/add.do",
                        success:function(res){
                            if(res=='success'){
                                $(".gtt").datagrid('reload')
                            }
                        }
                    });
                    $(".gtt1").dialog("close");
                }
            },{
                iconCls:"icon-cancel",
                text:"取消",
                handler:function(){
                    $(".gtt1").dialog("close");
                }
            }]
        });
    }
        });

        $("#gsearch").linkbutton({
            text:"批量插入",
            plain:true,
            iconCls:"icon-add",
            onClick: function(){
                $(".gtt1").dialog({
                    width:500,
                    height:300,
                    title:"批量插入",
                    iconCls : "icon-add",
                    href:"${pageContext.request.contextPath}/addmoreguru.jsp",
                    modal:true,
                    shadow:true,
                    buttons:[{
                        iconCls:"icon-save",
                        text:"保存",
                        handler:function(){
                            $("#gmff").form("submit",{
                                url:"${pageContext.request.contextPath }/guru/addmore.do",
                                success:function(res){
                                    if(res=='success'){
                                        $(".gtt").datagrid('reload')
                                    }
                                }
                            });
                            $(".gtt1").dialog("close");
                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            $(".gtt1").dialog("close");
                        }
                    }]
                });
            }
        });

        $("#gupdate").linkbutton({
            text: "修改上师信息",
            plain:true,
            iconCls:"icon-reload",
            onClick: function(){
                var rowData = $(".gtt").datagrid('getSelected');
                console.log(rowData);
                $(".gtt1").dialog({
                    width:500,
                    height:300,
                    title:"修改上师信息",
                    iconCls:"icon-reload",
                    href:"${pageContext.request.contextPath }/updateguru.jsp",
                    modal:true,
                    shadow:true,
                    buttons:[{
                        iconCls:"icon-save",
                        text:"保存",
                        handler:function(){
                            $("#guff").form('submit',{
                                url:'${pageContext.request.contextPath }/guru/update.do',
                                success:function(res){
                                    if(res=='success'){
                                        $(".gtt").datagrid('reload')
                                    }
                                }
                            });
                            $(".gtt1").dialog("close");
                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            $(".gtt1").dialog("close");
                        }
                    }],
                    onLoad:function(){
                        $("#guff").form("load",rowData);
                    }

                });
            }
        });

    });
    function qq(value, name) {
        $(".gtt").datagrid('load',{
            value:value,
            name:name
        });
        $(".gtt").datagrid({
            url:"${pageContext.request.contextPath}/guru/findproperty.do"
        });
    }
</script>
<div class="gtt">

</div>