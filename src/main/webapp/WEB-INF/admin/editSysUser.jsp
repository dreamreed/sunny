<%--
  Created by IntelliJ IDEA.
  User: chenhao
  Date: 2016/9/21 0021
  Time: 下午 3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/includes/taglibs.jsp"%>
<html>
<head>

    <title>Title</title>
    <script src="/statics/js/jquery-1.7.1.js" type="text/javascript"></script>
    <script>
        function  saveOrUpdateSysUser(){
            $("#sysUserForm").submit();
        }
    </script>
</head>
<body>
   <form id="sysUserForm" action="/sysUser/saveOrUpdate.do" method="post">
       <input value="${sysUser.id}" type="hidden" name="id"><br/>
       用户名:<input value="${sysUser.account}" type="text" name="account"><br/>
       密码:<input value="${sysUser.password}" type="password" name="password"><br/>
       姓名:<input value="${sysUser.name}" type="text" name="name"><br/>
       是否可用： <input id="enable_0" type="radio" name="enable" value="0" <c:if test="${sysUser.enable==0}">checked="checked" </c:if>>

       <label for="enable_0">否</label>
       <input id="enable_1" type="radio" name="enable" value="1"  <c:if test="${sysUser.enable==1 || sysUser.enable==null}"> checked="checked"</c:if>>
       <label for="enable_1">是</label>
       <div >
           <a  href="javascript:saveOrUpdateSysUser();">保存</a>
       </div>
   </form>
</body>
</html>
