<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

	<head >
		<title>All Tutors To Select From</title>
		<link rel="stylesheet" href="style.css" />	
	</head>

	<body >
	
	<div align="center">
	
		<h1>All Tutors to select from</h1>
		
		<table align="center">
			<tr>
				<th>Choose Tutor</th>
				<th>Staff ID</th>
				<th>#Supervision Group</th>
			</tr>
			
			<c:forEach items="${allTutors}" var="tutor">
				<tr>
					<td>
					
						<form method="POST" action="addStudent.html" >
							
							<input type="hidden"  name ="studentId" value="${studentID}"/> 
							<input type="hidden"  name ="tutorId" value="${tutor.id}"/> 
							
							<input type="submit" value="${tutor.name}">
						</form>	

					</td>
					<td>${tutor.staffId}</td>
					<td>${tutor.supervisionGroup.size()}</td>
					
				</tr>
			</c:forEach>
	 	</table>
		<jsp:include page="/web/footer.jsp" />
		
		</div>
	</body>
</html>