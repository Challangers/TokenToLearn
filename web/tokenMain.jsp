<%--
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
    <h3 class="w3-bar-item">Projet : Workshop 2</h3>
    <a href="#" class="w3-bar-item w3-button">Groupe 1</a>
    <a href="#" class="w3-bar-item w3-button">Groupe 2</a>
    <a href="#" class="w3-bar-item w3-button">Groupe 3</a>
    <div  class="w3-container w3-cell-bottom">
        <button class="w3-button w3-circle w3-amber">+</button>
        <button class="w3-button w3-circle w3-black">-</button>

</div>
</div>
<div style="margin-left:25%">
<div class="w3-container">
<%--<% for (Ad ad : (List<Ad>) pageContext.getRequest().getAttribute("ads")) { %>
    <jsp:param name="tutor" value="<%= ad.getTutorName() %>"/>
    <jsp:param name="tags" value="<%= ad.getTutorTags() %>"/>
<% } %>    --%>
    <div style= "margin-right:25%">
<h3>Token restant :</h3>
        </div>
    <div class="w3-container w3-amber">
    <button onclick="myFunction('Intervenant1')" class="w3-button w3-block w3-black w3-left-align">
        Intervenant 1</button>

    <div id="Intervenant1" class="w3-hide w3-animate-zoom">
    <a class="w3-button w3-block w3-left-align" href="#">Groupe 1</a>
        <a class="w3-button w3-block w3-left-align" href="#">Groupe 2</a>
        <a class="w3-button w3-block w3-left-align" href="#">|+| Ajouter à la file</a>
    </div>
        <button onclick="myFunction('Intervenant2')" class="w3-button w3-block w3-black w3-left-align">
            Intervenant 2</button>

        <div id="Intervenant2" class="w3-hide w3-animate-zoom">
            <a class="w3-button w3-block w3-left-align" href="#">Groupe 1</a>
            <a class="w3-button w3-block w3-left-align" href="#">Groupe 2</a>
            <a class="w3-button w3-block w3-left-align" href="#">|+| Ajouter à la file</a>
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
