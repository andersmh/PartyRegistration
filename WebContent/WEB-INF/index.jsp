<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" />
<script src="${pageContext.request.contextPath}/js/script.js"></script>

<title>Påmelding</title>
</head>
<body>
	<h2>Påmeldings skjema</h2>
	<form method="post" class="pure-form pure-form-aligned" action="/test">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Navn:</label> <input type="text" name="fornavn"
					value="${schema.firstName}" onkeyup="correctFirstName()" /> <font
					color="red" id="badfirstname">${schema.errorFirstName}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input type="text"
					name="etternavn" value="${schema.lastName}"
					onkeyup="correctLastName()" /> <font color="red" id="badlastname">${schema.errorLastName}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input type="text"
					name="mobil" value="${schema.mobile}" onkeyup="correctMobile()" />

				<font color="red" id="badphone">${schema.errorMobile}</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input type="password"
					name="passord" value="" onkeyup="correctPassword()" /> <font
					color="red" id="badpassword">${schema.errorPassword}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					type="password" name="passordRepetert" value=""
					onkeyup="correctPasswordRepeter()" /> <font color="red"
					id="notequalpassword">${schema.errorRepetedPassword}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
					value="mann" ${schema.mannChecked} />mann <input type="radio"
					name="kjonn" value="kvinne" ${schema.kvinneChecked} />kvinne <font
					color="red">${schema.errorKjonn}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary"
					id="meldpaa">Meld meg på</button>
			</div>
		</fieldset>
	</form>
</body>
</html>
