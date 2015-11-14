<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.text.DecimalFormat"%>
<html>

<head>
   <title>Thank You!</title>

   <link rel = "stylesheet" href = "styles.css" 
      type = "text/css" />
</head>


<%-- end scriptlet --%>

<body>
   <p class="bigFont">Thank You</p>
   <p>此次共消费: 
      <span class = "bold">
         <%=new DecimalFormat("0.00").format(Double.parseDouble(request.getParameter("total"))) %>元
      </span>
   </p>
</body>

</html>