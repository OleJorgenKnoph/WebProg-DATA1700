$(function (){
    hentKunde();
})

function hentKunde() {
    const id = window.location.search.substring(1);
    const url = "/hentEnKunde?"+id;
    $.get(url,function(data){
        $("#id").val(data.id);
        $("#persNr").val(data.persNr);
        $("#navn").val(data.navn);
        $("#adr").val(data.adr);
        $("#regNr").val(data.regNr);
        $("#alleMerker option:selected").val(data.merke);
        $("#alleTyper option:selected").val(data.type);

    })
        .fail(function (jqXHR){
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });
}

function validerOgEndreKunde() {
    const persNrOK = validerPersNr($("#persNr").val());
    const navnOK = validerNavn($("#navn").val());
    const adrOK = validerAdr($("#adr").val());
    const regNrOK = validerRegNr($("#regNr").val());

    if (persNrOK && navnOK && adrOK && regNrOK){
        endreKunde();
    }
}

function endreKunde() {
    let kunde = {
        persNr: $("#persNr").val(),
        navn: $("#navn").val(),
        adr: $("#adr").val(),
        regNr: $("#regNr").val(),
        merke: $("#alleMerker option:selected").val(),
        type: $("#alleTyper option:selected").val()
    };

    $.post("/oppdaterKunde", kunde, function (){
        window.location.href="/";
    })
        .fail(function (jqXHR){
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });
}

