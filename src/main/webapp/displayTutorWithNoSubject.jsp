<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>All Tutors With no Subject</title>
		<link rel="stylesheet" href="style.css" />	
	</head>

	<body>
		<h1>All tutors with no subject</h1>
			
	 	<h1>There are  ${totalSubjects} tutors with no student.</h1>

		<table>
			<tr>
				<th>Name</th>
				<th>Staff ID</th>
				<th>Add Subject</th>
				
			</tr>
			
			<c:forEach items="${allTutors}" var="tutor">
				<tr>
				
					<td>
						<a href="<c:url value="/displayTutorDetail.html">
									<c:param name="id" value="${tutor.id}"/>
								</c:url>">${tutor.name}
						</a>
					</td>
					<td>
						${tutor.staffId}
					</td>
					
				</tr>
			</c:forEach>
			
	 	</table>
	 	
		<jsp:include page="/footer.jsp" />
	</body>
</html>