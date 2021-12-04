<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <c:set var="income" scope="session" value="${10*8}"/>
        <c:out value="${income}"/>
    </body>
</html>