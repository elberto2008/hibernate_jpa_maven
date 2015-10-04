<html>

	<head>
		<title>Add a New Student</title>
		<link rel="stylesheet" href="style.css" />	
	</head>

	<body>
		<h1>Add a new Student</h1>
		
		<form method="POST" ACTION="addNewStudent.html">
			<p></p>
			<h2>Student's Credentials</h2>
			<p></p>
			<p><label>Name</label><input type="TEXT" NAME="name"/></p>
			<p></p>
			<h2>Student's Address</h2>
			<p></p>
			<p><label>Street</label><input type="TEXT" NAME="street"/></p>
			<p><label>City</label><input type="TEXT" NAME="city"/></p>
			<p><label>Zip</label><input type="TEXT" NAME="zip"/></p>
			

			<p><input type="SUBMIT" value="Add the Student" class="btn btn-default"/></p>
		</form>
		
		<jsp:include page="/footer.jsp"/>
	</body>
</html>