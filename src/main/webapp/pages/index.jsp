<!DOCTYPE html>
<html>
<body>

	<div>
		<h2>Mapped to AddServlet</h2>
		<form action="add.jsp" method="get">
			
			Enter 1st number: <input type="text" name="num1"><br>
			Enter 2nd number: <input type="text" name="num2"><br>
			<input type="submit">
			
		</form>
		
		<form action="add.jsp" method="get">
			
			<input type="hidden" name="error" value="errorHasOccurred">
			<input type="submit" value="Trigger error page">
			
		</form>
		
		<form action="project.jsp" method="post">
			
			<input type="submit" value="Database page">
			
		</form>
	</div>
	<br>
	<div>
		<h2>Mapped to PostInfoServlet</h2>
		<form action="postInfo" method="post">
			
			<input type="submit">
			
		</form>
	</div>
		
</body>
</html>