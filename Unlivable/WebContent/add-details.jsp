<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Unlivable: Search</title>
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
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1OfqXsmT6ACzWrApB03gpI6lae0WqqXE&callback=initMap"
	async defer></script>
<script type="text/javascript">
	var geocoder;
	var map;
	var address = "San Diego, CA";
	function initialize() {
		geocoder = new google.maps.Geocoder();
		var latlng = new google.maps.LatLng(-34.397, 150.644);
		var myOptions = {
			zoom : 8,
			center : latlng,
			mapTypeControl : true,
			mapTypeControlOptions : {
				style : google.maps.MapTypeControlStyle.DROPDOWN_MENU
			},
			navigationControl : true,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		map = new google.maps.Map(document.getElementById("map_canvas"),
				myOptions);
		if (geocoder) {
			geocoder
					.geocode(
							{
								'address' : address
							},
							function(results, status) {
								if (status == google.maps.GeocoderStatus.OK) {
									if (status != google.maps.GeocoderStatus.ZERO_RESULTS) {
										map
												.setCenter(results[0].geometry.location);

										var infowindow = new google.maps.InfoWindow(
												{
													content : '<b>' + address
															+ '</b>',
													size : new google.maps.Size(
															150, 50)
												});

										var marker = new google.maps.Marker(
												{
													position : results[0].geometry.location,
													map : map,
													title : address
												});
										google.maps.event.addListener(marker,
												'click', function() {
													infowindow
															.open(map, marker);
												});

									} else {
										alert("No results found");
									}
								} else {
									alert("Geocode was not successful for the following reason: "
											+ status);
								}
							});
		}
	}
</script>

</head>
<body>
<body class="container">
	<div class="row">
		<ul>
			<il>${address.streetNum}</il>
			<il>${address.nsew}</il>
			<il>${address.streetName}</il>
			<il>${address.unit}</il>
			<il>${address.city}</il>
			<il>${address.stateAbbr}</il>
			<il>${address.zip}</il>
		</ul>
		<div class="center">
			<h1>Unlivable: Add Property</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div>
				<form action="AddPropertyDetails.do" method="POST">
					<table>
						<tr>
							<div>Please enter the unlivable information for the
								property you wish to add</div>
							<div class="description">Unlivable space includes hallways,
								landings, and areas included in total square footage that is
								non-dwelling.</div>
						</tr>
						<tr>
							<td class="field"><input type="number" name="numOfFloors" /></td>
							<td class="field"><input type="number" name="numOfBa" /></td>
							<td class="field"><input type="text" name="numOfBr" /></td>
						</tr>
						<tr>
							<td class="subtitle-left"># of Floors</td>
							<td class="subtitle-center"># of Bedrooms</td>
							<td class="subtitle-center"># of Bathrooms</td>
						</tr>
					</table>
					<table>
						<tr>
							<td class="field"><input type="text" name="buildingSqft" /></td>
							<td class="field"><input type="text" name="stairSqft" /></td>
							<td class="field"><input type="text" name="hallSqft" /></td>
						</tr>
						<tr>
							<td class="subtitle-left">Building SqFt.</td>
							<td class="subtitle-center">Stair SqFt.</td>
							<td class="subtitle-center">Other unlivable space</td>
						</tr>
					</table>
					<table>
						<tr>
							<td class="field"><input type="text" name="landSqft"
								value="0" /></td>
							<td class="result-table"><div id="ceiling-checkbox">
									<input type="checkbox" name="vaultedCeiling" value="TRUE" /> 
								</div>
								<div class="subtitle-center-top">Is the regular ceiling
									height greater than 8ft?</div></td>
						</tr>
						<tr>
							<td class="subtitle-left">Land SqFt. (optional)</td>
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