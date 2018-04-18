<%--
  Created by IntelliJ IDEA.
  User: Saurav Bhandari
  Date: 4/3/2018
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"><html>
<head>
    <title>Book List</title>
    <style type="text/css">
        html, body {
            height: 100%;
            padding: 0;
            margin: 0;
        }

        form {
            width: 30em;
            height: 9em;
            margin: -5em auto 0 auto;
            position: relative;
            top: 50%;
            border: 1px dotted #ccc;
            padding: .25em;
        }

        fieldset {
            margin: 0;
            border: 0;
            padding: 0;
        }

        legend {
            float: left;
            font-size: 200%;
            text-align: center;
            color: blue;
            font-weight: bold;
            border-bottom: 1px solid blue;
            width: 15em;
            padding: 0;
        }

        label, label + input {
            display: inline;
            float: left;
            margin-top: 1em;
        }

        label {
            text-align: right;
            width: 28%;
            clear: left;
            margin-top: .8em;
        }

        label + input {
            width: 60%;
            padding: .25em;;
            border: 1px inset;
            margin-left: 0;
        }

        #sub {
            margin-top: 1em;
            position: relative;
            float: left;
            clear: left;
            margin-left: 29%
        }

        #sub1 {
            margin-top: 1em;
            position: relative;
            float: left;
            clear: left;
            margin-left: 29%
        }
    </style>
</head>
<body>
${msg}
<form action="/login" method="post">
    <input type="hidden" name="action" value="login">
    <fieldset>
        <legend>Sign In</legend>
        <label for="name">Name: </label><input type="text" name="username" id="name">
        <label for="password">Password: </label><input type="password" name="password" id="password">
        <input type="submit" value="Login" id="sub">
    </fieldset>
</form>
<a href="\booklist">Book List</a>
</body>
</html>
