"use strict";

//validasjon();
testFornavn();
testEtternavn();
testTelefon();
testPassord();
testPassordConfirmation();
testKjonn();

/* Validering fornavn */
function testFornavn() {
	var inputFornavn = document.getElementById("firstName").value;
	if (inputFornavn[0] !== inputFornavn[0].toUpperCase()) {
		fornavnRed();
		fornavnFeilmelding();
	} else {
		fornavnGreen();
		fornavnGodkjent();
	}
}

function fornavnRed() {
	document.getElementById("firstName").style.color = "red";
}

function fornavnGreen() {
	document.getElementById("firstName").style.color = "green";
}

function fornavnFeilmelding() {
	document.getElementById("fornavn").style.color = "red";
	document.getElementById("fornavn").innerHTML = "Ha stor forbokstav!";
}

function fornavnGodkjent() {
	document.getElementById("fornavn").style.color = "green";
	document.getElementById("fornavn").innerHTML = "Godkjent!";
}

/* Validering etternavn */
function testEtternavn() {
	var inputEtternavn = document.getElementById("lastName").value;
	if (inputEtternavn[0] !== inputEtternavn[0].toUpperCase()) {
		etternavnRed();
		etternavnFeilmelding();
	} else {
		etternavnGreen();
		etternavnGodkjent();
	}
}

function etternavnRed() {
	document.getElementById("lastName").style.color = "red";
}

function etternavnGreen() {
	document.getElementById("lastName").style.color = "green";
}

function etternavnFeilmelding() {
	document.getElementById("etternavn").style.color = "red";
	document.getElementById("etternavn").innerHTML = "Ha stor forbokstav";
}

function etternavnGodkjent() {
	document.getElementById("etternavn").style.color = "green";
	document.getElementById("etternavn").innerHTML = "Godkjent!";
}

/* Validering telefon */
function testTelefon() {
	var inputTelefon = document.getElementById("phone").value;
	if (inputTelefon.length !== 8) {
		telefonRed();
		telefonFeilmelding();
	} else {
		telefonGreen();
		telefonGodkjent();
	}
}

function telefonRed() {
	document.getElementById("phone").style.color = "red";
}

function telefonGreen() {
	document.getElementById("phone").style.color = "green";
}

function telefonFeilmelding() {
	document.getElementById("mobil").style.color = "red";
	document.getElementById("mobil").innerHTML = "Skriv 8 siffer";
}

function telefonGodkjent() {
	document.getElementById("mobil").style.color = "green";
	document.getElementById("mobil").innerHTML = "Godkjent!";
}

/* Validering passord */
function testPassord() {
	var inputPassord = document.getElementById("pass").value;
	if (inputPassord.length < 5) {
		passordRed();
		passordFeilmelding();
	} else {
		passordGreen();
		passordGodkjent();
	}
}

function passordRed() {
	document.getElementById("pass").style.color = "red";
}

function passordGreen() {
	document.getElementById("pass").style.color = "green";
}

function passordFeilmelding() {
	document.getElementById("passord").style.color = "red";
	document.getElementById("passord").innerHTML = "Minst 5 tegn";
}

function passordGodkjent() {
	document.getElementById("passord").style.color = "green";
	document.getElementById("passord").innerHTML = "Godkjent!";
}

/* Validering passord repetisjon */
function testPassordConfirmation() {
	var inputPassConf = document.getElementById("passConf").value;
	if (inputPassConf !== document.getElementById("pass").value) {
		passordConfRed();
		passordConfFeilmelding();
	} else {
		passordConfGreen();
		passordConfGodkjent();
	}
}

function passordConfRed() {
	document.getElementById("passConf").style.color = "red";
}

function passordConfGreen() {
	document.getElementById("passConf").style.color = "green";
}

function passordConfFeilmelding() {
	document.getElementById("passord2").style.color = "red";
	document.getElementById("passord2").innerHTML = "Ulike passord";
}

function passordConfGodkjent() {
	document.getElementById("passord2").style.color = "green";
	document.getElementById("passord2").innerHTML = "Godkjent!";
}