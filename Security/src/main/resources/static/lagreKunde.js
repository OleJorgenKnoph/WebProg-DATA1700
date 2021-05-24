$(function (){
    hentAlleBiler();
});

function hentAlleBiler() {
    $.get("/hentAlleBiler", function (bil){
      formaterBiler(bil);
    })
}

function formaterBiler(bil) {
    let utMerke = "<select id='alleMerker' class='form-control' onchange='formaterTyper()'>";
    let forrigeMerke = "";

    for (const enBil of bil){
        if (forrigeMerke !== enBil.merke) {
            forrigeMerke = enBil.merke; //Setter forrigeMerke til nåværende merke for å kun skrive ut ett merke 1 gang

            utMerke += "<option value='" + enBil.merke + "' >" + enBil.merke + "</option>";
        }
    }
    utMerke += "</select>";

    $("#innholdMerke").html(utMerke);

    formaterTyper();
}

function formaterTyper() {

    let utType = "<select id='alleTyper' class='form-control'>";

    $.get("/hentAlleBiler", function (bil){

        for (const enBil of bil){
            if (enBil.merke === $("#alleMerker option:selected").val()){

                utType +="<option value='" + enBil.type + "' >" + enBil.type + "</option>";

            }
        }

        utType += "</select>";

        $("#innholdType").html(utType);
    })
        .fail(function (jqXHR){
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });
}

function lagreOgValiderKunde() {
    const persNrOK = validerPersNr($("#persNr").val());
    const navnOK = validerNavn($("#navn").val());
    const adrOK = validerAdr($("#adr").val());
    const regNrOK = validerRegNr($("#regNr").val());
    const passordOK = validerPassord($("#passord").val());

    if (persNrOK && navnOK && adrOK && regNrOK && passordOK){
        lagreKunde();
    }
}


function lagreKunde() {
    let kundeObj = {
        persNr: $("#persNr").val(),
        navn: $("#navn").val(),
        adr: $("#adr").val(),
        regNr: $("#regNr").val().toUpperCase(),
        merke: $("#alleMerker option:selected").val(),
        type: $("#alleTyper option:selected").val(),
        passord: $("#passord").val()
    };

    $.post("/lagreKunde", kundeObj, function () {
        window.location.href="index.html";
    })
        .fail(function (jqXHR){
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });
}