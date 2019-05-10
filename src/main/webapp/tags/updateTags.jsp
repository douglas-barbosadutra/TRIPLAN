<%@ include file="../header.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.TagsDTO"%>

<html>
<head>
<title>Modifica Tag</title>
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
color: black;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
}
.body{
	text-align: center;



}
</style>

<%
	TagsDTO updateTags = (TagsDTO) request.getAttribute("tagsUpdate");
%>
</head>

<body>

		<div class="titolo">

			<p>Modifica Tag</p>

		</div>
			<div class="body">
		<br>
		<br>
		<form method="POST" action="/Tags/update">
			<br>
			<input type="hidden" name="idtag" value="<%=updateTags.getIdtag()%>" />
			<br>
			Nome Tag: <input type="text" size="40" maxlength="40" name="nametag" value="<%=updateTags.getNametag()%>" />
			<br>
			<br>
			Attrazione: <input type="text" size="40" maxlength="40" name="nameplacetag" value="<%=updateTags.getNameplacetag()%>" />
			<br>
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/Tags/indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>
		
	</div>
</body>
</html>