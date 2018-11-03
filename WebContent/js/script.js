function correctFirstName() {
    var firstName = document.getElementsByName('fornavn')[0];
    var errorText = document.getElementById('badfirstname');

    //Fix regex
    if ((/^[A-ZÆØÅ][a-zæøå\-\sA-ZÆØÅ]{1,20}$/).test(firstName.value)) {
        errorText.style.visibility = "hidden";
        return true;
    } else {
        errorText.style.visibility = "visible";
        return false;
    }
}

function correctLastName() {
    var lastName = document.getElementsByName('etternavn')[0];
    var errorText = document.getElementById('badlastname');

    if ((/^[A-ZÆØÅ][a-zA-Z\-æøåÆØÅ]{1,20}$/).test(lastName.value)) {
        errorText.style.visibility = "hidden";
        return true;
    } else {
        errorText.style.visibility = "visible";
        return false;
    }
}

function correctMobile() {
    var mobile = document.getElementsByName('mobil')[0];
    var errorText = document.getElementById('badphone');
    if (String(mobile.value).match(/^\d{8}$/)) {

        errorText.style.visibility = "hidden";
        return numberNotTaken(mobile.value);
    } else {
        errorText.style.visibility = "visible";
        return false;
    }
}

function correctPassword() {
    var password = document.getElementsByName('passord')[0];
    var errorText = document.getElementById('badpassword');

    if ((/^[a-zæøåA-ZÆØÅ\-0-9]{8,20}$/).test(password.value)) {
        errorText.style.visibility = "hidden";
        return true;
    } else {
        if (password.value.length !== 0) errorText.style.visibility = "visible";
        return false;
    }
}

function correctPasswordRepeter() {
    var firstPass = document.getElementsByName('passord')[0];
    var repetedPass = document.getElementsByName('passordRepetert')[0];
    var errorText = document.getElementById('notequalpassword');

    if (firstPass.value === repetedPass.value) {
        errorText.style.visibility = "hidden";
        return true;
    } else {
        if (repetedPass.value.length !== 0) errorText.style.visibility = "visible";
        return false;
    }
}

function readyPage() {
    var redText = document.querySelectorAll('font');
    var submitButton = document.getElementById('meldpaa');

    //Remove all red flags
    for (var i = 0; i < redText.length; i++) {
        redText[i].style.visibility = "hidden";
    }
    //Disable button as a first block to invalid inputs
    submitButton.disabled = true;
}

function enableButton() {
    var submitButton = document.getElementById('meldpaa');

    //See if all boxes are correct
    submitButton.disabled = (correctPasswordRepeter() &&
        correctPassword() &&
        correctMobile() &&
        correctFirstName() &&
        correctLastName() &&
        checkIfKjonnIsSelected()) !== true;

}

function validateFields() {
    return correctPasswordRepeter() &&
        correctPassword() &&
        correctMobile() &&
        correctFirstName() &&
        correctLastName() &&
        checkIfKjonnIsSelected() === true
}

function checkIfKjonnIsSelected() {
    var kjonnButtons = document.getElementsByName('kjonn');

    for (var i = 0; i < kjonnButtons.length; i++) {
        if (kjonnButtons[i].checked === true) {
            return true;
        }
    }

    return false;
}

function numberNotTaken() {
    return true;
}