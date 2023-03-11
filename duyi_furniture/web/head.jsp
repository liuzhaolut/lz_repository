<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/27
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.dy.bean.GoodClass" %>
<%@ page import="com.dy.util.DataUtil" %>
<%@ page import="com.dy.service.GoodsClassService" %>
<%@ page import="com.dy.serviceimpl.GoodsClassServiceImpl" %>
<%@ page import="com.dy.bean.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.jsp"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1">
                <p class="fl">
                    <%
                        User user = (User) session.getAttribute("user");
                        if (user == null){
                    %>
                        <a href="login.jsp" id="login">登录</a>
                        <a href="reg.jsp" id="reg">注册</a>
                    <%
                        } else {
                    %>
                       <a href="mygxin.jsp" id="login"><%=user.getNickName() == null?user.getUserPhone():user.getNickName()%></a>
                    <%
                        }
                    %>

                </p>
                <form action="flowerDer.jsp" method="get" class="fl">
                    <input type="text" name="goodsName" placeholder="热门搜索：干花花瓶"/>
                    <input type="submit" value=""/>
                    <input type="hidden"name="type" value="3">
                </form>
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                        src="img/ewm.png"/></a><a href="cart.jsp"><img src="img/gwc.png"/></a>
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="index.jsp">首页</a></li>
            <li><a href="flowerDer.jsp?type=0&class1Name=所有商品">所有商品</a>
            </li>
            <%
                //      从缓存中取出所有分类
                List<HashMap<String, Object>> class1 = (List<HashMap<String, Object>>) DataUtil.data.get("class");
                GoodsClassService goodsClassService = new GoodsClassServiceImpl();
                if (class1 == null) {
                    List<GoodClass> data = goodsClassService.findAll();
                    //          创建一个新集合
                    class1 = new ArrayList<>();
                    //          遍历所有分类
                    for (int i = 0; i < data.size(); i++) {
                        GoodClass goodClass = data.get(i);
                        if (goodClass.getParentId() == 0) {
                            //              一级分类取出 goodclass
                            HashMap<String, Object> data2 = new HashMap<>();
                            data2.put("class1", goodClass);
                            //              存储所有二级分类
                            ArrayList<GoodClass> class2 = new ArrayList<>();
                            for (int j = 0; j < data.size(); j++) {
                                if (data.get(j).getParentId() == goodClass.getId()) {
                                    //                  取出属于一级分类的二级分类对象
                                    class2.add(data.get(j));
                                }
                            }
                            //              二级分类集合  存储到map中
                            data2.put("class2", class2);
                            //              Java中的引用传递
                            class1.add(data2);
                        }
                    }
                    DataUtil.data.put("class",class1);
                }
            %>

            <%
                //循环遍历class1
                for (int i = 0; i < class1.size(); i++) {
                    HashMap<String, Object> data = class1.get(i);
//          获取一级分类
                    GoodClass cla1 = (GoodClass) data.get("class1");
//          获取二级分类
                    List<GoodClass> cla2 = (List<GoodClass>) data.get("class2");
            %>
                <li>
                    <a href="flowerDer.jsp?type=1&classId1=<%=cla1.getId()%>&class1Name=<%=cla1.getClassname()%>"><%=cla1.getClassname()%></a>
                    <div class="sList2">
                        <div class="clearfix">
                            <%
                                for(GoodClass goodClass : cla2){
                            %>
                            <a href="flowerDer.jsp?type=2&classId1=<%=cla1.getId()%>&classId2=<%=goodClass.getId()%>&class1Name=<%=cla1.getClassname()%>&class2Name=<%=goodClass.getClassname()%>"><%=goodClass.getClassname()%></a>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </li>
            <%
                }
            %>
        </ul>
    </div>
</div>

