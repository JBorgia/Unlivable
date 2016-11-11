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
		<div class="center">
			<h1>Unlivable: Search</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div>
				<form action="GetPropertyData.do" method="GET">
					<table>
						<tr>
							<div>Please enter the address of the property to retrieve</div>
						</tr>
						<tr>
							<td class="field"><input type="text" name="streetNum" /></td>
							<td>
								<table>
									<tr>
										<td class="field"><select name="nsew" class="drop">
												<option value="" selected="selected">N/A</option>
												<option value="N">N</option>
												<option value="S">S</option>
												<option value="E">E</option>
												<option value="W">W</option>
												<option value="NW">NW</option>
												<option value="NE">NE</option>
												<option value="SE">SW</option>
												<option value="SW">SE</option>
										</select></td>
										<td class="field"><input type="text" name="streetName" /></td>
									</tr>
								</table>
							</td>
							<td class="field"><input type="text" name="unit" /></td>
						</tr>
						<tr>
							<td class="subtitle-left">Address Number</td>
							<td class="subtitle-center">Street Name</td>
							<td class="subtitle-center">Unit</td>
						</tr>
					</table>
					<table>
						<tr>
							<td class="field"><input type="text" name="city" /></td>
							<td class="field"><select name="stateAbbr" class="drop">
									<option value="" selected="selected">N/A</option>
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
							<td class="field"><input type="text" name="zip" /></td>
						</tr>
						<tr>
							<td class="subtitle-left">City</td>
							<td class="subtitle-state">State</td>
							<td class="subtitle-center">ZIP</td>
						</tr>
					</table>
					<div class="submit-search">
						<input type="submit">
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-6"></div>
	</div>
</body>
</html>