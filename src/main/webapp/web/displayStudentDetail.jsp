<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Student's Details</title>
		<link rel="stylesheet" href="style.css" />	
	</head>

	<body>
		<h1>Student's Credentials</h1>
			

		<table>
			<tr>
				<th>Name</th>
				<th>Enrollment ID</th>
				
			</tr>
			<tr>
				<td>${student.name}</td>
				<td>${student.enrollmentID}</td>
			</tr>
	  </table>
			
		<h1>Student's Address</h1>			

		<table>
			<tr>
				<th>Street</th>
				<th>City</th>				
				<th>Zip Code</th>
				
			</tr>
			<tr>
				<td>${student.address.street}</td>
				<td>${student.address.city}</td>
				<td>${student.address.zipOrPostcode}</td>
			</tr>
	  </table>	<h1>Student's tutor information </h1>
		
		<c:if test="${student.supervisor == null}">
		
			<form method="GET" action="displayTutorsToSelectFrom.html" >
				<input type="hidden"  name ="id" value="${student.id}"/> 
				
				<input type="submit" value="Chose a tutor for this student">
			</form>
		</c:if>
		


		<table>
			<tr>
				<th>Name</th>
				<th>Staff ID</th>
		
			</tr>
			<tr>
				<td>${student.supervisor.name}</td>
				<td>${student.supervisor.staffId}</td>
			</tr>
	  </table>
	  
	  
	<h1>Student's subjects</h1>			
	  
	  <table>
			<tr>
				<th>Name</th>
				<th>#Semesters</th>
		
			</tr>
			
			<c:forEach items="${student.supervisor.subjectsQualifiedToTeach}" var="subject">
			<tr>
				<td>${subject.subjectName}</td>
				<td>${subject.numberOfSemesters}</td>
			</tr>
			</c:forEach>

	  </table>
	  
	  
	  <form method="POST" action="deleteStudent.html" >
				<input type="hidden"  name ="id" value="${student.id}"/> 
				
				<input type="submit" value="Delete this student">
	  </form>
	 	
		<jsp:include page="/web/footer.jsp" />
	</body>
</html>