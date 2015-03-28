<%@page import="com.geminisystems.PortletExample2"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<portlet:defineObjects />

<%PortletPreferences prefs = renderRequest.getPreferences();
String email = prefs.getValue(PortletExample2.KEY_EMAIL, "");
String password = prefs.getValue(PortletExample2.KEY_PASSWORD, "");
%> 



<form action="<portlet:actionURL/>" method="POST">

    <input type="text" name="<%=PortletExample2.KEY_EMAIL%>" value="<%=email%>"/>
    <input type="password" name="<%=PortletExample2.KEY_PASSWORD%>" value="<%=password%>"/>
    <input type="submit" name="<%=PortletExample2.SUBMIT%>" value="Save"/>

</form>