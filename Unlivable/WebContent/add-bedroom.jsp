<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Unlivable: Bedroom Information</title>
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
			<h1><span class="un">Un</span>livable: Bedroom Information</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div>
				<form action="AddPropertyBedroom.do" method="POST">
					<table>
						<tr>
							<div>Please enter the bedroom information for the property</div>
							<div class="description">
								Bedroom features are another aspect of property layout important
								for comparisons. <br>Please enter them when available.
							</div>
						</tr>
					</table>
					<c:forEach items="${property.bedrooms}" var="bedroom" varStatus="bedroomLoop">
						<table>
							<tr class="result-table">
								<td class="result-table">
									<div class="bed-buffer">Bedroom <c:out value="${bedroomLoop.index+1}" /></div>
								</td>
							</tr>
							<tr class="result-table">
								<td class="result-table">
									<div id="ceiling-checkbox">
										<input type="checkbox" name="attachedBa" value="TRUE" />
									</div>
									<div class="subtitle-br-button">Attached Bath</div>
								</td>
								<td class="result-table">
									<div id="ceiling-checkbox">
										<input type="checkbox" name="closet" value="TRUE" />
									</div>
									<div class="subtitle-br-button">Closet</div>
								</td>
							</tr>
						</table>
						<table>
							<tr>
								<td class="field"><input type="text" name="bedroomSqft"
									value="0" /></td>
								<td class="field"><input type="text" name="closetSqft"
									value="0" /></td>
							</tr>
							<tr>
								<td class="subtitle-left">Bedroom SqFt</td>
								<td class="subtitle-left">Closet SqFt</td>
							</tr>
						</table>
					</c:forEach>
					<table>
						<tr>
							<td>
								<div class="submit-search">
									<input type="submit" />
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="col-md-6"></div>
	</div>
</body>
</html>