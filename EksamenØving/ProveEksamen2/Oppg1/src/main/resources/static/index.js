$(function () {
    hentAlle();
});

function reg() {
    let brukerObj = {
        brukernavn: $("#brukernavn").val(),
        passord: $("#passord").val()
    }


    if (validerBrukernavn() && validerPassord()) {
        $.post("/regBruker", brukerObj, function () {
            hentAlle();
        })
    }
}

function validerPassord(){
    let passord = $("#passord").val();
    const regexp = /^[a-zøæåA-ZÆØÅ0-9]{6,25}$/;
    const passordOK = regexp.test(passord);

    if (!passordOK){
        $("#feilMelding").html("Passordet må være mellom 6 og 25 bokstaver og tall");
        return false;
    }
    else {
        $("#feilMelding").html("");
        return true;
    }
}
function validerBrukernavn() {
    let brukernavn = $("#brukernavn").val();
    const regexp = /^[a-zæøåA-ZÆØÅ0-9 .\-]{2,30}$/;
    const brukerOK = regexp.test(brukernavn);

    if (!brukerOK){
        $("#feilMelding").html("Brukernavnet må mellom 2og 30 bokstaver og tall(bindestrek og mellomrom er også tillatt)");
        return false;
    }
    else {
        $("#feilMelding").html("");
        return true;
    }
}


function hentAlle() {

    let ut = "<table>" +
        "<tr>" +
        "<th>Brukernavn</th>" +
        "<th>Passord</th>" +
        "</tr>" +
        "<tr>";

    $.get("/hentAlle", function (bruker) {

        for (let i = 0; i < bruker.length; ++i){
            ut += "<tr><td>"+ bruker[i].brukernavn +"</td>" +
                "<td>"+ bruker[i].passord +"</td></tr>";
        }

        ut += "</tr></table>";

        $("#resultat").html(ut);
    })
}