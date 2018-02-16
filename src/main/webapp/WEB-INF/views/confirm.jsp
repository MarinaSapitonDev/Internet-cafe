
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div class="t_confirm"><spring:message code="label.confirmH"/></div>
<div class="t_confirm small_t"><spring:message code="label.confirmText"/></div>

<div class="center"> <a href="/" ><spring:message code="label.back"/></a></div>
</body>
</html>
