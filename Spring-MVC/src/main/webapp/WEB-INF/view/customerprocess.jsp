<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Captain
  Date: 31-08-2021
  Time: 09:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Processed Form</title>
</head>
<body>
Customer ${customer.firstName} ${customer.lastName} is registered to the shop.
and the card points are ${customer.cardPoints}
With customer id ${customer.customerIdentity}
</body>
</html>
