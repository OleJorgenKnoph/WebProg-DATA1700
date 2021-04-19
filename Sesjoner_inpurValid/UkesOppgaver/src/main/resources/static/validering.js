function validerPersNr(verdi) {
    const regEx = /^[0-9]{11}$/;
    const ok = regEx.test(verdi);

    if (!ok){
        $("#feilPersNr").html("Personnummeret må bestå av 11 siffer");
        return false;
    }
    else {
        $("#feilPersNr").html("");
        return true;
    }
}

function validerNavn(verdi) {
 const regEx = /^[a-zA-ZæøåÆØÅ. \-]{2,25}$/;
 const ok = regEx.test(verdi);

    if (!ok){
        $("#feilNavn").html("Navnet må bestå av 2 til 25 bokstaver");
        return false;
    }
        else {
            $("#feilNavn").html("");
            return true;
    }
}

function validerAdr(verdi) {
    const regEx = /^[a-zA-ZæøåÆØÅ.0-9 \-]{5,70}$/;
    const ok = regEx.test(verdi);

    if (!ok){
        $("#feilAdr").html("Adressen må bestå av over 5 bokstaver og tall");
        return false;
    }
    else {
        $("#feilAdr").html("");
        return true;
    }
}

function validerRegNr(verdi) {
    const regEx = /^[A-Za-z\-]{2}[0-9\-]{5}$/;
    const ok = regEx.test(verdi);

    if (!ok){
        $("#feilRegNr").html("RegNummeret må bestå av 2 bokstaver og 5 siffer");
        return false;
    }
    else {
        $("#feilRegNr").html("");
        return true;
    }
}

function validerPassord(passord) {
    const regEx = /^[A-Za-zæøå0-9\-]{4,}$/;
    const ok = regEx.test(passord);

    if (!ok){
        $("#feilPassord").html("Passordet må være 4 eller fler bokstaver eller siffer");
            return false;
    }
    else {
        $("#feilPassord").html("");
        return true;
    }
}