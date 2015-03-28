<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />
<%
 String text = "";
 if (portletSession.getAttribute("text")!= null)
      text = portletSession.getAttribute("text").toString();

%>

Received event<br>
<textarea rows="5" cols="40"><%=text%></textarea>

Received public parameter<br>
<textarea rows="5" cols="40"><%=renderRequest.getParameter("public")%></textarea>



