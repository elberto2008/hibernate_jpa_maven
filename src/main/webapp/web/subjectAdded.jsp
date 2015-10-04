<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Subject Added</title>
		<link rel="stylesheet" href="style.css" />	
	</head>
	<body>
		<h1>New Subject Added</h1>
		
		<p>Thank you, we now have a new subject with name  of ${name}</p>
		
	 	<jsp:include page="/footer.jsp"/>
		
	</body>
</html>