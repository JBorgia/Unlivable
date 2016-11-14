<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Unlivable: Review</title>
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
				<a href="index.jsp"><span class="un">Un</span>livable</a>: Review Entry
			</h1>
		</div>
	</div>
	<br>
	<div>
		<c:if test="${!empty property}">
			<div class="row">
				<div class="col-md-3">
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
				<div class="col-md-9">
					<table>
						<tr class="result-table">
							<c:if test="${!empty property.numOfFloors}">
								<td class="result-table"><div class="subtitle-result-right">#
										of Floors:</div>${property.numOfFloors}</td>
							</c:if>
							<c:if test="${!empty property.numOfBr}">
								<td class="result-table"><div class="subtitle-result-right">#
										of Bedrooms:</div>${property.numOfBr}</td>
							</c:if>
							<c:if test="${!empty property.numOfBa}">
								<td class="result-table"><div class="subtitle-result-right">#
										of Bathrooms:</div>${property.numOfBa}</td>
							</c:if>
							<c:if test="${!empty property.garageSpaces}">
								<td class="result-table"><div class="subtitle-result-right">#
										of Garage Spaces:</div>${property.garageSpaces}</td>
							</c:if>
							<c:if test="${!empty searchProperties.get(item).vaultedCeiling}">
								<td class="result-table"><div class="subtitle-result-right">High
										Ceilings</div></td>
							</c:if>
						</tr>
						<tr class="result-table">
							<c:if test="${!empty property.numOfFloors}">
								<td class="result-table"><div class="subtitle-result-right">Building
										SqFt:</div>${property.buildingSqft}</td>
							</c:if>
							<c:if test="${!empty property.landSqft}">
								<td class="result-table"><div class="subtitle-result-right">Land
										SqFt:</div>${property.landSqft}</td>
							</c:if>
							<c:if test="${!empty property.unlivableSqft}">
								<td class="result-table"><div class="subtitle-result-right">Unlivable
										SqFt:</div>${property.unlivableSqft}</td>
							</c:if>
							<c:if test="${!empty searchProperties.get(item).unlivableSqft}">
								<td class="result-table"><div class="subtitle-result-right">Unlivable:</div><fmt:formatNumber value="${searchProperties.get(item).unlivableSqft / searchProperties.get(item).buildingSqft}" type="percent" maxFractionDigits="2"/></td>
							</c:if>
						</tr>
					</table>
				</div>
			</div>
		</c:if>
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
			</tr>
		</table>
		<div class="col-sm-6"></div>
	</div>
</body>
</html>