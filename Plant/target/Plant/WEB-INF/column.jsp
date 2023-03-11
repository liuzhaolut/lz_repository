<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/21
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script type="text/javascript">
    function update(x,id) {
        var tr=x.parentElement.parentElement.parentElement;
        var tds=tr.children;
        tds[1].remove()
        var input =document.createElement("input")
        tr.insertBefore(input,tds[1])
        input.onblur=function(){
            tds[1].remove()
            var td=document.createElement("td")
            td.innerHTML=this.value;
            tr.insertBefore(td,tds[1])
            var name = this.value;
            $.ajax({
                type:"POST",
                url:"updateRoleServlet.do",
                data:"name=" + name + "&rid=" + id,
                success:function(msg) {
                    if (msg == "1") {
                        alert("修改成功");
                    }else if (msg == "0") {
                        alert("修改失败");
                    } else {
                        alert("网络异常");
                    }
                }
            });
        }
    }
</script>
</head>
<div>

<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
        <table class="table table-hover text-center">
            <tr>
                <th width="10%">角色ID</th>
                <th>角色名称</th>
                <th width="250">操作</th>
            </tr>
            <form id="roleform">
                <c:forEach var="r" items="${roles}">
                    <tr>
                        <td>${r.role_id}</td>
                        <td >${r.role_name}</td>
                        <td>
                            <div class="button-group">
                                <a type="submit" class="button border-main" onclick="update(this,${r.role_id})">
                                    <span class="icon-edit"></span>
                                    修改
                                </a>
                                <a class="button border-red" href="deleteRoleServlet.do?rid=${r.role_id}" onclick="return del(17)">
                                <span class="icon-trash-o">
                                </span>
                                    删除
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </form>
        </table>
    </div>
    <script>
        function del(id){
            if(confirm("您确定要删除吗?")){

            }
        }
    </script>
    <div class="panel admin-panel margin-top">
        <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
        <div class="body-content">
            <form method="post" class="form-x" action="addRoleServlet.do">
                <input type="hidden" name="id"  value="" />
                <div class="form-group">
                    <div class="label">
                        <label>角色名称：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w50" name="rname" value="" data-validate="required:请输入名称" />
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label></label>
                    </div>
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit" style="margin-left: 95px;margin-top: 20px"> 提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
