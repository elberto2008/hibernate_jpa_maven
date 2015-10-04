<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

	<head>
		<title>All Tutors</title>
		<link rel="stylesheet" href="style.css" />	
	</head>

	<body>
		<h1>All Tutors in the College</h1>
		
		<table align="center">
			<tr>
				<th>Name</th>
				<th>Salary</th>
			</tr>
			
			<c:forEach items="${allTutors}" var="tutor">
				<tr>
					<td>
						<a href="<c:url value="/displayTutorDetail.html">
									<c:param name="id" value="${tutor.id}"/>
								</c:url>">${tutor.name}
						</a>
					</td>
					<td>${tutor.salary}</td>
				</tr>
			</c:forEach>
	 	</table>
	 	<p> The total salary bill is ${totallSalaryBill}.</p>
		<jsp:include page="/web/footer.jsp" />
	</body>
</html>