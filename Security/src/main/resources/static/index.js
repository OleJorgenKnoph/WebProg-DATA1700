$(function () {
   hentAlleKunder();
   sjekkInnlogging();
});

function hentAlleKunder() {
    $.get("/hentKunder", function (kunder){
        formaterKunde(kunder);
    })
        .fail(function (jqXHR){
           const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });
}

function formaterKunde(kunde){
    let ut = "<div class='table-responsive'><table class='table table-striped table-dark table-bordered table-hover table-sm'>" +
        "<thead>" +
        "<tr>" +
        "<th scope='col'>Personnummer</th>" +
        "<th scope='col'>Navn</th>" +
        "<th scope='col'>Adresse</th>" +
        "<th scope='col'>RegNummer</th>" +
        "<th scope='col'>Merke</th>" +
        "<th scope='col'>Type</th>" +
        "<th scope='col'></th>" +
        "<th scope='col'></th>" +
        "</tr>" +
        "</thead>" +
        "<tbody>";

    for (const enKunde of kunde){
        ut += "<tr>" +
            "<th scope='row'>"+ enKunde.persNr +"</th>" +
            "<td>"+ enKunde.navn +"</td>" +
            "<td>"+ enKunde.adr +"</td>" +
            "<td>"+ enKunde.regNr +"</td>" +
            "<td>"+ enKunde.merke +"</td>" +
            "<td>"+ enKunde.type +"</td>" +
            "<td><a href='endreKunde.html?id="+ enKunde.id +"' class='btn btn-light btn-sm'>Endre</a></td>" +
            "<td><button type='button' class='btn btn-secondary btn-sm' onclick='slettEnKunde("+ enKunde.id +")'>Slett</button> </td>" +
            "</tr>";
    }

    ut += "</tbody></table></div>";

    $("#table-content").html(ut);
}

function slettEnKunde(id) {
    const url = "/slettEnKunde?id="+id;
    $.get( url, function() {
        hentAlleKunder()
    })
        .fail(function (jqXHR){
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });
}

function slettAlle() {
    $.get("/slettAlle", function (){
        hentAlleKunder();
    })
        .fail(function (jqXHR){
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });
}

function leggTilInnloggetObjekter(){

        $("#leggTilSlettKnapp").html("<button class='btn btn-danger' onclick='slettAlle()'>Slett alle biler</button>");
}
