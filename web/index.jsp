<%-- Created by IntelliJ IDEA. --%>
<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>TokenToLearn</title>

    <link rel="stylesheet" type="text/css" href="CSS/W3.css"/>


</head>
<form class="formDisplay" id="login" method="post" action="${pageContext.request.contextPath}/connection">
<body>



    <div class="w3-panel w3-black">
        <h1>Connexion</h1>
    </div>

    <div class="w3-panel w3-black">
        <div class="w3-panel w3-border w3-round w3-padding-large">
        <fieldset class="inputs">
            <input id="mail" name="mail" type="email" placeholder="Adresse mail" maxlength="64" autofocus required/>
            <input id="password" name="password" type="password" placeholder="Mot de passe" minlength="8" required/>
        </fieldset>
        </div>

        <div class="w3-panel w3-border w3-round w3-padding-large">
        <fieldset class="actions">
            <input type="submit" id="submit" value="Valider"/>
            <input type="reset" id="reset" value="Annuler"/>

            <a>Inscription</a>
        </fieldset>
        </div>
    </div>

</form>
</body>
</html>
--%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}
        form {border: 3px solid #f1f1f1;}

        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        button {
            background-color: #ffc107;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            opacity: 0.8;
        }

        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }

        .container {
            padding: 16px;
        }

        span.psw {
            float: right;
            padding-top: 16px;
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }
            .cancelbtn {
                width: 100%;
            }
        }
    </style>
</head>
<body>
<title>TokenToLearn connexion</title>
<div style="margin-left:25%">
  <div  style ="margin-right:25%">
<h2>Connexion</h2>

<form class="formDisplay" id="login" method="post" action="${pageContext.request.contextPath}/connection">

    <div class="container">
        <b>Username</b>
        <input name="mail" type="text" placeholder="Adresse mail" maxlength="64" autofocus required/>

        <b>Mot de passe</b>
        <input id="password" name="password" type="password" placeholder="Mot de passe" minlength="8" required/>

        <button type="submit">Login</button>
        <label>
            <input type="checkbox" checked="checked" name="Remember me">se rappeler pour la prochaine fois
        </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
</form>
</div>
</div>
</body>
</html>
