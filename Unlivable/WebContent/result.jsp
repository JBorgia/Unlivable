<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Unlivable</title>
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
		<div class="center">
			<h1>Unlivable</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div>
				<c:forEach items="${properties}" var="item">
					<table>
						<tr>
							<td>${item.address.streetNum}</td>
							<td>${item.address.nsew}${item.address.streetName}</td>
							<td>${item.address.unit}</td>
						</tr>
						<tr>
							<td class="subtitle">Address Number</td>
							<td class="subtitle">Street Name</td>
							<td class="subtitle">Unit</td>
						</tr>
						<tr>
							<td>${item.address.city}</td>
							<td>${item.address.stateAbbr}</td>
							<td>${item.address.zip}</td>
						</tr>
						<tr>
							<td class="subtitle">City</td>
							<td class="subtitle">State</td>
							<td class="subtitle">ZIP</td>
						</tr>
					</table>
				</c:forEach>
			</div>
		</div>
		<div class="col-md-6"></div>
	</div>
</body>
</html>