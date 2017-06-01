<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>购物车页面</title>

		<link href="css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="css/demo.css" rel="stylesheet" type="text/css" />
		<link href="css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="css/optstyle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" language="JavaScript" src="js/text1.js" charset="utf-8"></script>
	</head>

	<body >

		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="menu-hd">
							<a href="index.jsp" target="_top" class="h">商城首页|| </a>
							<a href="grzx.jsp" target="_top">个人中心|| </a>
							<a href="gwc.jsp" target="_top" class="h">购物车|| </a>
							<a href="" target="_top">收藏夹</a>
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

			<!--购物车 -->
			<div class="concent">
				<div id="cartTable">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
								<div id="J_SelectAll1" class="select-all J_SelectAll">

								</div>
							</div>
							<div class="th th-item">
								<div class="td-inner">购物车</div>
							</div>
							<div class="th th-price">
								<div class="td-inner">商品编号</div>
							</div>
							<div class="th th-amount">
								<div class="td-inner">数量</div>
							</div>
							<div class="th th-sum">
								<div class="td-inner">单价</div>
							</div>
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>

					<tr class="item-list">
						<div class="bundle  bundle-last ">
							<div class="bundle-hd">
								<div class="bd-promos">
									<div class="bd-has-promo">商品信息<span class="bd-has-promo-content"></span>&nbsp;&nbsp;</div>
									<div class="act-promo">
										<a href="#" target="_blank"><span class="gt">&gt;&gt;</span></a>
									</div>
									<span class="list-change theme-login">编辑</span>
								</div>
							</div>
		<%
		   Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wsgwpt?useUnicode=true&characterEncoding=utf8", "root", "");
			Statement stmt = con.createStatement();
			ResultSet as = stmt.executeQuery("select * from shopping_cart");
			while (as.next()) {
		%>
							<div class="clear"></div>
							<div class="bundle-main">
							<form  name="form" action="./SelectShopcartServlet"   accept-charset="utf-8" >
								<ul class="item-content clearfix">
									<li class="td td-chk">
										<div class="cart-checkbox ">
											<input class="check" id="J_CheckBox_170037950254" name="items[]" value="170037950254" type="checkbox">
											<label for="J_CheckBox_170037950254"></label>
										</div>
									</li>
									<li class="td td-item">
										<div class="item-pic">
											<a href="#" target="_blank" data-title="美康粉黛醉美东方唇膏口红正品 持久保湿滋润防水不掉色护唇彩妆" class="J_MakePoint" data-point="tbcart.8.12">
												<img src="images/good3.jpg" class="itempic J_ItemImg"></a>
										</div>
										<div class="item-info">
											<div class="item-basic-info">
												<a href="#" target="_blank" title="美康粉黛醉美唇膏 持久保湿滋润防水不掉色" class="item-title J_MakePoint" data-point="tbcart.8.11"><%=as.getString("thing_name")%></a>
											</div>
										</div>
									</li>
									<li class="td td-info">
										<div class="item-props item-props-can">
											<span class="sku-line">类型：<%=as.getString("thing_state")%></span>
											<span class="sku-line">库存：<%=as.getString("goods_amount")%></span>
											<span tabindex="0" class="btn-edit-sku theme-login">修改</span>
											<i class="theme-login am-icon-sort-desc"></i>
										</div>
									</li>
									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content">
												<div class="price-line">
													<em class="price-original"></em>
												</div>
												<div class="price-line">
													<input class="text_box" id="goods_id" name="goods_id" type="text" readonly="true" value="<%= as.getString("thing_id") %>" style="width:30px;" />
												</div>
											</div>
										</div>
									</li>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<div class="sl">
													<input class="min am-btn" name="" type="button" value="-" />
													<input class="text_box" id="num" name="num" type="text" value="<%= as.getString("thing_amount") %>" style="width:30px;" />
													<input class="add am-btn" name="" type="button" value="+" />
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner">
										
											<em tabindex="0" class="J_ItemSum number"><%=  as.getDouble("thing_price")%></em>
										</div>
									</li>
									<li class="td td-op">
										<div class="td-inner">
											<a title="删除" class="btn-fav" href="./DelShopcartServlet?thing_id=<%= as.getString("thing_id") %>">
                  删除</a>
											<input class="btn-area" type="submit" name="" value="结算" >
										</div>
									</li>
								</ul>
								</form>
								
		<%
			}
		%>
							</div>
						</div>
					</tr>
					<div class="clear"></div>

					
				</div>
				
			</div>

	</body>

</html>