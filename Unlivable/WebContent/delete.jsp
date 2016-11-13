<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Unlivable: Confirmation</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="styles.css">
<link href="https://fonts.googleapis.com/css?family=Quicksand"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<body class="container">
	<div class="row">
		<div class="center">
			<h1>
				<span class="un">Un</span>livable: Confirmation
			</h1>
		</div>
	</div>
	<br>
	<div>${selectedPropertyKey} has been deleted.</div>
	<table>
		<tr>
			<td>
				<div class="submit-search">
					<form action="index.jsp">
						<input type="submit" value="Home" />
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>