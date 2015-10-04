<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>All Subjects</title>
		<link rel="stylesheet" href="style.css" />	
	</head>

	<body>
		<h1>All subjects</h1>
			

		<table>
			<tr>
				<th>Name</th>
				<th>Number of Semesters</th>
			</tr>
			
			<c:forEach items="${allSubjects}" var="subject">
				<tr>

					<td>
						<a href="<c:url value="/displaySubjectDetail.html">
									<c:param name="id" value="${subject.id}"/>
								</c:url>">${subject.subjectName}
						</a>
					</td>
					<td>${subject.numberOfSemesters}</td>
				</tr>
			</c:forEach>
			
	 	</table>
	 	
	 	<jsp:include page="/footer.jsp"/>
	</body>
</html>