<%@ page import="java.util.List" %>

<%@ page import="com.dy.bean.*" %>

<%@ page import="com.dy.serviceimpl.*" %>

<%@ page import="com.dy.service.*" %><%--

  Created by IntelliJ IDEA.

  User: DELL

  Date: 2020/11/5

  Time: 19:13

  To change this template use File | Settings | File Templates.

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>

<html>

<head lang="en">

    <meta charset="utf-8"/>

    <title>order</title>

    <link rel="stylesheet" type="text/css" href="css/public.css"/>

    <link rel="stylesheet" type="text/css" href="css/proList.css"/>

    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>


</head>

<body><!----------------------------------------order------------------>

<%@include file="head.jsp"%>

<%


//    城市数据

    RegionService service = new RegionServiceImpl();

    List<CnRegion> citys = service.findByLevel(1);

//    地址数据

    AddressService addressService = new AddressServiceImpl();

    List<Address> addresses = addressService.findByUserId(user.getId());

//    商品数据

    FindGoodsService findGoodsService = new FindGoodsServiceImpl();

    SqlCartsService sqlCartsService = new SqlCartsService();

    List<Goods> goods = null;

    String goodsId = request.getParameter("id");

    String num = request.getParameter("num");


    List<Carts> cs = null;

    if (goodsId != null) {

//        立即结算

        goods = new ArrayList<>();

        Goods goods1 = findGoodsService.findGoodsById(Integer.parseInt(goodsId));

        goods.add(goods1);

    } else {

//        购物车结算

        cs = sqlCartsService.findByUserId(user.getId());

        if (cs != null && cs.size() != 0) {

            goods = findGoodsService.findGoodsCart(cs);

//            排序

            ArrayList<Goods> gs2 = new ArrayList<>();

            for (int i = 0; i < cs.size(); i++) {

                Carts c = cs.get(i);

                for (int j = 0; j < goods.size(); j++) {

                    if (c.getGoodsId() == goods.get(j).getId()){

                        gs2.add(goods.get(j));

                        break;

                    }

                }

            }

            goods = gs2;

        }

    }


//    付款方式

    PaymentsService p = new PaymentsServiceImpl();

    List<Payments> payments = p.findAll();


//    快递方式

    TransportsService transportsService = new TransportsServiceImpl();

    List<Transports> transports = transportsService.findAll();


%>

