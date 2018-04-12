<%@ page import="ovh.challangers.tokentolearn.beans.Project" %>
<%@ page import="ovh.challangers.tokentolearn.beans.Tutor" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cleme
  Date: 11/04/2018
  Time: 09:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<link rel="stylesheet" type="text/css" href="CSS/W3.css"/>


<head>
    <title>Choix du projet</title>
</head>
<body>
<form class="w3-container w3-card-4 w3-light-grey w3-text-black w3-margin">
<div style="margin-left:25%" >
    <div style="margin-right: 25%">
<div class="w3-container">
    <div style="text-align: center">

            <h2>Quel projet voulez-vous rejoindre ?</h2><div class="w3-panel w3-border">
        </div>
    </div>
    <ul class="w3-ul w3-xlarge">
    <% for (Project p : (List<Project>) pageContext.getRequest().getAttribute("projects")) { %>
            <li id="projectName" name="projectName"><a href="${pageContext.request.contextPath}/tokenMain?id=<%= p.getId() %>"> <%= p.getId() %> </a> </li>
    <% } %>
    </ul>
    <div  class="w3-container w3-cell-bottom">
        <div class="w3-container w3-right">
            <%--<% if(pageContext.getRequest().getAttribute("user"))%>--%>
        <button class="w3-button w3-circle w3-amber">+</button>
        <button class="w3-button w3-circle w3-black">-</button>
        </div>
    </div>
</div>
</div>
</div>
</form>
</body>
</html>
