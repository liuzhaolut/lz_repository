<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/11/10
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>ok</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body><!----------------------------------------order------------------>
<jsp:include page="head.jsp"/>
<div class="order mt cart">
    <div class="site"><p class="wrapper clearfix"><span class="fl">支付成功</span>
        <img class="top" src="img/temp/cartTop03.png"></p>
    </div>
    <p class="ok">支付成功！剩余<span>5</span>秒<a href="myorderq.jsp">返回订单页</a></p></div>
<div class="like"><h4>猜你喜欢</h4>
    <div class="bottom">
        <div class="hd"><span class="prev"><img src="img/temp/prev.png"></span><span class="next"><img
                src="img/temp/next.png"></span></div>
        <div class="imgCon wrapper bd">
            <div class="likeList clearfix">
                <div><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like01.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like02.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like03.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like04.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp" class="last">
                    <dl>
                        <dt><img src="img/temp/like05.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a></div>
                <div><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like01.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like02.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like03.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like04.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp" class="last">
                    <dl>
                        <dt><img src="img/temp/like05.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a></div>
            </div>
        </div>
    </div>
</div><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">渡一家居&copy;为您的家庭增添一抹温馨<br/>
        本网站所列数据仅作为学生作品展示 ， 学生作品如有侵权，请联系：18516955565</p></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    autoPlay: false,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});</script>
</body>
</html>

