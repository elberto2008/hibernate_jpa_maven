<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Tutor Detail</title>
		<link rel="stylesheet" href="style.css" />	
	</head>

	<body>
		<h1>Staff Member: ${tutor.name}</h1>
			
		<p>Salary: ${tutor.salary}</p>
		<p>Staff ID: ${tutor.staffId}</p>
		
		<h2>Students supervised by this tutor:</h2>
		
		<table>
			<tr>
				<th>Name</th>
				<th>Address</th>
			</tr>
			
			<c:forEach items="${tutor.supervisionGroup}" var="student">
				<tr>
					<td>${student.name}</td>
					<td>${student.address}</td>
				</tr>
			</c:forEach>
			
	 	</table>
	 	
	 	
	 	
	 	
	 			 	
	 	<h2>Subject taught by this tutor:</h2>
		
		<table>
			<tr>
				<th>Name</th>
				<th>Semesters</th>
			</tr>
			
			<c:forEach items="${tutor.subjectsQualifiedToTeach}" var="subject">
				<tr>
					<td>${subject.subjectName}</td>
					<td>${subject.numberOfSemesters}</td>
				</tr>
			</c:forEach>
			

	 	</table>
		
		
		
			<form method="GET" action="displaySubjectsToSelectFrom.html" >
				<input type="hidden"  name ="id" value="${tutor.id}"/> 
				
				<input type="submit" value="Chose a subject for this tutor">
			</form>
		
	 	<form method="POST" action="deleteTutor.html" >
				<input type="hidden"  name ="id" value="${tutor.id}"/> 
				
				<input type="submit" value="Delete this Tutor">
	  </form>
	 	

	 	
	 	
		<jsp:include page="/footer.jsp" />
	</body>
</html>