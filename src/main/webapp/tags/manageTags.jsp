<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.TagsDTO"%>

<%
	List<TagsDTO> allTags = (List<TagsDTO>) request.getAttribute("allTagsDTO");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Hau Nguyen">
<meta name="keywords" content="au theme template">
<title>Gestione Utenti</title>
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
</head>
<body>

	<div class="titolo">

		<p>Gestione Tags</p>

	</div>
	<br>



	<br />
	<table style="margin:20px auto;" >
		<tr>
			<th>ID</th>
			<th>Nome Tag</th>
			<th>Attrazione</th>
		</tr>
		<%
		for (TagsDTO tags : allTags) {
		%>
		<tr>
			<td><%=tags.getIdtag()%></td>
			<td><%=tags.getNametag()%></td>
			<td><%=tags.getNameplacetag()%></td>
			<td class="center"><a href="/Tags/updateRedirect?id=<%=tags.getIdtag()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/Tags/delete?id=<%=tags.getIdtag()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/Tags/insertRedirect"><i class="fas fa-plus-circle fa-lg"> Nuovo Tag </i></a>

	<br>
	<br>
	<a href="/Tags/indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>