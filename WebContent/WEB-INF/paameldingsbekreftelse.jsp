<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/index.css">
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		&nbsp;&nbsp;&nbsp;${validering.fornavn}<br />
		&nbsp;&nbsp;&nbsp;${validering.etternavn}<br />
		&nbsp;&nbsp;&nbsp;${validering.mobil}<br /> &nbsp;&nbsp;&nbsp;${validering.kjonn}
	</p>
	<a href="DeltakerlisteServlet">Gå til deltakerlisten</a>
</body>
</html>