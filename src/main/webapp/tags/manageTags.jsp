<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Tag</title>
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
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>
.tabella {
font-color:black;
}


.titolo {
	color: balck;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
}
</style>
</head>
<%
	List<TagsDTO> AllTags = (List<TagsDTO>) request.getAttribute("AllTags");
%>
</head>
<body>

	<div class="titolo">

		<p>Gestione Tag</p>

	</div>

	<table style="margin:20px auto"; cellspacing=8;>
		<tr>
			<th>ID</th>
			<th>Tag</th>
			<th>Nome Monumento</th>
		</tr>
		<%
			for (TagsDTO tags : AllTags) {
		%>
		<tr>
			<td><%=tags.getIdTag()%></td>
			<td><%=tags.getName_tag()%></td>
			<td><%=tags.getName_place_tag()%></td>
			<td class="center"><a href="/JspApp/TagsServlet?richiesta=updateRedirect&id=<%=tags.getIdTag()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/JspApp/TagsServlet?richiesta=delete&id=<%=tags.getIdTag()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/JspApp/TagsServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> Nuovo Tag </i></a>

	<br>
	<br>
	<a href="/JspApp/TagsServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>