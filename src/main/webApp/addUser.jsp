<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
    });
</script>
<form id="ff" action="/cmfz-admin/admin/insertUser.do" method="post">
    <div style="margin-left: 100px;margin-top: 20px">
        <table>
                <th>
                    用户名:
                </th>
                <td>
                    <input id="username" type="text"  name="name" class="text" value="" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input id="pwd" type="password" name="password" class="text" value="" maxlength="20" autocomplete="off"/>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="submit" class="loginButton" value="添加">
                </td>
            </tr>
        </table>
    </div>

</form>