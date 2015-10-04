<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

	<head>
		<title>All Subject To Select From</title>
		<link rel="stylesheet" href="style.css" />	
	</head>

	<body>
		<h1>All Subjects to select from</h1>
		
		<table align="center">
			<tr>
				<th>Choose Subject</th>
				<th>#Semesters</th>
			</tr>
			
			<c:forEach items="${allSubjects}" var="subject">
				<tr>
					<td>
					
						<form method="POST" action="addSubject.html" >
							
							<input type="hidden"  name ="tutorId" value="${tutorID}"/> 
							<input type="hidden"  name ="subjectId" value="${subject.id}"/> 
							
							<input type="submit" value="${subject.subjectName}">
						</form>	

					</td>
					<td>${subject.numberOfSemesters}</td>
					
				</tr>
			</c:forEach>
	 	</table>
		<jsp:include page="/web/footer.jsp" />
	</body>
</html>