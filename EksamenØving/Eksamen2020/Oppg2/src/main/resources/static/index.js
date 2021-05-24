function regUtover() {
    if (validering($("#e-post").val(), $("#passord").val())) {
        let utover = {
            fornavn: $("#fornavn").val(),
            etternavn: $("#etternavn").val(),
            klubb: $("#klubb").val(),
            epost: $("#e-post").val(),
            passord: $("#passord").val()
        };

        //Endret knappen til å angi en onclick hendelse som kjører denne hele funksjonen
        $.post("/lagreUtover", utover, function () {
            $("#fornavn").val("");
            $("#etternavn").val("");
            $("#klubb").val("");
            $("#e-post").val("");
            $("#passord").val("");
        }).fail(function (jqXHR) {
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        })
    }
    else {
        $("#loggetInn").html("Epost og/eller passord ugyldig. Tast inn sikre og riktige verdier")
    }
}

function loggInn() {
    if (validering($("#brukernavn").val(), $("#loggInnPassord").val())) {
        $("#feil").html("");
        let obj = {
            epost: $("#brukernavn").val(),
            passord: $("#loggInnPassord").val()
        };

        $.get("/loggInn", obj, function (innloggetStatus) {
            console.log(innloggetStatus);
            if (innloggetStatus) {
                $("#loggetInn").html("Du er logget inn!")
                $("#brukernavn").val("");
                $("#loggInnPassord").val("");
            } else {
                $("#loggetInn").html("Innlogging feilet - feil brukernavn eller passord");
            }
        }).fail(function (jqXHR) {
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        })
    }

    else {
        $("#loggetInn").html("Epost eller passord feil");
    }
}

function validering(epost, passord) {
    const regExEpost = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    const regExPassord = /^(?=.*[A-ZÆØÅa-zæøå])(?=.*\d)[A-ZÆØÅa-zæøå\d]{6,}$/;

    const epostOK = regExEpost.test(epost);
    const passordOK = regExPassord.test(passord);

    if (epostOK && passordOK){
        return true;
    }
    else {
        return false;
    }
}