<div class="order cart mt">

    <!-----------------site------------------->

    <div class="site">

        <p class="wrapper clearfix">

            <span class="fl">订单确认</span>

            <img class="top" src="img/temp/cartTop02.png">

        </p>

    </div>

    <!-----------------orderCon------------------->

    <div class="orderCon wrapper clearfix">

        <div class="orderL fl">

            <!--------h3---------------->

            <h3>收件信息

                 <a href="javascript:addressShow(1, null)" class="fr">新增地址</a>

            </h3>

            <div class="addres clearfix" id="addressList">

            <!--------addres---------------->

            <%

                if (addresses.size() == 0){

            %>

            <div id="addressNull" style="height: 100px;line-height: 100px;text-align: center;font-size: 32px">

                暂无收货地址，请先添加地址

            </div>

            <%

                } else {

                for (int i = 0; i < addresses.size(); i++) {

                    String provinceName = service.findByCode(addresses.get(i).getProvinceId() + "").getName();

                    String cityName = service.findByCode(addresses.get(i).getCityId() + "").getName();

                    String areaName = service.findByCode(addresses.get(i).getAreaId() + "").getName();

                    String streetName = service.findByCode(addresses.get(i).getStreetId() + "").getName();

                    if (i == 0){

                        Address address = addresses.get(i);

            %>

                        <div onclick="addressId=<%=address.getId()%>" class="addre fl on"  id="a<%=address.getId()%>">

                            <div class="tit clearfix">

                                <p class="fl"><%=address.getUserName()%>

                                    <span class="default">[默认地址]</span>

                                </p>

                                <p class="fr">

                                    <a href="javascript:deleAddress(<%=address.getId()%>)">删除</a><span>|</span>

                                    <a href="javascript:updateAddress('<%=address.getId()%>','<%=address.getUserName()%>','<%=address.getUserPhone()%>','<%=address.getProvinceId()%>','<%=address.getCityId()%>','<%=address.getAreaId()%>','<%=address.getStreetId()%>','<%=address.getUserAddress()%>')" class="edit">编辑</a>

                                </p>

                            </div>

                            <div class="addCon">

                                <p><%=provinceName%>&nbsp;<%=cityName%>&nbsp;<%=areaName%>&nbsp;<%=streetName%></p>

                                <p><%=address.getUserPhone()%></p>

                            </div>

                        </div>

            <%

                    } else {

                        Address address = addresses.get(i);

            %>

                        <div onclick="addressId=<%=address.getId()%>" class="addre fl" id="a<%=address.getId()%>">

                            <div class="tit clearfix">

                                <p class="fl">

                                    <%=address.getUserName()%>

                                </p>

                                <p class="fr">

                                    <a href="javascript:setDefault(<%=address.getId()%>)" class="setDefault">设为默认</a><span>|</span>

                                    <a href="javascript:deleAddress(<%=address.getId()%>)">删除</a><span>|</span>

                                    <a href="javascript:updateAddress('<%=address.getId()%>','<%=address.getUserName()%>','<%=address.getUserPhone()%>','<%=address.getProvinceId()%>','<%=address.getCityId()%>','<%=address.getAreaId()%>','<%=address.getStreetId()%>','<%=address.getUserAddress()%>')" class="edit">编辑</a>

                                </p>

                            </div>

                            <div class="addCon"><p><%=provinceName%>&nbsp;<%=cityName%>&nbsp;<%=areaName%>&nbsp;<%=streetName%></p>

                                <p><%=address.getUserPhone()%></p></div>

                        </div>

            <%

                      }

                    }

                }

            %>

            </div>


            <h3>支付方式</h3>

            <!--------way---------------->

            <div class="way clearfix">

                <%

                    for (int i = 0; i < payments.size(); i++) {

                %>

                      <img onclick="payId=<%=payments.get(i).getId()%>" <%=i==0?"class=\"on\"":""%> src="img/<%=payments.get(i).getImg()%>">

                <%

                    }

                %>

            </div>

            <h3>选择快递</h3>

            <!--------dis---------------->

            <div class="dis clearfix">

            <%

                for (int i = 0; i < transports.size(); i++) {

            %>

                <span onclick="trId=<%=transports.get(i).getId()%>" <%=i==0?"class=\"on\"":""%>><%=transports.get(i).getName()%></span>

            <%

                }

            %>

            </div>

        </div>

        <div class="orderR fr">

            <div class="msg">

                <h3>订单内容

                    <a href="cart.jsp" class="fr">返回购物车</a>

                 </h3><!--------ul---------------->

                <%

                    double price = 0;

                    for (int i = 0; i < goods.size(); i++) {

                        Goods g = goods.get(i);

                        int numInt = num != null?Integer.parseInt(num):cs.get(i).getCartNum();

                        price += g.getPrice() * numInt;

                %>

                <ul class="clearfix">

                    <li class="fl"><img style="height: 87px;width: 87px" src="img/small/<%=g.getImg().get(0)%>"></li>

                    <li class="fl"><p><%=g.getName().length()>18?(g.getName().substring(0,15)+"…"):g.getName()%></p>

                        <p>颜色分类：此商品无颜色分类</p>

                        <p>数量：<%=numInt%></p></li>

                    <li class="fr">￥<%=g.getPrice() * numInt%></li>

                </ul>

                <%

                    }

                %>


            </div><!--------tips---------------->

            <div class="tips"><p><span class="fl">商品金额：</span><span class="fr">￥<%=price%></span></p>

                <p><span class="fl">优惠金额：</span><span class="fr">￥0.00</span></p>

                <p><span class="fl">运费：</span><span class="fr">免运费</span></p></div><!--------tips count---------------->

            <div class="count tips"><p><span class="fl">合计：</span><span class="fr">￥<%=price%></span></p></div>

            <!--<input type="button" name="" value="去支付">--> <a href="javascript:buy()" class="pay">下单</a></div>

        <script>


            //  支付方式

            var payId = <%=payments.get(0).getId()%>;

            // 配送方式

            var trId = <%=transports.get(0).getId()%>;

            //  地址

            var addressId = <%=addresses.size()>0?addresses.get(0).getId():null%>;


            var goodsId = <%=request.getParameter("id")%>;

            var goodsNum = <%=request.getParameter("num")%>;


            function buy() {

                if (addressId == null){

                    layer.msg("暂无收获地址，请先新增地址.");

                    return;

                }

                var para = "?addressId=" + addressId + "&payId=" + payId + "&trId=" + trId;

                if (goodsId != null){

                    para += "&goodsId=" + goodsId + "&goodsNum=" + goodsNum;

                }

                window.location.href = "buy.do" + para;

            }

        </script>

    </div>

