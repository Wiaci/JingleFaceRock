<jsp:useBean id="point" scope="page" type="PointWork"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:p="http://primefaces.org/ui"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:f="http://xmlns.jcp.org/jsf/core"
      xmlns:a="http://xmlns.jcp.org/jsf/passthrough">
<head>
    <title>Title</title>
</head>
<body>
<h:form>
    <h:outputLabel value="X: "/>
    <p:spinner min="-5" max="5" value="${point.x}" onchange="setX(this.value)"/> <br/>

    <h:outputLabel value="Y: "/>
    <h:inputText id="ytext" value="#{point.y}" onchange="setY(this.value)"/>
    <span id="incorrect"/><br/>
</h:form>
</body>
</html>
