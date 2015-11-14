
<%@ page language="java"
	import="java.util.*,com.bright.estore.product.model.*"
	pageEncoding="UTF-8"%>
<%@ page import="com.bright.estore.cart.model.CartItemsModel"%>
<%@ page import="java.text.DecimalFormat"%>
<html>

	<head>
		<title>Shopping Cart</title>

		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<LINK href="images/main.css" type=text/css rel=stylesheet>
	</head>

	<body>

		<CENTER>
			<TABLE cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff
				background=images/top1bg.jpg border=0>
				<TBODY>
					<TR>
						<TD width=778>
							&nbsp;
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE class=center height=100 cellSpacing=0 cellPadding=0 width=778
				bgColor=#ffffff border=0>
				<TBODY>
					<TR>
						<TD align=middle width=150>
							<IMG title="" height=100 src="images/logo.jpg" width=100 border=0>
						</TD>
						<TD width=58>
							&nbsp;
						</TD>
						<TD vAlign=top width=110>
							<IMG height=90 src="images/top1.jpg" width=70 border=0>
						</TD>
						<TD vAlign=top width=110>
							<IMG height=90 src="images/top2.jpg" width=70 border=0>
						</TD>
						<TD vAlign=top width=110>
							<IMG height=90 src="images/top3.jpg" width=70 border=0>
						</TD>
						<TD vAlign=top width=110>
							<IMG height=90 src="images/top4.jpg" width=70 border=0>
						</TD>
						<TD width=130>
						</TD>
					</TR>
				</TBODY>
			</TABLE>

			<TABLE class=center cellSpacing=0 cellPadding=0 width=778
				bgColor=#ffffff border=0>
				<TBODY>
					<TR>
						<TD style="FONT-SIZE: 1px" bgColor=#b0b0b0 colSpan=19 height=1></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff border=0>
				<TBODY>
					<TR>
						<TD style="FONT-SIZE: 1px" bgColor=#dcdcdc height=3></TD>
					</TR>
					<TR>
						<TD align=right background=images/bn01.jpg height=120>
							&nbsp;
						</TD>
					</TR>
				</TBODY>
			</TABLE>

			<TABLE height=15 cellSpacing=0 cellPadding=0 width=778 border=0>
				<TBODY>
					<TR>
						<TD style="FONT-SIZE: 10px; LINE-HEIGHT: 10px"
							background=images/bnbg1.gif height=15></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff border=0
				height="357">
				<TBODY>
					<TR>
						<TD vAlign=top width=168 height=400>
							<TABLE class=center height="100%" cellSpacing=0 cellPadding=0
								width=168 bgColor=#ffffff background=images/leftbg.gif border=0>
								<TBODY>

									<TR>
										<TD class=lefttd vAlign=top align=middle>
											<BR>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
						</TD>
						<TD vAlign=top align=middle width=610>
							<TABLE cellSpacing=0 cellPadding=0 width="98%"
								background=images/top01.gif border=0>
								<TBODY>
									<TR>
										<TD align=left height=25>
											<IMG height=11 src="images/icon1.gif" width=31>
											购物车信息
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<BR>
							<TABLE style="TEXT-ALIGN: center" cellSpacing=0 cellPadding=0
								width=590 border=0>
								<TBODY>


									<!--   ÏÔÊ¾ÄÚÈÝ¿ªÊ¼  -->

									<table cellSpacing=0 cellPadding=0 width="726" border=1 height="193">
										<thead>
											<tr align="center">
												<th>
													书名
												</th>
												<th>
													购买数量
												</th>
												<th>
													单价
												</th>
												<th>
													小计
												</th>
											</tr>
										</thead>
										<%
										  Map cart = (Map) session.getAttribute("cart");
											if (cart == null || cart.size() == 0) {
												out.print("<p>当前购物车里没有书本</p>");
											} else {
												Set set = cart.keySet();
												Object[] isbn = set.toArray();
												double total = 0;
												for (int i = 0, len = isbn.length; i < len; i++) {
													CartItemsModel cartModel = (CartItemsModel) cart.get((String)isbn[i]);
													total = total + cartModel.getBookModel().getPrice() * cartModel.getQty();
													//out.println(total);
													//System.out.println("************"+total);
										%>
										<tr>
											<td>
												<a href="displayBook.jsp?isbn=<%=cartModel.getBookModel().getIsbn() %>"><%=cartModel.getBookModel().getTitles()%></a>
											</td>

											<td align="center">
												<%=cartModel.getQty()%>
											</td>

											<td class="right">
												<%=new DecimalFormat("0.00").format(cartModel
									.getBookModel().getPrice())%>
											</td>

											<td class="bold right">
												<%=new DecimalFormat("0.00").format(cartModel
									.getQty()
									* cartModel.getBookModel().getPrice())%>
											</td>
										</tr>
										<%
											}
										%>
										<tr>
											<td colspan="4" class="bold right">
												<b>&#24635;&#35745;&#65306; </b>
											<%=new DecimalFormat("0.00").format(total)%>  
											<% } %>
											</td>
										</tr>
									</table>

									<p class="bold green">
										<a href="books.jsp">继续购买</a>
									</p>

									<!-- form to proceed to checkout -->
									<form method="get" action="order.html">
										<p>
											<input type="submit" value="结账" />
										</p>
									</form>

									<!--   ÏÔÊ¾ÄÚÈÝ½áÊø  -->
								</TBODY>
							</TABLE>
							<BR>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE class=center cellSpacing=0 cellPadding=0 width=778
				bgColor=#ffffff border=0>
				<TBODY>
					<TR>
						<TD align=middle background=images/bk.gif height=50>
						</TD>
					</TR>
				</TBODY>
			</TABLE>

		</CENTER>
	</BODY>
</HTML>
