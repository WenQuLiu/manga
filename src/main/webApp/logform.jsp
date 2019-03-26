<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {

        $('.ltt').datagrid({
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            url:'${pageContext.request.contextPath}/log/showAll.do',
            columns:[[
                {field:'logId',title:'编号标识',width:80},
                {field:'logUser',title:'操作人',width:80,sortable:true},
                {field:'logTime',title:'操作时间',width:80,sortable:true},
                {field:'logSource',title:'操作对象',width:80,sortable:true},
                {field:'logAction',title:'操作详情',width:80,sortable:true},
                {field:'logResult',title:'操作结果',width:80},
                {field:'logMessage',title:'操作数据',width:80}
            ]],
            pagination : true,
            pageList : [ 5, 8, 10, 15, 20 ],
            pageSize : 5,
            fit:true,
            fitColumns: true,
            singleSelect:true
        });
    });
</script>
<div class="ltt">

</div>