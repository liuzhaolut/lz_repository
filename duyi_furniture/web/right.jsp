<%@ page import="com.dy.bean.User" %>
<%@ page import="com.dy.serviceimpl.SqlCartsService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dy.bean.Carts" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/11/2
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="gotop"><a href="cart.jsp">
    <dl class="goCart">
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
        <%
            User user = (User) session.getAttribute("user");
            if (user != null){
                SqlCartsService service = new SqlCartsService();
                List<Carts> data = service.findByUserId(user.getId());
                int num = 0;
                for (Carts c:data
                     ) {
                    num += c.getCartNum();
                }
        %>
              <span><%=num%></span>

        <%
            }else {
                if (session.getAttribute("cartsCount") != null){
        %>

                 <span>${cartsCount}</span>

        <%
              }
            }
        %>

    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.jsp">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>18516955565</p></div>
<!-------------------login--------------------------><!--footer-->
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
        本网站数据用作学习交流使用， 如有侵权 ，请联系</p>
</div>

