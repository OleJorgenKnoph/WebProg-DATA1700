$(function () {
   hentTypene()
});

function hentTypene() {
    $.get("/lastTypene", function (data) {
        const merke = $("#merke").val();
        for (let i = 0; i < data.length; ++i){
            if (data[i].merke === merke){
                ut = "<select id='modell' class='form-control'>" +
                        "<option value=" + data[i].type1 + ">" + data[i].type1 + "</option>" +
                        "<option value=" + data[i].type2 + ">" + data[i].type2 + "</option>" +
                        "<option value=" + data[i].type3 + ">" + data[i].type3 + "</option>" +
                    "</select>"
            }
        }
            $("#modellDiv").html(ut);
    });
}

function regBil() {
    const bilObj = {
        persNr: $("#persNr").val(),
        navn: $("#navn").val(),
        adr: $("#adr").val(),
        kjennetegn: $("#regNr").val(),
        merke: $("#merke").val(),
        type: $("#modell").val()
    };

    $.post("/regBil", bilObj, function (data) {
            let ut = "<h2>Alle Bilene:</h2><table class='table table-striped'>"+
                    "<tr><th>Personnr</th><th>Navn</th><th>Adresse</th><th>Kjennetegn</th><th>Merke</th><th>Type</th></tr>";
            for (const kunde of data){
                ut += "<tr>"+
                        "<td>" + kunde.persNr + "</td>" +
                        "<td>" + kunde.navn + "</td>" +
                        "<td>" + kunde.adr + "</td>" +
                        "<td>" + kunde.kjennetegn + "</td>" +
                        "<td>" + kunde.merke + "</td>" +
                        "<td>" + kunde.type + "</td> </tr>";
            }
            ut += "</table>"
        $("#resultat").html(ut);

    //Tømme feltene
        $("#persNr").val("");
        $("#navn").val("");
        $("#adr").val("");
        $("#regNr").val("");
        $("#merke").val("");
        $("#modell").val("");
    })

}

function slettAlle() {
    $.get("/slett", function () {
        $("#resultat").html("");
        console.log("Slettet");
    })
}