<%@ page import="com.sun.corba.se.impl.orbutil.graph.Graph" %>
<%@ page import="java.util.List" %>
<%@ page import="ovh.challangers.tokentolearn.controlers.database.DaoFactory" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="ovh.challangers.tokentolearn.beans.*" %><%--
  Created by IntelliJ IDEA.
  User: maxor
  Date: 12/04/2018
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="css/W3.css"/>
<head>
    <title>Token to learn</title>

</head>
<body>
<div class="w3-sidebar w3-light-grey w3-bar-block" style="width:25%">
        <% User user = (User) pageContext.getRequest().getAttribute("user");%>
            <% List<Project> projects = (List<Project>) pageContext.getRequest().getAttribute("projects") ; %>
            <% for (Project p : projects) { %>
            <a href="#" class="w3-bar-item w3-button"> <%= p.getId() %> </a>
    <% } %>
    <div  class="w3-container w3-cell-bottom">
        <button class="w3-button w3-circle w3-amber">+</button>
        <button class="w3-button w3-circle w3-black">-</button>
    </div>
</div>
<div style="margin-left:25%">
    <div class="w3-container">
            <% Tutor tuts = (Tutor) pageContext.getRequest().getAttribute("tutor");%>
        <div class="w3-container w3-amber">
            <button onclick="myFunction('Intervenant1')" class="w3-button w3-block w3-black w3-left-align"><%= user.getId() %></button>
            <div id="Intervenant1" class="w3-hide w3-animate-zoom">
                <% for (Tutor.WaitingQueue waitingQueue : tuts.getWaitingqueue()) { %>
                    <span class="w3-button w3-block w3-left-align"><%= waitingQueue.value.group.getGroupid()%></span>
                <%}%>
            </div>
        </div>
    </div>
</div>

<script>
    function myFunction(id) {
        var x = document.getElementById(id);
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
        } else {
            x.className = x.className.replace(" w3-show", "");
        }
    }
</script>

</body>
</html>
