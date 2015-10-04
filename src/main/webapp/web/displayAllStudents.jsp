<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title >All Students</title>
		<link rel="stylesheet" href="style.css" />	
</head>

<body>
   <nav class="navbar navbar-default">
	<div class="col-md-3 col-md-offset-3">
		<h4>All students</h4>

		<h4>There are ${totalStudent} Student in the college.</h4>
	</div>   
   </nav>
  <div class="container">
    
    </div>
	  <div class="container">
    
    </div>
      <div class="container">
    
    </div>
      <div class="container">
    
    </div>
	
	<div class="container">
	<div class="col-md-3 col-md-offset-3">
		<table>
			<tr>
				<th>Student Name</th>
				<th>Enrollment ID</th>

			</tr>

			<c:forEach items="${allStudents}" var="student">
				<tr>

					<td><a
						href="<c:url value="/displayStudentDetail.html">
									<c:param name="id" value="${student.id}"/>
								</c:url>">${student.name}
					</a></td>
					<td>${student.enrollmentID}</td>

				</tr>
			</c:forEach>

		</table>

	</div>
	
	</div>
    <div class="container">
    
    </div>
	  <div class="container">
    
    </div>
      <div class="container">
    
    </div>
      <div class="container">
    
    </div>
	<div class="container">
	<div class="col-md-3">
		<jsp:include page="/web/footer.jsp" />
	</div>
	</div>


</body>
</html>