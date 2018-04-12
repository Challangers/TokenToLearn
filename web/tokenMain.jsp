<%@ page import="com.sun.corba.se.impl.orbutil.graph.Graph" %>
<%@ page import="java.util.List" %>
<%@ page import="ovh.challangers.tokentolearn.controlers.database.DaoFactory" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="ovh.challangers.tokentolearn.beans.*" %><%--
  Created by IntelliJ IDEA.
  User: cleme
  Date: 10/04/2018
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="CSS/W3.css"/>
<head>
    <title>Token to learn</title>

</head>
<body>
<div class="w3-sidebar w3-light-grey w3-bar-block" style="width:25%">
    <% String projectName = (String) pageContext.getRequest().getAttribute("projectName") ; %>
    <h3 class="w3-bar-item">Projet : <%= projectName %> </h3>
    <% for (Group g : (List<Group>) pageContext.getRequest().getAttribute("groups")) { %>
    <a href="#" class="w3-bar-item w3-button"> <%= g.getGroupid() %> </a>
    <% } %>
    <div  class="w3-container w3-cell-bottom">
        <button class="w3-button w3-circle w3-amber">+</button>
        <button class="w3-button w3-circle w3-black">-</button>

</div>
</div>
<div style="margin-left:25%">
<div class="w3-container">
<% Group groupStudent = (Group) pageContext.getRequest().getAttribute("groupStudent");%>
    <a><%= groupStudent.getGroupid() %></a>
    <div style= "margin-right:25%">
<h3>Token restant : <%= groupStudent.getToken() %></h3>
        </div>
    <div class="w3-container w3-amber">
        <% for (User t : (List< User>) pageContext.getRequest().getAttribute("tutors")) { %>
    <button onclick="myFunction('Intervenant1')" class="w3-button w3-block w3-black w3-left-align"><%= t.getId() %></button>

    <div id="Intervenant1" class="w3-hide w3-animate-zoom">
        <% Tutor tutor = DaoFactory.getDatastore().createQuery(Tutor.class).field("user").equal(t).get();%>
        <% for (Tutor.WaitingQueue waitingQueue : tutor.getWaitingqueue()) { %>
        <span class="w3-button w3-block w3-left-align"><%= waitingQueue.value.group.getGroupid()%></span>
        <%}%>

        <form class="w3-hide" action="${pageContext.request.contextPath}/intervention" id="addfile" method="post">
            <input type="hidden" name="do" value="request">
            <input type="hidden" name="tutor" value="<%= t.getId() %>">
            <input type="hidden" name="canal" value="2">
        </form>
        <span class="w3-button w3-block w3-left-align" onclick="document.getElementById('addfile').submit()">|+| Ajouter à la file</span>
    </div>
        <% }%>
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
