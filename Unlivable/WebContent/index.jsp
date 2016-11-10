<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>States of America</title>
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
<title>United States</title>
<script>
var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map-canvas'), {
      center: {lat: ${state.latitude}, lng: ${state.longitude}},
      zoom: 7
    });
  }
</script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1OfqXsmT6ACzWrApB03gpI6lae0WqqXE&callback=initMap"
	async defer></script>
</head>
<body>
<body class="container">
	<div class="row">
		<div class="center">
			<h1>United States of America</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-7">
			<span class="pull-right">
				<div class="searchfields">
					<h3>Search for State</h3>
					<table>
						<tr>
							<td class="search">Search by name:</td>
							<td>
								<form action="GetStateData.do" method="GET">
									<input type="text" name="name" /> <input class="button2"
										type="submit">
								</form>
							</td>
						</tr>
						<tr>
							<td class="search">Search by abbreviation:</td>
							<td>
								<form action="GetStateData.do" method="GET">
									<input type="text" name="abbr" /> <input class="button2"
										type="submit">
								</form>
							</td>
						</tr>
						<tr>
							<td class="search">Search by capital:</td>
							<td>
								<form action="GetStateData.do" method="GET">
									<input type="text" name="capital" /> <input class="button2"
										type="submit">
								</form>
							</td>
						</tr>
						<tr>
							<td class="search">Navigate Sates:</td>
							<td>
								<div class="col-md-6">
									<form action="SlideState.do" method="GET">
										<input class="search-button" type="submit" name="slide"
											value="Prev">
									</form>
								</div>
								<div class="col-md-6">
									<form action="SlideState.do" method="GET">
										<input class="search-button" type="submit" name="slide"
											value="Next">
									</form>
								</div>
							</td>
						</tr>
					</table>
				</div>
				<div>
					<c:choose>
						<c:when test="${state.election=='Republican'}">
							<div class="box overlay red">
								<div id="map-canvas" style="height: 400px; width: 475px"></div>
							</div>
						</c:when>
						<c:when test="${state.election=='Democrat'}">
							<div class="box overlay blue">
								<div id="map-canvas" style="height: 400px; width: 475px"></div>
							</div>
						</c:when>
						<c:otherwise>
							<div>
								<div id="map-canvas" style="height: 400px; width: 475px"></div>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</span>
		</div>
		<div class="col-md-5">
			<div class="center">
				<div class="left">
					<div class="info">
						<c:choose>
							<c:when test="${!empty state}">
								<ul>
									<li><b>NAME: &nbsp&nbsp</b>${state.name}</li>
									<li><b>ABBREVIATION: &nbsp&nbsp</b>${state.abbreviation}</li>
									<li><b>CAPITAL: &nbsp&nbsp</b>${state.capital}</li>
									<li><b>LATITUDE: &nbsp&nbsp</b>${state.latitude}</li>
									<li><b>LONGITUDE: &nbsp&nbsp</b>${state.longitude}</li>
									<li><b>POPULATION: &nbsp&nbsp</b> <fmt:formatNumber
											value="${state.population}" type="number"
											maxFractionDigits="0" /></li>
									<li><b>2016 ELECTION: &nbsp&nbsp</b>${state.election}</li>
								</ul>
							</c:when>
							<c:otherwise>
								<ul>
									<li>No State Found</li>
								</ul>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<div class="newState">
				<div class="center">
					<h3>Add a New State</h3>
				</div>
				<form action="NewState.do" method="POST">
					<table>
						<tr>
							<td class="add">State name:</td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td class="add">Abbreviation:</td>
							<td><input type="text" name="abbreviation"></td>
						</tr>
						<tr>
							<td class="add">State Capital:</td>
							<td><input type="text" name="capital"></td>
						</tr>
						<tr>
							<td class="add">State Latitutde:</td>
							<td><input type="text" name="latitude"></td>
						</tr>
						<tr>
							<td class="add">State Longitude:</td>
							<td><input type="text" name="longitude"></td>
						</tr>
						<tr>
							<td class="add">Population:</td>
							<td><input type="text" name="population"></td>
						</tr>
						<tr>
							<td class="add">2016 Election:</td>
							<td><input type="text" name="election"></td>
						</tr>
					</table>
					<div class="center">
						<input class="button" type="submit" size="large">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>