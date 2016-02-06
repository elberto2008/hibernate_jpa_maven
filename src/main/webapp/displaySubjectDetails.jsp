<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Subject's Details</title>
		<link rel="stylesheet" href="style.css" />	
	</head>

	<body>
		<h1>Subject's details</h1>
			

		<table>
			<tr>
				<th>Name</th>
				<th>#Semesters</th>
				
			</tr>
			<tr>
			
				<td>${subject.subjectName}</td>
				<td>${subject.numberOfSemesters}</td>
			</tr>
	  </table>
			
		<h1>Tutor qualified to teach this subject</h1>			

		<table>
			<tr>
				<th>Name</th>
				<th>Staff ID</th>								
			</tr>
			<c:forEach items="${subject.qualifiedTutors}" var="tutor">
				<tr>
					<td>${tutor.name}</td>
					<td>${tutor.staffId}</td>
				</tr>
			</c:forEach>
		
	  </table>	
	  
	  <h1>Student registered for this subject</h1>
	  
	  
	  
		<table>
			<tr>
				<th>Name</th>
				<th>Enrollment ID</th>								
			</tr>
		
	  </table>	
	  
	  
	  <form method="POST" action="deleteSubject.html" >
				<input type="hidden"  name ="id" value="${subject.id}"/> 
				
				<input type="submit" value="Delete this subject">
	  </form>
	 	
		<jsp:include page=/footer.jsp" />
	</body>
</html>