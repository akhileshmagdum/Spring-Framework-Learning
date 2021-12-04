<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:forEach var="j" begin="1" end="3">
Item <c:out value="${j}"/><p>
    </c:forEach>
</body>
</html>