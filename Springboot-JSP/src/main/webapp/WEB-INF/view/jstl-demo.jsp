<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <c:catch var="expToCatch"/>
        <% int x = 10/0; %>
        <c:catch/>

    <c:if test="${expToCatch != null}">
        <p>the exception is ${expToCatch}<br/>
        and message ${expToCatch.message}</p>
    </c:if>
    </body>
</html>