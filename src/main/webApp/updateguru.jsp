<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
    });
</script>
<form id="guff" method="post" enctype="multipart/form-data">
    <div style="margin-left: 100px;margin-top: 20px">
        <table>
            <tr>
                <td>上师编号：</td>
                <td><input class="easyui-textbox" name="guruId" readonly/></td>
            </tr>
            <tr>
                <td>上师法号：</td>
                <td><input class="easyui-textbox" name="guruName"/></td>
            </tr>
            <tr>
                <td>上师头像：</td>
                <td><input class="easyui-filebox" name="guruPicture"></td>
            </tr>
            <tr>
                <td>上师简介：</td>
                <td><input class="easyui-textbox" name="guruContent"/></td>
            </tr>

        </table>
    </div>
</form>