</div><!--编辑弹框--><!--遮罩-->

<div class="mask"></div>

<div class="adddz editAddre">

    <form action="#" method="get">

        <input type="text" placeholder="姓名" id="userName" class="on"/>

        <input type="text" placeholder="手机号" id="userPhone"/>

        <div class="city dyjjcity">
            <select name="" onchange="selectChange(1, this)">
                <%
                    for (CnRegion r: citys
                         ) {
                %>
                     <option value="<%=r.getCode()%>"><%=r.getName()%></option>
                <%
                    }
                %>
            </select>
            <select onchange="selectChange(2, this)">
                <option value="城市/地区">城市/地区</option>
            </select>
            <select onchange="selectChange(3, this)">
                <option value="区/县">区/县</option>
            </select>
            <select onchange="selectChange(4, this)">
                <option value="配送区域">配送区域</option>
            </select>

        </div>

        <textarea name="" rows="" cols="" id="userAddress" placeholder="详细地址"></textarea>

        <div class="bc">

            <input type="button" onclick="save()" value="保存"/>

            <input type="button" value="取消"/>

        </div>

    </form>

</div><!--返回顶部-->

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>

<script src="js/layer/layer.js" type="text/javascript" charset="utf-8"></script>

<script>

    $(function () {

        selectChange(1, $(".dyjjcity>select:eq(0)").get(0));

    });

    function setDefault(id) {

        layer.load();

        $.get("addressDefault.do","id=" + id, function (data) {

            layer.closeAll();

            layer.msg(data.msg);

            setTimeout(function () {

                window.location.reload();

            }, 750)

        });

    }

    function deleAddress(id){

        layer.load();

        $.get("addressDele.do","id=" + id, function (data) {

            layer.closeAll();

            layer.msg(data.msg);

            $("#a" + id).remove();

        });


    }



    function updateAddress(id, userName, userPhone, code1, code2, code3, code4, userAddress) {

        addressShow(0, id)

        $("#userName").val(userName);

        $("#userPhone").val(userPhone);

        $("#userAddress").val(userAddress);

        //选中了省份

        var $opt = $("option[value='"+ code1 +"']");

        $opt.attr("selected",true);

        selectChange(1,$opt.parent().get(0));


        //设置市的选中

        $opt = $("option[value='"+ code2 +"']");

        $opt.attr("selected",true);

        selectChange(2,$opt.parent().get(0));


        //设置县的选中

        $opt = $("option[value='"+ code3 +"']");

        $opt.attr("selected",true);

        selectChange(3,$opt.parent().get(0));


        //设置街道的选中

        $opt = $("option[value='"+ code4 +"']");

        $opt.attr("selected",true);

        selectChange(4,$opt.parent().get(0));

    }


    var saveFlag = null;

    var updateId = null;

    function addressShow(type, addressId) {

        if (type == 1){

            saveFlag = 1;

            $("#userName").val("");

            $("#userPhone").val("");

            $("#userAddress").val("");

        }else {

            saveFlag = 0;

            updateId = addressId;


        }

        $(".mask,.editAddre").show();

    }


    function save() {

        //获取信息

        var userName = $("#userName").val();
        var userPhone = $("#userPhone").val();
        var userAddress = $("#userAddress").val();
        var code1 = $(".dyjjcity option:selected").get(0).value;
        var code2 = $(".dyjjcity option:selected").get(1).value;
        var code3 = $(".dyjjcity option:selected").get(2).value;
        var code4 = $(".dyjjcity option:selected").get(3).value;
        layer.load();
        if (saveFlag == 1){
            $.get("addressAdd.do",{
                "userName":userName,
                "userPhone":userPhone,
                "code1":code1,
                "code2":code2,
                "code3":code3,
                "code4":code4,
                "userAddress":userAddress,
                "new":$("#addressNull").length
            }, function (data) {
                layer.closeAll();
                layer.msg("新增成功")
                $(".mask, .editAddre").hide();
                var text = null;
                if (data.status == 1){
                    //第一次新增
                    $("#addressNull".remove());
                    addressId = data.data.id;
                    text = "<div onclick=\"addressId=" + data.data.id + "\" class=\"addre fl on\" id=\"a" + data.data.id + "\">\n" +
                        "<div class=\"tit clearfix\"><p class=\"fl\">" + data.data.userName + "<span class=\"default\">[默认地址]</span></p>\n" +
                        "<p class=\"fr\"><a href=\"javascript:deleteAddress("+ data.data.id +")\">删除</a><span>|</span><a href=\"javascript:updateAddress('"+ data.data.id +"','"+ data.data.userName +"','"+ data.data.userPhone +"','"+ code1 +"','"+ code2 +"','"+ code3 +"','"+ code4 +"','"+ data.data.userAddress +"')\" class=\"edit\">编辑</a></p></div>\n" +
                        "\n" +

                        "<div class=\"addCon\"><p>"+$(".dyjjcity option:selected").get(0).innerHTML+"&nbsp;"+$(".dyjjcity option:selected").get(1).innerHTML+"&nbsp;"+$(".dyjjcity option:selected").get(2).innerHTML+"&nbsp;"+$(".dyjjcity option:selected").get(3).innerHTML+"</p>\n" +

                        "<p>"+data.data.userPhone+"</p></div>\n" +

                        "  </div>\n";

                } else {

                    text = "<div onclick=\"addressId=" + data.data.id + "\" class=\"addre fl\" id=\"a"+data.data.id+"\">\n" +

                        "<div class=\"tit clearfix\"><p class=\"fl\">"+ data.data.userName +"</p>\n" +

                        "<p class=\"fr\"><a href=\"javascript:setDefault("+data.data.id+")\" class=\"setDefault\">设为默认</a><span>|</span><a href=\"javascript:deleteAddress("+data.data.id+")\">删除</a><span>|</span><a href=\"javascript:updateAddress('"+data.data.id+"','"+data.data.userName+"','"+data.data.userPhone+"','"+code1+"','"+code2+"','"+code3+"','"+code4+"','"+data.data.userAddress+"')\" class=\"edit\">编辑</a></p></div>\n" +

                        "\n" +

                        "<div class=\"addCon\"><p>"+$(".dyjjcity option:selected").get(0).innerHTML+"&nbsp;"+$(".dyjjcity option:selected").get(1).innerHTML+"&nbsp;"+$(".dyjjcity option:selected").get(2).innerHTML+"&nbsp;"+$(".dyjjcity option:selected").get(3).innerHTML+"</p>\n" +

                        "<p>"+ data.data.userPhone +"</p></div>\n" +

                        "  </div>\n";

                }

                $("#addressList").append($(text));


            },"JSON");

        }else {

            $.get("addressUpdate.do",{

                "id":updateId,

                "userName":userName,

                "userPhone":userPhone,

                "code1":code1,

                "code2":code2,

                "code3":code3,

                "code4":code4,

                "userAddress":userAddress,

            }, function (data) {

                layer.closeAll();

                layer.msg("修改成功");

                setTimeout(function () {

                    window.location.reload();

                },750);

            });

        }


    }

    function selectChange(type, select) {

        if (type == 4){
            return;
        }
        //获取选中的值

        var code = $(select).find("option:selected").val();
        //单线程同步
        $.ajax({
            url:"getRegionByParentCode.do",
            type:"GET",
            async:false,
            data:"code=" + code,
            dataType:"JSON",
            success:function (data) {
                var $select;
                switch (type) {
                    case 1:
                        $select = $(".dyjjcity>select:eq(1)");
                        break;
                    case 2:
                        $select = $(".dyjjcity>select:eq(2)");
                        break;
                    case 3:
                        $select = $(".dyjjcity>select:eq(3)");
                        break;
                }
                $select.html("");
                for (var i = 0; i < data.data.length; i++) {
                    var city = data.data[i];
                    var $newOption = $("<option value = '" + city.code + "'>" + city.name + "</option>");
                    $select.append($newOption);
                }
                select = $(".dyjjcity>select:eq(" + type + ")").get(0);
                selectChange(type + 1, select)
            }
        });
    }

</script>

<jsp:include page="right.jsp"/>

<script src="js/public.js" type="text/javascript" charset="utf-8"></script>

<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>

<script src="js/user.js" type="text/javascript" charset="utf-8"></script>

</body>

</html>


