<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>All Students With no Tutor</title>
		<link rel="stylesheet" href="style.css" />	
	</head>

	<body>
		<h1>All students with no tutor</h1>
			
	 	<h1>There are  ${totalStudent} Student in the college.</h1>

		<table>
			<tr>
				<th>Name</th>
				<th>Enrollment ID</th>
				<th>Add Tutor</th>
				
			</tr>
			
			<c:forEach items="${allStudents}" var="student">
				<tr>
				
					<td>
						<a href="<c:url value="/displayStudentDetail.html">
									<c:param name="id" value="${student.id}"/>
								</c:url>">${student.name}
						</a>
					</td>
					<td>
						${student.enrollmentID}
					</td>
					
				</tr>
			</c:forEach>
			
	 	</table>
	 	
		<jsp:include page="/footer.jsp" />
	</body>
</html>