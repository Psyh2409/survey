<%--
  Created by IntelliJ IDEA.
  User: Psyh
  Date: 03-Nov-20
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.gmail.psyh2409.Questionnaire" %>
<%@ page import="java.util.List" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Survey</title>
</head>
<body>
<form action="/statistics" method="POST">
    First name: <input type="text" name="name"><br>
    Last name: <input type="text" surname="surname"><br>
    Your age: <input type="text" age="age"><br>
    <%List<String> statements = new Questionnaire().getAssertions();%>
    <%for(int i = 0; i < statements.size(); i++){%>
    <br/><h3><%=statements.get(i)%></h3>
    <br/><input type = "radio" name = "answer<%=String.valueOf(i)%>" value = "yes" /> Yes
    <br/><input type = "radio" name = "answer<%=String.valueOf(i)%>" value = "no" /> No
    <%}%>
    <br/>
    <br/><input type="submit" value="Send"> </input>
</form>
</body>
</html>
<%--------------------------------------------------------------------------------------------------------------------%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Survey</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>%s</h1>--%>
<%--<br/>--%>
<%--<form action="/">--%>
<%--    <input type="redirect" value="Go back!"/>--%>
<%--</form>--%>

<%--<form action="/" class="inline">--%>
<%--    <button class="float-left submit-button" >Home</button>--%>
<%--</form>--%>

<%--</body>--%>
<%--</html>--%>
