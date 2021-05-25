function registrer() {
    let kundePakke = {
        fornavn: $("#fornavn").val(),
        etternavn: $("#etternavn").val(),
        adresse: $("#adresse").val(),
        postnr: $("#postnr").val(),
        telefonnr: $("#telefonnr").val(),
        epost: $("#epost").val(),
        volum: $("#volum").val(),
        vekt: $("#vekt").val()
    };

    $.post("/lagreKunde", kundePakke, function (){
        $("#fornavn").val("")
        $("#etternavn").val("")
        $("#adresse").val("")
        $("#postnr").val("")
        $("#telefonnr").val("")
        $("#epost").val("")
        $("#volum").val("")
        $("#vekt").val("")
    })
}

//Kjøres hit og går videre til registrering hvis disse verdiene er godkjente
function validerNavnOgPostnr() {
    const fornavnOK = validerFornavn($("#fornavn").val());
    const etternavnOK = validerEtternavn($("#etternavn").val());
   /* const postnrOK = validerPostnr($("#postnr").val());
    const postNrFinnes = sjekkPostnr($("#postnr").val());*/

    if (fornavnOK && etternavnOK/* && postnrOK && postNrFinnes*/){
        registrer();
    }
}


function validerFornavn(verdi){
    const regEx = /^[a-zA-ZæøåÆØÅ. \-]{2,70}$/;
    const fornavnOK = regEx.test(verdi);

    if (fornavnOK){
        $("#feilmeldinger").html("");
        return true;

    }
        else {
        $("#feilmeldinger").html("Ugyldig fornavn. Må bestå av bokstaver fra 2 til 70 karakterer.");
        return false
    }
}
function validerEtternavn(verdi){
    const regEx = /^[a-zA-ZæøåÆØÅ. \-]{2,70}$/;
    const etternavnOK = regEx.test(verdi);

    if (etternavnOK){
        $("#feilmeldinger").html("");
        return true;

    }
    else {
        $("#feilmeldinger").html("Ugyldig etternavn. Må bestå av bokstaver fra 2 til 70 karakterer.");
        return false
    }
}
/*function validerPostnr(verdi){
    const regEx = /^[0-9]{4}$/;
    const postnrOK = regEx.test(verdi);

    if (postnrOK){
        $("#feilmeldinger").html("");
        return true;

    }
    else {
        $("#feilmeldinger").html("Ugyldig postnr. Må bestå av 4 tall");
        return false
    }
}

function sjekkPostnr() {

    const url = "/sjekkPostNr?"+$("#postnr").val();

    $.get(url, function (data) {
            if (data) {
                $("#feilmeldinger").html("Postnummer er gyldig")
                return true
            }
            else {
                $("#feilmeldinger").html("Postnr er ikke gyldig")
                return false;
            }
        })
}*/
