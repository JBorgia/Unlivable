<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Unlivable: Update</title>
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
				<span class="un">Un</span>livable: Update
			</h1>
		</div>
	</div>
	<form action="UpdateProperty.do">
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
						<button type="submit" name="choice" value="update">Update</button>
					</div>
				</td>
				<td>
					<div class="submit-search">
						<button type="submit" name="choice" value="delete">Delete</button>
					</div>
				</td>
			</tr>
		</table>
		<c:forEach items="${searchProperties.keySet()}" var="item">
			<br>
			<div class="row">
				<div class="col-md-4">
					<div>
						<table>
							<tr>
								<td class="result-table">
									<div class="compare-button">
										<input type="radio" style="vertical-align: middle"
											value="${item}" name="selectedPropertyKey">
									</div>
								</td>
								<td>
									<div>
										<table>
											<tr>
												<c:if
													test="${!empty searchProperties.get(item).address.streetNum}">
													<td class="result-table">
														<div class="subtitle-result">Address:</div>${searchProperties.get(item).address.streetNum}
														${searchProperties.get(item).address.nsew}
														${searchProperties.get(item).address.streetName}. <!-- </td> -->
														<c:if
															test="${!empty searchProperties.get(item).address.unit}">
															<!-- <td class="result-table"> -->
															<div class="subtitle-result-right">Unit:</div>${searchProperties.get(item).address.unit}
												</c:if>
													</td>
												</c:if>
										</table>
										<table>
											<tr class="result-table">
												<td class="result-table"><div class="subtitle-result">City:</div>${searchProperties.get(item).address.city}</td>
												<td class="result-table"><div
														class="subtitle-result-right">State:</div>${searchProperties.get(item).address.stateAbbr}</td>
												<td class="result-table"><div
														class="subtitle-result-right">ZIP:</div>${searchProperties.get(item).address.zip}</td>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="col-md-8">
					<table>
						<tr class="result-table">
							<c:if test="${!empty searchProperties.get(item).numOfBr}">
								<td class="result-table"><div class="subtitle-result-right">#
										of Bedrooms:</div>${searchProperties.get(item).numOfBr}</td>
							</c:if>
							<c:if test="${!empty searchProperties.get(item).numOfBa}">
								<td class="result-table"><div class="subtitle-result-right">#
										of Bathrooms:</div>${searchProperties.get(item).numOfBa}</td>
							</c:if>
							<c:if test="${!empty searchProperties.get(item).numOfFloors}">
								<td class="result-table"><div class="subtitle-result-right">#
										of Floors:</div>${searchProperties.get(item).numOfFloors}</td>
							</c:if>
							<c:if test="${!empty searchProperties.get(item).garageSpaces}">
								<td class="result-table"><div class="subtitle-result-right">#
										of Garage Spaces:</div>${searchProperties.get(item).garageSpaces}</td>
							</c:if>
						</tr>
						<tr class="result-table">
							<c:if test="${!empty searchProperties.get(item).numOfFloors}">
								<td class="result-table"><div class="subtitle-result-right">Building
										SqFt:</div>${searchProperties.get(item).buildingSqft}</td>
							</c:if>
							<c:if test="${!empty searchProperties.get(item).landSqft}">
								<td class="result-table"><div class="subtitle-result-right">Land
										SqFt:</div>${searchProperties.get(item).landSqft}</td>
							</c:if>
							<c:if test="${!empty searchProperties.get(item).vaultedCeiling}">
								<td class="result-table"><div class="subtitle-result-right">High
										Ceilings:</div>${searchProperties.get(item).vaultedCeiling}</td>
							</c:if>
							<c:if test="${!empty searchProperties.get(item).unlivableSqft}">
								<td class="result-table"><div class="subtitle-result-right">Unlivable
										SqFt:</div>${searchProperties.get(item).unlivableSqft}</td>
							</c:if>
							<c:if test="${!empty searchProperties.get(item).unlivableSqft}">
								<td class="result-table"><div class="subtitle-result-right">Unlivable:</div><fmt:formatNumber value="${searchProperties.get(item).unlivableSqft / searchProperties.get(item).buildingSqft}" type="percent" maxFractionDigits="2"/></td>
							</c:if>
						</tr>
					</table>
				</div>
			</div>
		</c:forEach>
	</form>
	<div class="col-md-6"></div>
</body>
</html>