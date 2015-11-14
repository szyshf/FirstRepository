<%@ page language="java"
	import="java.util.*,com.bright.estore.product.model.*"
	pageEncoding="UTF-8"%>
<%@page import="java.text.DecimalFormat"%>
<html>

	<head>

		<title>书本的详细信息</title>

		<!-- <link rel="stylesheet" href="./styles.css" type="text/css" />    -->
		<LINK href="images/main.css" type="text/css" rel="stylesheet" />

		<style type="text/css">
<!--
#addBook {
	position: absolute;
	width: 377px;
	height: 288px;
	z-index: 1;
	left: 580px;
	top: 383px;
	background-color:#66CCCC
}
-->
        </style>

		<script language="javascript" type="text/javascript">
       function checkValue(){
        if(isNaN(document.form1.number.value)){
        alert("购买数量必须为数字!");
        document.form1.number.focus();
        document.form1.number.select();
        return false;
          }
          
          if(document.form1.number.value < 1){
          alert("请至少购买一本!");
          document.form1.number.focus();
          document.form1.number.select();
          return false;
          }
        }
        
        function changShow(op){
         document.getElementById("addBook").style.display=op;
        }
       </script>
	</head>

	<body>
		<p class="bigFont">
			<br>
		</p>
		<CENTER>
			<TABLE cellSpacing="0" cellPadding="0" width="778" bgColor="#ffffff"
				background="images/top1bg.jpg" border="0">
				<TBODY>
					<TR>
						<TD width="778"></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE class="center" height="100" cellSpacing="0" cellPadding="0"
				width="778" bgColor="#ffffff" border="0">
				<TBODY>
					<TR>
						<TD align="middle" width="150">
							<IMG title="" height="100" src="images/logo.jpg" width="100"
								border="0" />
						</TD>
						<TD width="58"></TD>
						<TD vAlign="top" width="110">
							<IMG height="90" src="images/top1.jpg" width="70" border="0" />
						</TD>
						<TD vAlign="top" width="110">
							<IMG height="90" src="images/top2.jpg" width="70" border="0" />
						</TD>
						<TD vAlign="top" width="110">
							<IMG height="90" src="images/top3.jpg" width="70" border="0" />
						</TD>
						<TD vAlign="top" width="110">
							<IMG height="90" src="images/top4.jpg" width="70" border="0" />
						</TD>
						<TD width="130"></TD>
					</TR>
				</TBODY>
			</TABLE>

			<TABLE class="center" cellSpacing="0" cellPadding="0" width="778"
				bgColor="#ffffff" border="0">
				<TBODY>
					<TR>
						<TD style="FONT-SIZE: 1px" bgColor="#b0b0b0" colSpan="19"
							height="1">
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing="0" cellPadding="0" width="778" bgColor="#ffffff"
				border="0">
				<TBODY>
					<TR>
						<TD style="FONT-SIZE: 1px" bgColor="#dcdcdc" height="3">
						</TD>
					</TR>
					<TR>
						<TD align="right" background="images/bn01.jpg" height="120">
						</TD>
					</TR>
				</TBODY>
			</TABLE>

			<TABLE height="15" cellSpacing="0" cellPadding="0" width="778"
				border="0">
				<TBODY>
					<TR>
						<TD style="FONT-SIZE: 10px; LINE-HEIGHT: 10px"
							background="images/bnbg1.gif" height="15">
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing="0" cellPadding="0" width="778" bgColor="#ffffff"
				border="0">
				<TBODY>
					<TR>
						<TD vAlign="top" width="168" height="400">
							<TABLE class="center" height="100%" cellSpacing="0"
								cellPadding="0" width="168" bgColor="#ffffff"
								background="images/leftbg.gif" border="0">
								<TBODY>

									<TR>
										<TD class="lefttd" vAlign="top" align="middle">
											<BR />
										</TD>
									</TR>
								</TBODY>
							</TABLE>
						</TD>
						<TD vAlign="top" align="middle" width="610">
							<TABLE cellSpacing="0" cellPadding="0" width="98%"
								background="images/top01.gif" border="0">
								<TBODY>
									<TR>
										<TD align="left" height="25">
											<IMG height="11" src="images/icon1.gif" width="31" />
											<font style="cursor: hand"
												onclick="javascript:history.go(-1);">返回</font>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<BR />
							<TABLE style="TEXT-ALIGN: center" cellSpacing="0" cellPadding="0"
								width="590" border="0">
								<TBODY>
									<%
										List bookList = (List) session.getAttribute("bookList");
										String isbn = request.getParameter("isbn");
										Iterator it = bookList.iterator();
										while (it.hasNext()) {
											BookModel bookModel = (BookModel) it.next();
											if (isbn.equals(bookModel.getIsbn())) {
												session.setAttribute("bookModel", bookModel);
									%>
									<tr height="100">
										<td colspan="3">
											<h2>
												<%=bookModel.getTitles()%>
											</h2>
										</td>
									</tr>

									<tr>
										<!-- create table cell for product image -->
										<td rowspan="5">
											<!-- cell spans 5 rows -->
											<img
												src="images/<%=bookModel.getImageFile()%>"
												alt="${bookToAdd.title }" style="border: thin solid black" />										</td>

										<!-- create table cells for price in row 1 -->
										<td class="bold" align="left">
											书本编号
										</td>

										<td align="left">
											<%=bookModel.getIsbn()%>
										</td>
									</tr>

									<tr align="left">

										<!-- create table cells for ISBN in row 2 -->
										<td class="bold" align="left">
											价格
										</td>

										<td align="left">
											<%=bookModel.getPrice()%>
										</td>

									</tr>

									<tr align="left">

										<!-- create table cells for edition in row 3 -->
										<td class="bold">
											版次
										</td>

										<td>
											<%=bookModel.getPublisherID()%>
										</td>
									</tr>

									<tr align="left">

										<!-- create table cells for copyright in row 4 -->
										<td class="bold">
											出版日期

										</td>

										<td>
											<%=bookModel.getCopyright()%>
										</td>
									</tr>


									<tr align="left">
										<!-- create Add to Cart button in row 5 -->
										<td>
											<p>
												<input type="button" value="放入购物车"
													onclick="changShow('block')" />
											</p>
										</td>

										<!-- create View Cart button in row 5 -->
										<td>
											<form method="get" action="viewCart.jsp">
												<p>
													<br>
													<input type="submit" value="查看购物车" />
												</p>
											</form>
										</td>
									</tr>
								</TBODY>
							</TABLE>
							<BR />
							<div id="addBook" style="display: none">
								<form name="form1" method="post" action="CartAddServlet"
									onSubmit="return checkValue()">
									<br>
									<h3 align="center" style="color: red">
										请填写以下信息
									</h3>
									<table width="297" height="195" align="center">
										<tr>
											<td width="56">
												书本编号
											</td>
											<td width="199"><%=bookModel.getIsbn()%></td>
										</tr>
										<tr>
											<td>
												价 格
											</td>
											<td><%=new DecimalFormat("0.00").format(bookModel
									.getPrice())%></td>
										</tr>
										<tr>
											<td>
												版 次
											</td>
											<td><%=bookModel.getEditionNumber()%></td>
										</tr>
										<tr>
											<td>
												出版日期
											</TD>
											<TD><%=bookModel.getCopyright()%></TD>
										</tr>
										<TR>
											<TD>
												购买数量
											</TD>
											<td>
												<input name="number" type="text" value="1" size="10" />
											</td>
										</TR>
										<tr>
											<td>
												<input type="submit" value=" 确定 " />
											</td>
											<TD>
												<div id="ab" align="center">

													<input name="reset" type="reset" value=" 取消 "
														onClick="changShow('none')" />
												</div>
											</td>
										</tr>
										<%
											}
											}
										%>
									</table>
								</form>
								<p>&nbsp;
									
							  </p>
						  </div>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE class="center" cellSpacing="0" cellPadding="0" width="778"
				bgColor="#ffffff" border="0">
				<TBODY>
					<TR>
						<TD align="middle" background="images/bk.gif" height="50">
						</TD>
					</TR>
				</TBODY>
			</TABLE>

		</CENTER>
	<body>
		&nbsp;
	</body>

</html>
