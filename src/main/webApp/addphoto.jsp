<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
    });
</script>
<form id="ff" method="post" enctype="multipart/form-data">
    <div style="margin-left: 100px;margin-top: 20px">
        <table>
            <tr>
                <td>轮播图描述：</td>
                <td><input class="easyui-textbox" name="slidesshowDescribe"/></td>
            </tr>
            <tr>
                <td>轮播图状态：</td>
                <td>
                    <select class="easyui-combobox" data-options="width:100" name="slidesshowFlag">
                        <option>不展示</option>
                        <option>展示</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>上传轮播图：</td>
                <td><input class="easyui-filebox" name="slidesshowPosition"></td>
            </tr>
        </table>
    </div>
</form>