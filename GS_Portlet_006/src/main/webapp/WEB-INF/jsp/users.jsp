<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<portlet:defineObjects/>


<c:if test="${not empty users}">

    <ul>
        <c:forEach items="${users}" var="u">

            <li>
                Name : <h2>${u.login}</h2> &nbsp; Email : <h2>${u.email}</h2> &nbps;&nbsp;

                <portlet:renderURL var="editUrl">
                    <portlet:param name="action" value="edit"/>
                    <portlet:param name="id" value="${u.userId}"/>
                </portlet:renderURL>

                <portlet:renderURL var="deleteUrl">
                    <portlet:param name="action" value="delete"/>
                    <portlet:param name="id" value="${u.userId}"/>
                </portlet:renderURL>

                <a href="${editUrl}">Edit</a>&nbsp;<a href="${deleteUrl}">Delete</a>

            </li>

        </c:forEach>

    </ul>

</c:if>



<portlet:actionURL var="url">
    <portlet:param name="create" value="yes"/>
</portlet:actionURL>

<%--<form:form commandName="user" action="${url}">--%>
    <%--<form:hidden path="userId"/>--%>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<td>Login</td>--%>
            <%--<td>--%>
                <%--<form:errors path="login" cssStyle="background-color:orange;font-weight:bold;"/>--%>
                <%--<form:input path="login" cssStyle="width:250px"/>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>Password</td>--%>
            <%--<td>--%>
                <%--<form:errors path="password" cssStyle="background-color:orange;font-weight:bold;"/>--%>
                <%--<form:password path="password" cssStyle="width:250px"/>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>Email</td>--%>
            <%--<td>--%>
                <%--<form:errors path="email" cssStyle="background-color:orange;font-weight:bold;"/>--%>
                <%--<form:input path="email" cssStyle="width:250px"/>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td></td>--%>
            <%--<td>--%>
                <%--<input type="submit"/>--%>
            <%--</td>--%>
        <%--</tr>--%>

    <%--</table>--%>
<%--</form:form>--%>

<form method="post" action="${url}">

    <table>
        <tr>
            <td>Login</td>
            <td>
                <input type="text" name="login"/>
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td>
                <input type="text" name="password" />
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="email"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit"/>
            </td>
        </tr>

    <%--</table>--%>

</form>