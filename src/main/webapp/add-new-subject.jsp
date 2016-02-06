<html>

	<head>
		<title>Add a New Tutor</title>
		<link rel="stylesheet" href="style.css" />	
	</head>

	<body>
		<h1>Add a new Tutor</h1>
		
		<form method="POST" ACTION="addNewSubject.html">
			<p><label>Name</label><input type="TEXT" NAME="name"/></p>
			<p><label>#Semesters</label><input type="TEXT" NAME="numberOfSemesters"/></p>

			<p><input type="SUBMIT" value="Add the Subject" class="button"/></p>
		</form>
		
		<jsp:include page="/footer.jsp"/>
	</body>
</html>