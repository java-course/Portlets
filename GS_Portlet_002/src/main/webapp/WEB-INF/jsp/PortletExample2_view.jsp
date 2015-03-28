<%@page import="com.geminisystems.PortletExample2"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<portlet:defineObjects />
<%PortletPreferences prefs = renderRequest.getPreferences();
    String email = prefs.getValue(PortletExample2.KEY_EMAIL, "");
    String password = prefs.getValue(PortletExample2.KEY_PASSWORD, "");
    pageContext.getRequest().setAttribute("email", email);
    pageContext.getRequest().setAttribute("password", password);

%> 

<c:choose>

    <c:when test="${(email eq '') || (password eq '')}">
        <a href="<portlet:renderURL portletMode='EDIT'></portlet:renderURL>">Pls set email and/or password</a>
    </c:when>

    <c:otherwise>

        <form action="<portlet:actionURL/>" method="POST">

            <textarea name="<%=PortletExample2.TEXT%>" rows="10" cols="45" ></textarea>
            <input type="submit" name="<%=PortletExample2.SUBMIT_TEXT%>" value="Save"/>

        </form>

    </c:otherwise>

</c:choose>



