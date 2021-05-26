<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title> luv 2 code company Home page</title>
</head>
<body>
<h2>luv 2 code company Home page </h2>
<hr>
<p>
Welcome to luv2code company home page!
</p>

<!--  Add Logout button -->

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout">

</form:form>
</body>

</html>