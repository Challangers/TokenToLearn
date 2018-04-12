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
<link rel="stylesheet" type="text/css" href="css/W3.css"/>
<head>
    <title>Token to learn</title>

</head>
<body>
<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
    }

    /* The Modal (background) */
    .modal {
        display: none; /* Hidden by default */
        position: fixed; /* Stay in place */
        z-index: 1; /* Sit on top */
        padding-top: 100px; /* Location of the box */
        left: 0;
        top: 0;
        width: 100%; /* Full width */
        height: 100%; /* Full height */
        overflow: auto; /* Enable scroll if needed */
        background-color: rgb(0, 0, 0); /* Fallback color */
        background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
    }

    /* Modal Content */
    .modal-content {
        background-color: #fefefe;
        margin: auto;
        padding: 20px;
        border: 1px solid #888;
        width: 80%;
    }

    /* The Close Button */
    .close {
        color: #aaaaaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close:hover,
    .close:focus {
        color: #000;
        text-decoration: none;
        cursor: pointer;
    }
</style>
<div class="w3-sidebar w3-light-grey w3-bar-block" style="width:25%">
    <% String projectName = (String) pageContext.getRequest().getAttribute("projectName"); %>
    <h3 class="w3-bar-item">Projet : <%= projectName %>
    </h3>
    <% for (Group g : (List<Group>) pageContext.getRequest().getAttribute("groups")) { %>
    <a href="#" class="w3-bar-item w3-button"><%= g.getGroupid() %>
    </a>
    <% } %>
    <div class="w3-container w3-cell-bottom">
        <button class="w3-button w3-circle w3-amber">+</button>
        <button class="w3-button w3-circle w3-black">-</button>

    </div>
</div>
<div style="margin-left:25%">
    <div class="w3-container">
        <% Group groupStudent = (Group) pageContext.getRequest().getAttribute("groupStudent");%>
        <a><%= groupStudent.getGroupid() %>
        </a>
        <div style="margin-right:25%">
            <h3>Token restant : <%= groupStudent.getToken() %>
            </h3>
        </div>
        <div class="w3-container w3-amber">
            <% for (User t : (List<User>) pageContext.getRequest().getAttribute("tutors")) { %>
            <button onclick="myFunction('Intervenant1')"
                    class="w3-button w3-block w3-black w3-left-align"><%= t.getId() %>
            </button>

            <div id="Intervenant1" class="w3-hide w3-animate-zoom">
                <% Tutor tutor = DaoFactory.getDatastore().createQuery(Tutor.class).field("user").equal(t).get();%>
                <% for (Tutor.WaitingQueue waitingQueue : tutor.getWaitingqueue()) { %>
                <span class="w3-button w3-block w3-left-align"><%= waitingQueue.value.group.getGroupid()%> (<%= waitingQueue.value.canal.name().toLowerCase() %>)</span>
                <%}%>

                <form class="w3-hide" action="${pageContext.request.contextPath}/intervention" id="addfile"
                      method="post">
                    <input type="hidden" name="do" value="request">
                    <input id="tutor-id" type="hidden" name="tutor" value="<%= t.getId() %>">
                    <input id="canal-val" type="hidden" name="canal" value="2">
                </form>
                <span class="w3-button w3-block w3-left-align" onclick="addfile('<%= t.getId() %>')">|+| Ajouter à la file</span>
            </div>
            <% }%>
        </div>
    </div>
</div>


<!-- The Modal -->
<div id="myModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <p>Etes vous sur de vous ajouter à la file d'intervention de <span id="interv"></span> ?</p>
        <span id="close" class="w3-button w3-block w3-left-align">Non &times;</span> <span id="direct"
                                                                                           class="w3-button w3-block w3-left-align">Intervention directe</span>
        <span id="discord" class="w3-button w3-block w3-left-align">Intervention Discord</span>
    </div>

</div>

<script>
    function myFunction(id) {
        var x = document.getElementById(id);
        if (x.className.indexOf("w3-show") === -1) {
            x.className += " w3-show";
        } else {
            x.className = x.className.replace(" w3-show", "");
        }
    }


    function addfile(name) {
        document.getElementById('myModal').style.display = 'block';
        document.getElementById('tutor-id').value = name;
        document.getElementById('interv').innerText = name;
    }

    document.getElementById('close').onclick = () => {
        document.getElementById('myModal').style.display = 'none';
    };

    document.getElementById('direct').onclick = () => {
        document.getElementById('canal-val').value = 1;
        document.getElementById("addfile").submit();
    };

    document.getElementById('discord').onclick = () => {
        document.getElementById('canal-val').value = 2;
        document.getElementById("addfile").submit();
    };
</script>
</body>
</html>
