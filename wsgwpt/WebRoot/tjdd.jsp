<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>提交订单页面</title>
    
	<link href="css/admin.css" rel="stylesheet" type="text/css">
		<link href="css/amazeui.css" rel="stylesheet" type="text/css">
		<link href="css/personal.css" rel="stylesheet" type="text/css">
		<link href="css/systyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="JavaScript" src="js/text1.js" charset="utf-8"></script>
	</head>
<body>
		<!--头 -->
		<header>
			<article>
				<div class="mt-logo">
					<!--顶部导航条 -->
					<div class="am-container header">
						<ul class="message-l">
							<div class="topMessage">
							</div>
						</ul>
						<ul class="message-r">
							<div class="menu-hd">
							<a href="index.jsp" target="_top" class="h">商城首页|| </a>
							<a href="grzx.jsp" target="_top">个人中心|| </a>
							<a href="gwc.jsp" target="_top" class="h">购物车|| </a>
							<a href="#" target="_top">收藏夹</a>
						</div>
						</ul>
						</div>

						<!--悬浮搜索框-->

						<div class="nav white">
							<div class="logoBig">
								<li><img src="images/logo.jpg" /></li>
							</div>

							<div class="search-bar pr">
								<a name="index_none_header_sysc" href="#"></a>
								<form action="./SearchGoodServlet">
									<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
									<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
								</form>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
			</article>
		</header>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="index.jsp">首页</a></li>
                                <li class="qc"><a href="#">店铺</a></li>
                                <li class="qc"><a href="goods.jsp">商品</a></li>
							</ul>
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="am-cf am-padding">
						<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">提交订单</strong> / <small>AddOrder</small></div>
					</div>
					<hr/>
					<!--信息框-->
					<form  name="form1" class="am-form am-form-horizontal" action="./AddOrderServlet" onSubmit="return check1()"  accept-charset="utf-8">
						<div class="am-form-group">
							<label for="user-old-password" class="am-form-label">订单号</label>
							<div class="am-form-content">
							<% 
							Date date1=new Date();
                            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");//设置格式
                            String date = formater.format(date1);//转化为字符串
							//String date = (new java.util.Date()).toLocaleString(); 
							String year=date.substring(0,4);//取第0+1位至第4位
                            String month=date.substring(5,7);//取第5+1位至第7位
                            String day=date.substring(8,10);//取第8+1位至第10位
                            String hour=date.substring(11,13);
                            String min=date.substring(14,16);
                            String miu=date.substring(17,19);
							 %>  
								<input type="text" id="order_id" name="order_id" readonly="true" value="<%=year+month+day+hour+min+miu%> ">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-new-password" class="am-form-label">商品编号</label>
							<div class="am-form-content">
								<input type="text" id="goods_id" name="goods_id" readonly="true" value="${shopcart.thing_id }">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-confirm-password" class="am-form-label">商品名称</label>
							<div class="am-form-content">
								<input type="text" id="goods_name" name="goods_name" readonly="true" value="${shopcart.thing_name }">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-confirm-password" class="am-form-label">商品数量</label>
							<div class="am-form-content">
								<input type="text" id="goods_amount" name="goods_amount"  value="${shopcart.thing_amount }">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-confirm-password" class="am-form-label">商品类型</label>
							<div class="am-form-content">
								<input type="text" id="order_state" name="order_state" readonly="true" value="${shopcart.thing_state }">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-confirm-password" class="am-form-label">商品单价</label>
							<div class="am-form-content">
								<input type="text" id="good_price" name="good_price" readonly="true" value=" ${shopcart.thing_price } ">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-confirm-password" class="am-form-label">收货人</label>
							<div class="am-form-content">
								<input type="text" id="user_name" name="user_name" placeholder="">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-confirm-password" class="am-form-label">收货地址</label>
							<div class="am-form-content">
								<input type="text" id="user_address" name="user_address" placeholder="">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-confirm-password" class="am-form-label">联系电话</label>
							<div class="am-form-content">
								<input type="text" id="user_tel" name="user_tel" placeholder="">
							</div>
						</div>
						<div class="info-btn" align="center">
							 <input type="submit" name="" value="提交订单" >
							 &nbsp;
							 <input type="button" style="color:bule" value="返回购物车" onclick="javascript:history.go(-1);" /><br>
							 <a>&nbsp;&nbsp;</a>
						</div>

					</form>

				</div>
				
			</div>

			
		</div>

	</body>

</html>
