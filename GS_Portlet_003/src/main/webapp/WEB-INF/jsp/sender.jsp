<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<portlet:defineObjects />

<%PortletPreferences prefs = renderRequest.getPreferences();%> 


<form action="<portlet:actionURL/>" method="POST">

    Typed text will be sent as portlet event<br>
    <textarea cols="40" rows="5" name="text"></textarea>
    <input type="submit" name="submit_event" value="Send Event"/>
    <input type="submit" name="submit_public" value="Send Parameter"/>

</form>