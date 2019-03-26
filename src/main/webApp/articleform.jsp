<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor')
    var $text1 = $("#arti")
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload.do';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files';
    editor.customConfig.onchange = function (html){
        $text1.val(html)
    }
    //console.info(editor.txt.html())
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.create()
    //初始化textarea的值
    //$text1.val(editor.txt.html)
    $(function() {
        $(document).ready(function () {
            $(".author").combobox('reload',"${pageContext.request.contextPath}/article/all.do");
        })

        $(".author").combobox({
            prompt: '选择作者',
            valueField : 'guruId',
            textField : 'guruName'
        });

        $("#inputarticle").linkbutton({
            text : "创建文章",
            onClick:function () {
                $("#aff").form('submit',{
                    url:"${pageContext.request.contextPath }/article/add.do",
                    success:function(res){
                        if(res=='success'){
                            $("#aff").form('reset')
                            editor.txt.html("")
                        }
                    }
                });
            }
        });

        $("#resetarticle").linkbutton({
            text : "重置内容",
            onClick:function () {
                $("#aff").form('reset')
                editor.txt.html("")
            }
        });
    });
</script>
<form id="aff" method="post">
<table style="padding-left: 50px">
    <div>
        <label for="articleTitle">文章标题:</label>
        <input class="easyui-textbox" style="width:150px" name="articleTitle">
    </div>
    <p></p>
    <div>
        <label for="articleTitle">文章类别:</label>
        <input class="author" name="guruI">
    </div>
    <p></p>
    <div>
        <label for="articleFlag">文章状态:</label>
        <input class="easyui-switchbutton" style="width:80px" name="articleFlag" data-options="onText:'上架',offText:'下架'">
    </div>
    <p></p>
    <div>
        <label for="articleContent">文章内容:</label>
    </div>
    <p></p>
    <div>
            <input type="hidden" name="articleContent" id="arti"/>
            <div id="editor">
                <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
            </div>
    </div>
    <p></p>
    <div>
            <a id="inputarticle"></a>&nbsp;&nbsp;
            <a id="resetarticle"></a>
    </div>
</table>
</form>



