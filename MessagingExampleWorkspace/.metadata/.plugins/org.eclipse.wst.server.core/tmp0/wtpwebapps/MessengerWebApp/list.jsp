<%@page import="de.sones.mule.demo.MessageBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="msgListBean" class="de.sones.mule.demo.MessageListBean" scope="request"/>


<table border="1">

<%
ArrayList<MessageBean> result = msgListBean.getMessages();


for (MessageBean msg : result)
{
   out.println("<tr>");
	
   out.println("<td>" + msg.getDate().toString()  + "</td>" +
		       "<td>" + msg.getUserName() + "</td>" +
		       "<td>" + msg.getMessage() + "</td>"
    );
	
   out.println("</tr>");	
}
%>

</table>

<hr/>
<a href="index.jsp">Back</a>
<hr/>

</body>
</html>