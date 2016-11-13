<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Unlivable: Property Details</title>
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
			<h1><span class="un">Un</span>livable: Property Details</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div>
				<form action="AddPropertyDetails.do" method="POST">
					<table>
						<tr>
							<div>Please enter the unlivable information for the
								property you wish to add.</div>
							<div class="description">Unlivable space includes stairs,
								hallways, landings, and areas included in total square-footage
								that is connective and non-dwelling. Each flight of stairs
								belongs to only one floor and should be counted only once.</div>
						</tr>
						<tr>
							<td class="field"><input type="number" name="numOfFloors" /></td>
							<td class="field"><input type="number" name="numOfBa" /></td>
							<td class="field"><input type="text" name="numOfBr" /></td>
							<td class="field"><input type="number" name="garageSpaces" /></td>
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
							<td class="field"><input type="text" name="landSqft" /></td>
							<td class="field"><input type="text" name="buildingSqft" /></td>
							<td class="field"><input type="text" name="unlivableSqft" /></td>
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
					<table>
						<tr>
							<td>
								<div class="submit-search">
									<button type="submit" name="addBedroom" value="FALSE">Submit</button>
								</div>
							</td>
							<td>
								<div class="submit-search">
									<button type="submit" name="addBedroom" value="TRUE">Add
										Bedroom Details</button>
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