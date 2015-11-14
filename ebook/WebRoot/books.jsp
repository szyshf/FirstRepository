<%@ page language="java" import="java.util.*,com.bright.estore.product.model.*" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<TITLE>ebooks</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="images/main.css" type=text/css rel=stylesheet>
</HEAD>
<BODY>
<CENTER>
<TABLE cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff
	background=images/top1bg.jpg border=0>
	<TBODY>
		<TR>
			<TD width=778>&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
<TABLE class=center height=100 cellSpacing=0 cellPadding=0 width=778
	bgColor=#ffffff border=0>
	<TBODY>
		<TR>
			<TD align=middle width=150><IMG title="" height=100
				src="images/logo.jpg" width=100 border=0></TD>
			<TD width=58>&nbsp;</TD>
			<TD vAlign=top width=110><IMG height=90 src="images/top1.jpg"
				width=70 border=0></TD>
			<TD vAlign=top width=110><IMG height=90 src="images/top2.jpg"
				width=70 border=0></TD>
			<TD vAlign=top width=110><IMG height=90 src="images/top3.jpg"
				width=70 border=0></TD>
			<TD vAlign=top width=110><IMG height=90 src="images/top4.jpg"
				width=70 border=0></TD>
			<TD width=130></TD>
		</TR>
	</TBODY>
</TABLE>

<TABLE class=center cellSpacing=0 cellPadding=0 width=778
	bgColor=#ffffff border=0>
	<TBODY>
	<tr>
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
			<TD align=right background=images/bn01.jpg height=120>&nbsp;</TD>
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
<TABLE cellSpacing=0 cellPadding=0 width=778 bgColor=#ffffff border=0>
	<TBODY>
		<TR>
			<TD vAlign=top width=168 height=400>
			<TABLE class=center height="100%" cellSpacing=0 cellPadding=0
				width=168 bgColor=#ffffff background=images/leftbg.gif border=0>
				<TBODY>

					<TR>
						<TD class=lefttd vAlign=top align=middle><BR>
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
						<TD align=left height=25><IMG height=11
							src="images/icon1.gif" width=31>书籍列表<br></TD>
					</TR>
				</TBODY>
			</TABLE>
			<BR>
			<TABLE style="TEXT-ALIGN: center" cellSpacing=0 cellPadding=0
				width=590 border=0>
				<TBODY>
				<!--   ��ʾ���ݿ�ʼ  -->
      				<%
      				    List bookList = (List)session.getAttribute("bookList");
      				    
      				    for (int i=0,size = bookList.size(); i<size; i++){
      				    	BookModel bookModel = (BookModel)bookList.get(i);
      				    	if (i % 3 == 0){
      				 %>
      							<TR>
      				<%      } %>
      				<TD>
						<TABLE cellSpacing=0 cellPadding=0 width=180
							background=images/bg.jpg border=0>
							<TBODY>
								<TR>
									<TD vAlign=bottom height=30>&nbsp;&nbsp; 
										<a href="displayBook.jsp?isbn=<%=bookModel.getIsbn()%>">&nbsp;&nbsp; &nbsp;&nbsp; <%=subStr(bookModel.getTitles())%></a>
									</TD>
								</TR>
								<TR align=middle>
									<TD height=120>
										<A href="displayBook.jsp?isbn=<%=bookModel.getIsbn()%>">
											<IMG height=110 src="images/<%=bookModel.getImageFile()%>" width=90 border=0>
										</A>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						<BR>
				</TD>
      		
      			<% if ((i+1) % 3 == 0) { %>
						</TR>
				<% } %>
				
				<% } %>


      			

      
				<!--   ��ʾ���ݽ���  -->
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
			<TD align=middle background=images/bk.gif height=50></TD>
		</TR>
	</TBODY>
</TABLE>

</CENTER>
</BODY>
</HTML>
<%!

	public String subStr(String str){
		if(str==null || "".equals(str))
			return "";
		if(str.length()>20)
			return str.substring(0,20)+"...";
		else
			return str;
	}
 %>

