<%--
  Created by IntelliJ IDEA.
  User: cleme
  Date: 11/04/2018
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="CSS/W3.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
    <title>Nouveau Projet</title>
</head>
<div class="w3-container w3-center">

</div>
<body>

<form action="/action_page.php" class="w3-container w3-card-4 w3-light-grey w3-text-black w3-margin">
    <h2 class="w3-center">Nouveau Projet</h2>

        <h2>List des étudiants</h2>
    <div class="w3-panel w3-border">
        <table class="w3-table-all w3-hoverable">
            <thead>
            <tr class="w3-light-grey">
                <th>Nom</th>
                <th>Prénom</th>
                <th> </th>
            </tr>
            </thead>
            <tr>
                <td>bernard</td>
                <td>albert</td>
                <td><input class="w3-check" type="checkbox">
                    <label> </label></td>
            </tr>
            <tr>
                <td>michou</td>
                <td>gilbert</td>
                <td><input class="w3-check" type="checkbox">
                    <label> </label></td>
            </tr>
            <tr>
                <td>jean mi</td>
                <td>dupont</td>
                <td><input class="w3-check" type="checkbox">
                    <label> </label></td>
            </tr>
        </table>

    <div class="w3-row w3-section">
        <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-pencil"></i></div>
        <div class="w3-rest">
            <input class="w3-input w3-border" name="ProjectName" type="text" placeholder="Nom du projet">
        </div>
    </div>

    <div class="w3-row w3-section">
        <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
        <div class="w3-rest">
            <input class="w3-input w3-border" name="first" type="text" placeholder="Nom de l'intervenant">
        </div>
    </div>

    <div class="w3-row w3-section">
        <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-hashtag"></i></div>
        <div class="w3-rest">
            <input class="w3-input w3-border" name="last" type="text" placeholder="Tags">
        </div>
    </div>

    <div class="w3-row w3-section">
        <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa chevron-circle-left"></i></div>
        <div class="w3-rest">
            <input class="w3-input w3-border" name="tokenNumber" type="number" placeholder="Nombre de token par groupe">
        </div>
    </div>
    </div>
    <button class="w3-button w3-block w3-section w3-amber w3-ripple w3-padding">Créer</button>

</form>

</body>
</html>
