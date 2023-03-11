<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/22
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="panel admin-panel">
    <div class="panel-head" id="add">
        <strong>
            <span class="icon-pencil-square-o"></span>
            增加内容
        </strong>
    </div>
    <div class="body-content">
        <form method="post" class="form-x" action="addPlantServlet.do" enctype="multipart/form-data">
            <div class="form-group">
                <div class="label">
                    <label>商品名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="pname" data-validate="required:请输入商品名称" />
                    <div class="tips"></div>
                </div>
            </div>
            <script type="text/javascript">
                $(document).ready(function(){
                    $('#image1').click(function(){
                        $('#url1').click();
                    });
                });
            </script>
            <div class="form-group">
                <div class="label">
                    <label>图片：</label>
                </div>
                <div class="field">
                    <input type="file" id="url1" name="pic" class="input tips" style="width:25%; float:left;display: none"  value=""  data-toggle="hover" data-place="right" data-image="" />
                    <input type="button" class="button bg-blue margin-left" id="image1" value="+ 浏览上传"  style="float:left;">
                    <div class="tipss">图片尺寸：500*500</div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>商品类别：</label>
                </div>
                <div class="field">
                    <select class="input w50" name="sign">
                        <option value="">请选择分类</option>
                        <option value="最受好评">最受好评</option>
                        <option value="畅销">畅销</option>
                        <option value="新品">新品</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>数量：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="pcoun" data-validate="required:请输入商品数量" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>价格：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="pprice" data-validate="required:请输入商品价格" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>商品简介：</label>
                </div>
                <div class="field">
                    <textarea name="content" class="input" style="height:300px; border:1px solid #ddd;width: 450px"></textarea>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
