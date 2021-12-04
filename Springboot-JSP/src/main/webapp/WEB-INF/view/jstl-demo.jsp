<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:forTokens items="Rahul-Nakul-Rajesh" delims="-" var="name">
<c:out value="${name}"/><p>
    </c:forTokens>
</body>
</html>