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
	<div>Are you sure you want to delete this property? This action
		cannot be undone.</div>
	<div id="pad-modify-address">
		<table>
			<tr>
				<td class="result-table"><c:if
						test="${!empty property.address.streetNum}">
						<div class="subtitle-result">Address:</div>${property.address.streetNum}
													${property.address.nsew} ${property.address.streetName}.
												</c:if> <c:if test="${!empty property.address.unit}">
						<div class="subtitle-result-right">Unit:</div>${property.address.unit}
											</c:if></td>

				<tr class="result-table">
								<td class="result-table"><div class="subtitle-result">City:</div>${property.address.city}</td>
								<td class="result-table"><div class="subtitle-result-right">State:</div>${property.address.stateAbbr}</td>
								<td class="result-table"><div class="subtitle-result-right">ZIP:</div>${property.address.zip}</td>
						
		</table>
					</div>
	<table>
					<tr>
					<td>
				<div class="submit-search">
					<form action="index.jsp">
						<a href="index.jsp"><input type="button" name="choice"
										value="Home" /></a>
					</form>
				</div>
			</td>
			<td>
				<div class="submit-search">
					<form action="DeleteProperty.do">
						<input type="button" name="choice" value="Delete" />
					</form>
				</div>
			</td>
		</tr>
	</table>


		
		
			</body>
</html>