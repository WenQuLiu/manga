<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
    });
</script>
<form id="gff" method="post" enctype="multipart/form-data">
    <div style="margin-left: 100px;margin-top: 20px">
        <table>
            <tr>
                <td>上师法名：</td>
                <td><input class="easyui-textbox" name="guruName"/></td>
            </tr>
            <tr>
                <td>上师照片：</td>
                <td><input class="easyui-filebox" name="guruPhoto"></td>
            </tr>
            <tr>
                <td>上师简介：</td>
                <td><input class="easyui-textbox" name="guruContent"/></td>
            </tr>
        </table>
    </div>
</form>