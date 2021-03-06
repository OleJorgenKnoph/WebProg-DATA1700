function reg() {
    const persnr = $("#persNr");
    const navn = $("#navn");
    const adr = $("#adresse");
    const kjennetegn = $("#kjennetegn");
    const merke = $("#bilmerke");
    const type = $("#type");

    let bilObj = {
    persNr: persnr.val(),
    navn: navn.val(),
    adresse: adr.val(),
    kjennetegn: kjennetegn.val(),
    bilmerke: merke.val(),
    type: type.val()
};

    $.post("/regBil", bilObj, function (data){
    let ut ="<h3>Alle biler:</h3><table class='table table-bordered table-striped'><tr><th>PersonNr</th><th>Navn</th><th>Adresse</th><th>Kjennetegn</th><th>Merke</th><th>Type</th></tr>";
        for (let i = 0; i < data.length; ++i){
            ut += "<tr><td>" + data[i].persNr + "</td>";
            ut += "<td>" + data[i].navn + "</td>";
            ut += "<td>" + data[i].adresse + "</td>";
            ut += "<td>" + data[i].kjennetegn + "</td>";
            ut += "<td>" + data[i].bilmerke + "</td>";
            ut += "<td>" + data[i].type + "</td></tr>";
        }
                ut+="</table>"
        $("#resultat").html(ut);
    })

    //Tømme feltene
    persnr.val(null);
    navn.val(null);
    adr.val(null);
    kjennetegn.val(null);
    merke.val(null);
    type.val(null);
}

    function slett() {
    const ok = confirm("Sikker på at du vil slette kundene?");
    if (ok) {
            $.get("/slett", function () {
                $("#resultat").html("");
            })
        console.log("SlettIF()")

    }
    console.log("Slett()")
    }
