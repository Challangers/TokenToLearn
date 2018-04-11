<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>TokenToLearn</title>

    <link rel="stylesheet" type="text/css" href="CSS/W3.css"/>
</head>

<body>

<form class="formDisplay" id="login" method="post" action="${pageContext.request.contextPath}/connection">
    <h1>Connexion</h1>

    <fieldset class="inputs">
        <input id="mail" name="mail" type="email" placeholder="Adresse mail" maxlength="64" autofocus required/>
        <input id="password" name="password" type="password" placeholder="Mot de passe" minlength="8" required/>
    </fieldset>

    <fieldset class="actions">
        <input type="submit" id="submit" value="Valider"/>
        <input type="reset" id="reset" value="Annuler"/>

        <a>Inscription</a>
    </fieldset>
</form>
</body>
</html>