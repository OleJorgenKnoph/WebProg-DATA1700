function kjopBillett() {
    const film = $("#film").val();
    const fornavn = $("#fornavn").val();
    const etternavn = $("#etternavn").val();
    const tlfnr = $("#tlfnr").val();
    const epost = $("#epost").val();
    const antall = $("#antall").val();

    //Removes so multiple inputs arent selected as faulty
        $("#film").removeClass(" error");
        $("#fornavn").removeClass(" error");
        $("#etternavn").removeClass(" error");
        $("#antall").removeClass(" error");
        $("#epost").removeClass(" error");
        $("#tlfnr").removeClass(" error");

let godkjent = true;

    if (!film) {
        $("#film").addClass(" error");
            godkjent = false;
    }
        if (!antall) {
            $("#antall").addClass(" error");
            godkjent = false;
        }
            if (!fornavn) {
                $("#fornavn").addClass(" error");
                godkjent = false;
            }
                if (!etternavn) {
                $("#etternavn").addClass(" error");
                    godkjent = false;
                }
                    if (!tlfnr) {
                        $("#tlfnr").addClass(" error");
                        godkjent = false;
                    }
                        if (!epost) {
                            $("#epost").addClass(" error");
                            godkjent = false;
                        }

    if (godkjent) {
        const billett = {
            film: film,
            fornavn: fornavn,
            etternavn: etternavn,
            tlfnr: tlfnr,
            epost: epost,
            antall: antall,
        }


        $.post("/lagreBillett", billett, function (kunde) {
            let ut = "<table class='table table-striped'>" +
                "<tr><th>Fornavn</th>" +
                "<th>Etternavn</th>" +
                "<th>Film</th>" +
                "<th>Antall</th>" +
                "<th>Epost</th>" +
                "<th>Telefonnr</th></tr>";
            for (let billett of kunde) {
                ut += "<tr>" +
                    "   <td>" + billett.fornavn + "</td>" +
                    "   <td>" + billett.etternavn + "</td>" +
                    "   <td>" + billett.film + "</td>" +
                    "   <td>" + billett.antall + "</td>" +
                    "   <td>" + billett.epost + "</td>" +
                    "   <td>" + billett.tlfnr + "</td></tr>";
            }
            ut += "</table>"

            $("#resultat").html(ut);
        })

        $("#film").val("");
        $("#fornavn").val("");
        $("#etternavn").val("");
        $("#tlfnr").val("");
        $("#epost").val("");
        $("#antall").val("");
    }
}

function slettBillett() {
    $.get("/slett", function () {
        $("#resultat").html("");
    })
}