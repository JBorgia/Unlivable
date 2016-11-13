<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Unlivable: Modify</title>
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
				<span class="un">Un</span>livable: Modify
			</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div>
				<form action="ModifyProperty.do" method="POST">
					<div>Modifying property ${selectedPropertyKey} . . .</div>
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
					<div>Address:</div>
					<table>
						<tr>
							<td class="field"><input type="text" name="streetNum"
								value="${property.address.streetNum}" /></td>
							<td>
								<table>
									<tr>
										<td class="field"><select name="nsew" class="drop">
												<option value="${property.address.nsew}" selected="selected">N/A</option>
												<option value="N">N</option>
												<option value="S">S</option>
												<option value="E">E</option>
												<option value="W">W</option>
												<option value="NW">NW</option>
												<option value="NE">NE</option>
												<option value="SE">SW</option>
												<option value="SW">SE</option>
										</select></td>
										<td class="field"><input type="text" name="streetName"
											value="${property.address.streetName}" /></td>
									</tr>
								</table>
							</td>
							<td class="field"><input type="text" name="unit"
								value="${property.address.unit}" /></td>
						</tr>
						<tr>
							<td class="subtitle-left">Address Number</td>
							<td class="subtitle-center">Street Name</td>
							<td class="subtitle-center">Unit</td>
						</tr>
					</table>
					<table>
						<tr>
							<td class="field"><input type="text" name="city"
								value="${property.address.city}" /></td>
							<td class="field"><select name="stateAbbr" class="drop">
									<option value="${property.address.stateAbbr}"
										selected="selected">N/A</option>
									<option value="AL">AL</option>
									<option value="AK">AK</option>
									<option value="AZ">AZ</option>
									<option value="AR">AR</option>
									<option value="CA">CA</option>
									<option value="CO">CO</option>
									<option value="CT">CT</option>
									<option value="DE">DE</option>
									<option value="FL">FL</option>
									<option value="GA">GA</option>
									<option value="HI">HI</option>
									<option value="ID">ID</option>
									<option value="IL">IL</option>
									<option value="IN">IN</option>
									<option value="IA">IA</option>
									<option value="KS">KS</option>
									<option value="KY">KY</option>
									<option value="LA">LA</option>
									<option value="ME">ME</option>
									<option value="MD">MD</option>
									<option value="MA">MA</option>
									<option value="MI">MI</option>
									<option value="MN">MN</option>
									<option value="MS">MS</option>
									<option value="MO">MO</option>
									<option value="MT">MT</option>
									<option value="NE">NE</option>
									<option value="NV">NV</option>
									<option value="NH">NH</option>
									<option value="NJ">NJ</option>
									<option value="NM">NM</option>
									<option value="NY">NY</option>
									<option value="NC">NC</option>
									<option value="ND">ND</option>
									<option value="OH">OH</option>
									<option value="OK">OK</option>
									<option value="OR">OR</option>
									<option value="PA">PA</option>
									<option value="RI">RI</option>
									<option value="SC">SC</option>
									<option value="SD">SD</option>
									<option value="TN">TN</option>
									<option value="TX">TX</option>
									<option value="UT">UT</option>
									<option value="VT">VT</option>
									<option value="VA">VA</option>
									<option value="WA">WA</option>
									<option value="WV">WV</option>
									<option value="WI">WI</option>
									<option value="WY">WY</option>
							</select></td>
							<td class="field"><input type="text" name="zip"
								value="${property.address.zip}" /></td>
						</tr>
						<tr>
							<td class="subtitle-left">City</td>
							<td class="subtitle-state">State</td>
							<td class="subtitle-center">ZIP</td>
						</tr>
					</table>
					<br>
					<table>
						<tr>
							<div>Unlivable metrics:</div>
						</tr>
						<tr>
							<td class="field"><input type="number" name="numOfFloors"  value="${property.numOfFloors}"/></td>
							<td class="field"><input type="number" name="numOfBa"   value="${property.numOfBa}"/></td>
							<td class="field"><input type="text" name="numOfBr"   value="${property.numOfBr}"/></td>
							<td class="field"><input type="number" name="garageSpaces"   value="${property.garageSpaces}"/></td>
						</tr>
						<tr>
							<td class="subtitle-left"># of Floors</td>
							<td class="subtitle-center"># of Bedrooms</td>
							<td class="subtitle-center"># of Bathrooms</td>
							<td class="subtitle-center"># of Garage Spaces</td>
						</tr>
					</table>
					<table>
						<tr>
							<td class="field"><input type="text" name="landSqft"  value="${property.landSqft}"/></td>
							<td class="field"><input type="text" name="buildingSqft"  value="${property.buildingSqft}"/></td>
							<td class="field"><input type="text" name="unlivableSqft"  value="${property.unlivableSqft}"/></td>
						</tr>
						<tr>
							<td class="subtitle-left">Land SqFt.</td>
							<td class="subtitle-center">Building SqFt.</td>
							<td class="subtitle-center">Unlivable Space</td>
						</tr>
					</table>
					<table>
						<tr>
							<td class="result-table"><div id="ceiling-checkbox">
									<input type="checkbox" name="vaultedCeiling" value="TRUE" />
								</div>
								<div class="subtitle-center-top">Is the regular ceiling
									height greater than 8ft?</div></td>
						</tr>
					</table>
					<c:forEach items="${property.bedrooms}" var="bedroom"
						varStatus="bedroomLoop">
						<table>
							<tr class="result-table">
								<td class="result-table">
									<div class="bed-buffer">
										Bedroom
										<c:out value="${bedroomLoop.index+1}" />
									</div>
								</td>
							</tr>
							<tr class="result-table">
								<td class="result-table">
									<div id="ceiling-checkbox">
										<c:choose>
											<c:when test="${bedroom.attachedBa='TRUE'}">
												<input type="checkbox" name="attachedBa" value="TRUE"
													checked />
											</c:when>
											<c:otherwise>
												<input type="checkbox" name="attachedBa" value="TRUE" />
											</c:otherwise>
										</c:choose>
									</div>
									<div class="subtitle-br-button">Attached Bath</div>
								</td>
								<td class="result-table">
									<div id="ceiling-checkbox">
										<c:choose>
											<c:when test="${bedroom.closet='TRUE'}">
												<input type="checkbox" name="closet" value="TRUE"
													checked />
											</c:when>
											<c:otherwise>
												<input type="checkbox" name="closet" value="TRUE" />
											</c:otherwise>
										</c:choose>
									</div>
									<div class="subtitle-br-button">Closet</div>
								</td>
							</tr>
						</table>
						<table>
							<tr>
								<td class="field"><input type="text" name="bedroomSqft"
									value="${bedroom.bedroomSqft}" /></td>
								<td class="field"><input type="text" name="closetSqft"
									value="${bedroom.closetSqft}" /></td>
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
									<input type="submit" value="Save">
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