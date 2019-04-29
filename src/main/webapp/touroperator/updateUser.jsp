<%@ include file="../header.jsp"%>
<html>
<head>
<title>Modifica Utente</title>
<style>
body {
	background-image:
		url("http://1.bp.blogspot.com/-FLsi6FOuXJ8/UHHBwqDTLNI/AAAAAAAAEG0/KTBA9VtfDl0/s1600/viaggio-a-Paris.gif");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	text-align: center;
	color: black;
}
</style>
<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>


.titolo {
color: balck;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
}
.body{
	text-align: center;



}
</style>

<%
	UserDTO updateUser = (UserDTO) request.getAttribute("userUpdate");
%>
</head>
<body>

		<div class="titolo">

			<p>Modifica Utente</p>

		</div>
			<div class="body">
		<br>
		<br>
		<form method="POST" action="/JspApp/TourOperatorServlet?richiesta=update">

			<%
				String selected = "selected=\"selected\"";
				String adminSelected = "";
				String boSelected = "";
				if (updateUser.getUsertype().equals("admin")) {
					adminSelected = selected;
				} else
					boSelected = selected;
			%>
			User type: <select style="width: 270px;" name="user_type">

				<option <%=adminSelected%> value="touroperator">TourOperator</option>
				<option <%=boSelected%> value="user">User</option>


			</select>
			<br>
			<input type="hidden" name="user_id" value="<%=updateUser.getUserId()%>" />
			<br>
			Username: <input type="text" size="40" maxlength="40" name="user_user" value="<%=updateUser.getUsername()%>" />
			<br>
			<br>
			Password: <input type="text" size="40" maxlength="40" name="user_pass" value="<%=updateUser.getPassword()%>" />
			<br>
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/JspApp/TourOperatorServlet?richiesta=UserManager&"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>
		
	</div>
</body>
</html>