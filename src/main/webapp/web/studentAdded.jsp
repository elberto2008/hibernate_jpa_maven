<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Student Added</title>
		<link rel="stylesheet" href="style.css" />	
	</head>
	<body>
		<h1>New Student Added</h1>
		
		<p>Thank you, we now have a new student with Enrollment ID of ${enrollementID}</p>
		
		<jsp:include page="/web/footer.jsp" />
		
	</body>
</html>