
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>




<html>

<head>

    <title>CoffeList</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/script.js" />"></script>

</head>

<body>

<div class="lang"><spring:message code="label.lang"/> <a href="?language=en">English</a> | <a href="?language=ru">Russian</a></div>

<form method="post" modelAttribute="typeQuant" action="calculate-order" onsubmit="return validateForm()"   >

<table class="form-coffee">

    <th><spring:message code="coffee.name"/></th>
    <th><spring:message code="coffee.price"/></th>
    <th><spring:message code="coffe.quant"/></th>

    <c:forEach items="${coffees}"  var="coffee" varStatus="status">

        <tr>

            <td><input type="checkbox" path="types" name="types"  onclick="setDisabled()" value="${coffee.type_name}"/>${coffee.type_name}</td>
            <td>${coffee.price} TGR</td>
            <td><input  path="quantitys" name="quantitys" disabled="true" size="5"  /></td>

        </tr>

    </c:forEach>

</table>

    <div class="center error">
        <c:if test="${not empty error_code}">
            <c:out value="${error_code}"/>
        </c:if>
    </div>

<div class="center"><spring:message code="label.stock"/></div>

<div class="bt_center"><input type="submit" value=<spring:message code="coffee.add_bt"/> class="myButton" > </div>

</form>

</body>

</html>