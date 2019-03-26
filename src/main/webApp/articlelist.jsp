<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {

        $('.ltt').datagrid({
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            url:'${pageContext.request.contextPath}/article/selectAllArticle.do',
            columns:[[
                {field:'articleTitle',title:'标题',width:80},
                {field:'articleContent',title:'内容',width:80}
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