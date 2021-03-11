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


    if (!film) {
        $("#film").addClass(" error");
            return;
    }
        if (!antall) {
            $("#antall").addClass(" error");
                return;
        }
            if (!fornavn) {
                $("#fornavn").addClass(" error");
                return;
            }
                if (!etternavn) {
                $("#etternavn").addClass(" error");
                    return;
                }
                    if (!tlfnr) {
                        $("#tlfnr").addClass(" error");
                        return;
                    }
                        if (!epost) {
                            $("#epost").addClass(" error");
                            return;
                        }

    else {
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
                "<tr><th>Navn</th>" +
                "<th>Film</th>" +
                "<th>Antall</th>" +
                "<th>Epost</th>" +
                "<th>Telefonnr</th></tr>";
            for (let billett of kunde) {
                ut += "<tr>" +
                    "   <td>" + billett.fornavn + " " + billett.etternavn + "</td>" +
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