package com.demo.model;

public class HTML {
	
	private String htmlOut;

	public HTML (int selector) {
		System.out.println(selector);
		if(selector < 6) {
			this.htmlOut = """
					<!DOCTYPE html>
					<html>
					<head>
						<style>
							.container {
							  display: grid;
							  grid-template-columns: repeat(3, 1fr);
							  gap: 10px;
							}
							
							.item {
							  padding: 5px;
							  background-color: #1eaafc;
							  background-image: linear-gradient( 130deg, #6c52d9, #1eaafc 85%, #3edfd7);
							  border-radius: 4px;
							  border: 6px solid #171717;
							  box-shadow: 0 10px 20px rgb(0 0 0 / 19%), 0 6px 6px rgb(0 0 0 / 23%);
							  color: #fff;
							  aspect-ratio: 1/1;
							}
							
							input {
								margin-bottom: 5px;
							}	
								
						</style>
					</head>
					<body>
					
					<div class="container">
						<div class="item">
							<h2>Mapped to AddServlet</h2>
							<h3>Currently generated from add.jsp</h3>
							<form action="pages/add.jsp" method="get">
								
								Enter 1st number: <br><input type="text" name="num1"><br>
								Enter 2nd number: <input type="text" name="num2"><br>
								<input type="submit">
								
							</form>
							<br>
							<form action="pages/add.jsp" method="get">
								
								<input type="hidden" name="error" value="errorHasOccurred">
								<input type="submit" value="Trigger error page">
								
							</form>
						</div>
						<div class="item">
							<h2>Mapped to Project Servlet</h2>
							<h3>Generated by project.jsp file</h3>
							
							<form action="pages/project.jsp" method="post">
								
								<input type="submit" value="Database page">
								
							</form>
						</div>
						<div class="item">
							<h2>Mapped to PostInfoServlet</h2>
							<form action="postInfo" method="post">
								
								<input type="submit">
								
							</form>
						</div>
						<div class="item">
							<h2>Mapped to ModelView Servlet</h2>
							
							<form action="mvc" method="post">
								
								<input type="submit" value="Go to model view controller">
								
							</form>
						</div>
						<div class="item">
							<h2>Mapped to Filter Demo Servlet</h2>
							
							<form action="filterDemo" method="get">
								
								<input type="text" name="var1">
								<input type="text" name="var2">
								<input type="submit" value="Go to filterDemo">
								
							</form>
						</div>
	=				</div>
							
					</body>
					</html>
					""";
		}else {
			this.htmlOut = """
					<!DOCTYPE html>
					<html>
					<head>
						<style>
							.container {
							  display: grid;
							  grid-template-columns: repeat(3, 1fr);
							  gap: 10px;
							}
							
							.item {
							  padding: 5px;
							  background-color: #1eaafc;
							  background-image: linear-gradient( 130deg, #6c52d9, #1eaafc 85%, #3edfd7);
							  border-radius: 4px;
							  border: 6px solid #171717;
							  box-shadow: 0 10px 20px rgb(0 0 0 / 19%), 0 6px 6px rgb(0 0 0 / 23%);
							  color: #fff;
							  aspect-ratio: 1/1;
							}
							
							input {
								margin-bottom: 5px;
							}	
								
						</style>
					</head>
					<body>
					
					<div class="container">
						<div class="item">
							<h2>Mapped to AddServlet</h2>
							<h3>Currently generated from add servlet endpoint</h3>
							<form action="add" method="get">
								
								Enter 1st number: <br><input type="text" name="num1"><br>
								Enter 2nd number: <input type="text" name="num2"><br>
								<input type="submit">
								
							</form>
							<br>
							<form action="pages/add.jsp" method="get">
								
								<input type="hidden" name="error" value="errorHasOccurred">
								<input type="submit" value="Trigger error page">
								
							</form>
						</div>
						<div class="item">
							<h2>Mapped to Project Servlet</h2>
							<h3>Generated by project.jsp file</h3>
							
							<form action="pages/project.jsp" method="post">
								
								<input type="submit" value="Database page">
								
							</form>
						</div>
						<div class="item">
							<h2>Mapped to PostInfoServlet</h2>
							<form action="postInfo" method="post">
								
								<input type="submit">
								
							</form>
						</div>
						<div class="item">
							<h2>Mapped to ModelView Servlet</h2>
							
							<form action="mvc" method="post">
								
								<input type="submit" value="Go to model view controller">
								
							</form>
						</div>
						<div class="item">
							<h2>Mapped to Filter Demo Servlet</h2>
							
							<form action="filterDemo" method="get">
								
								<input type="text" name="var1">
								<input type="text" name="var2">
								<input type="submit" value="Go to filterDemo">
								
							</form>
						</div>
							
					</body>
					</html>
					""";
		}
		
	}

	public String getHtmlString() {
		return this.htmlOut;
	}
}
