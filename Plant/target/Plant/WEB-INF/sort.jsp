<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/22
  Time: 9:06
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
    <script type="text/javascript">
        function updateState(x) {
            var tr=x.parentElement.parentElement.parentElement;
            var tds=tr.children;
            tds[7].remove()
            var input =document.createElement("input")
            tr.insertBefore(input,tds[7])
            input.onblur=function(){
                tds[7].remove()
                var td=document.createElement("td")
                td.innerHTML=this.value;
                tr.insertBefore(td,tds[7])
                var state = this.value;
                var id = document.getElementById("pid").innerHTML;
                id = id.trim();
                $.ajax({
                    type:"POST",
                    url:"updatePlantStateServlet.do",
                    data:"state=" + state + "&pid=" + id,
                    success:function(msg) {
                        if (msg == "1") {
                            if (state == 1){
                                alert("上架成功");
                            } else if (state == 0){
                                alert("下架成功");
                            }
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
<body>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong>
            <a href="" style="float:right; display:none;">添加字段</a>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th>选择</th>
                <th width="100" style="text-align:left; padding-left:20px;">商品ID</th>
                <th>图片</th>
                <th>名称</th>
                <th>分类名称</th>
                <th>商品数量</th>
                <th>价格</th>
                <th width="10%">状态</th>
                <th width="310">操作</th>
            </tr>
            <volist name="list" id="vo">
                <c:forEach items="${sortPl}" var="pw">
                    <tr>
                        <td>
                            <input type="checkbox" name="id[]" value="${pw.plant_id}" />
                        </td>
                        <td style="text-align:left; padding-left:20px;" id="pid" name="id">
                            ${pw.plant_id}
                        </td>
                        <td width="10%">
                            <img src="${pw.pic}" alt="" width="70" height="50" />
                        </td>
                        <td>${pw.plant_name}</td>
                        <td>${pw.sign}</td>
                        <td>${pw.count}</td>
                        <td name="price">${pw.price}</td>
                        <td>${pw.state}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main" onclick="updateState(this)">
                                    <span class="icon-edit"></span> 修改
                                </a>
                                <a class="button border-red" href="deletePlantServlet.do?pid=${pw.plant_id}" onclick="return del()">
                                    <span class="icon-trash-o"></span> 删除
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td style="text-align:left; padding:19px 0;padding-left:20px;"><input type="checkbox" id="checkall"/>
                        全选 </td>
                    <td colspan="7" style="text-align:left;padding-left:20px;">
                        <a href="javascript:void(0)" class="button border-red icon-trash-o" style="padding:5px 15px;" onclick="DelSelect()"> 删除</a>
                        <a  style="padding:5px 15px; margin:0 10px;" class="button border-blue icon-edit" onclick="sorts()"> 排序 </a>
                            <select name="sort" style="padding:5px 15px; border:1px solid #ddd;">
                                <option value="price">价格</option>
                                <option value="state">状态</option>
                                <option value="count">数量</option>
                            </select>

                        &nbsp;&nbsp;&nbsp;&nbsp;
                        移动到：
                        <select name="movecid" style="padding:5px 15px; border:1px solid #ddd;" onchange="changecate(this)">
                            <option value="">请选择分类</option>
                            <option value="">最受好评</option>
                            <option value="">畅销</option>
                            <option value="">新品</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="8">
                        <div class="pagelist">
                            <a href="">上一页</a>
                            <span class="current">1</span>
                            <a href="">2</a><a href="">3</a>
                            <a href="">下一页</a>
                            <a href="">尾页</a>
                        </div>
                    </td>
                </tr>
        </table>
    </div>
</form>
<script type="text/javascript">

    //搜索
    function changesearch(){

    }

    //单个删除
    function del(){
        if(confirm("您确定要删除吗?")){

        }
    }

    //全选
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

    //批量删除
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
            $("#listform").submit();
        }
        else{
            alert("请选择您要删除的内容!");
            return false;
        }
    }

    //批量排序
    function sorts(){
        var listform = document.getElementById("listform");
        listform.action = "sortServlet.do";
        listform.method = "post";
        listform.submit();
    }


    //批量移动
    function changecate(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");
            return false;
        }
    }


</script>
</body>
</html>
