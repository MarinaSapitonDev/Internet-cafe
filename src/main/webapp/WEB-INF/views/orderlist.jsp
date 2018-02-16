
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>Title</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/valid.js" />"></script>

</head>

<body>

<table class="ord_result">
    <th><spring:message code="coffee.name"/></th>
    <th><spring:message code="coffee.price"/></th>
    <th><spring:message code="coffe.quant"/></th>
    <th><spring:message code="label.result"/></th>

    <c:forEach items="${values}" var="value" >

        <tr>
            <td>${value.type}</td>
            <td>${value.price}TGR</td>
            <td>${value.quantity}</td>
            <td>${value.result}</td>
        </tr

    </c:forEach>

    <tr><td></td><td></td><td><spring:message code="label.sum"/></td><td>${allPrice}</td></tr>
    <tr><td></td><td></td><td><spring:message code="label.delivery"/></td><td>${delivery}</td></tr>
    <tr> <td></td><td></td><td><spring:message code="label.result"/></td><td>${result}</td></tr>

</table>

<form:form method="post" modelAttribute="order" action="add-order" id="formConfirm" onsubmit="return validAddress()"  >

<table class="form-coffee w"  >

    <th><spring:message code="label.delivery"/></th>
    <tr>
        <td><spring:message code="label.fulName"/></td>
        <td><form:input path="name"  name ="FIO" size="25"/></td>
    </tr>

    <tr>
        <td><spring:message code="label.address"/></td>
        <td><form:input path="delivery_address"  id = "Address"  size="25" /></td>
        <td><form:errors path="delivery_address" cssClass="error" /></td>
    </tr>

</table>

    <div class="bt_center"><input type="submit"  value=<spring:message code="coffee.order_bt" /> class="myButton" >  </div>
  <div class="center"> <a href="/" > <spring:message code="label.back"/></a></div>
</form:form>


</body>

</html>
