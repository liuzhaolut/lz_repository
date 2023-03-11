<%@ page import="java.util.List" %>
<%@ page import="com.etc.plant.entity.User" %>
<%@ page import="com.etc.plant.entity.Message" %>
<%@ page import="com.etc.plant.entity.Comment" %>
<%@ page import="com.etc.plant.entity.Plants" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/21
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<form method="post" action="">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder">评论管理</strong></div>
        <div class="padding border-bottom">
            <ul class="search">
                <li>
                    <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="120">评论ID</th>
                <th>用户ID</th>
                <th>用户名称</th>
                <th>商品ID</th>
                <th>商品名称</th>
                <th width="25%">评论内容</th>
                <th>评论星级</th>
                <th>操作</th>
            </tr>
            <%
                List<Comment> comments = (List<Comment>) session.getAttribute("comments");
                List<User> users = (List<User>) session.getAttribute("u1");
                List<Plants> plants = (List<Plants>) session.getAttribute("p1");
                for (int i = 0; i < comments.size(); i++) {
                    Comment comment = comments.get(i);
                    User user = users.get(i);
                    Plants plants1 = plants.get(i);
            %>
            <tr>
                <td><input type="checkbox" name="id[]" value="1" />
                   <%=comment.getComment_id()%></td>
                <td><%=user.getUser_id()%></td>
                <td><%=user.getUser_name()%></td>
                <td><%=plants1.getPlant_id()%></td>
                <td><%=plants1.getPlant_name()%></td>
                <td><%=comment.getComment()%></td>
                <td><%=comment.getComment_pic()%></td>
                <td>
                    <div class="button-group">
                        <a class="button border-red" href="deleteCommentServlet.do?cid=<%=comment.getComment_id()%>">
                            <span class="icon-trash-o"></span>
                            删除
                        </a>
                    </div>
                </td>
            </tr>
            <%
                }
            %>
            <tr>
                <td colspan="8">
                    <div class="pagelist">
                        <a href="">上一页</a>
                        <span class="current">1</span>
                        <a href="">2</a>
                        <a href="">3</a>
                        <a href="">下一页</a>
                        <a href="">尾页</a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript">

    function del(id){
        if(confirm("您确定要删除吗?")){

        }
    }

    $("#checkall").click(function(){
        $("input[name='id[]']").each(function(){
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    function DelSelect(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var t=confirm("您确认要删除选中的内容吗？");
            if (t==false) return false;
        }
        else{
            alert("请选择您要删除的内容!");
            return false;
        }
    }

</script>
</body>
</html>
